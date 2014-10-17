class Alumno {
	//Atributos
	private String nom;
	private int cuenta;
	private ArregloEnteros tels;
	private ArregloFlotantes califs;
	private double prom;
	private Direccion dir;

	//Contructores
	public Alumno(int maxtel,int maxcalif){
		tels=new ArregloEnteros(maxtel);
		califs=new ArregloFlotantes(maxcalif);
		dir=new Direccion();
	}

	//Metodo
	public void Captura(){
		cuenta=Teclado.entero("Dame tu numero de cuenta");
		SetNombre();
		CapturaTels();
		CapturaCalifs();
		CapturaDir();
	}
	private void SetNombre(){
		nom=Teclado.cadena("Nombre:");
	}
	private void CapturaTels(){
		int op=0;
		do{
			if(tels.ValidaEspacio()){
				tels.Insertar(Teclado.entero("Ingresa el telefono:"));
				op=Teclado.entero("Ingresa otro numero:  1)Si  2)No");
			}
			else{
				op=2;
			}
		}
		while(op!=2);
	}
	private void CapturaCalifs(){
		int op=0;
		float cali;
		do{
			if(califs.ValidaEspacio()){
				System.out.println("Ingresa Calificacion");
				cali=Leer.datoFloat();
			op=Teclado.entero("Ingresar otra calificion: 1)Si  2)No");
			}
			else{
				op=2;
			}
		}
		while(op!=2);
	}
	private void CapturaDir(){
		dir.Capturar();
	}
	public void Listar(){
		System.out.print("\nCuenta:"+cuenta+"\tNombre:"+nom+"\t");
		System.out.print("Direccion:");
		dir.Listar();
		System.out.print("\tTelefonos:");
		tels.Listar();
		califs.Listar();
		CalcularPromedio();
		System.out.print("\tPromedio:"+prom);
	}
	/*public void Listartemp(){
		System.out.println(cuenta+"\t"+nom+"\t");
		//dir.Listar();
		//tels.Listar();
		//califs.Listar();
		CalcularPromedio();
		System.out.println("\t"+prom);
	}*/
	public int GetCuenta(){
		return cuenta;
	}
	public void Actualizar(){
		int opcion=Menu(), opc, dato;
		float calinue;
		do{
			switch(opcion){
				case 1 : SetNombre();
						break;
				case 2 : opc=Teclado.entero("1)Insertar\n2)Actualizar");
					if(opc==1)
						CapturaTels();
					else if (opc==2){
						tels.Listar();
						dato=Teclado.entero("Dame el telefono que deseas actualizar");
						tels.Actualizar(dato);
					}
					else 
						System.out.println("Opcion no valida");
					break;
				case 3 : opc=Teclado.entero("1)Insertar\n2)Actualizar");
					if(opc==1)
						CapturaCalifs();
					if (opc==2){
						califs.Listar();
						
						System.out.println("Dame la calficacion que deseas actualizar");
						dato=Leer.datoInt();
						System.out.println("Nueva Calificacion");
						calinue=Leer.datoFloat();
						califs.SetDato(dato,calinue);
						}
						

					break;
				case 4 : dir.Actualizar();
					 break;  
			} 	
		}while(opcion!=5);
	}

	private int Menu(){
		int opc;
		do{
			opc=Teclado.entero("1)Nombre\n2)Telefono\n3)Calificacion\n4)Direccion\n5)Salir");
			if(opc<1||opc>5)
				System.out.println("Opcion no valida");
		}
		while(opc<1||opc>5);
		return opc;
	}
	public void CalcularPromedio(){
		int i, indice;
		indice=califs.GetIndice();
		prom=0.0;
		for(i=0; i<=indice; i++)
			prom=prom+califs.GetValor(i);
		prom=prom/(indice+1);
	} 
	public double GetProm(){
		CalcularPromedio();
		return prom;
	}
	public String GetNom(){
		return nom;
	}
	public void GeneradorAlumnos(){
		String [][]Nombres;
		Nombres=new String[][] {{"Mauricio","Arturo","Daniel","Yaasiel"},{"Perez","Mendoza","NOSE","Enrique"}};
		nom=(Nombres[((int)(Math.random() * 2))][0]+Nombres[((int)(Math.random() * 2))][1]);
		califs.SetIndice(0);
		//llenar el arreglo de calificaciones aleatorias de [5,10]
		do{
			califs.Insertar(((float)(Math.random()*5+5)));
		}while(califs.ValidaEspacio());	
		cuenta=((int) (Math.random() * 1000));
	}
}
