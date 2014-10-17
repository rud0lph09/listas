class AgendaNombres{
	public static int SubMenu(){
		int opc;
		do{
			opc=Teclado.entero("\n1)Insertar al principio\n2)Inertar al final\n3)Insertar despues de un dato\n4)Insertar antes de un dato\n5)Listar nombres\n");
		} while (opc<1||opc>7);
		return opc;
	}
	public static void main(String []args){
		ListaSE nombres= new ListaSE();
		int opc, opc2;
		System.out.println("\tBienvenido a la Agenda");
		do{
			System.out.println("\nElige la opcion que deseas realizar");
			opc=SubMenu();
			switch(opc){
				case 1 : 
					nombres.InsertarAlPrincipio(Teclado.cadena("\nDame el nombre a insertar: "));
					break;
				case 2 :
					nombres.InsertarAlFinal(Teclado.cadena("\nDame el nombre a insertar: "));
					break;
				case 3 :
					nombres.InsertarDespues(Teclado.cadena("\nDame el nombre a buscar: "),Teclado.cadena("\nDame nuevo nombre: "));
					break;
				case 4 :
					nombres.InsertarAntes(Teclado.cadena("\nDame el nombre al que quieres que se inserte antes: "),Teclado.cadena("\nDame el nuevo nombre: "));
					break;
				case 5 :
					nombres.Listar();
			}
			opc2=Teclado.entero("\nDeseas elegir otra opcion 1)Si 2)No :  ");		
		}while(opc2==1);
	}
}