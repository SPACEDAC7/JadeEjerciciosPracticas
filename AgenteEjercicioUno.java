import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class AgenteEjercicioUno extends Agent {

	public AgenteEjercicioUno() {
		// TODO Auto-generated constructor stub
	}


	public void setup(){
		this.preProcesadoDeInfo();
		this.analizando();
		boolean validado = this.validacion();
		this.almacenado(validado);
	}
	
	public void preProcesadoDeInfo(){
		Object[] arguments = this.getArguments();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		if(arguments == null){
			System.out.println("Don't input a file name correctly");
		}else{
			try {
				System.out.println(arguments[0]);
				// Apertura del fichero y creacion de BufferedReader para poder
				// hacer una lectura comoda (disponer del metodo readLine()).
				archivo = new File ((String) arguments[0]);
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);

				// Lectura del fichero
				String linea;
				while((linea=br.readLine())!=null)
					System.out.println(linea);
			}
			catch(Exception e){
				e.printStackTrace();
			}finally{
				try{                    
					if( null != fr ){   
						fr.close();     
					}                  
				}catch (Exception e2){ 
					e2.printStackTrace();
				}
			}
		}
	}
	
	public void analizando(){
		System.out.println("Analizando...");
	}
	
	public boolean validacion(){
		boolean validado = false;
		Scanner entrada = new Scanner(System.in);
		int i = 0;
		while(i < 3 && !validado ){
			System.out.println("Son correctos los datos?:(Y/N)");
			if("Y".compareTo(entrada.next()) == 0){
				validado = true;
			}
			i++;
		}
		
		return validado;
	}
	
	public void almacenado(boolean v){
		if(v){
			System.out.println("Se ha finalizado satisfactoriamente");
		}else{
			System.out.println("No se ha finalizado satisfactoriamente");
		}
	}

}
