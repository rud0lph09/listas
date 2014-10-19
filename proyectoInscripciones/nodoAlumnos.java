public class nodoAlu{
	//En esta clase se esta trbajando con
	//Alumnos por lo que cada alumnos es un
	//Nodo y la informacion a la que apunta
	//es un arreglo el cual cuenta con
	//la informacion básica sobre el alumno
	String[6] info;
	String id, nombre, apellido, apellidoM, numTel, grupo;
	info[0]=id;
    info[1]=nombre;      //declaracion de los elementos
    info[2]=apellido;    //basicos de informacion para
    info[3]=apellidoM;   //los alumnos y se igualan a un
    info[4]=numTel;      //indice de el arreglo de info
    info[5]=grupo;
	Nodo siguiente;
	//En este constructor solo se especifica
	//a que apunta cada nodo
	//que es la informacion y el nodo siguiente
	public Nodo(String[] i, Nodo s)
	{
		info = i;
		siguiente = s;
	}
	//Se crearian como alumno.Insertar(info["01","Rodolfo","Castillo","Vidrio","5521061342","1A"])

//setters y getters
 
//este metodo obtiene la informacion de
//cualquier nodo y regresa la info	
public String getInfo(){    // son los get/setters de la informacion a la cual apunta
	return info;            // este nodo
}

//con este podemos mandarle la informacion
//al nodo
public void setInfo(String info){
	this.info = info;
}

//con este nodo se le pide el nodo siguiente
//util para buscar nodos
public Nodo getSiguiente(){     //son los get/setters que apuntan al nodo siguiente a
	return siguiente;           //enlistar
}

//con este se establece cual es el nodo a apuntar
public void setSiguiente(Nodo siguiente){
	this.siguiente = siguiente;
}
}
