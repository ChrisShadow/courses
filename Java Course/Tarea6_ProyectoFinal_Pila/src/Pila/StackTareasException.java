package Pila;

public class StackTareasException extends Exception {
	public static final long serialVersionUID=0;

	public StackTareasException () {
		super("Las condiciones de la pila no son aptas.");
	}
	
	public StackTareasException (String msm){
		super(msm);
	}

}
