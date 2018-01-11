import java.util.Date;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class wakerEjercicioDos extends WakerBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date currentDate ;
	public wakerEjercicioDos(Agent a, Date wakeupDate) {
		super(a, wakeupDate);
		// TODO Auto-generated constructor stub
	}

	public wakerEjercicioDos(Agent a, long timeout, Date currentDate) {
		super(a, timeout);
		this.currentDate = currentDate;
		// TODO Auto-generated constructor stub
	}
	
	public void onWake(){
		//currentDate = new Date();
		System.out.println("Me acabo de despertar y son las " + currentDate.toString() );
	}

}
