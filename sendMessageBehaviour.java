import java.util.Date;
import java.util.UUID;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.introspection.AddedBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class sendMessageBehaviour extends TickerBehaviour {

	DFAgentDescription dfd= new DFAgentDescription();
	ServiceDescription sd= new ServiceDescription();
	
	public sendMessageBehaviour(Agent a, long period) {
		super(a, period);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTick() {

		sd.setType("Continuador");

		dfd.addServices(sd);
		DFAgentDescription[] result = null;
		try {
			result = DFService.search(myAgent, dfd );
			System.out.println("Se ha buscado los buscadores");
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hay " + result.length+" agentes de tipo Continuador");
		AID[] Agentes = new AID[result.length];
		for(int i=0; i<result.length; i++ )
			Agentes[i] = result[i].getName();


		// Fill the REQUEST message
		if(Agentes.length > 0){
			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			int idReceiver = (int) (Math.random()*Agentes.length);
			System.out.println("Se lo mando a " + idReceiver);
			msg.addReceiver(Agentes[idReceiver]);
			/*for (int i = 0; i < Agentes.length; ++i) {
				msg.addReceiver(Agentes[i]);
			}*/
			msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
			// We want to receive a reply in 10 secs
			String identify = UUID.randomUUID().toString();
			msg.setConversationId(identify);
			msg.setContent("dummy-action");
			myAgent.send(msg);
			
			myAgent.addBehaviour(new waitBehaviour(myAgent, identify));
		}else{
			System.out.println("No se han encontrado agentes Continuador");
		}

	}

}
