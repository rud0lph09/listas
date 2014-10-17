class Nodo{
	//Atributos
	private String dato;
	private Nodo sig;
//Constructor
	public Nodo(String dato, Nodo sig){
		this.dato=dato;
		this.sig=sig;
	}
//Metodos
	public Nodo GetSig(){
		return sig;
	}
	public String GetDato(){
		return dato;
	}
	public void SetDato(String info){
		dato=info;
	}
	public void SetSig(Nodo sig){
		this.sig=sig;
	}
}