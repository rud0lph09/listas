public class lista{
	
	Nodo inicio;
    Nodo fin;

    public lista(){              //Constructor de lista de nodos
    	inicio = fin = null;
    }

    public void InsertarAlInicio(String info){
    	Nodo nuevo = new Nodo(info, inicio);
    	inicio = nuevo;
    	if (fin == null) 
    		fin = inicio;
    }

    public void InsertarAlFinal(String info){
    	Nodo nuevo = new Nodo(info, fin);
    	if (inicio == null){
    		fin = nuevo;
    		inicio = fin;
    	}
    	else
    	{
    		fin.setSiguiente(nuevo);
    		fin = nuevo;
    	}
	}

	public void EliminarInicio()
	{
		inicio = inicio.siguiente;
	}

	public String ExtraerInicio(){
		String info = inicio.getInfo();
		inicio = inicio.getSiguiente();
		if(inicio == null)
			fin = null;
		return info;
	}
	
} 