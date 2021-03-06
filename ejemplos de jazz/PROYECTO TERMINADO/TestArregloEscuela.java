class TestArregloEscuela{
		private static int Menu(){
		int opc;
		do{
			opc=Teclado.entero("\n\n1)Insertar Alumno\n2)Listar\n3)Buscar\n4)Borrar\n5)Actualizar\n6)Ordenar\n7)Salir\nOpcion: ");
		}while (opc<1||opc>7);
		return opc;
	}
	public static void MenuGrupo(ArregloAlumno grupo){
		int opcion, cuenta, max, maxtels, maxcalifs, pos;
		Alumno mialumno;
		//ArregloAlumno grupo;
		maxtels=Teclado.entero("Tamaño max de telefonos");
		maxcalifs=Teclado.entero("Tamaño max de calificaciones");
		grupo.GeneradorGrupos();
		do{
			opcion=Menu();
			switch(opcion){
				case 1 : if(grupo.ValidaEspacio()){
					mialumno=new Alumno(maxtels,maxcalifs);
					mialumno.Captura();
					grupo.Insertar(mialumno);
						}
						else System.out.println("Ya no hay espacio para un alumno mas");
				break;
				case 2 : grupo.Listar();
				break;
				case 3 : cuenta=Teclado.entero("Dame la cuenta");
					pos=grupo.Buscar(cuenta);
					if(pos!=-1)
						grupo.Listar(pos);
					else System.out.println("Cuenta no encontrada");
					break;
				case 4 : grupo.Borrar(Teclado.entero("Dame la cuenta de alumno a borrar: "));
					break;
				case 5 : grupo.Actualizar(Teclado.entero("Dame el numero de cuenta del alumno a actualizar"));
				 break;
				case 6:
				Ordenar orden=new Ordenar();
				orden.Ordena(grupo);
				break;
				}
		}while(opcion!=7);
	}
	private static int MenuEscuela(){
		int opc;
		do		{
			opc=Teclado.entero("\n\n1)Insertar Grupo\n2)Listar\n3)Buscar\n4)Borrar\n5)Actualizar\n6)Grupo con mayor promedio\n7)Grupo con menor promedio\n8)Alumnos reprobados\n9)Grupo arriba del promedio general\n10)Salir\nOpcion: ");
		}while (opc<1||opc>10);
		return opc;
	}
	public static void main(String []args){
		int opcion, max, max2;
		ArregloGrupo escuela;
		ArregloAlumno grupo;
		max=Teclado.entero("Tamaño maximo de grupos");
		//max2=Teclado.entero("Tamaño maximo de alumnos");
		escuela=new ArregloGrupo(max);
		//grupo=new ArregloAlumno(max2);
		//escuela.Insertar(grupo);
		do{
			opcion=MenuEscuela();
			switch(opcion){
				case 1 : max2=Teclado.entero("Tamaño maximo de grupo");
						grupo=new ArregloAlumno(max2);
						escuela.Insertar(grupo);
						MenuGrupo(grupo);
					break;
				case 2:	escuela.Listar();
					break;
				case 3: escuela.Buscar(Teclado.entero("Dame el grupo a buscar"));
					break;
				case 4 : escuela.Borrar(Teclado.entero("Dame el dato a borrar"));
					break;
				case 5 : escuela.Actualizar(Teclado.entero("Dame al grupo a actualizar"));
					break;
				case 6 :escuela.PromedioMax();
					break;
				case 7 :escuela.PromedioMin();
					break;
				case 8 : escuela.ListarReprobados();
					break;
				case 9 : escuela.PromedioA();
					break;
			}
		}while (opcion!=10);
	}	

}
