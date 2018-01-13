import jade.core.Agent;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import java.util.Date;
import java.util.UUID;
import java.util.Vector;


public class Iniciador extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Iniciador() {
		// TODO Auto-generated constructor stub
	}
	private int nResponders;
	
	  protected void setup() {
	  	// Read names of responders as arguments
		  addBehaviour(new sendMessageBehaviour(this, 1000));
	  } 
}
