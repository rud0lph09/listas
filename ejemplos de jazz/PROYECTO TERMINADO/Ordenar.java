

class Ordenar{
	//Metodo para arreglo enteros
	public void Ordena(ArregloEnteros arr){
		int ind=arr.Getindice();
		int i,j,aux;
		for(i=1;i<=ind;i++){
			aux=arr.GetElemento(i);
			j=i;
			while((j>0) && aux<arr.GetElemento(j-1)){
				arr.SetElemento(j,arr.GetElemento(j-1));
				j--;			
			}
			arr.SetElemento(j,aux);
		}
	}
	//Para arregloAlumnos por numero de cuenta
	public void Ordena(ArregloAlumno arr){
		int ind=arr.Getindice();
		int i,j;
		//es necesario obtener el maxtel y maxcalif maximos
		Alumno aux;
		//Alumno aux=new Alumno(
		for(i=1;i<=ind;i++){
			aux=arr.GetElemento(i);
			j=i;
			while((j>0) && aux.GetCuenta()<arr.GetElemento(j-1).GetCuenta()){
				arr.SetElemento(j,arr.GetElemento(j-1));
				j--;			
			}
			arr.SetElemento(j,aux);
		}
	}
	
	
	public static void main(String[] args) {
		/*con esto se prueba el acomodo de enteros
		ArregloEnteros mierda=new ArregloEnteros(5);
		do{
			mierda.Insertar(((int)(Math.random()*100)));
		}while(mierda.ValidaEspacio());
		mierda.Listar();
		Ordenar joder =new Ordenar();
		joder.Ordena(mierda);
		System.out.println("\n");
		mierda.Listar();*/
		//ahora el acomodo de alumnos por cuenta
		ArregloAlumno mierda=new ArregloAlumno(6);
		
		do{
			Alumno mellevalagoma=new Alumno(5,5);
			System.out.println("fuck");
			mellevalagoma.GeneradorAlumnos();
			mierda.Insertar(mellevalagoma);
		}while(mierda.ValidaEspacio());
		mierda.Listar();
		Ordenar joder =new Ordenar();
		joder.Ordena(mierda);
		System.out.println("\n");
		mierda.Listar();
		
	}
}
