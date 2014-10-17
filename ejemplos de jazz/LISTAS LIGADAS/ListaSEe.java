class ListaSEe{
	//Atributos
	private Nodoe H;
	private Nodoe T;
	private boolean existe;
	//Constructor
	public ListaSEe(){
		H=T=null;
	}
	//Metodos
	public void InsertarAlPrincipio(int dato){
		Nodoe q=new Nodoe(dato,H);
		H=q;
		if(T==null)
			T=q;
	}
	public void InsertarAlFinal(int dato){
		Nodoe q= new Nodoe(dato,null);
		if(T==null)
			H=q;
		else
			T.SetSig(q);
		T=q;
	}
	public Nodoe Buscar(int dato){
		Nodoe q=H;
		while(q!=null){
			if(dato==q.GetDato())
				return q;
			q=q.GetSig();
		}
		return null;
	}
	public void InsertarNodoe(int datonvo,Nodoe anterior){
		Nodoe nuevo= new Nodoe(datonvo,anterior.GetSig());
		anterior.SetSig(nuevo);
		if(anterior==T)
			T=nuevo;
	}
	public void InsertarDespues(int dato, int datonvo){
		Nodoe q=Buscar(dato);
		if(q!=null)
			InsertarNodoe(datonvo,q);
		else
			System.out.println("No existe el dato");
	}
	public Nodoe BuscarNodoeAnterior(int dato){
		Nodoe actual, anterior=null;
		existe=false;
		for(actual=H;actual!=null;actual=actual.GetSig()){
			if(existe=dato==actual.GetDato())
				return anterior;
			anterior=actual;
		}
		return null;
	}
	public void InsertarAntes(int dato, int datonvo){
		Nodoe anterior=BuscarNodoeAnterior(dato);
		if(!existe)
			System.out.println("No existe el dato");
		else if(anterior==null)
			InsertarAlPrincipio(datonvo);
		else
			InsertarNodoe(datonvo,anterior);
	}
	public void Actualizar(int dato){
		Nodoe q=Buscar(dato);
		if(q!=null)
			q.SetDato(Teclado.entero("Dame el nuevo numero: "));
		else
			System.out.println("Numero no encontrado");
	}
	public void Listar(){
		Nodoe q=H;
		if(q==null)
			System.out.println("Lista vacia");
		else{
			while(q!=null){
				System.out.println(q.GetDato());
				q=q.GetSig();
			}
		}
	}
	public boolean GetExistenum()
	{
		return existe;
	}
	public int Borrare(Nodoe q)
	{
		int aux=0;
		if(H==T)
		{
			aux=H.GetDato();
			H=T=null;
		}
		else 
		{
			if(q==null)
			{
				aux=H.GetDato();
				H=H.GetSig();
			}
			else
			 {
			 	aux=q.GetSig().GetDato();
			 	q.SetSig(q.GetSig().GetSig());
			 	if(q.GetSig()==null)
			 	{
			 		T=q;
			 	}
			}
		}
		return aux;
	}
}