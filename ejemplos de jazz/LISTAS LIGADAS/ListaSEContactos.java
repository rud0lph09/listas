class ListaSEContactos{
	private NodoContacto H;
	private NodoContacto T;
	private boolean existe;
	//Constructor
	public ListaSEContactos(){
		H=T=null;
	}
	//Metodos
	public void InsertarAlPrincipio(Contacto dato){
		NodoContacto q=new NodoContacto(dato,H);
		H=q;
		if(T==null)
			T=q;
	}
	public void InsertarAlFinal(Contacto dato){
		NodoContacto q= new NodoContacto(dato,null);
		if(T==null)
			H=q;
		else
			T.SetSig(q);
		T=q;
	}
	public void InsertarTelefono(String dato){
		NodoContacto q=Buscar(dato);
		if(q!=null)
			q.GetDato().SetTel(Teclado.entero("Dame el numero a insertar: "));
		else
			System.out.println("Contacto no encontrado");
	}
	public NodoContacto Buscar(String dato){
		NodoContacto q=H;
		while(q!=null){
			if(dato.equals(q.GetDato().GetNombre()))
				return q;
			q=q.GetSig();
		}
		return null;
	}
	public void InsertarNodoContacto(Contacto datonvo,NodoContacto anterior){
		NodoContacto nuevo= new NodoContacto(datonvo,anterior.GetSig());
		anterior.SetSig(nuevo);
		if(anterior==T)
			T=nuevo;
	}
	public int Contador(){
		int cont=0;
		NodoContacto q=H;
		if(q==null)
			return 0;
		else{
			for(q=H; q.GetSig()!=null; q=q.GetSig())
				cont=cont+1;
			return cont;
		}
	}
	public void Ordenar(){
      NodoContacto q=H;
      Contacto aux=null;
      int i, cont=Contador();
      if(q!=null){
      	for(i=0;i<=cont;i++){ 
      		for(q=H; q.GetSig()!=null; q=q.GetSig())  	
      			if(q.GetDato().GetNombre().compareTo(q.GetSig().GetDato().GetNombre())>0){
      	   	 		aux=q.GetDato();	
      	    		q.SetDato(q.GetSig().GetDato());
      	    		q.GetSig().SetDato(aux);
      	    } 
      	}
      	System.out.println("Lista ordenada correctamente");
  	}
      else
      	System.out.println("La lista esta vacia");
   }
	public void InsertarDespues(Contacto dato, Contacto datonvo){
		NodoContacto q=Buscar(dato.GetNombre());
		if(q!=null)
			InsertarNodoContacto(datonvo,q);
		else
			System.out.println("No existe el dato");
	}
	public NodoContacto BuscarNodoContactoAnterior(String dato){
		NodoContacto actual, anterior=null;
		existe=false;
		for(actual=H;actual!=null;actual=actual.GetSig()){
			if(existe=dato.equals(actual.GetDato().GetNombre()))
				return anterior;
			anterior=actual;
		}
		return null;
	}
	public void InsertarAntes(Contacto dato, Contacto datonvo){
		NodoContacto anterior=BuscarNodoContactoAnterior(dato.GetNombre());
		if(!existe)
			System.out.println("No existe el dato");
		else if(anterior==null)
			InsertarAlPrincipio(datonvo);
		else
			InsertarNodoContacto(datonvo,anterior);
	}
	public void Actualizar(String dato){
		NodoContacto q=Buscar(dato);
		int opc, salir;
		if(q!=null){
		do{
			opc=Teclado.entero("Que deseas actualizar 1)Nombre 2)Telefono: ");
			switch(opc){
			case 1:
				q.GetDato().SetNombre(Teclado.cadena("Dame el nuevo nombre: "));
				break;
			case 2:
				q.GetDato().ActualizarTelefono(Teclado.entero("Dame el numero a actualizar: "));	
				break;
			}
			salir=Teclado.entero("Deseas hacer otra actualizacion  1)Si 2)No: ");
		}while(salir!=2);
		}
		else
			System.out.println("El nobre no existe");
	}
	public void Listar(){
		NodoContacto q=H;
		if(q==null)
			System.out.println("Lista vacia");
		else{
			while(q!=null){
				System.out.println("\n"+q.GetDato().GetNombre());
				q.GetDato().ListaTel();
				q=q.GetSig();
			}
		}
	}
	public void  Borrar(NodoContacto q)
	{
		if(H==T)
		{
			
			H=T=null;
		}
		else 
		{
			if(q==null)
			{
					H=H.GetSig();
			}
			else
			 {
			 	q.SetSig(q.GetSig().GetSig());
			 	if(q.GetSig()==null)
			 	{
			 		T=q;
			 	}
			}
		}
		System.out.println("Dato borrado");
	}

public boolean GetExisteContacto()
	{
		return existe;
	}
	public void BorrarTel(String dato)
	{
		NodoContacto q;
		q=Buscar(dato);
		if(q!=null)
		{
			q.GetDato().BorrarTelefono(Teclado.entero("Dame el numero a borrar: "));
		}
		else
		{
			System.out.println("ERROR dato no existe");
		}
	}
}