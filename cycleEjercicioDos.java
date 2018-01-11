import java.util.Date;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class cycleEjercicioDos extends TickerBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date currentDate;
	int account;
	public cycleEjercicioDos(Agent a, long period , Date currentDate) {
		super(a, period);
		this.account = 0;
		this.currentDate = currentDate;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTick() {
		currentDate = new Date();
		System.out.println("He aparecido " + this.account + " y la hora es " + this.currentDate.toString());
		this.account++;
	}

}
