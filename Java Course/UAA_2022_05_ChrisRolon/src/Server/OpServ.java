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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpServ {
	private int puertoServidor;

    private Socket miServicio = null;
    private ServerSocket socketServicio = null;
    private DataOutputStream salidaDatos = null;
    private DataInputStream entradaDatos = null;

    private boolean repetirIteracion = true;
    private boolean terminarServidor = false;
    private List<Suscripcion> listClienteSuscrip = new ArrayList<>();

    public int getPuertoServidor() {
        return puertoServidor;
    }

    public OpServ(int puertoServidor) {
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
            Logger.getLogger(OpServ.class.getName()).log(Level.WARNING, "El puerto esta en uso - Puerto " + this.getPuertoServidor(), e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(OpServ.class.getName()).log(Level.SEVERE, null, ex);
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
                parametroRecibido = lineaRecibida.split(" | ");
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

        char opcionRecibida = parametro[0].charAt(0);
        int cantParam = parametro.length;

        if (validarParametros(opcionRecibida, cantParam)) {
            switch (opcionRecibida) {
                case 'A':
                    escribir = agregarSuscripcion(parametro);
                    break;
                case 'B':
                    escribir = modificarSuscripcion(parametro);
                    break;
                case 'D':
                    escribir = eliminarSuscripcion(parametro);
                case 'C':
                    escribir = ConsultaSuscripcion(parametro);
                    break;
            }
        } else {
            escribir = "Respuesta del Servidor: Cantidad de parametros recibidos incorrectos\n";
        }

        this.enviarDatos(escribir);

    }

    private String agregarSuscripcion(String[] parametro) {
    	String enviarMsjClient="";
    	int codProducto=Integer.valueOf(parametro[3]);
    	int iva =Integer.valueOf(parametro[6]);
    	int monto=Integer.valueOf(parametro[5]);
    	Suscripcion suscripNuev = new Suscripcion();
    	suscripNuev.setIdPersona(Integer.valueOf(parametro[1]));
    	suscripNuev.setNroCuenta(parametro[2]);
    	suscripNuev.setEstado(parametro[4].charAt(0));
    	
    	if(codProducto >=1 && codProducto<=5)
    		suscripNuev.setCodProducto(codProducto);
    	if(monto > 0)
    		suscripNuev.setMonto(monto);
    	
    	if(suscripNuev.VerificarIVA(iva))
    		suscripNuev.setIva(iva);
    	
    	for (Suscripcion s : listClienteSuscrip) {
			if(s.equals(suscripNuev))
				enviarMsjClient="Ya existe la suscricion con el ID Persona("+suscripNuev.getIdPersona()+"),  la cuenta("+suscripNuev.getNroCuenta()+") y el Cód. Producto("+suscripNuev.getCodProducto()+") ";
		}

    	listClienteSuscrip.add(suscripNuev);	
    	enviarMsjClient = suscripNuev.toString();
    	
		return enviarMsjClient;
	}
    
    private String ConsultaSuscripcion(String[] parametro) {
    	String enviarMsjClient="";
    	int cantParametro = parametro.length;
    	if(cantParametro==3) {
    		enviarMsjClient=ConsultarPorCodPersona(parametro);
    	}else if(cantParametro==2){
    		enviarMsjClient=ConsultarPorProducto(parametro);
    	}else {
    		enviarMsjClient="\nParámetros fuera de contexto para la consulta.";
    	}
		return enviarMsjClient;
	}

    //1.2 ConsultaSuscripcion
	private String ConsultarPorProducto(String[] parametro) {
		String enviarMsjClient="";
		char param = parametro[1].charAt(0);
		Map<Integer,Double> stream=null;
		Map<Integer,Long> streamT=null;
		
		
		if(param=='B') {
			stream=listClienteSuscrip.stream()
					.filter(ss -> ss.getEstado() == 'A')
					.collect(
							Collectors.groupingBy(Suscripcion::getCodProducto,
							Collectors.averagingInt(Suscripcion::getMonto)
							));
			stream.forEach((codP,promE) -> System.out.printf("El producto: %d \nCon promedio de la factura es: %.2f: ", codP,promE
					));
		
			
			streamT=listClienteSuscrip.stream()
					.filter(ss -> ss.getEstado() == 'A')
					.collect(
							Collectors.groupingBy(Suscripcion::getCodProducto,
							Collectors.counting())
							);	
			stream.forEach((coP,cant) -> System.out.printf("El producto: %d \\nCon cantidad de la factura es: %d: ", coP,cant
					));
				
		}else {
			enviarMsjClient="\nSin resultados...";
		}
		
		return enviarMsjClient;
	}
	
	//1.1 ConsultaSuscripcion
	private String ConsultarPorCodPersona(String[] parametro) {
		String enviarMsjClient="";
		int idPersona = Integer.valueOf(parametro[2]);
		char estado = parametro[1].charAt(0);
		Map<String,Integer> stream=null;
		int acuFac=0;
		
        stream = listClienteSuscrip.stream()
				.filter(s -> s.getIdPersona() == idPersona && s.getEstado() == estado)
				.collect(Collectors.groupingBy(
						Suscripcion:: getNroCuenta,
						Collectors.summingInt(Suscripcion::getMonto)
						));
		
		stream.forEach((count,money) -> System.out.printf("La cuenta: %s \nEl total de la facutras es: %d: ", count,money
				));
	
		return enviarMsjClient;
	}

	private String eliminarSuscripcion(String[] parametro) {
		Object[] arraySuscripciones = listClienteSuscrip.toArray();
		int idPersona = Integer.valueOf(parametro[1]);
		String nroCuenta = parametro[2];
		int codProducto = Integer.valueOf(parametro[3]);
		String enviarMsjClient="";
		Suscripcion suscrip;

		int posicion = eliminacionGenerica(arraySuscripciones, idPersona, nroCuenta, codProducto);

		if (posicion != -1) {

			suscrip = listClienteSuscrip.remove(posicion);

			enviarMsjClient = "Suscripción eliminada correctamente " + suscrip.toString();

		} else if (posicion == -1) {
			enviarMsjClient = "No se encontró ninguna suscripción coincidente con: \n " + "• IDPersona" + idPersona
					+ "\n• Nro. Cuenta" + nroCuenta + "\n• Cód. Producto" + codProducto;
		}
		return enviarMsjClient;
	}

	//Sub. eliminarSuscripcion
	private <T> int eliminacionGenerica(T[] arraySuscripciones, T idPersona, T nroCuenta, T codProducto) {
		int retorno = -1;
		int idPers = (int) idPersona;
		String nroCuen = (String) nroCuenta;
		int codProd = (int) codProducto;
		Suscripcion suscrip;

		for (int i = 0; i < arraySuscripciones.length; i++) {
			suscrip = (Suscripcion) arraySuscripciones[i];

			if (suscrip.getIdPersona() == idPers && suscrip.getNroCuenta().equalsIgnoreCase(nroCuen)
					&& suscrip.getCodProducto() == codProd) {
				retorno = i;
			}
		}

		return retorno;
	}
	
	private String modificarSuscripcion(String[] parametro) {
		String resultado = "";
		int idPersona = Integer.valueOf(parametro[1]);
		String nroCuenta = parametro[2];
		int codProducto = Integer.valueOf(parametro[3]);
		char estado = parametro[4].charAt(0);
		int monto = Integer.valueOf(parametro[5]);
		int iva = 0;
		int posicion = 0;
		Suscripcion suscripNueva;
		Iterator<Suscripcion> itSuscripcion = listClienteSuscrip.iterator();

		while (itSuscripcion.hasNext()) {
			suscripNueva = itSuscripcion.next();			
			iva = suscripNueva.getIva();			
			
			if (suscripNueva.getIdPersona() == idPersona && suscripNueva.getNroCuenta().equalsIgnoreCase(nroCuenta)
					&& suscripNueva.getCodProducto() == codProducto) {

				suscripNueva.setEstado(estado);
				suscripNueva.setMonto(monto);
				if(suscripNueva.VerificarIVA(iva))
					suscripNueva.setIva(iva);
				else
					iva= (monto * 10)/100;
				suscripNueva.setIva(iva);
				
				
				listClienteSuscrip.add(posicion, suscripNueva);
				resultado = "Se ha actualizado: " + suscripNueva.toString();
			}
			posicion++;
		}
		
		if (resultado.isEmpty()) {
			resultado = "No se ha encontrado ningún registro para actualizar";
		}

		return resultado;
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
            Logger.getLogger(OpServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OpServ.class.getName()).log(Level.SEVERE, null, ex);
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

}
