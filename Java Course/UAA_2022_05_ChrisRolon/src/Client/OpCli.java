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

public class OpCli {
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

	public OpCli(int numeroPuerto, String ipMaquina) {
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
			Logger.getLogger(OpCli.class.getName()).log(
					Level.WARNING, "Por favor, verifique que el servidor este levantado en la maquina con IP: "
							+ this.getIpMaquina() + " y escuche el PUERTO: " + this.getNumeroPuerto(),
					con.getMessage());
		} catch (Exception ex) {
			Logger.getLogger(OpCli.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private synchronized void ingresarDatos() {
		boolean repetirIteracion = true, errorIngresarDatos = true;
		while (repetirIteracion) {

			try {
				entrada = new BufferedReader(new InputStreamReader(System.in));
				int opcion = 0;
				while (opcion != 6) {
					System.out.println("------------------------------------");
					System.out.println("Opciones disponibles");
					System.out.println("------------------------------------");
					System.out.println("1- Agregar nueva suscripción telefónica.");
					System.out.println("2- Modificar suscripción telefónica.");
					System.out.println("3- Eliminar suscripción telefónica.");
					System.out.println("4- Consultar suscripciones activas por persona");
					System.out.println("5- Consultar suscripciones por producto.");
					System.out.println("6- Salir");
					System.out.println("------------------------------------");
					System.out.println("Seleccione una opcion:");

					do {
						try {
							opcion = Integer.parseInt(entrada.readLine());
							errorIngresarDatos = false;
						} catch (NumberFormatException num) {
							System.out.println("\nIngrese una opcion de 1 a 6\n");
							errorIngresarDatos = true;
						}
					} while (errorIngresarDatos);

					if (opcion < 1 || opcion > 6) {
						System.out.println("\nIngrese una opcion de 1 a 6\n");
						continue;
					}

					if (opcion == 6) {
						repetirIteracion = false;
						continue;
					}

					if (opcion >= 1 && opcion <= 5) {
						switch (opcion) {
						case 1:
							agregarSusc(opcion);
							break;
						case 2:
							modificarSusc(opcion);
							break;
						case 3:
							eliminarSusc(opcion);
							break;
						case 4:
							consultarPorPersona(opcion);
							break;
						case 5:
							consultarPorProducto(opcion);
							break;
						}
						
					}

					escucharDatos(socketCliente/*, opcion*/);
					Thread.sleep(1000);
				}

			} catch (Exception ex) {
				Logger.getLogger(OpCli.class.getName()).log(Level.SEVERE, null, ex);

			}

		}
		this.cerrarTodo();
	}

	private void consultarPorProducto(int opcion) {
		String resultado = "C | B";		
		enviarDatos(resultado);
	}

	private void consultarPorPersona(int opcion) throws IOException {
		String resultado = "";
		int idPersona = 0;

		boolean errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese ID de persona");
				idPersona = Integer.parseInt(entrada.readLine());
				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);
		
		resultado = "C | A | " + idPersona;
		
		enviarDatos(resultado);
		
	}

	private void eliminarSusc(int opcion)  throws IOException {
		String resultado = "";
		int idPersona = 0;
		String nroCuenta = "";
		int codProducto = 0;

		boolean errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese ID de persona");
				idPersona = Integer.parseInt(entrada.readLine());
				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		System.out.println("Ingrese número de cuenta");
		nroCuenta = entrada.readLine();

		errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese código de producto (1 - 5)");
				codProducto = Integer.parseInt(entrada.readLine());
				if (codProducto <= 0 || codProducto >= 6) {
					System.out.println("El código de producto debe ser del 1 al 5");
					errorIngresarDatos = true;
				}
				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		resultado = "D | " + idPersona + " | " + nroCuenta + " | " + codProducto;

		enviarDatos(resultado);
		
	}

	private void modificarSusc(int opcion) throws IOException {
		String resultado = "";
		int idPersona = 0;
		String nroCuenta = "";
		int codProducto = 0;
		char estado = ' ';
		int monto = 0;

		boolean errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese ID de persona");
				idPersona = Integer.parseInt(entrada.readLine());
				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		System.out.println("Ingrese número de cuenta");
		nroCuenta = entrada.readLine();

		errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese código de producto (1 - 5)");
				codProducto = Integer.parseInt(entrada.readLine());
				if (codProducto <= 0 || codProducto >= 6) {
					System.out.println("El código de producto debe ser del 1 al 5");
					errorIngresarDatos = true;
				}
				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		System.out.println("Ingrese el estado ( A (activo), I (inactivo) )");
		estado = entrada.readLine().toUpperCase().charAt(0);

		errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese monto a facturar");
				monto = Integer.parseInt(entrada.readLine());

				if (monto <= 0) {
					System.out.println("No se permite ingresar valores negativos o cero");
					errorIngresarDatos = true;
				}

				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		resultado = "B | " + idPersona + " | " + nroCuenta + " | " + codProducto + " | " + estado + " | " + monto;
		enviarDatos(resultado);
	}

	private void agregarSusc(int opcion) throws IOException {
		String resultado = "";
		int idPersona = 0;
		String nroCuenta = "";
		int codProducto = 0;
		char estado = ' ';
		int monto = 0;
		int iva = 0;

		boolean errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese ID de persona");
				idPersona = Integer.parseInt(entrada.readLine());
				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		System.out.println("Ingrese número de cuenta");
		nroCuenta = entrada.readLine();

		errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese código de producto (1 - 5)");
				codProducto = Integer.parseInt(entrada.readLine());
				if (codProducto <= 0 || codProducto >= 6) {
					System.out.println("El código de producto debe ser del 1 al 5");
					errorIngresarDatos = true;
				}
				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		System.out.println("Ingrese el estado ( A (activo), I (inactivo) )");
		estado = entrada.readLine().toUpperCase().charAt(0);

		errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese monto a facturar");
				monto = Integer.parseInt(entrada.readLine());

				if (monto <= 0) {
					System.out.println("No se permite ingresar valores negativos o cero");
					errorIngresarDatos = true;
				}

				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		errorIngresarDatos = true;
		do {
			try {
				System.out.println("Ingrese IVA");
				iva = Integer.parseInt(entrada.readLine());
				if (iva < (monto * 0.1) || iva > (monto * 0.1)) {
					System.out.println("El valor IVA ingresado no es del 10% sobre el monto ingresado");
					errorIngresarDatos = true;
				}

				errorIngresarDatos = false;

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número. Intente de nuevo.");
				errorIngresarDatos = true;
			}
		} while (errorIngresarDatos);

		resultado = "A | " + idPersona + " | " + nroCuenta + " | " + codProducto + " | " + estado + " | " + monto
				+ " | " + iva;

		enviarDatos(resultado);
		
	}

	private boolean escucharDatos(Socket socket) throws IOException {
		
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
			Logger.getLogger(OpCli.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(OpCli.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
