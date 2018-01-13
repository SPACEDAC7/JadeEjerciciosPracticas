import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
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
		
		DFAgentDescription dfd= new DFAgentDescription();
		dfd.setName(getAID()); // El id del agente
		ServiceDescription sd = new ServiceDescription();
		sd.setType("AgenteR");
		sd.setName("R1");
		dfd.addServices(sd);
		try {
		DFService.register(this, dfd);
		} catch (FIPAException fe) { fe.printStackTrace(); }
		
		addBehaviour(new TickerBehaviour(this, 1000) {
			
			@Override
			public void onTick() {
				DFAgentDescription dfd= new DFAgentDescription();
				ServiceDescription sd= new ServiceDescription();
				sd.setType("AgenteS");
				try {
					dfd.addServices(sd);
					DFAgentDescription[] result= DFService.search(myAgent, dfd);
					System.out.println("Hay " + result.length+" agentes de tipo Detectar");
					AID[] Agentes = new AID[result.length];
					for(int i=0; i<result.length; i++ )
						Agentes[i] = result[i].getName();
				} catch (FIPAException fe) { fe.printStackTrace(); }
				
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
