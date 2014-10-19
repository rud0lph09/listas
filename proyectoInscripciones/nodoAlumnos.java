public class nodoAlu{
	String[6] info;
	String id, nombre, apellido, apellidoM, numTel, grupo;
	info[0]=id;
    info[1]=nombre;
    info[2]=apellido;
    info[3]=apellidoM;
    info[4]=numTel;
    info[5]=grupo;
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
