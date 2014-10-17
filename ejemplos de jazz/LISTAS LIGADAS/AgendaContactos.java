class AgendaContactos{
	public static int menuprincipal(){
		int opc;
		do{
			opc=Teclado.entero("\n1)Insetar un contacto\n2)Actualizar\n3)Insertar un numero nuevo a un contacto\n4)Listar\n5)Borrar\n6)Ordenar\n7)Salir\n");
		}while(opc<1||opc>7);
		return opc;
	}
	public static void main(String[]args){
		int opc, opc2, b1,num;
		ListaSEContactos listacontacto=new ListaSEContactos();
		Contacto contacto;
		String nombre;
		NodoContacto q;
		System.out.println("\t\tBIENVENIDO A LA AGENDA DE CONTACTOS");
		do{
			System.out.println("\nElige una opcion: ");
			opc=menuprincipal();
			switch(opc){
				case 1 : 
					contacto=new Contacto();
					//contacto.SetTel(Teclado.entero("Dame un numero telefonico: "));
					listacontacto.InsertarAlFinal(contacto);
					break;
				case 2:
					listacontacto.Actualizar(Teclado.cadena("Dame el contacto a actualizar: "));
					break;
				case 3:
					listacontacto.InsertarTelefono(Teclado.cadena("Dame el nombre del contacto para inserta otro numero: "));
					break;
				case 4:
					listacontacto.Listar();
					break;
				case 5:
		
						do
						{
							b1=Teclado.entero("Elige que deceas borrar: 1)Contacto 2)Numero de contacto:");
							if(b1<1||b1>2)
								{System.out.println("OPCION NO VALIDA VUELVE A INTENTARLO");}
						}while(b1<1||b1>2);
						if(b1==1)
						{
							nombre=Teclado.cadena("Introduce el nombre del contacto que quieras borrar:");
							q=listacontacto.BuscarNodoContactoAnterior(nombre);
							if(listacontacto.GetExisteContacto())
							{
								listacontacto.Borrar(q);					}
							else
							{
								System.out.println("Dato no existente error ");
							}
						}
						else
						{
							nombre=Teclado.cadena("Dame el nombre del contacto al que deseas borrar numero");
							listacontacto.BorrarTel(nombre);
						}

					break;
				case 6:
					listacontacto.Ordenar();
					break;
			}
			//opc2=Teclado.entero("Deseas elegir otra opcion 1)Si 2)No: ");
		}while(opc!=7);
	}
}