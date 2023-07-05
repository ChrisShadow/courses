package Hospedaje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo extends File {

	private static final long serialVersionUID = 1L;
	//Instanciar el objeto File, atributos
	private static File archivo = new File("C:\\Users\\Marco\\Desktop\\Chris\\Java Course\\Clase14_Hospedaje\\arch");
	private static String nombreArchi="datosHospedaje.txt";
	
	public Archivo() {
		super(archivo, nombreArchi);
	}
	
	public Archivo(File ar, String nA) {
		/*String path="";
		if(ar.exists()) {
			path=ar.getPath();
		}*/
		super(ar.getPath(), nA);
		
	}

	public boolean analizarRuta(String path) {
		File ruta= new File(path);
		if (ruta.exists()) {
			return true;
		}
		return false;
	}
	
	//Opción 1
	public boolean GuardarArchivo(Hospedaje h, String accion){
		boolean lineaCont=false;
		File a= new File(archivo, nombreArchi);
		FileWriter save;
		BufferedWriter bw;
		
		try {
			//FileInputStream f= new FileInputStream(a);
			save= new FileWriter(a,true);
			bw = new BufferedWriter(save); 
			String contenido=accion.concat(" & ")+h.Linea().concat("\n");
			bw.append(contenido);
			bw.flush();
			bw.close();
			lineaCont=true;
		} catch (IOException e) {
			System.err.println("Ocurrió un error de "+e.getMessage());
		}
		
		return lineaCont;
	}
	
	/*//Opción 2
	public boolean GuardarArchivo(String accion, Hospedaje h){
		boolean lineaCont=false;
		File a= new File(archivo, nombreArchi);
		FileInputStream f;
		Writer writer;
		BufferedWriter bW;
		InputStream iW;
		/*FileOutputStream(file, true), "UTF-8"));
		FileWriter save;
		
		try {
			f= new FileInputStream(a);
			iW = new InputStream();
			//save= new FileWriter(a);
			String contenido=accion.concat("&")+h.Linea();
			//save.append(contenido);
			lineaCont=true;
		} catch (IOException e) {
			System.out.println("Ocurrió un error de "+e.getMessage());
		}
		
		return lineaCont;
	}*/
	
	public StringBuilder LeerrArchivo() throws FileNotFoundException {
		StringBuilder reporte= new StringBuilder();
		File a= new File(archivo, nombreArchi);
		BufferedReader b ;
		FileReader f;
		String cadena=""; 
		String[] content;
		try {
			f = new FileReader(a); 
			b = new BufferedReader(f); 
			cadena = b.readLine();
			reporte.append("Datos de la operación: ");
			while(cadena !=null) { 
				content= cadena.split(" & ");
				if(content[0].equals("INSERCION")) {
					reporte.append(content[1]).append(" # Operación: Inserción en el archivo.");
				}else {
					reporte.append(content[1]).append(" # Operación: Actualización del archivo.");	
				}
				cadena = b.readLine();
				//Para no añadir la cabacera
				if (cadena!=null)
					reporte.append("\nDatos de la operación: ");
			}
			b.close(); 
		} catch (IOException e) {
			System.err.println("Ocurrió un error de "+e.getMessage());
			reporte.append("Ocurrió un error de "+e.getMessage());
		} 
		return reporte;
	}
	
	
	
}
