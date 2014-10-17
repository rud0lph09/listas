class NodoContacto{
	//Atributos
	private Contacto dato;
	private NodoContacto sig;
//Constructor
	public NodoContacto(Contacto dato, NodoContacto sig){
		this.dato=dato;
		this.sig=sig;
	}
//Metodos
	public NodoContacto GetSig(){
		return sig;
	}
	public Contacto GetDato(){
		return dato;
	}
	public void SetDato(Contacto info){
		dato=info;
	}
	public void SetSig(NodoContacto sig){
		this.sig=sig;
	}
}