package HabitacionReserva;

public class  ExceptionSalesSlip extends Exception {
	public static final long serialVersionUID=0;

	public ExceptionSalesSlip () {
		super("Hubo un problema con el monto  de la factura");
	}
	
	public ExceptionSalesSlip (String msm){
		super(msm);
	}
	
}
