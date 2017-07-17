import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Garagemain {
	
	static List<Vehiculo> vehiculos = new ArrayList<>();
	static List<Cliente> clientes = new ArrayList<>();
	static List<Plaza> plazas = new ArrayList<>();
	static Garaje garaje = new Garaje();

	public static void main(String[] args) {

		// 4 clientes

		// 5 vehiculos

		// 30 plazas de garaje

		// 1 garaje
		
		generarComponentes();

	}

	
	public static void generarComponentes() {
		
		
		//VEHICULOS
		for (int i = 0; i < 5; i++) {
			Random rn = new Random();
			int range =  10000 ;
			int randomNum =  rn.nextInt(range) + 100;
			
			String matricula = String.valueOf(randomNum).concat("AAA");
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setMatricula(matricula);
			vehiculos.add(vehiculo);
		}
		
		//CLIENTES
		for (int i = 0; i < 4; i++) {
			Cliente cliente = new Cliente();
			Random rn = new Random();
			int range = 100000000 ;
			int randomNum =  rn.nextInt(range) + 100;
			
			String nif = String.valueOf(randomNum).concat("B");
			cliente.setNif(nif);
			String nombre = "Cliente"+(i+1);
			cliente.setNombreCompleto(nombre);
			cliente.setVehiculo(vehiculos.get(i));
			clientes.add(cliente);
		}
		
		//PLAZAS
		for (int i = 0; i < 30; i++) {
			Plaza plaza = new Plaza();
			plaza.setPrecio(80.00);
			plazas.add(plaza);
		}
		
		for (int j = 0; j < clientes.size(); j++) {
			Plaza plaza = plazas.get(j);
			plaza.setCliente(clientes.get(j));
		}
		
		//GARAJE
		for (int i = 0; i < 1; i++) {
			garaje.setPlazas(plazas);
		}
		System.out.println(garaje);
		
	}
}
