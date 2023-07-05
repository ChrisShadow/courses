package Famosos;

public class FamosoActor extends InfoFamosos {
	private double altura;
	private String tipoCom;
	private String[] topMejPeli;
	private String[] topMejNomi;
	
	//
	public FamosoActor() {
		super(); 
	}
	
	public FamosoActor(String nombreApellido, char sexo, int fechaNac, String keyFamoso, int tipoFam,
			double altura, String tipoCom, String topMejPeli, String topMejNomi) {
		super(nombreApellido, sexo, fechaNac, keyFamoso, tipoFam);
		this.topMejPeli= new String[5];
		this.topMejPeli=topMejPeli.split(",");
		this.topMejNomi= new String[3];
		this.topMejNomi=topMejNomi.split(",");
		this.altura=altura;
		this.tipoCom=tipoCom;
	}

	//
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getTipoCom() {
		return tipoCom;
	}

	public void setTipoCom(String tipoCom) {
		this.tipoCom = tipoCom;
	}

	public String[] getTopMejPeli() {
		return topMejPeli;
	}

	public void setTopMejPeli(String[] topMejPeli) {
		this.topMejPeli = topMejPeli;
	}

	public String[] getTopMejNomi() {
		return topMejNomi;
	}

	public void setTopMejNomi(String[] topMejNomi) {
		this.topMejNomi = topMejNomi;
	}
	
	
}
