import jade.core.Agent;

public class AgenteS extends Agent {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgenteS() {
	}
	
	public void setup(){
		this.envia();
	}
	
	public void envia(){
		this.addBehaviour(new avisoComportamiento(this, 100));
	}

}
