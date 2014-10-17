class Direccion{
	//Atributos
	private String numero;
	private String calle;
	private String colonia;
	
	public Direccion(){
		numero="3.1416";
		calle="de la amargura";
		colonia="doctores";
	}

	//Metodos
	public void Capturar(){
		SetCalle();
		SetNumero();
		SetColonia();
	} 
	private void SetCalle(){
		calle=Teclado.cadena("Calle:");
	}
	private void SetNumero(){
		numero=Teclado.cadena("Numero:");
	}
	private void SetColonia(){
		colonia=Teclado.cadena("Colonia:");
	}
	public void Listar(){
		System.out.print("calle "+calle+"\tnumero "+numero+"\tcolonia "+colonia);
	}
	public void Actualizar(){
		int opcion=Menu();
		switch (opcion){
			case 1 : 
				SetCalle();
					break;
			case 2 : 
				SetNumero();
				break;
			case 3 : 
				SetColonia();
				break;
		}
		while(opcion!=4);
	}
	private int Menu(){
		int opc;
		do{
			opc=Teclado.entero("1)Calle\n2)Numero\n3)Colonia\n4)Salir");
				if(opc<1||opc>4)
					System.out.println("Opcion no valida");
		}
		while(opc<1||opc>4);
		return opc;
	}
	public String Getnumero(){
	return numero;
	}
	public void Setnumero(String nuevo){
		numero=nuevo;
	}
	public String Getcalle(){
		return calle;
	}
	public void Setcalle(String nuevo){
		calle=nuevo;
	}
	public String Getcolonia(){
		return colonia;
	}
	public void Setcolonia(String nuevo){
		colonia=nuevo;
	}
}
