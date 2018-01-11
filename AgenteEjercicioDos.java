import java.util.Date;

import jade.core.Agent;

public class AgenteEjercicioDos extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgenteEjercicioDos() {
		// TODO Auto-generated constructor stub
	}
	
	public void setup(){
		Date fecha = new Date();
		Object[] arguments = this.getArguments();
		for(int i = 0; i < arguments.length;i++){
			System.out.println(arguments[i].toString());
		}
		System.out.println(arguments.length);
		if(arguments.length < 4){
			System.out.println("Se han pasado menos de 4 números como argumento");
		}else{
			System.out.println(fecha.toString());
			this.addBehaviour(new genericoEjercicioDos(this, Integer.parseInt((String) arguments[0]), Integer.parseInt((String)arguments[1]),Integer.parseInt((String)arguments[2]),Integer.parseInt((String)arguments[3])));
			this.addBehaviour(new wakerEjercicioDos(this, 10000, fecha));
			this.addBehaviour(new cycleEjercicioDos(this, 3000, fecha));
		}
	}

}
