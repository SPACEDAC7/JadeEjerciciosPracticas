import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;

public class receiveMessage extends CyclicBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Agent a;
	public receiveMessage() {
		// TODO Auto-generated constructor stub
	}

	public receiveMessage(Agent a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.a = a;
	}

	@Override
	public void action() {
		MessageTemplate template =MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
	  	ACLMessage msg = this.a.receive(template);
	  	
	  	if(msg != null){
		  	System.out.println("RECIBIDO");
		  	System.out.println(msg.getContent());
		  	try {
		  		System.out.println(msg.getContent());
				Thread.sleep(((int) (Math.random()*3+1)) * 1000);
		  	} catch (InterruptedException e) {
		  		// TODO Auto-generated catch block
		  		e.printStackTrace();
		  	}

		  	ACLMessage reply = msg.createReply();

		  	if((int) (Math.random()*10+1) > 2){
		  		System.out.println("Agent : Agree");
		  		reply.setPerformative(ACLMessage.AGREE);
		  		reply.setConversationId(msg.getConversationId());
		  		reply.setContent("inform-done");

		  	}else {
		  		// We refuse to perform the action
		  		System.out.println("Agent : Fail");
		  		reply.setConversationId(msg.getConversationId());
		  		reply.setPerformative(ACLMessage.FAILURE);
		  		reply.setContent("failure");
		  	}
		  	myAgent.send(reply);
	  	}else{
	  		System.out.println("No ha llegado el mensaje todavia");
	  	}
	}

}
