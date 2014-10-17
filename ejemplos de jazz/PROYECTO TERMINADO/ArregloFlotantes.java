class ArregloFlotantes{
	//Atributos
	private float []arreglo;
	private int indice;
	
	//Constructores
	public ArregloFlotantes(int max){
		arreglo=new float[max];
		indice=-1;
	}
	
	//Metodos
	public void Insertar(float dato){
		indice++;
		arreglo[indice]=dato;
	}
	public boolean ValidaEspacio(){
		return (indice<arreglo.length-1);
	}
	public void Listar(){
		int i;
		System.out.print("\tCalificaciones:");
			for(i=0;i<=indice;i++)
				System.out.print("\t"+i+")"+arreglo[i]);
	}
	public void Listar(int pos){
		System.out.println(arreglo[pos]);
	}
	public int Buscar(float dato){
		int i;
			for(i=0;i<=indice;i++){
				if(arreglo[i]==dato)
					return i;
			}
			return -1;	
	}
	public void Actualizar(float dato){
		int pos=Buscar(dato);
		  if(pos>=0){
		  	arreglo[pos]=Teclado.entero("Dame el nuevo numero");
		  }
		  else 
		  	System.out.println("No existe el dato para actualizar:"+ dato);
	}
	public void Borrar(float dato){
		int pos=Buscar(dato);
		if(pos!=-1){
		  	arreglo[pos]=arreglo[indice];
		  	indice --;
		} 
		else 
			System.out.println("No existe el numero");
	}
	public void SetDato(int pos, float dato){
		arreglo[pos]=dato;
	}
	public int GetIndice(){
		return indice;
	}
	public void SetIndice(int ind){
		indice=ind;
	}
	public float GetValor(int pos){
		return arreglo[pos];
	}
}
