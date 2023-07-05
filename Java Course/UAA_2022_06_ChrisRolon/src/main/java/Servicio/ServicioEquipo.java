package Servicio;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import Controlador.*;
import Modelo.*;
import java.util.ArrayList;

@Path("/equipos")
public class ServicioEquipo {

	public ArrayList<Equipo> listaDeEquipos = new ArrayList<Equipo>();
	private Equipo Equi;
	public Gson gson = new Gson();
	public EquipoController servicio = new EquipoController();

	//Agregar 
	@POST
	@Path("/agregar")
	@Consumes("application/json")
	public Response agregarEquipo(String json) {

		Entidad equipo = gson.fromJson(json, Entidad.class);

		Equi = convertirEntidad(equipo);

		boolean respuesta = servicio.agregarEquipos(Equi);

		if (respuesta)
			return Response.status(200).entity("Equipo: " + Equi.toString() + "\n¡Añadido\n").build();
		return Response.status(407).entity("Equipo no añadido: " + Equi.toString()).build();

	}
 
	//
	private Equipo convertirEntidad(Entidad equipo) {

		//Estado
		Estado I = Estado.INACTIVO;
		Estado A = Estado.ACTIVO;
		Estado B = Estado.BAJA;
		
		//Temporada
		CodigoTemporada pa = CodigoTemporada.PRIMAVERA;
		CodigoTemporada vo = CodigoTemporada.VERANO;
		CodigoTemporada oo = CodigoTemporada.OTONHO;
		
		Equipo equi = new Equipo();

		equi.setNroEquipo(equipo.getNroEquipo());
		equi.setNombreEquipo(equipo.getNombreEquipo());
		equi.setEntrenador(equipo.getEntrenador());
		equi.setAnhoTorneo(equipo.getAnhoTorneo());
		
		///equi.setCodTemporada(equipo.getCodTemporada());
		if(equipo.getCodTemporada().equalsIgnoreCase(pa.toString()))
			equi.setCodTemporada(pa);
		if(equipo.getCodTemporada().equalsIgnoreCase(vo.toString()))
			equi.setCodTemporada(vo);
		if(equipo.getCodTemporada().equalsIgnoreCase(oo.toString()))
			equi.setCodTemporada(oo);
		
		//equi.setEstado(equipo.getEstado());
		if(equipo.getEstado().toUpperCase().charAt(0) == A.toString().toUpperCase().charAt(0))
			equi.setEstado(A);
		if(equipo.getEstado().toUpperCase().charAt(0) == I.toString().toUpperCase().charAt(0))
			equi.setEstado(I);
		if(equipo.getEstado().toUpperCase().charAt(0) == B.toString().toUpperCase().charAt(0))
			equi.setEstado(B);
		
		equi.setCiudad(equipo.getCiudad());
		equi.setNroPartidosGanados(equipo.getNroPartidosGanados());
		equi.setNroPartidosPerdidos(equipo.getNroPartidosPerdidos());
		equi.setNroPartidosEmpatados(equipo.getNroPartidosEmpatados());
		equi.setRankingNacional(equipo.getRankingNacional());
		equi.setGolesMarcados(equipo.getGolesMarcados());
		equi.setGolesRecibidos(equipo.getGolesRecibidos());

		return equi;
	}

	// Listar equipos
	@GET
	@Path("/listar")
	@Produces("application/json")
	public String listarEquiposXML() throws Exception {

		listaDeEquipos = servicio.listarTodosEquipos();

		return gson.toJson(listaDeEquipos);
	}

	// Eliminar
	@DELETE
	@Path("/eliminar/{codequipo}/{torneo}/{temp}")
	public Response eliminarEquipo(@PathParam("codequipo") int codEquipo, @PathParam("torneo") String anhoTorn,
			@PathParam("temp") String codTemp) {
		try {

			listaDeEquipos = servicio.listarEquiposParametros(anhoTorn, codTemp);

			for (Equipo elemento : listaDeEquipos) {

				if (elemento.getNroEquipo() == codEquipo)
					Equi = elemento;

			}

			boolean respuesta = servicio.eliminarEquipos(Equi);

			if (respuesta)
				return Response.status(200).entity("¡Eliminado!").build();
			return Response.status(407).entity("Equipo no eliminado").build();

		} catch (Exception e) {
			System.out.println(":" + e.getMessage());
			return Response.status(407).entity("Equipo no eliminado").build();
		}
	}

	//Actualizar
	@PUT
	@Path("/actualizar/{codequipo}/{torneo}/{temp}")
	@Consumes("application/json")
	public Response actualizarEquipo(@PathParam("codequipo") int codEquipo, 
			@PathParam("torneo") String anhoTorn,
			@PathParam("temp") String codTemp, String json) {
		try {

			listaDeEquipos = servicio.listarEquiposParametros(anhoTorn, codTemp);
			Entidad equipo = gson.fromJson(json, Entidad.class);
			
			Equipo auxEqui = convertirEntidad(equipo);
			
			for (Equipo elemento : listaDeEquipos) {

				if (elemento.getNroEquipo() == codEquipo)
					Equi = elemento;

			}

			// Actualizar campos
			Equi.setNombreEquipo(auxEqui.getNombreEquipo());
			Equi.setEntrenador(auxEqui.getEntrenador());
			//Equi.setEstado(auxEqui.getEstado());
			Equi.setCiudad(auxEqui.getCiudad());
			Equi.setNroPartidosGanados(auxEqui.getNroPartidosGanados());
			Equi.setNroPartidosPerdidos(auxEqui.getNroPartidosPerdidos());
			Equi.setNroPartidosEmpatados(auxEqui.getNroPartidosEmpatados());
			Equi.setRankingNacional(auxEqui.getRankingNacional());
			Equi.setGolesMarcados(auxEqui.getGolesMarcados());
			Equi.setGolesRecibidos(auxEqui.getGolesRecibidos());
			
			boolean respuesta = servicio.actualizarEquipos(Equi, auxEqui.getEstado().toString());

			if (respuesta)
				return Response.status(200).entity("¡Actualizado!").build();
			return Response.status(407).entity("Equipo no actualizado").build();

		} catch (Exception e) {
			System.out.println(":" + e.getMessage());
			return Response.status(407).entity("Equipo no actualizado").build();
		}
	}

	// Servicio 5: Devolver equipos por filtros en un json
	@GET
	@Path("/listar/filtro/{torneo}/{temp}")
	@Produces("application/json")
	public String listarEquiposPorFiltroXML(@PathParam("torneo") String anhoTorn, @PathParam("temp") String codTemp)
			throws Exception {

		listaDeEquipos = servicio.listarEquiposParametros(anhoTorn, codTemp);

		return gson.toJson(listaDeEquipos);
	}

}
