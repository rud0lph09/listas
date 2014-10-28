public class usuarioBancaFI {
    
	
	//Atributos
	private int id,telefono, idTipo, idGenero; 
    private String nombre, apellido;
    private Double saldo;
 
    
    //Setters y getters
    public int getId()
    {
        return id;
    }
 

    public void setId(int id)
    {
        this.id = id;
    }

    public int getIdTipo()
    {
        return idTipo;
    }
 

    public void setIdTipo(int idTipo)
    {
        this.idTipo = idTipo;
    }
 
    public int getIdGenero()
    {
        return idGenero;
    }
 

    public void setIdGenero(int idGenero)
    {
        this.idGenero = idGenero;
    }
 
    public String getNombre()
    {
        return nombre;
    }
 

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
 

    public String getApellido()
    {
        return apellido;
    }
 

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    
    public Double getSaldo()
    {
        return saldo;
    }
 

    public void setSaldo(Double saldo)
    {
        this.saldo = saldo;
    }
 

    public int getTelefono()
    {
        return telefono;
    }
 

    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }
 
}