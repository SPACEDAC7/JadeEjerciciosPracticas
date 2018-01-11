import jade.core.Agent;
import jade.core.behaviours.Behaviour;
public class genericoEjercicioDos extends Behaviour {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int step = 0;
	int first;
	int second;
	int third;
	int fourth;
	public genericoEjercicioDos() {
		// TODO Auto-generated constructor stub
	}

	public genericoEjercicioDos(Agent a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	
	public genericoEjercicioDos(Agent a, int first, int second, int third, int fourth) {
		super(a);
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		switch(step){
		case 0:
			System.out.println(this.isPrime(first));
			step++;
			break;
		case 1:
			System.out.println(this.isPrime(second));
			step++;
			break;
		case 2:
			System.out.println(this.isPrime(third));
			step++;
			break;
		case 3:
			System.out.println(this.isPrime(fourth));
			step++;
			break;
		}

	}

	@Override
	public boolean done() {
		return step == 4;
	}
	
	public String isPrime(int number){
		int a=0,i,n;
		n= number;
		for(i=1;i<(n+1);i++){
			if(n%i==0){
				a++;
			}
		}
		if(a!=2){
			return n + "No es primo";
		}
		return  n + "Es primo";

	}

}
