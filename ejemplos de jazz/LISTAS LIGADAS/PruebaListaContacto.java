class PruebaListaContacto{
	public static void main(String[]args){
	ListaSEContactos contacto= new ListaSEContactos();
	Contacto prueba=new Contacto("mauri");
	prueba.SetTel(26164755);
	prueba.SetTel(12953541);
	prueba.SetTel(65261231);
	contacto.InsertarAlFinal(prueba);
	Contacto prueba2=new Contacto("joni");
	prueba2.SetTel(26164755);
	prueba2.SetTel(05121654);
	prueba2.SetTel(65465256);
	contacto.InsertarAlFinal(prueba2);
	/*String nombre=Teclado.cadena("Dame el Contacto a actualizar");
	if(contacto.Buscar(nombre)!=null){
		System.out.println("Contacto encontrado");
		//contacto.Actualizar();
	}
	else
		System.out.println("Contacto no encontrado");*/
	//contacto.InsertarTelefono(Teclado.cadena("Dame el nombre del contacto al que le quieres insertar un numero: "));
	contacto.Actualizar(Teclado.cadena("Dame el nombre a actualizar"));
	contacto.Listar();
	}
}