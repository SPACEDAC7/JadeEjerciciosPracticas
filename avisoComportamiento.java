import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
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
		
		DFAgentDescription dfd= new DFAgentDescription();
		ServiceDescription sd= new ServiceDescription();
		sd.setType("AgenteR");
		try {
			dfd.addServices(sd);
			DFAgentDescription[] result= DFService.search(myAgent, dfd );
			System.out.println("Hay " + result.length+" agentes de tipo Detectar");
			AID[] Agentes = new AID[result.length];
			for(int i=0; i<result.length; i++ )
				Agentes[i] = result[i].getName();
		} catch (FIPAException fe) { fe.printStackTrace(); }

		
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
