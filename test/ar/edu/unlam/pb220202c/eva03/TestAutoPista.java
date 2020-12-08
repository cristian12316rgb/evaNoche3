package ar.edu.unlam.pb220202c.eva03;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista nuevo=new Autopista();
	    Vehiculo auto=new Automovil("adc",120);
	
	nuevo.registrarTelepase(1, auto);
	
	assertEquals(((Integer)1),(Integer) nuevo.getTelapase().size());
	
	}
    @Test(expected=VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
    	Autopista nuevo=new Autopista();
	    Vehiculo auto=new Automovil("adc",120);
	
	  nuevo.registrarTelepase(1, auto);
	  nuevo.salirAutpista(auto);
	  
	  
	  
	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista nuevo=new Autopista();
		
	    Vehiculo auto=new Automovil("adc",120);
	    Vehiculo auto2=new Automovil("ad",130);//exceso de velocidad
	    Vehiculo camion=new Camion("fds",70,4);
	    Vehiculo camion2=new Camion("fd",80,4);//exceso de velocidad
		
	    nuevo.registrarTelepase(1, auto);
	    nuevo.registrarTelepase(2, auto2);
	    nuevo.registrarTelepase(3, camion);
	    nuevo.registrarTelepase(4, camion2);
	    
	    nuevo.ingresarAutopista(1);
	    nuevo.ingresarAutopista(2);
	    nuevo.ingresarAutopista(3);
	    nuevo.ingresarAutopista(4);
	    
	    Integer contador=0;
	    Vehiculo prueba=null;
	    for(Vehiculo j:nuevo.getVehiculosEnCirculacion()) {
	    	if(contador==0) {
	    		prueba=j;
	    	}else {
	    		assertTrue(prueba.getPatente().compareTo(j.getPatente())<0);
	    	}
	    }
	    
	   assertTrue(nuevo.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(auto2));
	   assertTrue(nuevo.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(camion2));
	   assertFalse(nuevo.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(auto));
	   assertFalse(nuevo.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(camion));
	}
    @Test
	public void queNoSePuedanAgregarAutosRepetidos() throws VehiculoNotFounException {
        Autopista nuevo=new Autopista();
		
	    Vehiculo auto1=new Automovil("adc",120);
	    Vehiculo auto2=new Automovil("adcg",120);
	    Vehiculo auto3=new Automovil("addf",120);
	    Vehiculo auto4=new Automovil("adc",120);
	    Vehiculo camion1=new Camion("fdsj",70,4);
	    Vehiculo camion2=new Camion("fdhg",70,4);
	    Vehiculo camion3=new Camion("fgf",70,4);
	    Vehiculo camion4=new Camion("fdsj",70,4);
	    
	    
	    
	    nuevo.registrarTelepase(1, auto1);
	    nuevo.registrarTelepase(2, auto2);
	    nuevo.registrarTelepase(3, auto3);
	    nuevo.registrarTelepase(4, auto4);
	    nuevo.registrarTelepase(5, camion1);
	    nuevo.registrarTelepase(6, camion2);
	    nuevo.registrarTelepase(7, camion3);
	    nuevo.registrarTelepase(8, camion4);
	    
	    
	    nuevo.ingresarAutopista(1);
	    nuevo.ingresarAutopista(2);
	    nuevo.ingresarAutopista(3);
	    nuevo.ingresarAutopista(4);
	    nuevo.ingresarAutopista(5);
	    nuevo.ingresarAutopista(6);
	    nuevo.ingresarAutopista(7);
	    nuevo.ingresarAutopista(8);
	    
	    
	    
	    assertEquals(((Integer)6), (Integer)nuevo.getVehiculosEnCirculacion().size());
	    
	    
	    
	}
	@Test
	public void queNoSeMulteUnaPatrullaPorExcesoDeVelocidad() throws VehiculoNotFounException {
        Autopista nuevo=new Autopista();
		
	    Vehiculo patrulla=new Patrulla("adc",130);
	    
	    nuevo.registrarTelepase(1, patrulla);
	    nuevo.ingresarAutopista(1);
	    
	    
	    
	    assertFalse(nuevo.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().contains(patrulla));
	    
		
		
	}
	
}
