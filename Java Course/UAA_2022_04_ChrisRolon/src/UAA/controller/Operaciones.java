package UAA.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import UAA.model.*;

public class Operaciones {

	public  Scanner data = new Scanner(System.in);
	
	//Para la colección original
	private HashMap<Integer, Curso> mapaCurso = new HashMap<>();  // código de la facultad y el número de curso para el curso;
	private HashMap<String, Alumno> mapaAlu = new HashMap<>(); 	 // el documento y tipo de documento para el alumno
	
	public void MenuOperaciones()  throws InputMismatchException {
		int opcion=0;
		boolean banA= false;
		boolean banC= false;
		do {
			data.nextLine();
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("-------------------------------------");
			System.out.println("1- Agregar Estudiante. ");
			System.out.println("2- Agregar Curso.");
			System.out.println("3- Mostrar datos del Curso y listado de alumnos.");
			System.out.println("4- Actualizar datos del curso.");
			System.out.println("5- Eliminar curso.");
			System.out.println("6- Mostrar datos del Curso por el código de la facultad descendentemente.");
			System.out.println("7- Mostrar datos del Curso  por el número de piso y el número de aula ascendentemente.");
			System.out.println("8- Salir del menú"); 
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1:
				AddStudent();
				banA=true;
				break;
			case 2:
				if(banA) {
					AddCourse();
					banC=true;
				}else {
					System.err.println("\nDebe ejecutar la opción 1.");
				}
				break;
			case 3:
				//if(banC) {
					ShowCoursebyListA();
				/*}else {
					System.err.println("\nDebe ejecutar la opción 2.");
				}*/
				break;
			case 4:
				//if(banC) {
					UpdateCourse();
				/*}else {
					System.err.println("\nDebe ejecutar la opción 2.");
				}*/
				break;
			case 5:
				//if(banC) {
					banC=DeleteCourse();
				/*}else {
					System.err.println("\nDebe ejecutar la opción 2.");
				}*/
				break;
			case 6:
				//if(banC) {
					ShowCoursebyUni();
				/*}else {
					System.err.println("\nDebe ejecutar la opción 2.");
				}*/
				break;
			case 7:
				//if(banC) {
					ShowCoursebyFandC(); //Floor and classroom
				/*}else {
					System.err.println("\nDebe ejecutar la opción 2.");
				}*/
				break;
			case 8:
				System.out.println("\nSaliendo del menú...\n");
				break;
			default:
				System.err.println("\nOpción no valida " + opcion + ". Intente de nuevo.");
				break;
			}
		}while(opcion!=8);
	}
	
	

	//Case 7
	private void ShowCoursebyFandC() {
		List<Curso> listCursos = new ArrayList<Curso>() ;
		Integer[] clavesC = mapaCurso.keySet().toArray(new Integer[0]);
		Curso objjC = null;
		for (Integer objetoC: clavesC) {
			objjC=mapaCurso.get(objetoC);
			listCursos.add(objjC);
        }
		
		if (!listCursos.isEmpty()) {
			Collections.sort(listCursos);
			Iterator<Curso> iteratorC = listCursos.iterator();
			System.out.println("\nLISTADO DE CURSOS SEGÚN NÚMERO PISO Y NÚMERO AULA ASCENDENTEMENTE");
	        while (iteratorC.hasNext()) {
	        	Curso cO= iteratorC.next();
	        	System.out.println(cO.toString().concat("\nPRESS ENTER"));
	        }
		}else{
			System.err.println("\nCURSOS INEXISTENTES");
		}
	}



	//Case 6
	private void ShowCoursebyUni() {
		List<Curso> listCursos = new ArrayList<Curso>() ;
		Integer[] clavesC = mapaCurso.keySet().toArray(new Integer[0]);
		Curso objjC = null;
		for (Integer objetoC: clavesC) {
			objjC=mapaCurso.get(objetoC);
			listCursos.add(objjC);
        }
		
		if (!listCursos.isEmpty()) {
			Collections.sort(listCursos, Collections.reverseOrder() );
			Iterator<Curso> iteratorC = listCursos.iterator();
			System.out.println("\nLISTADO DE CURSOS SEGÚN CÓDIGO DE FACULTAD DESCENDENTEMENTE");
	        while (iteratorC.hasNext()) {
	        	Curso cO= iteratorC.next();
	        	System.out.println(cO.toString().concat("\nPRESS ENTER"));
	        }
		}else{
			System.err.println("\nCURSOS INEXISTENTES");
		}
			
	}



	//Case 5
	private boolean DeleteCourse() {
		boolean banEliminado=false;
		int codF=0;
		int nroC=0;
		Integer clave= 0;
		Curso auxCur= null;
		
		if (mapaCurso.isEmpty()) {
			 System.out.println("\nLista de curso inexistente.");
		}else {
			//Ingreso el Código de la facultad.
			do {
				try {
					data.nextLine();
					System.out.println("\nIngrese el Código de la facultad: ");
					codF=data.nextInt();
					if(codF<1) {
						System.err.println("\nDato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception eL) {
					System.err.println(eL.getMessage());
				}	
			} while (codF<1);	
			
			//Ingreso el Número de curso.
			do {
				try {
					data.nextLine();
					System.out.println("\nIngrese el Número de curso: ");
					nroC=data.nextInt();
					if(nroC<1) {
						System.err.println("\nDato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception eL) {
					System.err.println(eL.getMessage());
				}	
			} while (nroC<1);		
			
			clave= (codF*100) + (nroC*10); //Clave Curso
			
			// Encontrar curso a eliminar
			if (mapaCurso.containsKey(clave)) {
				auxCur = mapaCurso.remove(clave);
				System.out.println("\nCurso eliminado: \n"+auxCur.toString()+"\n");
				banEliminado=true;
			}else {
				System.err.println("\nCurso inexistente.");
				banEliminado=false;
			}
		}
		
		
		/*Enumeration<Integer> enuClaves = mapaCurso.;
		while (enuClaves.hasMoreElements()) {
			Curso auxCur = mapaCurso.get(enuClaves.nextElement());
			if (auxCur.getTituloC().equals(tituloCanFi) && auxCa.getAnho()== anioFi )
				auxCancion = mapaCancion.get(claveFiltro);
		}
		
		
		if (auxCancion != null) {
			
			// Eliminar
			System.out.println("\nEliminando " + auxCancion.toString());	
			if (mapaCancion.containsValue(auxCancion)) {
				
				auxCancion = mapaCancion.remove(claveFiltro);
				respuesta=true;
				System.out.println("\nCanción eliminada con éxito.\nPREES ENTER");
			}				
			
		} else {
			System.err.println("\nNo se encontró canción a eliminar.");
			respuesta=false;
		}			
		
		Integer[] clavesC = mapaCurso.keySet().toArray(new Integer[0]);
		Curso cursoEliminar= null;
		for (Integer objetoC: clavesC) {
			if(objetoC.equals(clave))
				
				
			cursoEliminar=mapaCurso.get(objetoC);
			System.out.println(cursoEliminar.toString().concat("\nPRESS ENTER"));
        }*/
		
		
		return banEliminado;
	}



	//Case 4
	private void UpdateCourse() {
		int codF=0;
		int nroC=0;
		Integer clave= 0;
		Curso auxCur= null;
		String day="";
		String state="";
		
		//Auxiliares
		int auxCodP=0;
		char auxDia=' ';
		char auxEstado=' ';
		
		if (mapaCurso.isEmpty()) {
			 System.out.println("\nLista de curso inexistente.");
		}else {
			//Ingreso el Código de la facultad.
			do {
				try {
					data.nextLine();
					System.out.println("\nIngrese el Código de la facultad: ");
					codF=data.nextInt();
					if(codF<1) {
						System.err.println("\nDato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception eL) {
					System.err.println(eL.getMessage());
				}	
			} while (codF<1);	
			
			//Ingreso el Número de curso.
			do {
				try {
					data.nextLine();
					System.out.println("\nIngrese el Número de curso: ");
					nroC=data.nextInt();
					if(nroC<1) {
						System.err.println("\nDato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception eL) {
					System.err.println(eL.getMessage());
				}	
			} while (nroC<1);		
			
			clave= (codF*100) + (nroC*10); //Clave Curso
			
			// Encontrar curso a actualizar
			if (mapaCurso.containsKey(clave)) {
				auxCur = mapaCurso.get(clave);
				
				//Asignando a valores anteriores
				auxCodP=auxCur.getCodProf();
				auxDia=auxCur.getDia();
				auxEstado=auxCur.getEstado();
				
				//Ingreso del Código del profesor
				do {
					try {
						data.nextLine();
						System.out.println("\nIngrese el Código del profesor a actualizar: ");
						auxCur.setCodProf(data.nextInt());
						auxCur.setCodProf(auxCur.getCodProf());
						if(auxCur.getCodProf()<1 || auxCur.getCodProf()==auxCodP) {
							System.err.println("\nDato no admitido. Vuelva a intentar.");
						}	
					} catch (Exception eL) {
						System.err.println(eL.getMessage());
					}	
				} while (auxCur.getCodProf()<1 || auxCur.getCodProf()==auxCodP);
				
				//Ingreso del día
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese el día a actualizar (L, M, X, J, V): ");
						day = data.nextLine();
						day=day.toUpperCase();
						if((!day.equals("L") && !day.equals("M") && !day.equals("X") && !day.equals("J") && !day.equals("V")) || auxDia==day.charAt(0)) {
							System.err.println("\nCaracter incorrecto. Vuelva a intentar");
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}while((!day.equals("L") && !day.equals("M") && !day.equals("X") && !day.equals("J") && !day.equals("V")) || auxDia==day.charAt(0));
				auxCur.setDia(day);
				
				//Ingreso del Estado del curso (A=Activo,I=Inactivo, B=Baja) 
				
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese el Estado del curso a actualizar (A=Activo,I=Inactivo, B=Baja): ");
						state = data.nextLine();
						state=state.toUpperCase();
						if((!state.equals("A") && !state.equals("I") && !state.equals("B")) || (auxEstado==day.charAt(0)) || (auxEstado=='I' && day.equals("B")) || (auxEstado=='A' && day.equals("I"))) {
							System.err.println("\nCaracter incorrecto. Vuelva a intentar");
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}while((!state.equals("A") && !state.equals("I") && !state.equals("B")) || (auxEstado==day.charAt(0)) || (auxEstado=='I' && day.equals("B")) || (auxEstado=='A' && day.equals("I")));
				auxCur.setEstado(state);		
				
				System.out.println("\nCurso Actualizado: \n"+auxCur.toString()+"\nPRESS ENTER");
				//banEliminado=true;
			}else {
				System.err.println("\nCurso inexistente.");
				//banEliminado=false;
			}
		}	
	}



	//Case 3
	private void ShowCoursebyListA() {
		Integer[] clavesC = mapaCurso.keySet().toArray(new Integer[0]);
		Curso objjC = null;
		for (Integer objetoC: clavesC) {
			objjC=mapaCurso.get(objetoC);
			System.out.println(objjC.toString().concat("\nPRESS ENTER"));
        }
       /* if(alu!=null){
        	System.out.println("\n"+alu.toString()+ "\nPRESS ENTER");
        	newCu.setListA(alu);
        }else {
        	System.out.println("\nAlumno no encontrado\nPRESS ENTER");
        }*/
	}



	//Case 2
	private void AddCourse() {
		int opcion=1;
		Integer clave= 0;
		String nroDoc = ""; //Key
		String tipoDoc = "";   //Key 
		//Datos menos la lista
		Curso newCu = cargarDatosCur();
		
		clave= (newCu.getCodFac()*100) + (newCu.getNroCurso()*10); //Clave Curso
		
		if (mapaCurso.containsKey(clave)) {
			System.err.println("\nCurso existente.");
			return; 
	    }
		//String clavesA = ""; // Clave para alumnos	
		
		//Cargar lista
		while(opcion!=0) {
			/*Entrada de claves para asignar a la lista de alumnos
			Ingreso el Nro de Documento.*/
			do {
				try {
					data.nextLine();
					System.out.println("\nIngrese el Nro de Documento del alumno a asignar: ");
					nroDoc= data.nextLine();
					nroDoc=nroDoc.trim();
					if(nroDoc.isBlank() || nroDoc.isEmpty()) {
						System.err.println("\nDato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception eL) {
					System.err.println(eL.getMessage());
				}	
			} while (nroDoc.isBlank() || nroDoc.isEmpty());
			
			//Inngreso del Tipo de Documento
			do {
				try {
					data.nextLine();
					System.out.println("\nIngrese el Tipo de Documento del alumno correspondiente: ");
					tipoDoc=data.nextLine();
					tipoDoc=tipoDoc.trim();
					if(tipoDoc.isBlank() || tipoDoc.isEmpty()) {
						System.err.println("\nDato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception eL) {
					System.err.println(eL.getMessage());
				}	
			} while (tipoDoc.isBlank() || tipoDoc.isEmpty());		
			
			//clavesA= nroDoc.concat(tipoDoc);
			
			//Recorriendo valores del mapa, tipo alumno
			Alumno alu=null;
			System.out.println("\nBuscando al alumno...\n");
	        Alumno[] alumnos = mapaAlu.values().toArray(new Alumno[0]);
	        for (Alumno objetoA: alumnos) {
	        	//Asignarle a alu el valor según el filtro 
	            if(objetoA.getNroDoc().equalsIgnoreCase(nroDoc) && objetoA.getTipoDoc().equalsIgnoreCase(tipoDoc))
	            	alu=objetoA;
	        }
	        if(alu!=null){
	        	System.out.println("\n"+alu.toString());
	        	newCu.setListA(alu);
	        }else {
	        	System.err.println("\nAlumno no encontrado.");
	        }
	        System.out.println("\n0: SALIR; 1:CONTINUAR CARGANDO ALUMNOS");
	        opcion= data.nextInt();
		}      
		mapaCurso.put(clave, newCu);
		System.out.println("\n¡CURSO AGREGADO CORRECTAMENTE!.");
		
	}


	//Case 2.2
	private Curso cargarDatosCur() {
		Curso c = new Curso();
		//Ingreso el Código de la facultad.
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Código de la facultad: ");
				c.setCodFac(data.nextInt());
				//c.setCodFac(c.getCodFac());
				if(c.getCodFac()<1) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (c.getCodFac()<1);	
		
		//Ingreso el Número de curso.
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Número de curso: ");
				c.setNroCurso(data.nextInt());
				//c.setNroCurso(c.getNroCurso());
				if(c.getNroCurso()<1) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (c.getNroCurso()<1);	

		//Ingreso el Nombre de la materia.
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Nombre de la materia: ");
				c.setMateria(data.nextLine());
				c.setMateria(c.getMateria().trim().toUpperCase());
				if(c.getMateria().isBlank() || c.getMateria().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (c.getMateria().isBlank() || c.getMateria().isEmpty());		
		
		//Ingreso de la Modalidad ((presencial o a distancia).
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese la Modalidad (presencial o a distancia): ");
				c.setModalidad(data.nextLine());
				c.setModalidad(c.getModalidad().trim().toUpperCase());
				if(c.getModalidad().isBlank() || c.getModalidad().isEmpty() || (!c.getModalidad().equalsIgnoreCase("presencial") && !c.getModalidad().equalsIgnoreCase("distancia"))) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (c.getModalidad().isBlank() || c.getModalidad().isEmpty() || (!c.getModalidad().equalsIgnoreCase("presencial") && !c.getModalidad().equalsIgnoreCase("distancia")));
		
		//Ingreso del Código del profesor
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Código del profesor: ");
				c.setCodProf(data.nextInt());
				//c.setCodProf(c.getCodProf());
				if(c.getCodProf()<1) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (c.getCodProf()<1);	
		
		//Ingreso del día ((L, M, X, J, V)
		String day="";
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el día ((L, M, X, J, V): ");
				day = data.nextLine();
				day=day.toUpperCase();
				if(!day.equals("L") && !day.equals("M") && !day.equals("X") && !day.equals("J") && !day.equals("V")) {
					System.err.println("\nCaracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(!day.equals("L") && !day.equals("M") && !day.equals("X") && !day.equals("J") && !day.equals("V"));
		c.setDia(day);
		
		//Ingreso del turno (M=mañana, T=Tarde y N=Noche)
		String turn="";
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el turno (M=mañana, T=Tarde y N=Noche): ");
				turn = data.nextLine();
				turn=turn.toUpperCase();
				if(!turn.equals("M") && !turn.equals("T") && !turn.equals("N")) {
					System.err.println("\nCaracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(!turn.equals("M") && !turn.equals("T") && !turn.equals("N"));
		c.setTurno(turn);
		
		//Ingreso del Número de piso
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Número de piso: ");
				c.setNroPiso(data.nextInt());
				//c.setNroPiso(c.getNroPiso());
				if(c.getNroPiso()<1) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (c.getNroPiso()<1);		
		
		//Ingreso del Número de aula
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el  Número de aula: ");
				c.setNroAula(data.nextInt());
				//c.setNroAula(c.getNroAula());
				if(c.getNroAula()<1) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (c.getNroAula()<1);				
		
		
		//Ingreso del Estado del curso (A=Activo,I=Inactivo, B=Baja) 
		String state="";
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el Estado del curso (A=Activo,I=Inactivo, B=Baja): ");
				state = data.nextLine();
				state=state.toUpperCase();
				if(!state.equals("A") && !state.equals("I") && !state.equals("B")) {
					System.err.println("\nCaracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(!state.equals("A") && !state.equals("I") && !state.equals("B"));
		c.setEstado(state);		
		
		
		return c;
	}



	//Case 1
	private void AddStudent() {
		String clave= "";
		Alumno newAl = cargarDatos();
		clave= newAl.getNroDoc().concat(newAl.getTipoDoc());
		if (mapaAlu.containsKey(clave)) {
			System.err.println("\nAlumno existente.");
			return; 
	    }       
		mapaAlu.put(clave, newAl);
		System.out.println("\n¡AlUMNO AGREGADO CORRECTAMENTE!\nPRESS ENTER");
	}

	//Case 1.1
	private Alumno cargarDatos() {
		Alumno a = new Alumno();
		//Ingreso el Nro de Documento.
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Nro de Documento: ");
				a.setNroDoc(data.nextLine());
				a.setNroDoc(a.getNroDoc().trim().toUpperCase());
				if(a.getNroDoc().isBlank() || a.getNroDoc().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (a.getNroDoc().isBlank() || a.getNroDoc().isEmpty());
		
		//Inngreso del Tipo de Documento
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Tipo de Documento: ");
				a.setTipoDoc(data.nextLine());
				a.setTipoDoc(a.getTipoDoc().trim().toUpperCase());
				if(a.getTipoDoc().isBlank() || a.getTipoDoc().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (a.getTipoDoc().isBlank() || a.getTipoDoc().isEmpty());
		
		//Ingreso del Nombre completo
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el Nombre completo: ");
				a.setNombreApellido(data.nextLine());
				a.setNombreApellido(a.getNombreApellido().trim().toUpperCase());
				if(a.getNombreApellido().isBlank() || a.getNombreApellido().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (a.getNombreApellido().isBlank() || a.getNombreApellido().isEmpty());
	
		//Ingreso del teléfono
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el teléfono: ");
				a.setTele(data.nextLine());
				a.setTele(a.getTele().trim().toUpperCase());
				if(a.getTele().isBlank() || a.getTele().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (a.getTele().isBlank() || a.getTele().isEmpty());
		
		//Ingreso del sexo
		String sex="";
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el sexo(M;F): ");
				sex = data.nextLine();
				sex=sex.toUpperCase();
				if(!sex.equals("M") && !sex.equals("F")) {
					System.err.println("\nCaracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(sex.isEmpty() || sex.isBlank() || (!sex.equals("M") && !sex.equals("F")));
		a.setSex(sex);
		
		//Ingreso del correo electrónico
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el correo electrónico(aaa..@aaa....aaa): ");
				a.setMail(data.nextLine());
				a.setMail(a.getMail().trim());
				
				if(!ValidarCorreo(a.getMail())) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(a.getMail().equals(null) || a.getMail().isEmpty() || a.getMail().isBlank() || !ValidarCorreo(a.getMail()));		
		
		//Si tiene beca
		String bec="";
		do {
			try {
				data.nextLine();
				System.out.println("¿Es becado? (S;N): ");
				bec = data.nextLine();
				bec=bec.toUpperCase();
				if(!bec.equals("S") && !bec.equals("N")) {
					System.err.println("\nCaracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(bec.isEmpty() || bec.isBlank() || (!bec.equals("S") && !bec.equals("N")));
		a.setHasB(bec);		
		
		return a;
		
	}
	
	public static boolean ValidarCorreo(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}	
}
