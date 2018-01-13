import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAAgentManagement.FailureException;

public class Continuadores extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setup(){
		
		DFAgentDescription dfd= new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType("Continuador");
		sd.setName(this.getLocalName());
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) { fe.printStackTrace(); }
		
		addBehaviour(new receiveMessage(this));
	}
}
