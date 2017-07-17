
public class Plaza {
	
	private Cliente cliente;
	private double precio;
	private int numeroPlaza;
	private Boolean libre;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "\nPlaza " + cliente + ", Precio de la plaza=" + precio ;
	}
	public int getNumeroPlaza() {
		return numeroPlaza;
	}
	public void setNumeroPlaza(int numeroPlaza) {
		this.numeroPlaza = numeroPlaza;
	}
	public Boolean getLibre() {
		if(cliente==null) {
			return true;
		}else {
			return false;
		}
	}



}
