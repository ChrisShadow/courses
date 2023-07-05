package Famosos;

public class ExceptionFamous  extends Exception{

	public static final long serialVersionUID=0;

	public ExceptionFamous () {
		super("Las condiciones del famoso no son aptas.");
	}
	
	public ExceptionFamous (String msm){
		super(msm);
	}
}
