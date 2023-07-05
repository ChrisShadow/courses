package ExamenFinal;

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
	public static Registro rE;
	public static Estadistica eS;
	public static Archivo aR;	
	
	public static void main(String[] args) {
		int banOpcion=0;
		do {
			try {
				mU = new MenuOperaciones();
				aR= new Archivo ();
				//char opcion=MenuOperaciones(banOpcion);
				MenuOperaciones(banOpcion);
				banOpcion=1;
				/*if(opcion=='f') {
					banOpcion=1;
				}*/
			} catch (InputMismatchException v ) {
				System.err.println("La opción no es letra.Intenta de nuevo");
				banOpcion=0;
				data.nextLine();
			} catch (SQLException e) {
				System.err.println("Error de: " + e.getMessage());
				banOpcion=0;
				data.nextLine();
			}
		} while (banOpcion!=1);
		System.err.println("**PROGRAMA FINALIZADO**");
	}

	private static void MenuOperaciones(int banOpcion) { //char
		String opcion="";
		do {
			data.nextLine();
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("a- Cargar 30 registros de vacunación");
			System.out.println("b- Actualizar registro de vacunación");
			System.out.println("c- Registros de vacunación por grupo");
			System.out.println("d- Estadística de registro de vacunación por departamento");
			System.out.println("e- Generar archivo .info");
			System.out.println("f- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextLine().trim();
			opcion= opcion.toLowerCase();
			switch (opcion) {
			case "a":
				AddVacunacion();
				//banC=true;
				break;
			case "b":
				//if(banC) {
				UpdVacunacion();
				/*}else {
					System.err.println("Debe ejecutar la opción 1.");
				}*/
				break;
			case "c":
				//if(banC) {
				SelectVacunacion();
				/*}else {
					System.err.println("Debe ejecutar la opción 1.");
				}*/
				break;
			case "d":
				//if(banC) {
				SelectEstadistica();
				/*}else {
					System.err.println("Debe ejecutar la opción 1.");
				}*/
				break;
			case "e":
					GenerarArchivo();
				break;
			case "f":
				System.out.println("Finalizando menú...\n");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(!opcion.equals("f"));
		//return opcion.charAt(0);
	}
	
	//Opcion e
	private static void GenerarArchivo() {
		try {
			aR.GuardarArchivo(mU.LeerEstadistica());
			System.out.println("Archivo generardo correctamente");
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de "+e.getMessage());
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}
	}

	//Opcion d
	private static void SelectEstadistica() {
		ArrayList<Estadistica> liEt=null;
		StringBuilder reporte= new StringBuilder();
		reporte.append("\nEstadística por número de departamento y número de dosis\n");
		try {
			mU.ConsultarEstadistica();
			liEt=mU.liEs;
			for (Estadistica estadistica : liEt) {
				reporte.append(estadistica.toString());
			}
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}
		System.out.println(reporte);
	}

	//Opcion c
	private static void SelectVacunacion() {
		System.out.println(Generarreporte());
	}

	private static StringBuilder Generarreporte() {
		ArrayList<Grupo1> liG1=null;
		ArrayList<Grupo2> liG2=null;
		StringBuilder reporte= new StringBuilder();
		reporte.append("\n-----Grupo Uno-----\n");
		try {
			mU.consultarVAcunaGrupo1();
			liG1=mU.liG1;
			mU.consultarVAcunaGrupo2();
			liG2=mU.liG2;
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}
		for (Grupo1 grupoUno : liG1) {
			reporte.append(grupoUno.toString());
		}
		reporte.append("\n-----Grupo Dos-----\n");
		for (Grupo2 grupoDos : liG2) {
			reporte.append(grupoDos.toString());
		}
		
		return reporte;
	}

	//Opción b
	private static void UpdVacunacion() {
		int auxEstado=5;
		int dosis=0;
		String documento="";
		String fecha_aplicacion="";
		int estado=0;
		String sexo="";
		int departamento_donde_vive=0;
		
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
		
		
		//Ingreso del nro Dosis
		do {
			try {
				System.out.println("Ingrese el nro Dosis(1-3): ");
				dosis=data.nextInt();

				if(dosis<1 || dosis>3 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(dosis<1 || dosis>3);	
		
		//Ingreso de la fecha de aplicación
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la fecha de aplicación(formato valido dd/mm/yyyy_hh:mm:ss): ");
				fecha_aplicacion=data.next();
				fecha_aplicacion=fecha_aplicacion.trim();
				if(!ValidarFechaHora(fecha_aplicacion)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(fecha_aplicacion.equals(null) || fecha_aplicacion.isEmpty() || fecha_aplicacion.isBlank() || !ValidarFechaHora(fecha_aplicacion));		
		
		//Ingreso del estado
		do {
			try {
				System.out.println("Ingrese el Estado(1=activo;0=inactivo): ");
				estado=data.nextInt();

				if(estado<0 || estado>1 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(estado<0 || estado>1);
		auxEstado=estado;
		
		try {
			rE=mU.BuscarVacuna(documento,dosis,fecha_aplicacion,estado);
			if (rE!=null) {
				//Ingreso del Sexo
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese el sexo(Masculino;Femenino): ");
						sexo=data.nextLine().trim();
						if(sexo.isBlank() || sexo.isEmpty() || (!sexo.equals("Masculino") && !sexo.equals("Femenino"))) {
							System.err.println("Dato no admitido. Vuelva a intentar.");
						}
					} catch (Exception eL) {
						System.err.println(eL.getMessage());
					}
				} while (sexo.isBlank() || sexo.isEmpty() || (!sexo.equals("Masculino") && !sexo.equals("Femenino")));
				rE.setSexo(sexo);
				
				//Ingreso del Departamento
				do {
					try {
						System.out.println("Ingrese el nro del Departamento(1-17): ");
						departamento_donde_vive=data.nextInt();

						if(departamento_donde_vive<1 || departamento_donde_vive>17 ) {
							System.err.println("Cifra no admitida. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(departamento_donde_vive<1 || departamento_donde_vive>17);	
				rE.setDepartamento_donde_vive(departamento_donde_vive);
				
				//Ingreso del estado
				do {
					try {
						System.out.println("Ingrese el Estado(1=activo;0=inactivo): ");
						estado=data.nextInt();

						if(estado<0 || estado>1 ) {
							System.err.println("Cifra no admitida. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(estado<0 || estado>1);
				rE.setEstado(estado);
				boolean re= mU.SentenciaModificarReg(rE);
				if(re)
					
					System.out.println("\nRegistro Actualizado: "+ documento+" ; "+dosis+" ; "+fecha_aplicacion+" ; "+auxEstado );
				if(re==false)
					System.err.println("No se pudu actualizar.");
			}else {
				System.err.println("Registro inexistente.");
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

	//Opción a
	private static void AddVacunacion() {
		Registro[] vC=new Registro[1];
		Estadistica[] eT= new Estadistica[1];
		int contadorInser=0;
		int contadorNoInser=0;
		int auxAux=0;
		boolean cerrar=false;

		//Cargando datos al vector
		for (int i = 0; i <= vC.length-1 ; i++) {
			try {
				//Sub1 
				rE=CargarRegVac();
				vC[i]=rE;
			}catch(ArrayIndexOutOfBoundsException g) {
				System.err.println("Error de "+ g.getMessage());
			}
			
		}

		//Insertar
		for (int i = 0; i <= vC.length-1; i++) {
			try {
				auxAux=mU.SentenciaInsertarReg(vC[i]);
				//contadorInser++;
				if (auxAux>0) {
					//Sub2
					eS=CargarRegEstad(vC[i]);
					eT[contadorInser]=eS;
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
			}catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Error de "+e.getMessage());
				contadorNoInser ++;
			}finally {
				try {
					cerrar=mU.getDB().cerrarConexion();
				} catch (SQLException e) {
					System.err.println("Error de "+e.getMessage());
				}
			}

		}
		System.out.println("\nRegistro guardada correctamente\n");
		System.out.println("\nTotal de registros insertados("+contadorInser+") y total de registros no insertados("+contadorNoInser+")");


	}
	
	//Sub2
	private static Estadistica CargarRegEstad(Registro registro) {
		return new Estadistica(registro.getSexo(), registro.getDepartamento_donde_vive(), registro.getVacuna(), registro.getDosis());
	}

	//Sub1 
	private static Registro CargarRegVac() {
		//Superclase
		int dosis=0;
		String documento="";
		String fecha_aplicacion="";
		int estado=0;
		String sexo="";
		int departamento_donde_vive=0;
		//Subclases
		Vacuna v1= Vacuna.COVAXIN;
		Vacuna v2= Vacuna.PFIZER;
		Vacuna v3= Vacuna.ASTRAZENECA;
		Vacuna v4= Vacuna.MODERNA;
		int tipoVacuna=0;
		String es_donada="";
		//G1
		String numero_lote="";
		String fecha_compra="";
		String fecha_vencimiento="";
		//G2
		int costo_vacuna=0;
		int intervalo_siguiente_dosis=0;
		int dias_restante_vencimiento=0;
	
		Registro rT= null;
		
		Grupo1 g1= null;
		Grupo2 g2=null;
		
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
		
		//Ingreso del Departamento
		do {
			try {
				System.out.println("Ingrese el nro del Departamento(1-17): ");
				departamento_donde_vive=data.nextInt();

				if(departamento_donde_vive<1 || departamento_donde_vive>17 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(departamento_donde_vive<1 || departamento_donde_vive>17);
		
		//Ingreso del Sexo
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el sexo(Masculino;Femenino): ");
				sexo=data.nextLine().trim();
				if(sexo.isBlank() || sexo.isEmpty() || (!sexo.equals("Masculino") && !sexo.equals("Femenino"))) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}
		} while (sexo.isBlank() || sexo.isEmpty() || (!sexo.equals("Masculino") && !sexo.equals("Femenino")));
		
		//Ingreso de datos según grupo de vacunas
		do {
			data.nextLine();
			try {
				System.out.println("Ingrese el tipo de vacuna(1:COVAXIN;2:PFIZER;3:ASTRAZENECA;4:MODERNA: ");
				tipoVacuna=data.nextInt();
			if(tipoVacuna<1 || tipoVacuna>4) {
				System.err.println("Opción no admitida. Vuelva a intentar.");
			}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(tipoVacuna<1 || tipoVacuna>4);		
		
		//Ingreso del nro Dosis
		do {
			try {
				System.out.println("Ingrese el nro Dosis(1-3): ");
				dosis=data.nextInt();

				if(dosis<1 || dosis>3 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(dosis<1 || dosis>3);	
		
		//Ingreso de la fecha de aplicación
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la fecha de aplicación(formato valido dd/mm/yyyy_hh:mm:ss): ");
				fecha_aplicacion=data.next();
				fecha_aplicacion=fecha_aplicacion.trim();
				if(!ValidarFechaHora(fecha_aplicacion)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(fecha_aplicacion.equals(null) || fecha_aplicacion.isEmpty() || fecha_aplicacion.isBlank() || !ValidarFechaHora(fecha_aplicacion));		
		
		//Ingreso del estado
		do {
			try {
				System.out.println("Ingrese el Estado(1=activo;0=inactivo): ");
				estado=data.nextInt();

				if(estado<0 || estado>1 ) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(estado<0 || estado>1);	
		
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
		
		if (es_donada.equals("N")) {
			
			if(tipoVacuna==1 || tipoVacuna==3) {
				//Ingreso del Nro. Lote
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese el Nro. lote (formato valido 9=x9x/9X#X99X): ");
						numero_lote=data.next();
						numero_lote=numero_lote.trim();
						if(!ValidarNroLote(numero_lote)) {
							System.err.println("Formato inválido. Vuelva a ingresar");
						}
					} catch (Exception ex) {
						System.err.println(ex.getMessage());
					}
				}while(numero_lote.equals(null) || numero_lote.isEmpty() || numero_lote.isBlank() || !ValidarNroLote(numero_lote));
				
				//Ingreso Fecha compra
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese la la fecha/hora de compra(formato valido  yyyy/dd/mm): ");
						fecha_compra=data.next();
						fecha_compra=fecha_compra.trim();
						if(!ValidarFecha(fecha_compra)) {
							System.err.println("Formato inválido. Vuelva a ingresar");
						}
					} catch (Exception ex) {
						System.err.println(ex.getMessage());
					}
				}while(fecha_compra.equals(null) || fecha_compra.isEmpty() || fecha_compra.isBlank() || !ValidarFecha(fecha_compra)); //|| !ValidarFechaHora(fecha_hora_carga)
				
				//Ingreso Fecha vencimiento
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese la la fecha/hora de vencimiento(formato valido yyyy/dd/mm): ");
						fecha_vencimiento=data.next();
						fecha_vencimiento=fecha_vencimiento.trim();
						if(!ValidarFecha(fecha_vencimiento)) {
							System.err.println("Formato inválido. Vuelva a ingresar");
						}
					} catch (Exception ex) {
						System.err.println(ex.getMessage());
					}
				}while(fecha_vencimiento.equals(null) || fecha_vencimiento.isEmpty() || fecha_vencimiento.isBlank() || !ValidarFecha(fecha_vencimiento)); //|| !ValidarFechaHora(fecha_hora_carga)
				
				if(tipoVacuna==1) 
					g1= new Grupo1(documento, departamento_donde_vive, sexo, v1, dosis, fecha_aplicacion, estado, es_donada.charAt(0),numero_lote, fecha_compra, fecha_vencimiento);
				if(tipoVacuna==3) 
					g1= new Grupo1(documento, departamento_donde_vive, sexo, v3, dosis, fecha_aplicacion, estado, es_donada.charAt(0),numero_lote, fecha_compra, fecha_vencimiento);
				
				rT=g1;
			}else {
				//Ingreso del costo de la vacuna
				do {
					try {
						System.out.println("Ingrese el costo de la vacuna(Mayor a 5mil): ");
						costo_vacuna=data.nextInt();

						if(costo_vacuna<5000 ) {
							System.err.println("Cifra no admitida. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(costo_vacuna<5000);	
				
				//Ingreso del intérvalo siguiente dosis
				do {
					try {
						System.out.println("Ingrese el intérvalo de la siguiente dosis(Apartir de 4 hastas 17): ");
						intervalo_siguiente_dosis=data.nextInt();

						if(intervalo_siguiente_dosis<4 || intervalo_siguiente_dosis>17) {
							System.err.println("Cifra no admitida. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(intervalo_siguiente_dosis<3 || intervalo_siguiente_dosis>17);	
				
				
				//Ingreso de los días restante de vencimiento 
				do {
					try {
						System.out.println("Ingrese los días restante de vencimiento(A partir de 16): ");
						dias_restante_vencimiento=data.nextInt();

						if(dias_restante_vencimiento<16) {
							System.err.println("Cifra no admitida. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(dias_restante_vencimiento<16);	
			
				if(tipoVacuna==2) 
					g2= new Grupo2(documento, departamento_donde_vive, sexo, v2, dosis, fecha_aplicacion, estado, es_donada.charAt(0),costo_vacuna, intervalo_siguiente_dosis, dias_restante_vencimiento);
				if(tipoVacuna==4) 
					g2= new Grupo2(documento, departamento_donde_vive, sexo, v4, dosis, fecha_aplicacion, estado, es_donada.charAt(0),costo_vacuna, intervalo_siguiente_dosis, dias_restante_vencimiento);
				
				rT=g2;		
			
			}
		}else {
			if(tipoVacuna==1 || tipoVacuna==3) {
				numero_lote="0=u0u/0U#U00U";
				fecha_compra="0000/00/00";
				fecha_vencimiento="0001/00/00";
			
				if(tipoVacuna==1) 
					g1= new Grupo1(documento, departamento_donde_vive, sexo, v1, dosis, fecha_aplicacion, estado, es_donada.charAt(0),numero_lote, fecha_compra, fecha_vencimiento);
				if(tipoVacuna==3) 
					g1= new Grupo1(documento, departamento_donde_vive, sexo, v3, dosis, fecha_aplicacion, estado, es_donada.charAt(0),numero_lote, fecha_compra, fecha_vencimiento);
				
				rT=g1;		
			
			}else {
				costo_vacuna=0;
				intervalo_siguiente_dosis=4;
				dias_restante_vencimiento=30;
				
				if(tipoVacuna==2) 
					g2= new Grupo2(documento, departamento_donde_vive, sexo, v2, dosis, fecha_aplicacion, estado, es_donada.charAt(0),costo_vacuna, intervalo_siguiente_dosis, dias_restante_vencimiento);
				if(tipoVacuna==4) 
					g2= new Grupo2(documento, departamento_donde_vive, sexo, v4, dosis, fecha_aplicacion, estado, es_donada.charAt(0),costo_vacuna, intervalo_siguiente_dosis, dias_restante_vencimiento);
				
				rT=g2;		
			}
		}
		return rT;
	}

	//Expresión regular las fechas
	public static boolean ValidarFecha(String fecha) {
		return fecha.matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$");
	}

	//Expresión regular las fechas/horas
	public static boolean ValidarFechaHora(String fechaH) {
		return fechaH.matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})_([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$"); //(:)([0-5][0-9])
		//return fechaH.matches("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})(\\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])$");
	}

	//Expresión regular para el Nro. Lote
	public static boolean ValidarNroLote(String lote) {
		return lote.matches("[0-9]=[a-z][0-9][a-z]/[0-9][A-Z]#[A-Z][0-9]+[A-Z]");
	}

}
