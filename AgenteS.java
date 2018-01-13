import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgenteS extends Agent {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgenteS() {
	}
	
	public void setup(){
		DFAgentDescription dfd= new DFAgentDescription();
		dfd.setName(getAID()); // El id del agente
		ServiceDescription sd = new ServiceDescription();
		sd.setType("AgenteS");
		sd.setName("S1");
		dfd.addServices(sd);
		try {
		DFService.register(this, dfd);
		} catch (FIPAException fe) { fe.printStackTrace(); }
		
		this.envia();
	}
	
	public void envia(){
		this.addBehaviour(new avisoComportamiento(this, 1000));
	}

}
