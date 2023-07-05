package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Modelo.CodigoTemporada;
import Modelo.Equipo;
import Modelo.Estado;

public class EquipoController {

	//Estado
	Estado I = Estado.INACTIVO;
	Estado A = Estado.ACTIVO;
	Estado B = Estado.BAJA;
	
	//Temporada
	CodigoTemporada pa = CodigoTemporada.PRIMAVERA;
	CodigoTemporada vo = CodigoTemporada.VERANO;
	CodigoTemporada oo = CodigoTemporada.OTONHO;
	
	ArrayList<Equipo> listaDeEqEquipo = new ArrayList<Equipo>();
	
	
	/*consultar todos los equipos de la Asociación que se hayan 
	creado, cuyo estado sea diferente a baja o la posición en el ranking nacional sea menor o igual a 
	17*/
	public ArrayList<Equipo> listarTodosEquipos() throws Exception {

		ArrayList<Equipo> listaEqAux = new ArrayList<Equipo>();
		// Agregar nuevos equipos
		Equipo e1 = new Equipo(1, "Real Madrid", "Ancelotti", "10/10/2010", pa, I, "Madrid", 100, 0, 1, 18, 50, 1);
		Equipo e2 = new Equipo(2, "Barcelina", "Zidane", "10/10/2012", vo, A, "Barcelons", 10, 0, 1, 10, 50, 2);

		listaDeEqEquipo.add(e1);
		listaDeEqEquipo.add(e2);

		for (Equipo equipo : listaDeEqEquipo) {
			
			if(!equipo.getEstado().equals(B) || equipo.getRankingNacional()>=17) {
				listaEqAux.add(equipo);
			}
				
		}
		
		
		return listaEqAux;
	}
	
	/*año y temporada 
	específica, cuyo estado sea activo o inactivo. Este servicio debe recibir dos parámetros en la URL 
	los cuales tendrán los valores del año y temporada.
	Los equipos deben estar ordenados descendentemente por el estado y la posición en el ranking 
	nacional.*/
	public ArrayList<Equipo> listarEquiposParametros(String anho, String tempo) throws Exception {

		ArrayList<Equipo> listaEqAux = new ArrayList<Equipo>();

		// Añadiendo valores al resultado
		
		Collections.sort(listaDeEqEquipo);
		if(tempo.equalsIgnoreCase("PRIMAVERA")) {
			for (Equipo equipo : listaDeEqEquipo) {
				if((equipo.getEstado().equals(A) || equipo.getEstado().equals(B)) && equipo.getAnhoTorneo().equalsIgnoreCase(anho) && equipo.getCodTemporada().equals(vo)) {
					listaEqAux.add(equipo);
				}		
			}
		}else if(tempo.equalsIgnoreCase("VERANO")) {
			for (Equipo equipo : listaDeEqEquipo) {
				if((equipo.getEstado().equals(A) || equipo.getEstado().equals(B)) && equipo.getAnhoTorneo().equalsIgnoreCase(anho) && equipo.getCodTemporada().equals(pa)) {
					listaEqAux.add(equipo);
				}		
			}
		}else {
			for (Equipo equipo : listaDeEqEquipo) {
				if((equipo.getEstado().equals(A) || equipo.getEstado().equals(B)) && equipo.getAnhoTorneo().equalsIgnoreCase(anho) && equipo.getCodTemporada().equals(oo)) {
					listaEqAux.add(equipo);
				}		
			}
		}
		
		return listaEqAux;
	}
	
	
	/*No pueden existir dos equipos con el 
	mismo nombre del equipo y ciudad en la que se encuentra, tampoco puede existir dos equipos con 
	la misma posición en el ranking nacional, también se debe controlar el caso de dos equipos con el 
	mismo entrenador para un mismo año y temporada*/
	public boolean agregarEquipos(Equipo equipo) {
		
		boolean banAgregar = true;
		
		for (Equipo elemento : listaDeEqEquipo) {
			
			if (elemento.getNombreEquipo().equalsIgnoreCase(equipo.getNombreEquipo()) && elemento.getCiudad().equalsIgnoreCase(equipo.getCiudad()))
				banAgregar = false;
			if(elemento.getRankingNacional()==equipo.getRankingNacional())
				banAgregar = false;
			if(elemento.getEntrenador().equalsIgnoreCase(equipo.getEntrenador())){
				if(elemento.getAnhoTorneo().equalsIgnoreCase(equipo.getAnhoTorneo()) && 
						elemento.getCodTemporada().toString().equalsIgnoreCase(equipo.getCodTemporada().toString())) {
					banAgregar = false;
				}
			}
				
		}
		
		if(banAgregar)
			listaDeEqEquipo.add(equipo);
			

		return banAgregar;
	}
	
