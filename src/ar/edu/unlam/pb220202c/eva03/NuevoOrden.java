package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;

public class NuevoOrden implements Comparator<Vehiculo>{

	@Override
	public int compare(Vehiculo arg0, Vehiculo arg1) {
		return arg0.getPatente().compareTo(arg1.getPatente());
	}
	

}
