class ArregloEnteros{
	//Atributos
	private int[]arreglo;
	private int indice;
	
	//Constructores
	public ArregloEnteros(int max){
		arreglo=new int[max];
		indice=-1;
	}
	
	//Metodos
	public void Insertar(int dato){
		indice ++;
		arreglo[indice]=dato;
	}
	public boolean ValidaEspacio(){
		return (indice<arreglo.length-1);
	}
	public void Listar(){
		int i;
			for(i=0;i<=indice;i++)
				System.out.print(arreglo[i]+"\t");
	}
	public void Listar(int pos){
		System.out.println(arreglo[pos]);
	}
	public int Buscar(int dato){
		int i;
			for(i=0;i<=indice;i++){
				if(arreglo[i]==dato)
					return i;
			}
			return -1;	
	}
	public void Actualizar(int dato){
		int pos=Buscar(dato);
		  if(pos>=0){
		  	arreglo[pos]=Teclado.entero("Dame el nuevo numero");
		  }
		  else 
		  	System.out.println("No existe el dato para actualizar:"+ dato);
	}
	public void Borrar(int dato){
		int pos=Buscar(dato);
		if(pos!=-1){
		  	arreglo[pos]=arreglo[indice];
		  	indice --;
		} 
		else 
			System.out.println("No existe el numero");
	}
	public int GetElemento(int pos){
		return arreglo[pos];
	}
	public void SetElemento(int pos,int dato){
		arreglo[pos]=dato;
	}
	public int Getindice(){
		return indice;
	}
	
	
}

