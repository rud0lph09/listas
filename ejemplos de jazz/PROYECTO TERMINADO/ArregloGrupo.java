class ArregloGrupo{
	//atributos
	private int cont=0;
	private ArregloAlumno []arreglo;
	private int indice;
	private double prom;
  private double promediomayor;
	//contructor
	public ArregloGrupo(int max){
		arreglo= new ArregloAlumno[max];
		indice=-1;
	}
	//metodos
	public void Insertar(ArregloAlumno dato){
	indice ++;
		arreglo[indice]=dato;
	}
	public boolean ValidaEspacio(){
		return (indice<arreglo.length-1);
	}
	public void Listar(){
		int i;
		for(i=0;i<=indice;i++){
			System.out.println("\n\nGrupo"+i+":");
			arreglo[i].Listar();
		}
	}
	public int Buscar(int dato){
		int i;
			for(i=0;i<=indice;i++){
				if(i==dato)
					return i;
			}
			return -1;	
	}
	public void Borrar(int dato){
  		int pos=Buscar(dato);
  		 if(pos!=-1){
  		   	arreglo[pos]=arreglo[indice];
  		   	indice --;
  		}
  		 else
  		 	System.out.println("Grupo no encontrado");
  	}
  	public void Listar(int pos){
 		arreglo[pos].Listar();
  	}
  	private void PromedioGeneral(){
  		int i;
  		prom=0.0;
  				for(i=0; i<=indice; i++)
  					prom=prom+arreglo[i].GetProm();
  			prom=prom/(indice+1);
  	}
  	public double GetProm(){
      PromedioGeneral();
  		return prom;
  	}
  	public void PromedioMax(){
  		double max=arreglo[0].GetProm();
  		int i;
  		int mayor=0;
  			for(i=1; i<=indice; i++){
  				if(max<arreglo[i].GetProm()){
  				  	max=arreglo[i].GetProm();
  				  	mayor=i;
  				  }
  			}
  		System.out.println("El grupo con mayor promedio es el grupo"+mayor+"\ncon un promedio de"+arreglo[mayor].GetProm());	
  	}
  	public void PromedioMin(){
  		double min=arreglo[0].GetProm();
  		int i;
  		int menor=0;
  			for(i=1; i<=indice; i++){
  				if(min>arreglo[i].GetProm()){
  				  	min=arreglo[i].GetProm();
  				  	menor=i;
  				  }
  			}
  		System.out.println("El grupo con menor promedio es el grupo"+menor+"\ncon un promedio de"+arreglo[menor].GetProm());
  	}
  	public void PromedioA(){
  		int i;
  		System.out.println("Los grupos que superan al promedio general son:");
  			for(i=0; i<=indice; i++)
  				if(GetProm()>arreglo[i].GetProm())
  					System.out.println(i);
  	}
    public void ContarReprobados(){
    int i,n;
    for(i=0;i<=indice;i++){
   	
      n=arreglo[i].Getcont();
		if (n>cont)
			cont=n;
	}
}

    public void ListarReprobados(){
    int i,m=0;
	ContarReprobados();
    for(i=0;i<=indice;i++){
	m=arreglo[i].Getcont();
	if(cont==m){
      System.out.println("Los alumnos reprobados del Grupo"+i+"son:");
      arreglo[i].ListarReprobados();}}
    
    
  }
  public void Actualizar(int i){
    arreglo[i].Actualizar(Teclado.entero("Dame el numero de cuenta del alumno a actualizar"));
  }
  public double GetPromedioMax(){
    PromedioMax();
    return promediomayor;
  }

}	