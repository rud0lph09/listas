class Nodoe{
	//Atributos
	private int dato;
	private Nodoe sig;
//Constructor
	public Nodoe(int dato, Nodoe sig){
		this.dato=dato;
		this.sig=sig;
	}
//Metodos
	public Nodoe GetSig(){
		return sig;
	}
	public int GetDato(){
		return dato;
	}
	public void SetDato(int info){
		dato=info;
	}
	public void SetSig(Nodoe sig){
		this.sig=sig;
	}
}