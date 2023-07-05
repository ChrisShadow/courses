package Controlador;

import java.util.ArrayList;
import java.util.Iterator;

import Modelo.*;

public class CuentaController {

	TipoCuenta a = TipoCuenta.A;
	TipoCuenta b = TipoCuenta.B;
	TipoCuenta c = TipoCuenta.C;
	Moneda guaranies = Moneda.GS;
	Moneda dolares = Moneda.USD;
	Estado activo = Estado.ACTIVO;
	Estado inactivo = Estado.INACTIVO;
	ArrayList<Cuenta> listaDeCuentas = new ArrayList<Cuenta>();

	public ArrayList<Cuenta> listarTodasCuentas() throws Exception {
		/*
		 * 1) Obtener los datos de la base de datos:
		 * 
		 * BaseDato bd = new BaseDato();
		 * 
		 * Connection conexion = bd.conectar(); Statement st =
		 * conexion.createStatement(); String sql = "SELECT * FROM productos ";
		 * ResultSet rs = st.executeQuery(sql);
		 * 
		 * 2) Recorrer todos las tuplas de la base de datos.
		 * 
		 * 3) Cerrar la conexión con base de datos.
		 * 
		 */

		// Agregar nuevas cuentas
		Cuenta c1 = new Cuenta(1, 1, a, 10000.0, guaranies, activo);
		Cuenta c2 = new Cuenta(1, 2, a, 100.25, dolares, inactivo);
		Cuenta c3 = new Cuenta(2, 3, b, 50000.0, guaranies, inactivo);
		Cuenta c4 = new Cuenta(2, 4, c, 750.99, dolares, activo);
		Cuenta c5 = new Cuenta(3, 5, c, 250000.0, guaranies, inactivo);
		Cuenta c6 = new Cuenta(3, 6, b, 50000.0, guaranies, activo);

		listaDeCuentas.add(c1);
		listaDeCuentas.add(c2);
		listaDeCuentas.add(c3);
		listaDeCuentas.add(c4);
		listaDeCuentas.add(c5);
		listaDeCuentas.add(c6);

		return listaDeCuentas;
	}

	public Cuenta listarCuentaPorNroCuenta(int cuenta_id) throws Exception {

		Cuenta c = null;

		/*
		 * 1) Obtener los datos de la base de datos:
		 * 
		 * BaseDato bd = new BaseDato();
		 * 
		 * Connection conexion = bd.conectar(); Statement st =
		 * conexion.createStatement(); String sql = "SELECT * FROM productos ";
		 * ResultSet rs = st.executeQuery(sql);
		 * 
		 * 2) Recorrer todos las tuplas de la base de datos.
		 * 
		 * 3) Cerrar la conexión con base de datos.
		 * 
		 */

		// Añadiendo valores al resultado

		for (Cuenta elemento : listaDeCuentas) {
			if (elemento.getNroCuenta() == cuenta_id)
				c = elemento;
		}

		return c;
	}

	public boolean agregarCuenta(Cuenta cuenta) {

		/*
		 * Ver ejemplo del profesor para interactuar con base de datos
		 */

		boolean banAgregar = false;
		listaDeCuentas.add(cuenta);

		for (Cuenta elemento : listaDeCuentas) {
			if (elemento.equals(cuenta))
				banAgregar = true;
		}

		return banAgregar;
	}

	public boolean eliminarCuenta(Cuenta cuenta) {

		/*
		 * Ver ejemplo del profesor para interactuar con base de datos
		 */

		boolean banEliminar = false;

		if (cuenta.getEstado().equals(inactivo)) {

			Iterator<Cuenta> itCuenta = listaDeCuentas.iterator();
			while (itCuenta.hasNext()) {
				Cuenta cuentaActual = itCuenta.next();
				if (cuentaActual.getNroCuenta() == cuenta.getNroCuenta()
						&& cuentaActual.getNroSocio() == cuenta.getNroSocio()
						&& cuentaActual.getEstado().equals(inactivo)) {
					itCuenta.remove();
					banEliminar = true;
				}
			}
		}

		return banEliminar;
	}

	public boolean actualizarCuenta(Cuenta cuenta) {

		/*
		 * Ver ejemplo del profesor para interactuar con base de datos
		 */

		boolean banActualizar = false;
		
		Iterator<Cuenta> itCuenta = listaDeCuentas.iterator();
		while (itCuenta.hasNext()) {
			Cuenta cuentaActual = itCuenta.next();
			if (cuentaActual.getNroCuenta() == cuenta.getNroCuenta()
					&& cuentaActual.getNroSocio() == cuenta.getNroSocio()) {
				
				// Obtener los valores nuevos
				cuentaActual.setTipoCuenta(cuenta.getTipoCuenta());
				cuentaActual.setMoneda(cuenta.getMoneda());
				cuentaActual.setEstado(cuenta.getEstado());
				
				// Simulamos transacción
				if (cuentaActual.getEstado().equals(activo)) {
					cuentaActual.setSaldo(cuenta.getSaldo());
				} else {
					if (cuentaActual.getEstado().equals(inactivo)) {
						cuentaActual.setSaldo(0);
					}
				}
				
				banActualizar = true;
			}
		}		
		
		return banActualizar;
	}

}
