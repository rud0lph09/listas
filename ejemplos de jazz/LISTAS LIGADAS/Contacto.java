class Contacto{
	String nombre;
	ListaSEe tel;
	public Contacto(String dato){
		nombre=dato;
		tel=new ListaSEe();
	}
	public Contacto(){
		tel=new ListaSEe();
		Generar(3);
	}
	public String GetNombre(){
		return nombre;
	}
	public void ListaNombre(){
		System.out.println(nombre);
	}
	public void ListaTel(){
		System.out.println("Telefonos:");
		tel.Listar();
	}
	public void ActualizarTelefono(int dato){
		tel.Actualizar(dato);
	}
	public void SetTel(int dato){
		tel.InsertarAlFinal(dato);
	}
	public void SetNombre(String dato){
		nombre=dato;
	}
	public void Generar(int num_tels){
		Generador magia=new Generador();
		nombre=magia.Generanombres();	
		for(int i=0;i<num_tels;i++)
			tel.InsertarAlFinal(magia.telefono());
	}
	public void BorrarTelefono(int dato)
	{
		Nodoe q;
		int bo;
		boolean existe;
		q=tel.BuscarNodoeAnterior(dato);
		existe=tel.GetExistenum();
		if(existe==true)
		{
			bo=tel.Borrare(q);
			System.out.println("El dato borrado es "+ bo);
		}
		else
		{
			System.out.println("ERROR dato no existe");
		}
	}
}
