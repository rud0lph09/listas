class ListaSE{
	//Atributos
	private Nodo H;
	private Nodo T;
	private boolean existe;
	//Constructor
	public ListaSE(){
		H=T=null;
	}
	//Metodos
	public void InsertarAlPrincipio(String dato){
		Nodo q=new Nodo(dato,H);
		H=q;
		if(T==null)
			T=q;
	}
	public void InsertarAlFinal(String dato){
		Nodo q= new Nodo(dato,null);
		if(T==null)
			H=q;
		else
			T.SetSig(q);
		T=q;
	}
	public Nodo Buscar(String dato){
		Nodo q=H;
		while(q!=null){
			if(dato.equals(q.GetDato()))
				return q;
			q=q.GetSig();
		}
		return null;
	}
	public void InsertarNodo(String datonvo,Nodo anterior){
		Nodo nuevo= new Nodo(datonvo,anterior.GetSig());
		anterior.SetSig(nuevo);
		if(anterior==T)
			T=nuevo;
	}
	public void InsertarDespues(String dato, String datonvo){
		Nodo q=Buscar(dato);
		if(q!=null)
			InsertarNodo(datonvo,q);
		else
			System.out.println("No existe el dato");
	}
	public Nodo BuscarNodoAnterior(String dato){
		Nodo actual, anterior=null;
		existe=false;
		for(actual=H;actual!=null;actual=actual.GetSig()){
			if(existe=dato.equals(actual.GetDato()))
				return anterior;
			anterior=actual;
		}
		return null;
	}
	public void InsertarAntes(String dato, String datonvo){
		Nodo anterior=BuscarNodoAnterior(dato);
		if(!existe)
			System.out.println("No existe el dato");
		else if(anterior==null)
			InsertarAlPrincipio(datonvo);
		else
			InsertarNodo(datonvo,anterior);
	}
	public void Listar(){
		Nodo q=H;
		if(q==null)
			System.out.println("Lista vacia");
		else{
			while(q!=null){
				System.out.println(q.GetDato());
				q=q.GetSig();
			}
		}
	}
}