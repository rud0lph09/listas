public class Nodo{
	private String info;
	Nodo siguiente;
	public Nodo(String i, Nodo s)
	{
		info = i;
		siguiente = s;
	}

//setters y getters

public String getInfo(){    // son los get/setters de la informacion a la cual apunta
	return info;            // este nodo
}

public void setInfo(String info){
	this.info = info;
}

public Nodo getSiguiente(){     //son los get/setters que apuntan al nodo siguiente a
	return siguiente;           //enlistar
}

public void setSiguiente(Nodo siguiente){
	this.siguiente = siguiente;
}
}

