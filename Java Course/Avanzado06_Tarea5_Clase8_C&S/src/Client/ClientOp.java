package Client;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientOp {
	private Socket socketCliente = null;
	private BufferedReader entrada = null;
	private DataInputStream entradaDatos = null;
	private DataOutputStream salidaDatos = null;
	private int numeroPuerto;
	private String ipMaquina;

	public int getNumeroPuerto() {
		return numeroPuerto;
	}

	public String getIpMaquina() {
		return ipMaquina;
	}

	public ClientOp(int numeroPuerto, String ipMaquina) {
		this.numeroPuerto = numeroPuerto;
		this.ipMaquina = ipMaquina;
		this.conexion();
	}

	private void conexion() {
		try {
			socketCliente = new Socket(this.getIpMaquina(), this.getNumeroPuerto());

			Thread subProceso = new Thread(new Runnable() {
				@Override
				public void run() {
					ingresarDatos();
				}
			});

			subProceso.start();

		} catch (ConnectException con) {
			Logger.getLogger(ClientOp.class.getName()).log(
					Level.WARNING, "Por favor, verifique que el servidor este levantado en la maquina con IP: "
							+ this.getIpMaquina() + " y escuche el PUERTO: " + this.getNumeroPuerto(),
					con.getMessage());
		} catch (Exception ex) {
			Logger.getLogger(ClientOp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private synchronized void ingresarDatos() {
		boolean repetirIteracion = true, errorIngresarDatos = true;
		while (repetirIteracion) {

			try {
				entrada = new BufferedReader(new InputStreamReader(System.in));
				int opcion = 0;
				while (opcion != 4) {
					System.out.println("------------------------------------");
					System.out.println("Opciones disponibles");
					System.out.println("------------------------------------");
					System.out.println("1- Agregar nuevo profesor");
					System.out.println("2- Consultar materias de profesor por CI");
					System.out.println("3- Consultar materias por facultad");
					System.out.println("4- Salir");
					System.out.println("------------------------------------");
					System.out.println("Seleccione una opcion:");

					do {
						try {
							opcion = Integer.parseInt(entrada.readLine());
							errorIngresarDatos = false;
						} catch (NumberFormatException num) {
							System.out.println("\nIngrese una opcion de 1 a 4\n");
							errorIngresarDatos = true;
						}
					} while (errorIngresarDatos);

					if (opcion < 1 || opcion > 4) {
						System.out.println("\nIngrese una opcion de 1 a 4\n");
						continue;
					}

					if (opcion == 4) {
						repetirIteracion = false;
						continue;
					}

					if (opcion >= 1 && opcion <= 3) {
						switch (opcion) {
						case 1:
							agregarProfesor(opcion);
							break;
						case 2:
							consultarMatProfPorCi(opcion);
							break;
						case 3:
							consultarMatPorFacu(opcion);
							break;
						}
					}

					escucharDatos(socketCliente/*, opcion*/);
					Thread.sleep(1000);
				}

			} catch (Exception ex) {
				Logger.getLogger(ClientOp.class.getName()).log(Level.SEVERE, null, ex);

			}

		}
		this.cerrarTodo();
	}

	private boolean escucharDatos(Socket socket/*, int opcion*/) throws IOException {
		
			InputStream inputStream = null;
			String cadenaRecibida = null;
			inputStream = socket.getInputStream();
			entradaDatos = new DataInputStream(inputStream);
			cadenaRecibida = entradaDatos.readUTF();
			
			System.out.println(cadenaRecibida);

		return false;
	}

	private void enviarDatos(String datos) {

		try {
			OutputStream outputStream = null;
			outputStream = socketCliente.getOutputStream();
			salidaDatos = new DataOutputStream(outputStream);
			salidaDatos.writeUTF(datos);
			salidaDatos.flush();
		} catch (IOException ex) {
			Logger.getLogger(ClientOp.class.getName()).log(Level.SEVERE, null, ex);
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

			if (socketCliente != null) {
				socketCliente.close();
				System.out.printf("\nEl Socket en el puerto:%d se bajo\n", this.getNumeroPuerto());
			}

		} catch (IOException ex) {
			Logger.getLogger(ClientOp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void agregarProfesor(int opcion) throws IOException {
		String nombreCompleto, cedula, materia, curso, facultad, retorno;
		char semestre;
		int anoLectivo;

		System.out.println("\nIngrese nombre completo del profesor\n");
		nombreCompleto = entrada.readLine();

		System.out.println("\nIngrese cédula del profesor\n");
		cedula = entrada.readLine();

		System.out.println("\nIngrese la materia del profesor\n");
		materia = entrada.readLine();

		System.out.println("\nIngrese curso del profesor\n");
		curso = entrada.readLine();

		System.out.println("\nIngrese el semestre del profesor (O, P, V)\n");
		semestre = entrada.readLine().toUpperCase().charAt(0);

		System.out.println("\nIngrese la facultad del profesor\n");
		facultad = entrada.readLine();

		System.out.println("\nIngrese año lectivo del profesor\n");
		anoLectivo = Integer.parseInt(entrada.readLine());

		retorno = opcion + " - " + nombreCompleto + " - " + cedula + " - " + materia + " - " + curso + " - " + semestre
				+ " - " + facultad + " - " + anoLectivo;

		enviarDatos(retorno);
	}

	private void consultarMatProfPorCi(int opcion) throws IOException {
		String cedula, retorno;

		System.out.println("\nIngrese la cédula del profesor\n");
		cedula = entrada.readLine();

		retorno = opcion + " - " + cedula;

		enviarDatos(retorno);
	}

	private void consultarMatPorFacu(int opcion) throws IOException {
		String facultad, retorno;

		System.out.println("\nIngrese la facultad del profesor\n");
		facultad = entrada.readLine();

		retorno = opcion + " - " + facultad;

		enviarDatos(retorno);
	}
}