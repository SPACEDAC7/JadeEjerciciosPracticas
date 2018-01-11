import jade.core.Agent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class LanzadorEjercicioTres extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setup() {
		String name = "AgenteAuxiliar" ;
		AgentContainer c = getContainerController();
		try {
			for(int i = 1; i <= 4; i++){
				System.out.println("PRUEBA " + i);
				String nombre = name + i;
				AgentController a = c.createNewAgent( nombre,"AgenteEjercicioTres", new Object[12] );
				a.start(); //Inicializar al agente
				
			}
		}
		catch (Exception e){
			
			e.printStackTrace();
			
		}
	}

}
