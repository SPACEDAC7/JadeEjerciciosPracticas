import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class waitBehaviour extends OneShotBehaviour {

	public String identify;
	public Agent a;
	private static final long serialVersionUID = 1L;
	
	public waitBehaviour() {
		// TODO Auto-generated constructor stub
	}

	public waitBehaviour(Agent a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public waitBehaviour(Agent a, String identify){
		this.identify = identify;
		this.a = a;
	}
	

	@Override
	public void action() {
		// TODO Auto-generated method stub
		MessageTemplate template = MessageTemplate.and(
		  		MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST),
		  		MessageTemplate.MatchConversationId(identify));
		
		ACLMessage msg = a.receive(template);
		
		if(msg!= null){
			System.out.println("El contenido del mensaje es: " + msg.getContent());
		}else{
			block();
		}
	}
	
}