	/*eliminar un equipo de un año y temporada especifica. Este 
	servicio debe recibir tres parámetros en la URL los cuales tendrán los valores del cód. equipo, año y 
	temporada. Solo se puede eliminar equipos con estado baja o la posición en el ranking nacional sea 
	mayor a 28. 
	 * */	
	public boolean eliminarEquipos(Equipo equipo) {

		boolean banEliminar = false;

		if (equipo.getEstado().equals(B)|| equipo.getRankingNacional() > 28) {

			Iterator<Equipo> itEquipo = listaDeEqEquipo.iterator();

			while (itEquipo.hasNext()) {

				Equipo equipoActual = itEquipo.next();

				if (equipoActual.getAnhoTorneo().equalsIgnoreCase(equipo.getAnhoTorneo()) 
						&& equipoActual.getCodTemporada().toString().equalsIgnoreCase(equipo.getCodTemporada().toString())) {
					
					itEquipo.remove();
					
					banEliminar = true;
					
				}

			}
			
		} else {
			
			banEliminar = false;
			
		}

		return banEliminar;
	}
	
	
	/* actualizar un equipo de un año y temporada especifica. Este 
	servicio debe recibir tres parámetros en la URL (los cuales tendrán los valores del cód. equipo, año
	y temporada). Solo se puede actualizar equipos con estado activo o inactivo */
	public boolean actualizarEquipos(Equipo equipo, String estado) {
		boolean banActualizar = false;

		if (!equipo.getEstado().equals(B)) {

			Iterator<Equipo> itEquipo = listaDeEqEquipo.iterator();
			
			int indiceElemento = 0;

			while (itEquipo.hasNext()) {

				Equipo equipoActual = itEquipo.next();

				if (equipoActual.getAnhoTorneo().equalsIgnoreCase(equipo.getAnhoTorneo()) 
						&& equipoActual.getCodTemporada().toString().equalsIgnoreCase(equipo.getCodTemporada().toString())) {
					
					equipoActual.setNombreEquipo(equipo.getNombreEquipo());
					equipoActual.setEntrenador(equipo.getEntrenador());
					//equipoActual.setEstado(equipo.getEstado());
					if(estado.toUpperCase().charAt(0) == A.toString().toUpperCase().charAt(0))
						equipoActual.setEstado(A);
					if(estado.toUpperCase().charAt(0) == I.toString().toUpperCase().charAt(0))
						equipoActual.setEstado(I);
					if(estado.toUpperCase().charAt(0) == B.toString().toUpperCase().charAt(0))
						equipoActual.setEstado(B);
					equipoActual.setCiudad(equipo.getCiudad());
					equipoActual.setNroPartidosGanados(equipo.getNroPartidosGanados());
					equipoActual.setNroPartidosPerdidos(equipo.getNroPartidosPerdidos());
					equipoActual.setNroPartidosEmpatados(equipo.getNroPartidosEmpatados());
					equipoActual.setRankingNacional(equipo.getRankingNacional());
					equipoActual.setGolesMarcados(equipo.getGolesMarcados());
					equipoActual.setGolesRecibidos(equipo.getGolesRecibidos());
																	
					listaDeEqEquipo.add(indiceElemento, equipoActual);
					
					banActualizar = true;
				}
				
				indiceElemento++;

			}
			
		} else {
			
			banActualizar = false;
			
		}


		return banActualizar;
	}
	
}
