import java.io.*;

class Generador{
	String nombres[][];
	
	public Generador(){
		int i=0;
		nombres=new String[2][38];
		FileReader fr = null;
      	BufferedReader br = null;
      	File nomb;
		try{
			nomb= new File("nombres.txt");
			fr = new FileReader(nomb);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			//LLenar los nombres
			for(i=0;i<25;i++){
				if((linea=br.readLine())!=null){
		        	//System.out.println("capturado nombre "+i);
		        	nombres[0][i]=linea;
		     	}else
		     		break;
			}
			for(i=0;i<18;i++){
				if((linea=br.readLine())!=null){
		        	//System.out.println("capturado apellido "+(i));
		        	nombres[1][i]=linea;
		     	}else
		     		break;
			}
		 }
		 catch(Exception e){
         e.printStackTrace();
		 }finally{
		     // En el finally cerramos el fichero, para asegurarnos
		     // que se cierra tanto si todo va bien como si salta 
		     // una excepcion.
		     try{                    
		        if( null != fr ){   
		           fr.close();     
		        }                  
		     }catch (Exception e2){ 
		        e2.printStackTrace();
		     }
		  }
	}
	public int generaente(int max){
		return ((int) (Math.random() * max));
	}
		
	
	public String Generanombres(){
		return (nombres[0][((int)(Math.random() * 25))]+" "+nombres[1][((int)(Math.random() * 16))]);
	}
	public float califi(){
		return ((float)((Math.random()*2)*5)) ;
	}
	public int cuenta(){
		return ((int) (Math.random() * 5000));
	}
	public int telefono(){
		return ((int)((Math.random()*10000)*6)) ;
	}
	
	/*public Direccion Generadir(){
		Direccion generada=new Direccion();
		generada.Setnumero((String)(generaente(1000)));
	}*/
	
	public static void main(String[] args) {
		Generador aver=new Generador();
		for(int i=0;i<20;i++){
			System.out.println(aver.Generanombres());
			System.out.println("El promedio es "+aver.califi());
			System.out.println("EL numero de cuenta es "+aver.cuenta()+"\n");
		}
	}
}
