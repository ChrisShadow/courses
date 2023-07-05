package ExamenFinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Archivo extends File {
	

	private static final long serialVersionUID = 1L;

	private static File archivo = new File("C:\\Users\\Marco\\Desktop\\Chris\\Java Course\\Clase16_ExamenFinal\\ESTADISTICA");
	private static String nombreArchi="COVID_19_PY_DEPARTAMENTOS.info";
	
	public Archivo() {
		super(archivo, nombreArchi);
	}
	
	public Archivo(File ar, String nA) {
		super(ar.getPath(), nA);
	}

	public boolean analizarRuta(String path) {
		File ruta= new File(path);
		if (ruta.exists()) {
			return true;
		}
		return false;
	}
	
	public boolean GuardarArchivo(ResultSet resulReg) throws IOException{
		ArrayList<Estadistica> liE= new ArrayList<Estadistica>(); 
		Estadistica e=null;
		boolean lineaCont=false;
		File a= new File(archivo, nombreArchi);
		FileWriter save;
		BufferedWriter bw;
		String tipoVac="";
		BufferedReader b ;
		FileReader f;
		
		save= new FileWriter(a,true);
		bw = new BufferedWriter(save);
		
		if (!resulReg.equals(null)) {
			try {
				while(resulReg.next()) {
					e=new Estadistica();
					e.setDepartamento(resulReg.getInt("departamento"));
					tipoVac=resulReg.getString("vacuna");
					e.setDosis(resulReg.getInt("dosis"));
					e.setCantidad(resulReg.getInt("cantidad"));
					if(tipoVac.equals("COVAXIN")) {
						e.setVacuna(Vacuna.COVAXIN);
					}else if(tipoVac.equals("PFIZER")) {
						e.setVacuna(Vacuna.PFIZER);
					}else if(tipoVac.equals("ASTRAZENECA")) {
						e.setVacuna(Vacuna.ASTRAZENECA);
					}else {
						e.setVacuna(Vacuna.MODERNA);
					}
					//Añadir a la lista
					liE.add(e);
				}
				
				f = new FileReader(a); 
				b = new BufferedReader(f); 
				String linea = b.readLine();
				String contenido="";
				if(linea==null) {
					contenido="<departamento> ; <vacuna> ; <dosis> ; <cantidad>\n";
					bw.append(contenido);
					bw.flush();
					contenido="";
				}else {
					if(linea.equals("<departamento> ; <vacuna> ; <dosis> ; <cantidad>"))
						linea = b.readLine();
				}
				
				if (!liE.isEmpty()) {
						if(linea==null) {
							for (Estadistica estadistica : liE) {
								//Por primera vez
								contenido=estadistica.Linea().concat("\n");
								bw.append(contenido);
								bw.flush();
							}
						}else {
							while(linea!=null) {
								for (Estadistica estadistica : liE) {
									//Exite en ambos, base de datos y archivo: REGRABA
									if(linea.equals(estadistica.Linea())) {
										contenido=linea.concat("\n");
										//Sobreescritura
										//bw.append(contenido);
										System.out.println(contenido);
										//bw.flush();
										linea="";
									}
								}
								linea = b.readLine(); //Leer siguiente
						}
					}
					lineaCont=true;
				}else {
					System.err.println("Datos no encontrados.");
					lineaCont=false;
				}
				bw.close();
			} catch (SQLException ex) {
				System.err.println("Error de: " + ex.getMessage());
				lineaCont=false;
			}
		}else {
			lineaCont=false;
		}
		
		return lineaCont;
	}
}
