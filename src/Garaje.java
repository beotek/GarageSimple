import java.util.List;

public class Garaje {
	
	private List<Plaza> plazas;

	public List<Plaza> getPlazas() {
		return plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return "Garaje con "+ plazas.size() + " plazas \n" + plazas ;
	}
	

}
