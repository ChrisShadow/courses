package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class ServerOp {
	private int puertoServidor;

    private Socket miServicio = null;
    private ServerSocket socketServicio = null;
    private DataOutputStream salidaDatos = null;
    private DataInputStream entradaDatos = null;

    private boolean repetirIteracion = true;
    private boolean terminarServidor = false;
    private List<Professors> listProf = new ArrayList<>();

    public int getPuertoServidor() {
        return puertoServidor;
    }

    public ServerOp(int puertoServidor) {
        this.puertoServidor = puertoServidor;
        this.conexion();
    }

    private void conexion() {
        try {
            socketServicio = new ServerSocket(this.getPuertoServidor());
            miServicio = socketServicio.accept();
            System.out.printf("***El Servidor esta escuchando el puerto:%d***\n", this.getPuertoServidor());

            Thread subProceso = new Thread(new Runnable() {
                @Override
                public void run() {
                    recibirDatos();
                }
            });

            subProceso.start();

        } catch (BindException e) {
            Logger.getLogger(ServerOp.class.getName()).log(Level.WARNING, "El puerto esta en uso - Puerto " + this.getPuertoServidor(), e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ServerOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void recibirDatos() {
        while (repetirIteracion) {
            try {
                InputStream inputStream = null;
                String lineaRecibida = null;
                String parametroRecibido[];

                inputStream = miServicio.getInputStream();
                entradaDatos = new DataInputStream(inputStream);

                lineaRecibida = entradaDatos.readUTF();
                parametroRecibido = lineaRecibida.split(" - ");
                this.calcularResultado(parametroRecibido);

            } catch (IOException ex) {
                try {
                    if (miServicio != null) {
                        miServicio.close();
                    }

                    if (entradaDatos != null) {
                        entradaDatos.close();
                    }

                    miServicio = socketServicio.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void calcularResultado(String parametro[]) {
        String escribir = null;

        int opcionRecibida = Integer.valueOf(parametro[0]);
        int cantParam = parametro.length;

        if (validarParametros(opcionRecibida, cantParam)) {
            switch (opcionRecibida) {
                case 1:
                    escribir = agregar(parametro);
                    break;
                case 2:
                    escribir = ConsultarCi(parametro);
                    break;
                case 3:
                    escribir = ConsultarFacu(parametro);
                    break;
            }
        } else {
            escribir = "Respuesta del Servidor: Cantidad de parametros recibidos incorrectos\n";
        }

        this.enviarDatos(escribir);

    }

    private void enviarDatos(String datos) {
        try {
            OutputStream outputStream = null;
            outputStream = miServicio.getOutputStream();
            salidaDatos = new DataOutputStream(outputStream);
            salidaDatos.writeUTF(datos);
            salidaDatos.flush();

            if (terminarServidor) {
                this.cerrarTodo();
                this.repetirIteracion = false;
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerOp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cerrarTodo() {
        try {

            if (salidaDatos != null) {
                salidaDatos.close();
            }

            if (entradaDatos != null) {
                entradaDatos.close();
            }

            if (socketServicio != null) {
                socketServicio.close();
                System.out.printf("***El Servidor en el puerto:%d esta abajo***\n", this.getPuertoServidor());
            }

            if (miServicio != null) {
                miServicio.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(ServerOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validarParametros(int opcion, int cantidadParametros) {

        if (opcion == 1 && cantidadParametros == 8) {
            return true;
        }

        if (opcion == 2 && cantidadParametros == 2) {
            return true;
        }

        if (opcion == 3 && cantidadParametros == 2) {
            return true;
        }

        return false;
    }

    //1.1
    private String agregar(String[] parametro) {
        Professors p = new Professors(parametro[1], parametro[2], parametro[5].charAt(0), parametro[3], parametro[4],parametro[6], Integer.parseInt(parametro[7]));
        //1.2
        for (Professors profe : listProf) {
            if (profe.equals(p))
                return "El Profesor ya está inscripto con los datos ingresados " + p.toString();
        }
        listProf.add(p);
        return "Profesor agregado " + p.toString();
    }

    /*private String eliminar(String[] parametro) {
        Iterator<Alumno> itAlumno = listAlumno.iterator();
        String cedula = parametro[1];
        String materia = parametro[2];
        char semestre = parametro[3].charAt(0);

        while (itAlumno.hasNext()) {
            Alumno alumActual = itAlumno.next();
            if (alumActual.getCedula().equals(cedula)
                    && alumActual.getMateria().equals(materia)
                    && alumActual.getSemestre() == semestre) {
                String result = alumActual.toString();
                itAlumno.remove();
                return "Alumno eliminado correctamente " + result;
            }
        }

        return "No existe alumno para la materia y semestre ingresado";
    }*/

    // 1.3.1
    private String ConsultarCi(String[] parametro) {
       // Iterator<Professors> itProf = listProf.iterator();
        String cedula = parametro[1];
        String result = "";
        Stream<String> stream;

        stream = listProf.stream()
				.filter(p -> p.getCedula().equalsIgnoreCase(cedula))
				.map(Professors::getMateria);
        System.out.println("\nLas materias del tutor: \n");
        stream.forEach(x -> System.out.println(x));

		result = buscarResultado(stream, cedula);
       // result=stream.toString();
        
        /*while (itAlumno.hasNext()) {
            Alumno alumActual = itAlumno.next();
            if (alumActual.getCedula().equals(cedula)) {
                result = result + alumActual.getMateria() + "-" + alumActual.getSemestre() + "-" + alumActual.getCarrera() + "\n";
            }
        }*/

        if (result.isEmpty()) {
            return "No existe datos para el alumno ingresado";
        }

        return "\n" + result;
    }
    
    private String buscarResultado(Stream<String> stream, String cedula) {
    	String resultado = "";

		if (stream != null) {
			resultado = "\nLas materias del tutor: \n";
			for (Professors profesor : listProf) {

				if (profesor.getCedula().equalsIgnoreCase(cedula))
					resultado = resultado + profesor.getMateria().concat("\n");

			}
		}

		return resultado;
	}

	//1.3.2
    private String ConsultarFacu(String[] parametro) {
         String facu = parametro[1];
         String result = "";
         Professors[] aTeachers= (Professors[])listProf.toArray();

         result=filtradoGenerico(aTeachers, facu).toString();
        

         if (result.isEmpty()) {
             return "No existe datos para el alumno ingresado";
         }

         return "Listado de materias enseñadas en la facultad: \n" + result;
     }

	private <T> Integer filtradoGenerico(T[] aTeachers, T facu) {
		int cantMat= 0;
		for (int i = 0; i < aTeachers.length; i++) {
			if(((Professors) aTeachers[i]).getFacultad().equalsIgnoreCase((String) facu))
					cantMat++;		
		}
		return cantMat;
	}

}
