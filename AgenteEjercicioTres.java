import java.util.Date;

import jade.core.Agent;

public class AgenteEjercicioTres extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setup(){
		System.out.println("Hola soy " + getAID().getLocalName());
		System.out.println("Y son las: " + new Date());
	}
}
