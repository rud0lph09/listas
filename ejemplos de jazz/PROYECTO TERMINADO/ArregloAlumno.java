class ArregloAlumno{
	//atributos
	private int cont=0;
	private Alumno []arreglo;
	private int indice;
	private double prom;
	//Contructor
	public ArregloAlumno(int max){
		arreglo= new Alumno[max];
		indice=-1;
	}
	//Metodos
	public void Insertar(Alumno dato){
	indice ++;
		arreglo[indice]=dato;	
	}
	public boolean ValidaEspacio(){
		return (indice<arreglo.length-1);
	}
	public void Listar(){
		int i;
		  for(i=0; i<=indice; i++)
		  arreglo[i].Listar();
	}
	public int Buscar(int dato){
		int i;
		for(i=0;i<=indice;i++){
			if(arreglo[i].GetCuenta()==dato)
				return i;
		}
		return -1;
	}
 	public void Listar(int pos){
 		arreglo[pos].Listar();
  	}
  	public void Borrar(int dato){//dato es el numero de cuenta
  		int pos=Buscar(dato);
  		 if(pos!=-1){
  		   	arreglo[pos]=arreglo[indice];
  		   	indice --;
  		}
  		 else
  		 	System.out.println("Numero de cuenta no encontrado");
  	}
  	public void Actualizar(int dato){//recibe el numero de cuenta a actualizar
  		int pos=Buscar(dato);
  		 if(pos!=-1)
  		 	arreglo[pos].Actualizar();
  		 else
  		 	System.out.println("Numero de cuenta no encontrado");
  	}
  	public void PromGrup(){
  			int i;
  			prom=0.0;
  				for(i=0; i<=indice; i++)
  					prom=prom+arreglo[i].GetProm();
  			prom=prom/(indice+1);
  	}
  	public double GetProm(){
  		PromGrup();
  		return prom;
  	}
  	public Alumno GetElemento(int pos){
  		return arreglo[pos];
  	}
	public int Getindice(){
		return indice;
	}
	public void SetElemento(int pos,Alumno alm){
		arreglo[pos]=alm;
	}
	
	public void ContarReprobados(){
		int i;
cont=0;
			for(i=0; i<=indice; i++)
				if(arreglo[i].GetProm()<6)
					
					cont++;
				}
	public int Getcont(){
  		ContarReprobados();
  		return cont;
  	}
	public void ListarReprobados(){
		int i;
			for(i=0; i<=indice; i++)
				if(arreglo[i].GetProm()<6)
					System.out.println(arreglo[i].GetNom());
	}
	public void GeneradorGrupos(){
		do{
			Alumno prueba=new Alumno(5,5);
			prueba.GeneradorAlumnos();
			Insertar(prueba);
		}while(ValidaEspacio());
	}
	public static void main(String[] args) {
		ArregloAlumno grupo=new ArregloAlumno(5);
		grupo.GeneradorGrupos();
		grupo.Listar();
	}
}
