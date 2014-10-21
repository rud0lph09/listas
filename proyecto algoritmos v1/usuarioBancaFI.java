public class usuarioBancaFI {
    
	
	//Atributos
	private int cod,telefono; 
    private String nombre, apellido;
    private Double saldo;
 
    
    //Setters y getters
    public int getCod()
    {
        return cod;
    }
 

    public void setCod(int cod)
    {
        this.cod = cod;
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