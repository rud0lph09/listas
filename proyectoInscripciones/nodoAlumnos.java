package Proyecto;

public class nodoAlumnos{				//Esta clase esta trabajando con Alumnos, cada alumno es un Nodo y la informacion a la que apunta es un arreglo el cual 
										//cuenta con la informacion básica sobre el alumno
	
	//Atributos
	public String info[];
	public String id;
	public String nombre;
	public String apellido;
	public String apellidoM;
	public String numTel;
	public String grupo;
	
	info[0]=id;
    info[1]=nombre;      //declaracion de elementos basicos de info para los alumnos, se igualan a un indice de el arreglo de info
    info[2]=apellido;    
    info[3]=apellidoM;   
    info[4]=numTel;      
    info[5]=grupo;
    
	Nodo siguiente;
	
	//Constructor
	public NodoAlumnos(String[] i, Nodo s)	//Especifíca a que apunta cada nodo que hace referencia a la informacion y el nodo siguiente
	{										//Se crearian como alumno.Insertar(info["01","Rodolfo","Castillo","Vidrio","5521061342","1A"])
		info=i;
		siguiente=s;
	}

//Métodos Sets y Gets
 
public String getInfo()					// son los get/setters de la informacion a la cual apunta este nodo
{    
	return info;
}


public void setInfo(String info) 		//con este podemos mandarle la informacion al nodo
{
	this.info = info;
}


public Nodo getSiguiente() 				//son los get/set que apuntan al nodo siguiente a enlistar
{     
	return siguiente;           
}


public void setSiguiente(Nodo siguiente) //con este se establece cual es el nodo a apuntar
{
	this.siguiente = siguiente;
}


}