public class PrincipalBancaFI {
 
	
	//Metodo privado para verificar el menu y la entrada del menu del alumno 
	public static int controlDeMenu(String texto, int maxopc){
		int opcion;
		do{
			opcion = Teclado.entero(texto);
			if (opcion<1 || opcion>maxopc)
				System.out.println("Error al elegir, vuelve a elegir alguna opcion");				
			return opcion;
		  }
		while(opcion<1 || opcion>maxopc); 
															}
	
	
	
    int contador=0, id=1; 									//con esta pariable se lleva el control de los inscritos
    usuarioBancaFI usuario [] = new usuarioBancaFI[100]; 			//inicializamos el arreglo de objetos usuario
    
    //constructor de la clase PrincipalBanco
    public PrincipalBancaFI()
    { 								
    int opcion;
 
	do {
		opcion = controlDeMenu("\n1)Dar de Alta\n 2)Buscar\n 3)Abonar\n 4)Descontar\n 5)Mostrar\n 6)Eliminar\n 7)SALIDA\n\nEleccion: ",7);
		
		//Una vez que la opcion sea valida pasara a este switch
		switch (opcion){
        case 1:
            darDeAlta();
            break;
        case 2:
            Buscar();
            break;
        case 3:
            Abonar();
            break;
        case 4:
            Descontar();
            break;
        case 5:
            Mostrar();
            break;
        case 6:
            Eliminar();
            break;
        case 7:
            break;    
        default:
				break;
				
				
						}//Esta llave cierra el switch
			}//Esta llave cierra el do del Do-While
	
	while(opcion !=7); //Mientras la opcion sea
    }
    
 
    public void darDeAlta(){        
 
        int telefono;
        String nombre, apellido;
        Double saldo;        

        System.out.println("\n");
        nombre = Teclado.cadena("Ingrese el Nombre del usuario: ");
        apellido = Teclado.cadena("Ingrese el Apellido del usuario: ");
        telefono =Teclado.entero("Ingrese el Telefono del Usuario: ");
        saldo = Teclado.Double("Ingrese el Saldo inicial del Usuario: ");
 
        usuarioBancaFI temp = new usuarioBancaFI();
 
        temp.setId(id); 
        temp.setNombre(nombre); 
        temp.setApellido(apellido);
        temp.setTelefono(telefono);
        temp.setSaldo(saldo);        
 
        usuario[contador] = temp;
        contador++;  
        id++;      
    }
 
    public void Mostrar(){
 
        String ay="";
        
        System.out.println("\n");
        for(int i=0; i<contador; i++){
            ay+="ID: "+usuario[i].getId()+"\n" + "Nombre: "+usuario[i].getNombre()+"\n" + "Apellido: "+usuario[i].getApellido()+"\n" + "Telefono: "+usuario[i].getTelefono()+"\n" + "Saldo: "+usuario[i].getSaldo()+"\n\n";        
        }
        System.out.println(ay);
    }

    public void Abonar(){
        int c,b = 0;
        Double auxiliarAbono, abono;
        
        System.out.println("\n");
        c=Teclado.entero("Digite el ID de usuario a buscar: ");
            if(contador!=0)
            {
                for(int i=0; i<contador; i++)   //En estos dos metodos abonar y descontar, se realiza un barrido para buscar al usuario y ya que se encontro
                {                               //Al usuario la variable auxiliar se le asigna el valor actual de la cuenta +/- el valor introducido por el usuario 
                    if(usuario[i].getId()==c)
                    {
                        abono = Teclado.Double("Ingrese cantidad a abonar para el usuario "+usuario[i].getNombre()+" "+usuario[i].getApellido()+": ");
                        auxiliarAbono = usuario[i].getSaldo() + abono;
                        usuario[i].setSaldo(auxiliarAbono);
                        b=1;
                    }
                }
                if(b==0)
                System.out.println("Usuario no encontrado");
            }

    }

     public void Descontar(){
        int c,b = 0;
        Double auxiliarDescontar, descontar;
        
        System.out.println("\n");
        c=Teclado.entero("Digite el ID de usuario a buscar: ");
            if(contador!=0)
            {
                for(int i=0; i<contador; i++)
                {
                    if(usuario[i].getId()==c)
                    {
                        descontar = Teclado.Double("Ingrese cantidad a Descontar para el usuario "+usuario[i].getNombre()+" "+usuario[i].getApellido()+": ");
                        auxiliarDescontar = usuario[i].getSaldo() - descontar;
                        usuario[i].setSaldo(auxiliarDescontar);
                        b=1;
                    }
                }
                if(b==0)
                System.out.println("Usuario no encontrado");
            }

    }
 
    public void Buscar(){
 
        String aux = null;
        int c,b = 0;

        System.out.println("\n");
        c=Teclado.entero("Digite el ID de usuario a buscar: ");
            if(contador!=0)
            {
                for(int i=0; i<contador; i++)       
                {
                    if(usuario[i].getId()==c)
                    {
                        aux="";
                        aux+="ID: "+usuario[i].getId()+"\n"
                          + "Nombre: "+usuario[i].getNombre()+"\n"
                          + "Apellido: "+usuario[i].getApellido()+"\n"  //En este metodo al igual que en descontar y abonar se busca al usuario para despues 
                          + "Telefono: "+usuario[i].getTelefono()+"\n"  //asignarle estos valores a una variable auxiliar e imprimirla
                          + "Saldo: "+usuario[i].getSaldo()+"\n";
                        b=1;
                        System.out.println(aux);//Faltaba esta linea para imprimir el usuario buscado
                    }
                }
                if(b==0)
                System.out.println("Usuario "+aux+" no encontrado");
            }
 
        }
 
    public void Eliminar(){
    	
    	//creando un arreglo temporal con un campo menos
        int c;
        usuarioBancaFI alumTemp[] = new usuarioBancaFI[contador-1];
        System.out.println("\n");
 
                        c = Teclado.entero("Digite el ID del estudiante a eliminar: ");		
                        if(c<=contador)															
                        { 		
                            for(int i=0; i<contador; i++) 										
                            { 
                                if(c == usuario[i].getId()) 
                                    continue; 				 
                                
                                else{
                                    if(usuario[i].getId() < c)
                                        alumTemp[i] = usuario[i];
                                    if(usuario[i].getId() > c){
                                        usuario[i].setId(i);
                                        alumTemp[i-1] = usuario[i]; 
                                    }
                                }                                                                   
                            } 
                            usuario=null; id--; contador--; 
                            usuario = new usuarioBancaFI[5]; 
                            for(int i=0; i<alumTemp.length; i++){ 
                                usuario[i]=alumTemp[i];
                            }                            
                        }
                        else
                            System.out.println("El estudiante a eliminar no existe !!!");
    }
 
    
    public static void main(String[] args) {
        System.out.println("\n\n\n= = = = = = = = = = = = = = = = Bienvenido a BancaFI = = = = = = = = = = = = = = = =\n\n+ + Version 1.0\n+ + Team: Jaime Zayas\n          Rodolfo Castillo\n          Rodrigo Cedillo\n\n\n");    
    	PrincipalBancaFI bancaFI = new PrincipalBancaFI(); //creamos bancaFi como objeto en la funcion principal
        System.exit(0);        
    }
}