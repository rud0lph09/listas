package Proyecto;

public class lista{
	
	//Atributos
	Nodo inicio;
    Nodo fin;

    //Constructor de lista de nodos
    public lista()
    {             
    	inicio = fin = null;
    }

    
    //Métodos de Inserciones
    public void InsertarAlInicio(String info)
    {
    	Nodo nuevo = new Nodo(info, inicio);
    	inicio = nuevo;
    	if (fin == null) 
    		fin = inicio;
    }

    
    public void InsertarAlFinal(String info)
    {
    	Nodo nuevo = new Nodo(info, null);
    	if (inicio == null)
    	{
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

	
	public String ExtraerInicio()
	{
		String info = inicio.getInfo();
		inicio = inicio.getSiguiente();
		if(inicio == null)
			fin = null;
		return info;
	}

	
    public void Listar()
    {
        Nodo temp = inicio;
        while(temp != null)
        {
            System.out.println(temp.getInfo());
            temp = temp.siguiente;
        }

    }
	
} 