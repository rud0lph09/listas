public class listaAlumnos{ 
	Nodo inicio;
	Nodo fin;
//se declaran nodos basicos inicial y final
	public listaAlumnos{
		inicio = fin = null; //contructor de la lista de alumnos
	}
	//Los arreglos enviados seran de 
	//tipo string
	 public void InsertarAlInicio(String[] info){
    	Nodo nuevo = new Nodo(info, inicio);
    	inicio = nuevo;
    	if (fin == null) 
    		fin = inicio;
    }
//los metodos ya estan listos para implementarse
//la duda es saber si estoy enviandoles bien el arreglo
//info    
    public void InsertarAlFinal(String[] info){
    	Nodo nuevo = new Nodo(info, null);
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

    public void Listar()
    {
        Nodo temp = inicio;
        while(temp != null){
            System.out.println(temp.getInfo());
            temp = temp.siguiente;
        }

    }
}

/*
  la forma en la que la informacion va a
  funionar es como en un arreglo
  el indice 1 del arreglo sera el nombre
  el 2 sera el apellido y asi respecti-
  vamente

  alumno[ID, Nombre, Apellido, ApellidoM
  , NumTel, Grupo]

  alumno[0]=ID;
  alumno[1]=Nombre;
  alumno[2]=Apellido;
  alumno[3]=ApellidoM;
  alumno[4]=NumTel;
  alumno[5]=Grupo; <- null hasta asignar
*/