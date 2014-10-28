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
	
	
	
    int contador=0, id=1; 									         //con esta pariable se lleva el control de los inscritos
    usuarioBancaFI usuario [] = new usuarioBancaFI[100]; 			//inicializamos el arreglo de objetos usuario
    
    //constructor de la clase PrincipalBanco
    public PrincipalBancaFI()
    { 								
    int opcion;
    do {
		opcion = controlDeMenu("\n1)Dar de Alta\n 2)Buscar\n 3)Abonar\n 4)Cargar\n 5)Mostrar\n 6)Eliminar\n 7)Estadisticas\n 8)SALIDA\n\nEleccion: ",8);
		
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
            Cargar();
            break;
        case 5:
            Mostrar();
            break;
        case 6:
            Eliminar();
            break;
        case 7:
            doStats();
            break;
        case 8:
            break;        
        default:
				break;
				
				
						}//Esta llave cierra el switch
			}//Esta llave cierra el do del Do-While
	
	while(opcion !=8); //Mientras la opcion sea
    }
    
 
    public void darDeAlta(){        
 
        int telefono, idTipo, idGenero;
        String nombre, apellido;
        Double saldo;        

        System.out.println("\n");
        idGenero = Teclado.entero("El Nuevo usuario es: \n1)Hombre  \n2)Mujer?\n\nEleccion:");
        idTipo = Teclado.entero("Seleccione modo de registro:\n1)Inversionistas\n2)Usuarios\n\nEleccion:");
        nombre = Teclado.cadena("Ingrese el Nombre del usuario: ");
        apellido = Teclado.cadena("Ingrese el Apellido del usuario: ");
        telefono =Teclado.entero("Ingrese el Telefono del Usuario: ");
        saldo = Teclado.Double("Ingrese el Saldo inicial del Usuario: ");
 
        usuarioBancaFI temp = new usuarioBancaFI();
 
        temp.setId(id);
        temp.setIdTipo(idTipo);
        temp.setIdGenero(idGenero); 
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
            ay+="ID: "+usuario[i].getId()+" :"+usuario[i].getIdTipo()+"-"+usuario[i].getIdGenero()+"\n" + "Nombre: "+usuario[i].getNombre()+"\n" + "Apellido: "+usuario[i].getApellido()+"\n" + "Telefono: "+usuario[i].getTelefono()+"\n" + "Saldo: "+usuario[i].getSaldo()+"\n\n";        
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
                for(int i=0; i<contador; i++)   //En estos dos metodos abonar y Cargar, se realiza un barrido para buscar al usuario y ya que se encontro
                {                               //Al usuario la variable auxiliar se le asigna el valor actual de la cuenta +/- el valor introducido por el usuario 
                    if(usuario[i].getId()==c)
                    {
                        abono = Teclado.Double("Ingrese cantidad a abonar para el usuario "+usuario[i].getNombre()+" "+usuario[i].getApellido()+": ");
                        if (abono>0) {
                          auxiliarAbono = usuario[i].getSaldo() + abono;
                        usuario[i].setSaldo(auxiliarAbono);
                        b=1;  
                        }
                        else{
                            System.out.println("La cantidad abonada no es valida, porfavor intente de nuevo...");
                            Abonar();
                        }
                    }
                }
                if(b==0)
                System.out.println("Usuario no encontrado");
            }

    }

     public void Cargar(){
        int c,b = 0;
        Double auxiliarCargar, cargar;
        
        System.out.println("\n");
        c=Teclado.entero("Digite el ID de usuario a buscar: ");
            if(contador!=0)
            {
                for(int i=0; i<contador; i++)
                {
                    if(usuario[i].getId()==c)
                    {
                        cargar = Teclado.Double("Ingrese cantidad a cargar para el usuario "+usuario[i].getNombre()+" "+usuario[i].getApellido()+": ");
                        if ((cargar>0)&&(usuario[i].getSaldo()>cargar)) {
                        auxiliarCargar = usuario[i].getSaldo() - cargar;
                        usuario[i].setSaldo(auxiliarCargar);
                        b=1;    
                        }
                        else
                        {
                            System.out.println("La cantidad introducida no es valida, porfavor intente de nuevo...");
                            Cargar();
                        }
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
                        aux+="ID: "+usuario[i].getId()+" :"+usuario[i].getIdTipo()+"-"+usuario[i].getIdGenero()+"\n"+ "Nombre: "+usuario[i].getNombre()+"\n"+ "Apellido: "+usuario[i].getApellido()+"\n"  + "Telefono: "+usuario[i].getTelefono()+"\n"+ "Saldo: "+usuario[i].getSaldo()+"\n";
                        b=1;
                        System.out.println(aux);//Faltaba esta linea para imprimir el usuario buscado
                    }
                }
                if(b==0)
                System.out.println("Usuario "+aux+" no encontrado");
            }
 
        }
    public void doStats(){
        if (contador != 0) {
        int usu = 0, inversion = 0, hom = 0, fem = 0, deudas = 0;
        int i = 0, porchom = 0, porcfem = 0;
        String mensaje = "";
        for (i=0;i<contador ;i++) {
            if(usuario[i].getIdTipo() != 1){
                inversion += 1;
            }else{
                usu += 1;
            }
            if(usuario[i].getIdGenero() != 1){
                fem += 1;
            }else{
                hom += 1;
            }
            if(usuario[i].getSaldo() < 0){
                deudas += 1;
            }
        }
        porchom =hom/contador;
        porchom = porchom*100;
        porcfem =fem/contador;
        porcfem = porcfem*100;
        mensaje +="Total de Clientes Registrados: "+contador+"\nTotal de Usuarios Normales:"+usu+"\nTotal de Inversionistas"+inversion+"\nDel Total de Clientes hay "+deudas+" deudores \ny el "+porchom+" porciento son hombres\ny el "+porcfem+" porciento son mujeres";
        System.out.println(mensaje);
    }
    else{
        System.out.println("Error: No se han registrado clientes");
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
        System.out.println("\n\n\n= = = = = = = = = = = = = = = = Bienvenido a BancaFI = = = = = = = = = = = = = = = =\n\n+ + Version 2.0\n+ + Team: Jaime Zayas\n          Rodolfo Castillo\n          Rodrigo Cedillo\n\n\n\n\n\nTe recordamos que la ID del usuario esta en el siguiente formato:\n     id :tipo de usuario-genero");    
        PrincipalBancaFI bancaFI = new PrincipalBancaFI();
        System.out.println("\nGracias por su preferencia\n");
        System.exit(0);        
    }
}