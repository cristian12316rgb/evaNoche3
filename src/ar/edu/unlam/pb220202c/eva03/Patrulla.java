package ar.edu.unlam.pb220202c.eva03;

public class Patrulla extends Vehiculo implements Imultable{

	public Patrulla(String patente, Integer velocidadActual) {
		super(patente, velocidadActual);
		super.setLimiteVelocidad(130);
	}

	@Override
	public Boolean enInfraccion() {
		return false;
	}
	
	

}
