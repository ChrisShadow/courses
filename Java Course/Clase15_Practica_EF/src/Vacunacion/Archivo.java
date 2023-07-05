package Vacunacion;

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
	private static File archivo = new File("C:\\Users\\Marco\\Desktop\\Chris\\Java Course\\Clase15_Practica_EF\\DATA");
	private static String nombreArchi="COVID_19_PY_REGISTRO_VACUNACION.csv";
	
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
		ArrayList<Vacuna> liV= new ArrayList<Vacuna>(); 
		Vacuna v=null;
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
					v=new Vacuna();
					v.setDocumento(resulReg.getString("documento"));
					v.setLugar_vacunacion(resulReg.getString("lugar_vacunacion"));
					v.setFecha_aplicacion(resulReg.getString("fecha_aplicacion"));
					tipoVac=resulReg.getString("vacuna");
					if(tipoVac.equals("COVAXIN")) {
						v.setVacuna(TipoVacuna.COVAXIN);
					}else if(tipoVac.equals("PFIZER")) {
						v.setVacuna(TipoVacuna.PFIZER);
					}else if(tipoVac.equals("ASTRAZENECA")) {
						v.setVacuna(TipoVacuna.ASTRAZENECA);
					}else if(tipoVac.equals("MODERNA")) {
						v.setVacuna(TipoVacuna.MODERNA);
					}else if(tipoVac.equals("SPUTNIKV")) {
						v.setVacuna(TipoVacuna.SPUTNIKV);
					}else {
						v.setVacuna(TipoVacuna.HAYATVAX);
					}
					v.setDosis(resulReg.getInt("dosis"));
					v.setFecha_hora_carga(resulReg.getString("fecha_hora_carga"));
					//Añadir a la lista
					liV.add(v);
				}
				
				f = new FileReader(a); 
				b = new BufferedReader(f); 
				String linea = b.readLine();
				String contenido="";
				if(linea==null) {
					contenido="<documento> ; <lugar_vacunacion> ; <fecha_aplicacion> ; <vacuna> ; <dosis> ; <fecha_carga>\n";
					bw.append(contenido);
					bw.flush();
					contenido="";
				}else {
					if(linea.equals("<documento> ; <lugar_vacunacion> ; <fecha_aplicacion> ; <vacuna> ; <dosis> ; <fecha_carga>"))
						linea = b.readLine();
				}
				
				if (!liV.isEmpty()) {
						if(linea==null) {
							for (Vacuna vacuna : liV) {
								//Por primera vez
								contenido=vacuna.Linea().concat("\n");
								bw.append(contenido);
								bw.flush();
							}
						}else {
							while(linea!=null) {
								for (Vacuna vacuna : liV) {
									//Exite en ambos, base de datos y archivo: REGRABA
									if(linea.equals(vacuna.Linea())) {
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
			} catch (SQLException e) {
				System.err.println("Error de: " + e.getMessage());
				lineaCont=false;
			}
		}else {
			lineaCont=false;
		}
		
		return lineaCont;
	}
	
}
