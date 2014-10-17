class TestGrupo{
private static int Menu(){
	int opc;
	do {
		opc= Teclado.entero("1.- Insertar\n 2.- Listar \n 3.-Buscar \n 4.-Borrar\n5.-Actualizar \n 6.-Ordenar\n 7.- salir \n OPCION");
		if (opc<1||opc>7)
			System.out.println("Opción no Válida");
	}while (opc<1||opc>7);
	return opc;
}
private static int MenuMain(){
	int opc;
	do {
		opc= Teclado.entero("1.- Insertar\n 2.- Listar \n 3.-Buscar \n 4.-Borrar\n 5.-Actualizar \n 6.- Grupo con mayor promedio \n 7.-Grupo con menor promedio \n 8.-Grupo con mas reprobados \n 9.-Arriba de la media \n 10.- Salir");
		if (opc<1||opc>10)
			System.out.println("Opción no Válida");
	}while (opc<1||opc>10);
	return opc;
}
public static void TestArregloAl(){
	int opcion, cuenta, max, maxtel, maxcalif, pos;
	Alumno mialumno;
	ArregloAlumno grupo;
	max= Teclado.entero( "Tamaño maximo del grupo : ");
	maxtel= Teclado.entero( "Tamaño maximo de telefonos : ");
	maxcalif= Teclado.entero( "Tamaño maximo de calificaciones : ");

	grupo= new ArregloAlumno(max);

	do{
		opcion= Menu();
		switch (opcion){
			case 1:if(grupo.ValidaEspacio()){
						mialumno= new Alumno (maxtel, maxcalif);
						mialumno.Captura();
					}
				else
					System.out.println("No hay espacio");
				break;
			case 2: grupo.Listar();
				break;
			
			case 3: cuenta=Teclado.entero("Dame tu número de cuenta");
				pos=grupo.Buscar(cuenta);
				if(pos!=-1)
					grupo.Listar(pos);
				else
					System.out.println("Error inminente el ordenador se apagara en 5,4,3,2,1.....");
				break;
			case 4: grupo.Borrar(Teclado.entero("Cuenta del alumno a borrar"));
				break;

			case 5: grupo.Actualizar(Teclado.entero("Número de cuenta"));
				break;
			case 6:
				Ordenar orden=new Ordenar();
				orden.Ordena(grupo);
				break;
		}
 	}
 	while(opcion!=7);
}

public static void main (String []args){
	int opcion, max, pos;
	ArregloAlumno migrupo=new ArregloAlumno(20);
	ArregloGrupo escuela;
	max= Teclado.entero( "Tamaño maximo de grupos: ");
	escuela=new ArregloGrupo(max);


	do{
		opcion=MenuMain();
		switch (opcion){
			case 1:if(escuela.ValidaEspacio()){
				escuela.Insertar(migrupo);
			}
				else
					System.out.println("No hay espacio");
				break;
			case 2: escuela.Listar();
				break;
			
			case 3: escuela.Buscar(pos=Teclado.entero("Dame numero de grupo"));
				if(pos!=-1)
					escuela.Listar(pos);
				else
					System.out.println("Error inminente el ordenador se apagara en 5,4,3,2,1.....");
				break;
			case 4: escuela.Borrar(Teclado.entero("Numero de grupo a borrar"));
				break;

			case 5: TestArregloAl();
				break;
			
			case 6: escuela.PromedioMax();
				break;
			case 7: escuela.PromedioMin();
				break;

			case 8: escuela.ListarReprobados();
				break;
			case 9: escuela.PromedioA();
				break;
		}
	}
	while(opcion!=10);
}
}

	
