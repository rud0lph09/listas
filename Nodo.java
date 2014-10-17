public class Nodo{
	private String info;
	Nodo siguiente;
	public nodo(String i, Nodo s)
	{
		info = i;
		siguiente = s;
	}

//setters y getters

public String getInfo(){    // son los get/setters de la informacion a la cual apunta
	return info;            // este nodo
}

public void setInfo(){
	this.info = info;
}

public Nodo getSiguiente(){     //son los get/setters que apuntan al nodo siguiente a
	return siguiente;           //enlistar
}

public void setSiguiente(){
	this.siguiente = siguiente;
}
}

