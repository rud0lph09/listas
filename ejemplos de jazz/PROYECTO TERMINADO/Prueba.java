class Prueba{
	public static void main(String args[]){
		int salir=0;
		Alumno alumno=new Alumno(50,50);
		Alumno alumno2=new Alumno(50,50);
		Alumno alumno3=new Alumno(50,50);
		Alumno alumno4=new Alumno(50,50);
		ArregloAlumno grupo=new ArregloAlumno(50);
		ArregloAlumno grupo2=new ArregloAlumno(50);
		ArregloGrupo escuela=new ArregloGrupo(50);
		alumno.GeneradorAlumnos();
		alumno.CalcularPromedio();
		alumno2.GeneradorAlumnos();
		alumno2.CalcularPromedio();
		alumno3.GeneradorAlumnos();
		alumno3.CalcularPromedio();
		alumno4.GeneradorAlumnos();
		alumno4.CalcularPromedio();
		grupo.Insertar(alumno);
		grupo.Insertar(alumno2);
		grupo2.Insertar(alumno3);
		grupo2.Insertar(alumno4);
		escuela.Insertar(grupo);
		escuela.Insertar(grupo2);
		do{
			escuela.Listar();
			escuela.ListarReprobados();
			escuela.PromedioMax();
			escuela.PromedioMin();
			escuela.PromedioA();
			salir=Teclado.entero("\nDeseas salir -.-, Pues presiona 3 :D ");
		}
		while(salir!=3);		
	}
}