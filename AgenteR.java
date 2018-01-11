import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class AgenteR extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgenteR() {
		// TODO Auto-generated constructor stub
	}
	
	public void setup(){
		
		addBehaviour(new Behaviour() {
			
			@Override
			public boolean done() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void action() {
				ACLMessage msg= myAgent.receive();
				if(msg!= null) {
				String pro = msg.getContent();
				System.out.println("El mensaje recibido fue: " + pro);
				}else{
					//System.out.println("No se ha recibido nada");
				}
				
			}
		});
		
	}

}
