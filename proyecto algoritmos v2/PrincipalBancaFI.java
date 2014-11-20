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
 
        int idTipo, idGenero, edad;
        String telefono, nombre, apellido, seguir;
        Double saldo;        

        System.out.println("\n");
        idGenero = Teclado.entero("El Nuevo usuario es: \n1)Hombre  \n2)Mujer?\n\nEleccion:");
        if (idGenero >2) {
            System.out.println("Opcion incorrecta...\nTendremos que reiniciar el registro del usuario...\n");
            seguir = Teclado.cadena("\nPresiona enter para continuar.");
            darDeAlta();
        }else{
            System.out.println("");
            idTipo = Teclado.entero("Seleccione modo de registro:\n1)Inversionistas\n2)Usuarios\n\nEleccion:");
        if (idTipo >2) {
            System.out.println("Opcion incorrecta...\nTendremos que reiniciar el registro del usuario...\n");
            seguir = Teclado.cadena("\nPresiona enter para continuar.");
            darDeAlta();
        }else{
            System.out.println("");
            nombre = Teclado.cadena("Ingrese el Nombre del usuario: ");
            apellido = Teclado.cadena("Ingrese el Apellido del usuario: ");
            edad = Teclado.entero("Digite la edad del usuario:  ");
            if(edad >=13){
                telefono =Teclado.cadena("Ingrese el Telefono del Usuario: ");
                saldo = Teclado.Double("Ingrese el Saldo inicial del Usuario: ");
 
                if(idTipo==1){
                    if(edad < 18){
                        System.out.println("\nError: TODOS los inversionistas deben ser mayores de edad\nLe asignaremos al usuario una cuenta normal...");
                        idTipo = 2;
                        seguir = Teclado.cadena("\nPresiona enter para continuar.");
                    }
                }
                usuarioBancaFI temp = new usuarioBancaFI();
            
                temp.setIdGenero(idGenero);
                temp.setIdTipo(idTipo);
                temp.setId(id);
                temp.setNombre(nombre); 
                temp.setApellido(apellido);
                temp.setEdad(edad);
                temp.setTelefono(telefono);
                temp.setSaldo(saldo);
                usuario[contador] = temp;
                contador++;  
                id++;    
                }else{
                    System.out.println("La edad ingresada no es valida.\nTe recordamos que los nuevos Clientes deben ser mayor a 13 años \nReiniciaremos el proceso de Registro de usuario...");
                    seguir = Teclado.cadena("\nPresiona enter para continuar.");
                    darDeAlta();
                }
             
            }
        }        
    }
 
    public void Mostrar(){
 
        String ay="";
        
        System.out.println("\n");
        for(int i=0; i<contador; i++){
            ay+="ID: "+usuario[i].getId()+" :"+usuario[i].getIdTipo()+"-"+usuario[i].getIdGenero()+"\n" + "Nombre: "+usuario[i].getNombre()+"\n" + "Apellido: "+usuario[i].getApellido()+"\n" +"Edad: "+usuario[i].getEdad()+ "\nTelefono: "+usuario[i].getTelefono()+"\n" + "Saldo: "+usuario[i].getSaldo()+"\n\n";        
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
                        aux+="ID: "+usuario[i].getId()+" :"+usuario[i].getIdTipo()+"-"+usuario[i].getIdGenero()+"\n"+ "Nombre: "+usuario[i].getNombre()+"\n"+ "Apellido: "+usuario[i].getApellido()+"\n"  +"Edad: "+usuario[i].getEdad()+ "\nTelefono: "+usuario[i].getTelefono()+"\n"+ "Saldo: "+usuario[i].getSaldo()+"\n";
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
        int usu = 0, inversion = 0, hom = 0, fem = 0, deudas = 0, groupEdad1=0, groupEdad2=0;
        int i = 0;
        String mensaje = "";
        for (i=0;i<contador ;i++) {
            if(usuario[i].getIdTipo() != 1){
                usu += 1;
            }else{
                inversion += 1;
            }
            if(usuario[i].getIdGenero() != 1){
                fem += 1;
            }else{
                hom += 1;
            }
            if(usuario[i].getSaldo() < 0){
                deudas += 1;
            }
            if(usuario[i].getEdad() < 18){
                groupEdad1 += 1;
            }else{
                groupEdad2 += 1;
            }
        }
        
        mensaje +="Total de Clientes Registrados: "+contador+"\nTotal de Usuarios Normales:"+usu+"\nTotal de Inversionistas: "+inversion+"\nDel Total de Clientes hay "+deudas+" que son morosos \ny  "+hom+" son hombres\ny "+fem+" son mujeres";
        System.out.println(mensaje);
        System.out.println("\nDel total de usuarios "+groupEdad1+" son menores de edad\ny "+groupEdad2+" son mayores de edad.");
    }
    else{
        System.out.println("Error: No se han registrado clientes");
    }
    }
 
    public void Eliminar(){
    	
    	//creando un arreglo temporal con un campo menos
        if(contador >=1){
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
        }else
        System.out.println("Error: No hay clientes registrados");    
    }

    public static void main(String[] args) {
        System.out.println("\n\n\n= = = = = = = = = = = = = = = = Bienvenido a BancaFI = = = = = = = = = = = = = = = =\n\n+ + Version 2.2\n+ + Team: Jaime Zayas\n          Rodolfo Castillo\n          Rodrigo Cedillo\n\n\n\n\n\nTe recordamos que la ID del usuario esta en el siguiente formato:\n     id :tipo de usuario-genero");    
        PrincipalBancaFI bancaFI = new PrincipalBancaFI();
        System.out.println("\nGracias por su preferencia\n");
        System.exit(0);        
    }
}