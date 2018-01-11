import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class avisoComportamiento extends TickerBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String estado;
	public avisoComportamiento(Agent a, long period) {
		super(a, period);
		this.estado = "Libre";
	}

	@Override
	protected void onTick() {
		System.out.println("Envio");
		ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("R1", AID.ISLOCALNAME));
		msg.setLanguage("Spanish");
		msg.setOntology("Weather-forecast-ontology");
		msg.setContent(estado);
		myAgent.send(msg);
		if("Libre".compareTo(estado) == 0)
			estado = "Ocupado";
		else
			estado = "Libre";

	}

}
