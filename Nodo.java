package Proyecto;

public class Nodo{
	
	//Atributos
	private String info;
	Nodo siguiente;
	
	//Constructor
	public Nodo(String i, Nodo s)
	{
		info = i;
		siguiente = s;
	}

	
//Métodos set y get
public String getInfo()
{    
	return info;				// son los get/set de la informacion a la cual apunta este nodo            
}


public void setInfo(String info)
{
	this.info = info;
}


public Nodo getSiguiente()
{     
	return siguiente;			//son los get/set que apuntan al nodo siguiente a enlistar           
}


public void setSiguiente(Nodo siguiente)
{
	this.siguiente = siguiente;
}


}