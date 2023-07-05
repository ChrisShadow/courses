import org.junit.Assert;
import org.junit.Test;

import Modelo.*;
import Servicio.ServicioEquipo;

public class AppTest {

	//Estado
	Estado I = Estado.INACTIVO;
	Estado A = Estado.ACTIVO;
	Estado B = Estado.BAJA;		
			
	//Temporada
	CodigoTemporada pa = CodigoTemporada.PRIMAVERA;
	CodigoTemporada vo = CodigoTemporada.VERANO;
	CodigoTemporada oo = CodigoTemporada.OTONHO;		

	
	@Test
    public void method() {
		
		//Objetos prueba
		Equipo e1 = new Equipo(1,"Sport Ju'i","Zinedine Zidane","2019",pa,A,"Limpio",12,15,16,18,2,45);
		Equipo e2 = new Equipo(11,"Nueva Luna","Zinedine Zidane","2019",pa,B,"Paris",7,48,12,36,85,87);
		
		ServicioEquipo ser = new ServicioEquipo();
        Assert.assertEquals(200,ser.agregarEquipo(e1.toJson()).getStatus());
        Assert.assertEquals(200,ser.agregarEquipo(e2.toJson()).getStatus());
    }

	
}
