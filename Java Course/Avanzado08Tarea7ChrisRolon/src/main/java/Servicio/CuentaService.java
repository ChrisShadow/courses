package Servicio;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import Controlador.*;
import Modelo.Cuenta;
import Modelo.Entidad;
import Modelo.Estado;
import Modelo.Moneda;
import Modelo.TipoCuenta;

import java.util.ArrayList;

@Path("/cuentas")

public class CuentaService {

	TipoCuenta a = TipoCuenta.A;
	TipoCuenta b = TipoCuenta.B;
	TipoCuenta c = TipoCuenta.C;
	Moneda guaranies = Moneda.GS;
	Moneda dolares = Moneda.USD;
	Estado activo = Estado.ACTIVO;
	Estado inactivo = Estado.INACTIVO;
	
	public ArrayList<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();
	private Cuenta cu;
	//Un servicio que devuelva todas las cuentas en un json
	@GET
    @Path("/listar")
    @Produces("application/json")
    public String listarCuentasXML() throws Exception {
		Gson gson = new Gson();
		CuentaController cont=  new CuentaController(); 
		listaDeCuentas=cont.listarTodasCuentas();
		return gson.toJson(listaDeCuentas);
	}
	
	
	//Un servicio que devuelva una cuenta en particular como un json
	@GET
    @Path("/lista/{param}")
    @Produces("application/json")
    public String listarCuenta(@PathParam("param") int valor) throws Exception {
		Gson gson = new Gson();
		Cuenta c = null;
		CuentaController cont=  new CuentaController(); 
		c=cont.listarCuentaPorNroCuenta(valor);
		//listaDeCuentas=cont.listarTodasCuentas();
		return gson.toJson(c);
	}
	
	
	//Un servicio que permita crear una cuenta, se debe recibir un json con los datos de la cuenta
	@POST
    @Path("/agregar")
    @Consumes("application/json")
	public Response agregarCuenta(String json) {
		CuentaController cont=  new CuentaController(); 
		Gson gson = new Gson();
		cu = null;
        System.out.println(json);
        Entidad cuenta = gson.fromJson(json, Entidad.class);
        cu.setNroCuenta(cuenta.getNroCuenta());
        cu.setNroSocio(cuenta.getNroSocio());
        cu.setSaldo(cuenta.getSaldo());
        
        //Tipo cuenta
        if(cuenta.getTipoCuenta().equalsIgnoreCase("A")){
        	cu.setTipoCuenta(a);
        }else if(cuenta.getTipoCuenta().equalsIgnoreCase("B")) {
        	cu.setTipoCuenta(b);
        }else{
        	cu.setTipoCuenta(c);
        }
        
        //Moneda
        if(cuenta.getMoneda().equalsIgnoreCase("GS")) {
        	cu.setMoneda(guaranies);
        }else{
        	cu.setMoneda(dolares);
        }
        
        //Estado
        if(cuenta.getEstado().equalsIgnoreCase("ACTIVO")) {
        	cu.setEstado(activo);
        }else {
        	cu.setEstado(inactivo);
        }
        
        boolean respuesta = cont.agregarCuenta(cu);
       
        if (respuesta)
            return Response.status(200).entity("Cuenta agregada correctamente").build();
        return Response.status(407).entity("No se pudo agregar la cuenta").build();
	}
	
	//Un servicio que permita eliminar una cuenta en particular
    @DELETE
    @Path("/eliminar/{param}")
    public Response eliminarCuenta(@PathParam("param") int valor) {
    	CuentaController cont=  new CuentaController(); 
    	Cuenta cu= null;
    	try {
			cu=cont.listarCuentaPorNroCuenta(valor);
			boolean respuesta = cont.eliminarCuenta(cu);
	        if (respuesta)
	            return Response.status(200).entity("Cuenta eliminada correctamente").build();
	        return Response.status(407).entity("No se pudo eliminar la cuenta").build();
		} catch (Exception e) {
			System.out.println(":"+ e.getMessage()); 
			 return Response.status(407).entity("No se pudo eliminar la cuenta").build();
		}
    }
    
    
    //Un servicio que permita actualizar una cuenta en particular, se debe recibir un json con los datos modificado de la cuenta
    @PUT
    @Path("/actualizar/{param}")
    @Consumes("application/json")
    public Response actualizarCuenta(String json, @PathParam("param") int valor) {
    	CuentaController cont=  new CuentaController(); 
		Gson gson = new Gson();
		Cuenta cuNueva = null;
		Cuenta cuVieja = null;
		
		Entidad cuenta = gson.fromJson(json, Entidad.class);
		cuNueva= ConvertirEntidad(cuenta);
		if(cuNueva.getNroCuenta()==valor) {
			 boolean respuesta = cont.actualizarCuenta(cuNueva);
		     if (respuesta)
		    	 return Response.status(200).entity("Cuenta actualizada correctamente").build();
		     return Response.status(407).entity("No se pudo actualizar la cuenta").build();
		}else {
			try {
				cuVieja=cont.listarCuentaPorNroCuenta(valor);
				cuNueva.setNroCuenta(cuVieja.getNroCuenta());
				/*cuNueva.setNroSocio(cuVieja.getNroSocio());
				cuNueva.setSaldo(cuVieja.getSaldo());*/
				 boolean respuesta = cont.actualizarCuenta(cuNueva);
			     if (respuesta)
			    	 return Response.status(200).entity("Cuenta actualizada correctamente").build();
			     return Response.status(407).entity("No se pudo actualizar la cuenta").build();
			     
				
			} catch (Exception e) {
				System.out.println(":"+ e.getMessage()); 
				return Response.status(407).entity("No se pudo actualizar la cuenta").build();
			}
			
		}
    }


	private Cuenta ConvertirEntidad(Entidad cuenta) {
		Cuenta cu= new Cuenta();
		String tipoCuenta= cuenta.getTipoCuenta();
		String moneda= cuenta.getMoneda();
		String estado= cuenta.getEstado();
		
		//Tipo cuenta
        if(tipoCuenta.equalsIgnoreCase("A")){
        	cu.setTipoCuenta(a);
        }else if(tipoCuenta.equalsIgnoreCase("B")) {
        	cu.setTipoCuenta(b);
        }else{
        	cu.setTipoCuenta(c);
        }
        
        //Moneda
        if(moneda.equalsIgnoreCase("GS")) {
        	cu.setMoneda(guaranies);
        }else{
        	cu.setMoneda(dolares);
        }
        
        //Estado
        if(estado.equalsIgnoreCase("ACTIVO")) {
        	cu.setEstado(activo);
        }else {
        	cu.setEstado(inactivo);
        }
		
		cu.setNroCuenta(cuenta.getNroCuenta());
		cu.setNroSocio(cuenta.getNroSocio());
		cu.setSaldo(cuenta.getSaldo());
		
		
				
		return cu;
	}
	
	
}
