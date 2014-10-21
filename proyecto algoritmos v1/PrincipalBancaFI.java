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
	
	
	
    int contador=0, cod=1; 									//con esta pariable se lleva el control de los inscritos
    usuarioBancaFI usuario [] = new usuarioBancaFI[5]; 			//inicializamos el arreglo de objetos usuario
    
    //constructor de la clase PrincipalBanco
    public PrincipalBancaFI()
    { 								
    int opcion;
 
	do {
		opcion = controlDeMenu(" 1)Dar de Alta\n 2)Mostrar\n 3)Buscar\n 4)Eliminar\n 5)Abonar\n 6)Descontar\n 7)SALIDA  ",7);
		
		//Una vez que la opcion sea valida pasara a este switch
		switch (opcion){
        case 1:
            darDeAlta();
            break;
        case 2:
            Mostrar();
            break;
        case 3:
            Buscar();
            break;
        case 4:
            Eliminar();
            break;
        case 5:
            Abonar();
            break;
        case 6:
            Descontar();
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
 
        nombre = Teclado.cadena("Ingrese el Nombre del usuario: ");
        apellido = Teclado.cadena("Ingrese el Apellido del usuario: ");
        telefono =Teclado.entero("Ingrese el Telefono del Usuario: ");
        saldo = Teclado.Double("Ingrese el Saldo inicial del Usuario: ");
 
        usuarioBancaFI temp = new usuarioBancaFI();
 
        temp.setCod(cod); 
        temp.setNombre(nombre); 
        temp.setApellido(apellido);
        temp.setTelefono(telefono);
        temp.setSaldo(saldo);        
 
        usuario[contador] = temp;
        contador++;  
        cod++;      
    }
 
    public void Mostrar(){
 
        String ay="";
 
        for(int i=0; i<contador; i++){
            ay+="Codigo: "+usuario[i].getCod()+"\n" + "Nombre: "+usuario[i].getNombre()+"\n" + "Apellido: "+usuario[i].getApellido()+"\n" + "Telefono: "+usuario[i].getTelefono()+"\n" + "Saldo: "+usuario[i].getSaldo()+"\n\n";        
        }
        System.out.println(ay);
    }

    public void Abonar(){
        int c,b = 0;
        Double auxiliarAbono, abono;
 
        c=Teclado.entero("Digite el Codigo de usuario a buscar: ");
            if(contador!=0)
            {
                for(int i=0; i<contador; i++)
                {
                    if(usuario[i].getCod()==c)
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
 
        c=Teclado.entero("Digite el Codigo de usuario a buscar: ");
            if(contador!=0)
            {
                for(int i=0; i<contador; i++)
                {
                    if(usuario[i].getCod()==c)
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
 
        String ax = null;
        int c,b = 0;
 
        c=Teclado.entero("Digite el Codigo de usuario a buscar: ");
            if(contador!=0)
            {
                for(int i=0; i<contador; i++)
                {
                    if(usuario[i].getCod()==c)
                    {
                        ax="";
                        ax+="Codigo: "+usuario[i].getCod()+"\n"
                          + "Nombre: "+usuario[i].getNombre()+"\n"
                          + "Apellido: "+usuario[i].getApellido()+"\n"
                          + "Telefono: "+usuario[i].getTelefono()+"\n"
                          + "Saldo: "+usuario[i].getSaldo()+"\n";
                        b=1;
                        System.out.println(ax);//Faltaba esta linea para imprimir el usuario buscado
                    }
                }
                if(b==0)
                System.out.println("Usuario "+ax+" no encontrado");
            }
 
        }
 
    public void Eliminar(){
    	
    	//creando un arreglo temporal con un campo menos
        int c;
        usuarioBancaFI alumTemp[] = new usuarioBancaFI[contador-1];
 
                        c = Teclado.entero("Digite el codigo del estudiante a eliminar: ");		//pidiendo el codigo a eliminar
                        if(c<=contador)															//si el codigo a eliminar es menor o igual al contador de estudiantes
                        { 		
                            for(int i=0; i<contador; i++) 										//Inicio ciclo para realizar la eliminacion
                            { 
                                if(c == usuario[i].getCod()) //si el codigo a eliminar coincide con el codigo que hay en la posicion i
                                    continue; 				 //entonces continua con el ciclo
                                
                                else{
                                    if(usuario[i].getCod() < c)
                                        alumTemp[i] = usuario[i];//si esl codigo es menor se almacena tal cual                     
                                    if(usuario[i].getCod() > c){
                                        usuario[i].setCod(i);//si el codigo es mayor se le resta para que quede en consecutivo
                                        alumTemp[i-1] = usuario[i]; //se almacena con el nuevo codigo
                                    }
                                }                                                                   
                            } //Fin ciclo para realizar la eliminacion
                            usuario=null; cod--; contador--; //se hacen las modificaciones para los nuevos valores                   
                            usuario = new usuarioBancaFI[5]; //se vuelve a crear el arreglo 
                            for(int i=0; i<alumTemp.length; i++){ //se almacenan los valores no eliminados
                                usuario[i]=alumTemp[i];
                            }                            
                        }
                        else
                            System.out.println("El estudiante a eliminar no existe !!!");
    }
 
    
    public static void main(String[] args) {
        System.out.println("\n\n\n= = = = = = = = = = = = = = = = Bienvenido a BancaFI = = = = = = = = = = = = = = = =\n\n+ + Version 1.0\n+ + Team: Jaime Zayas\n          Rodolfo Castillo\n          Rodrigo Cedillo\n\n\n");    
    	PrincipalBancaFI w = new PrincipalBancaFI(); //creacion del objeto w, llamado al constructor de la clase PrincipalBanco
        System.exit(0);        
    }
}