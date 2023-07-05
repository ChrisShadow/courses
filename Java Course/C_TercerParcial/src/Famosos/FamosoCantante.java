package Famosos;

public class FamosoCantante extends InfoFamosos {
	private String genMus;
	private int cantTwitt;
	private String[] topMejAlb;
	private String[] cantInst;
	
	//
	public FamosoCantante() {
		super();
	}
	
	public FamosoCantante(String nombreApellido, char sexo, int fechaNac, String keyFamoso, int tipoFam, 
			String genMus, int cantTwitt, String topMejAlb, String cantInst) {
		super(nombreApellido, sexo, fechaNac, keyFamoso, tipoFam );
		this.topMejAlb= new String[4];
		this.topMejAlb=topMejAlb.split(",");
		this.cantInst=cantInst.split(",");
		this.genMus=genMus;
		this.cantTwitt=cantTwitt;
	}
	
	//
	public String getGenMus() {
		return genMus;
	}

	public void setGenMus(String genMus) {
		this.genMus = genMus;
	}

	public int getCantTwitt() {
		return cantTwitt;
	}

	public void setCantTwitt(int cantTwitt) {
		this.cantTwitt = cantTwitt;
	}

	public String[] getTopMejAlb() {
		return topMejAlb;
	}

	public void setTopMejAlb(String[] topMejAlb) {
		this.topMejAlb = topMejAlb;
	}

	public String[] getCantInst() {
		return cantInst;
	}

	public void setCantInst(String[] cantInst) {
		this.cantInst = cantInst;
	}
	
	
}
