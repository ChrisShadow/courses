package Vacunacion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static Scanner data = new Scanner(System.in);
	//Banderas para menú
	public static boolean banC=false;

	//Clases
	public static MenuOperaciones mU;
	public static Vacuna v;
	public static Archivo aR;

	public static void main(String[] args) {
		int banOpcion=0;
		do {
			try {
				mU = new MenuOperaciones();
				aR= new Archivo ();
				MenuOperaciones(banOpcion);
				banOpcion=1;
			} catch (InputMismatchException v ) {
				System.err.println("La opción no es numérica.Intenta de nuevo");
				banOpcion=0;
				data.nextLine();
			}catch (SQLException e) {
				System.err.println("Error de: " + e.getMessage());
				banOpcion=0;
				data.nextLine();
			}
		} while (banOpcion!=1);
		System.err.println("**THE END OF FUCKING JAVA**");
	}

	private static void MenuOperaciones(int banOpcion) {
		int opcion=0;
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("1- Cargar 6 registros de vacunación");
			System.out.println("2- Consultar registros de vacunación");
			System.out.println("3- Actualizar registro de vacunación");
			System.out.println("4- Eliminar registro de vacunación");
			System.out.println("5- Generar archivo CSV");
			System.out.println("6- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1:
				AddVacunacion();
				//banC=true;
				break;
			case 2:
				//if(banC) {
					ConsultarVacunacion();
				/*}else {
					System.err.println("Debe ejecutar la opción 1.");
				}*/
				break;
			case 3:
				//if(banC) {
					UpdVacunacion();
				/*}else {
					System.err.println("Debe ejecutar la opción 1.");
				}*/
				break;
			case 4:
				//if(banC) {
					DeleteVacunacion();
				/*}else {
					System.err.println("Debe ejecutar la opción 1.");
				}*/
				break;
			case 5:
					GenerarArchivo();
				break;
			case 6:
				System.out.println("Finalizando menú...\n");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=6);
	}

	//Opcion 5
	private static void GenerarArchivo() {
		try {
			aR.GuardarArchivo(mU.LeerVacuna());
			System.out.println("Archivo generardo correctamente");
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de "+e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}

	}

	//Opcion 4
	private static void DeleteVacunacion() {
		int dosis=0;
		int tipoVacuna=0;
		String tipo="";
		TipoVacuna v1= TipoVacuna.COVAXIN;
		TipoVacuna v2= TipoVacuna.PFIZER;
		TipoVacuna v5= TipoVacuna.ASTRAZENECA;
		TipoVacuna v3= TipoVacuna.MODERNA;
		TipoVacuna v4= TipoVacuna.SPUTNIKV;
		TipoVacuna v6= TipoVacuna.HAYATVAX;

		//Ingreso de datos según grupo de vacunas
		do {
			try {
				System.out.println("Ingrese el tipo de vacuna(1:COVAXIN;2:PFIZER;3:MODERNA;4:SPUTNIKV;5:ASTRAZENECA;6:HAYATVAX): ");
				tipoVacuna=data.nextInt();

				if(tipoVacuna<1 || tipoVacuna>6 ) {
					System.err.println("Opción no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(tipoVacuna<1 || tipoVacuna>6);
		switch (tipoVacuna) {
		case 1:
			tipo=v1.name();
			break;
		case 2:
			tipo=v2.name();
			break;
		case 3:
			tipo=v3.name();
			break;
		case 4:
			tipo=v4.name();
			break;
		case 5:
			tipo=v5.name();
			break;
		default:
			tipo=v6.name();
			break;
		}

		//Ingreso del nro Dosis
		do {
			try {
				System.out.println("Ingrese el nro Dosis: ");
				dosis=data.nextInt();

				if(dosis<1 || dosis>2 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(dosis<1 || dosis>2);

		try {
			v=mU.BuscarVacuna(dosis, tipo);
			if (v!=null) {
				boolean b= mU.SentenciaEliminar(v);
				if(b)
					System.out.println("\nRegistro eliminado correctamente:\n");
				System.err.println(v.toString());
			}else {
				System.err.println("No se encontró ningún registro para eliminar");
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}finally {
			try {
				boolean cerrar=mU.getDB().cerrarConexion();
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage());
			}
		}
	}

	//Opcion 3
	private static void UpdVacunacion() {
		int dosis=0;
		int tipoVacuna=0;
		String tipo="";
		TipoVacuna v1= TipoVacuna.COVAXIN;
		TipoVacuna v2= TipoVacuna.PFIZER;
		TipoVacuna v5= TipoVacuna.ASTRAZENECA;
		TipoVacuna v3= TipoVacuna.MODERNA;
		TipoVacuna v4= TipoVacuna.SPUTNIKV;
		TipoVacuna v6= TipoVacuna.HAYATVAX;

		//Ingreso de datos según grupo de vacunas
		do {
			try {
				System.out.println("Ingrese el tipo de vacuna(1:COVAXIN;2:PFIZER;3:MODERNA;4:SPUTNIKV;5:ASTRAZENECA;6:HAYATVAX): ");
				tipoVacuna=data.nextInt();

				if(tipoVacuna<1 || tipoVacuna>6 ) {
					System.err.println("Opción no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(tipoVacuna<1 || tipoVacuna>6);
		switch (tipoVacuna) {
		case 1:
			tipo=v1.name();
			break;
		case 2:
			tipo=v2.name();
			break;
		case 3:
			tipo=v3.name();
			break;
		case 4:
			tipo=v4.name();
			break;
		case 5:
			tipo=v5.name();
			break;
		default:
			tipo=v6.name();
			break;
		}

		//Ingreso del nro Dosis
		do {
			try {
				System.out.println("Ingrese el nro Dosis: ");
				dosis=data.nextInt();

				if(dosis<1 || dosis>2 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(dosis<1 || dosis>2);

		try {
			v=mU.BuscarVacuna(dosis, tipo);
			if (v!=null) {
				//Ingreso del lugar de vacunación
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese el lugar de vacunación: ");
						v.setLugar_vacunacion(data.nextLine().trim());
						if(v.getLugar_vacunacion().isBlank() || v.getLugar_vacunacion().isEmpty()) {
							System.err.println("Dato no admitido. Vuelva a intentar.");
						}
					} catch (Exception eL) {
						System.err.println(eL.getMessage());
					}
				} while (v.getLugar_vacunacion().isBlank() || v.getLugar_vacunacion().isEmpty());

				//Ingreso de la fecha/hora de carga
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese la la fecha/hora de carga(formato valido dd/mm/yyyy_HH:MM): ");
						v.setFecha_hora_carga(data.next().trim());
						if(!ValidarFechaHora(v.getFecha_hora_carga())) {
							System.err.println("Formato inválido. Vuelva a ingresar");
						}
					} catch (Exception ex) {
						System.err.println(ex.getMessage());
					}
				}while(v.getFecha_hora_carga().equals(null) || v.getFecha_hora_carga().isEmpty() || v.getFecha_hora_carga().isBlank() || !ValidarFechaHora(v.getFecha_hora_carga()));
				System.out.println("\nCantidad de registros actualizado: " + mU.SentenciaModificar(v));
			}else {
				System.err.println("No se encontró ningún registro para actualizar");
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}finally {
			try {
				boolean cerrar=mU.getDB().cerrarConexion();
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage());
			}
		}
	}

	//Opcion 2
	private static void ConsultarVacunacion() {
		System.out.println(Generarreporte());
	}

	private static StringBuilder Generarreporte() {
		ArrayList<GrupoUno> liG1=null;
		ArrayList<GrupoDos> liG2=null;
		ArrayList<GrupoTres> liG3=null;
		StringBuilder reporte= new StringBuilder();
		reporte.append("\nGrupo Uno\n");
		try {
			mU.consultarVAcunaGrupo1();
			liG1=mU.liG1;
			mU.consultarVAcunaGrupo2();
			liG2=mU.liG2;
			mU.consultarVAcunaGrupo3();
			liG3=mU.liG3;
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}
		for (GrupoUno grupoUno : liG1) {
			reporte.append(grupoUno.toString());
		}
		reporte.append("\nGrupo Dos\n");
		for (GrupoDos grupoDos : liG2) {
			reporte.append(grupoDos.toString());
		}
		reporte.append("\nGrupo Tres\n");
		for (GrupoTres grupoTres : liG3) {
			reporte.append(grupoTres.toString());
		}
		return reporte;
	}

	//Opción 1
	private static void AddVacunacion() {
		Vacuna[] vC=new Vacuna[2];
		int contadorInser=0;
		int contadorNoInser=0;
		int auxAux=0;
		boolean cerrar=false;

		//Cargando datos al vector
		for (int i = 0; i <= vC.length-1 ; i++) {
			try {
				v=CargarRegVac();
				vC[i]=v;
			}catch(ArrayIndexOutOfBoundsException g) {
				System.err.println("Error de "+ g.getMessage());
			}
			
		}

		//Insertar
		for (int i = 0; i <= vC.length-1; i++) {
			try {
				auxAux=mU.SentenciaInsertar(vC[i]);
				//contadorInser++;
				if (auxAux>0) {
					//System.out.println("\nVacuna guardada correctamente\n");
					contadorInser++;
				}else {
					contadorNoInser ++;
				}
				//System.out.println("\nTotal de registros insertados("+contadorInser+") y total de registros no insertados("+contadorNoInser+")");
			}catch (NullPointerException e) {
				System.err.println("Error de "+e.getMessage());
				contadorNoInser ++;
			} catch (SQLException e) {
				System.out.println("Error de " + e.getMessage());
				contadorNoInser ++;
			}finally {
				try {
					cerrar=mU.getDB().cerrarConexion();
				} catch (SQLException e) {
					System.err.println("Error de "+e.getMessage());
				}
			}

		}
		System.out.println("\nVacuna guardada correctamente\n");
		System.out.println("\nTotal de registros insertados("+contadorInser+") y total de registros no insertados("+contadorNoInser+")");


	}

	//Subfunción
	private static Vacuna CargarRegVac() {
		//supercase
		int dosis=0;
		String documento="";
		String lugar_vacunacion="";
		String fecha_aplicacion="";
		int tipoVacuna=0;
		TipoVacuna v1= TipoVacuna.COVAXIN;
		TipoVacuna v2= TipoVacuna.PFIZER;
		TipoVacuna v5= TipoVacuna.ASTRAZENECA;
		TipoVacuna v3= TipoVacuna.MODERNA;
		TipoVacuna v4= TipoVacuna.SPUTNIKV;
		TipoVacuna v6= TipoVacuna.HAYATVAX;
		String fecha_hora_carga="";

		//subclase
		GrupoUno g1=null;
		String es_donada="";
		GrupoDos g2=null;
		int costo_vacuna=0;
		GrupoTres g3=null;
		String numero_lote="";

		Vacuna v=null;

		//Ingreso del nro Dosis
		do {
			try {
				System.out.println("\nIngresando datos de la vacuna...\n\nIngrese el nro Dosis(1-2): ");
				dosis=data.nextInt();

				if(dosis<1 || dosis>2 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(dosis<1 || dosis>2);


		//Ingreso del Nro. Documento
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el Nro. Documento: ");
				documento=data.next();
				documento=documento.trim();
				if(documento.isBlank() || documento.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}
		} while (documento.isBlank() || documento.isEmpty());

		//Ingreso del lugar de vacunación
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el lugar de vacunación: ");
				lugar_vacunacion=data.nextLine();
				lugar_vacunacion=lugar_vacunacion.trim();
				if(lugar_vacunacion.isBlank() || lugar_vacunacion.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}
		} while (lugar_vacunacion.isBlank() || lugar_vacunacion.isEmpty());

		//Ingreso de la fecha de aplicación
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la fecha de aplicación(formato valido dd/mm/yyyy): ");
				fecha_aplicacion=data.next();
				fecha_aplicacion=fecha_aplicacion.trim();
				if(!ValidarFecha(fecha_aplicacion)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(fecha_aplicacion.equals(null) || fecha_aplicacion.isEmpty() || fecha_aplicacion.isBlank() || !ValidarFecha(fecha_aplicacion));


		//Ingreso de la fecha/hora de carga
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la la fecha/hora de carga(formato valido dd/mm/yyyy_HH:MM): ");
				fecha_hora_carga=data.next();
				fecha_hora_carga=fecha_hora_carga.trim();
				if(!ValidarFechaHora(fecha_hora_carga)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(fecha_hora_carga.equals(null) || fecha_hora_carga.isEmpty() || fecha_hora_carga.isBlank() || !ValidarFechaHora(fecha_hora_carga)); //|| !ValidarFechaHora(fecha_hora_carga)

		//Ingreso de datos según grupo de vacunas
		do {
			data.nextLine();
			try {
				System.out.println("Ingrese el tipo de vacuna(1:COVAXIN;2:PFIZER;3:MODERNA;4:SPUTNIKV;5:ASTRAZENECA;6:HAYATVAX): ");
				tipoVacuna=data.nextInt();

				if(tipoVacuna<1 || tipoVacuna>6 ) {
					System.err.println("Opción no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(tipoVacuna<1 || tipoVacuna>6);


		if (tipoVacuna==1 || tipoVacuna==2) {
			//Ingreso si es donada
			do {
				try {
					data.nextLine();
					System.out.println("¿Es donada?(S/N): ");
					es_donada=data.next();
					es_donada=es_donada.toUpperCase();
					es_donada=es_donada.trim();
					if(es_donada.isBlank() || es_donada.isEmpty() || (!es_donada.equals("S") && !es_donada.equals("N"))) {
						System.err.println("Opción no admitida. Vuelva a intentar.");
					}
				} catch (Exception eL) {
					System.err.println(eL.getMessage());
				}
			} while (es_donada.isBlank() || es_donada.isEmpty() || (!es_donada.equals("S") && !es_donada.equals("N")));
			if(tipoVacuna==1)
				g1= new GrupoUno(dosis, documento, lugar_vacunacion, fecha_aplicacion, v1 , fecha_hora_carga,es_donada.charAt(0));
			if(tipoVacuna==2)
				g1= new GrupoUno(dosis, documento, lugar_vacunacion, fecha_aplicacion, v2 , fecha_hora_carga,es_donada.charAt(0));
			//Casteo
			v= g1;

		}else if(tipoVacuna==3 || tipoVacuna==4) {
			//Ingreso del costo
			do {
				try {
					System.out.println("Ingrese el costo de la vacuna: ");
					costo_vacuna=data.nextInt();

					if(costo_vacuna<1 ) {
						System.err.println("Cifra no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(costo_vacuna<1);
			if(tipoVacuna==3)
				g2= new GrupoDos(dosis, documento, lugar_vacunacion, fecha_aplicacion, v3 , fecha_hora_carga,costo_vacuna);
			if(tipoVacuna==4)
				g2= new GrupoDos(dosis, documento, lugar_vacunacion, fecha_aplicacion, v4 , fecha_hora_carga,costo_vacuna);
			//Casteo
			v= g2;
		}else {
			//Ingreso del Nro. Lote
			do {
				try {
					data.nextLine();
					System.out.println("Ingrese el Nro. lote (formato valido xxx_99X): ");
					numero_lote=data.next();
					numero_lote=numero_lote.trim();
					if(!ValidarNroLote(numero_lote)) {
						System.err.println("Formato inválido. Vuelva a ingresar");
					}
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}while(numero_lote.equals(null) || numero_lote.isEmpty() || numero_lote.isBlank() || !ValidarNroLote(numero_lote));
			if(tipoVacuna==5)
				g3= new GrupoTres(dosis, documento, lugar_vacunacion, fecha_aplicacion, v5 , fecha_hora_carga,numero_lote);
			if(tipoVacuna==6)
				g3= new GrupoTres(dosis, documento, lugar_vacunacion, fecha_aplicacion, v6 , fecha_hora_carga,numero_lote);
			//Casteo
			v= g3;
		}

		return v;
	}

	//Expresión regular las fechas
	public static boolean ValidarFecha(String fecha) {
		return fecha.matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$");
	}

	//Expresión regular las fechas/horas
	public static boolean ValidarFechaHora(String fechaH) {
		return fechaH.matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})_([0-1][0-9]|2[0-3]):([0-5][0-9])$"); //(:)([0-5][0-9])
		//return fechaH.matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})(\\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])$");
	}

	//Expresión regular para el Nro. Lote
	public static boolean ValidarNroLote(String lote) {
		return lote.matches("[a-z]+_[0-9]+[A-Z]");
	}
}
