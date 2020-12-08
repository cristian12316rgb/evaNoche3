package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telapase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	Autopista(){
		this.telapase=new HashMap<>();
		this.vehiculosEnCirculacion=new HashSet<>();
	}
	
	public void registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		this.telapase.put(numeroTelpase, vehiculo);
	}
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista
		Vehiculo nuevo=this.telapase.get(numeroTelepase);
		if(nuevo!=null) {
			return this.vehiculosEnCirculacion.add(nuevo);
			 
		}
		
	    throw new VehiculoNotFounException("No tiene telepase");
		
		
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		
		if(this.vehiculosEnCirculacion.contains(vehiculo)) {
			this.vehiculosEnCirculacion.remove(vehiculo);
		}else {
			throw new VehiculoNotFounException("No esta en circulacion");
		}
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
	TreeSet<Vehiculo>nuevo=new TreeSet<>(new NuevoOrden());
	
	for(Vehiculo prueba:this.vehiculosEnCirculacion) {
		if(prueba instanceof Automovil) {
			if(prueba.getVelocidadActual()>=prueba.getLimiteVelocidad()) {
				nuevo.add(prueba);
			}
		}else {
			if(prueba instanceof Camion) {
				if(prueba.getVelocidadActual()>=prueba.getLimiteVelocidad()) {
					nuevo.add(prueba);
				}
			}else {
			if(prueba instanceof Imultable) {
				
			}
		}
		}
	}
	
	
	
	return nuevo;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return this.vehiculosEnCirculacion.size();
}
	public HashMap<Integer, Vehiculo> getTelapase() {
		return telapase;
	}
	public void setTelapase(HashMap<Integer, Vehiculo> telapase) {
		this.telapase = telapase;
	}
	public HashSet<Vehiculo> getVehiculosEnCirculacion() {
		return vehiculosEnCirculacion;
	}
	public void setVehiculosEnCirculacion(HashSet<Vehiculo> vehiculosEnCirculacion) {
		this.vehiculosEnCirculacion = vehiculosEnCirculacion;
	}
	
	
	
	}
