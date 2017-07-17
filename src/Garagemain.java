import java.util.Scanner;

public class Garagemain {

	// static List<Vehiculo> vehiculos = new ArrayList<>();
	// static List<Cliente> clientes = new ArrayList<>();
	// static List<Plaza> plazas = new ArrayList<>();
	static Garaje garaje = new Garaje();
	static ControladorGaraje controlador;

	public static void main(String[] args) {

		// 4 clientes

		// 5 vehiculos

		// 30 plazas de garaje

		// 1 garaje

		generarComponentes();

		// iniciar aplicacion o listar menú

		iniciarAplicacion();
		
		

	}

	private static void iniciarAplicacion() {
		System.out.println("Bienvenido a nuestro garaje, Seleccione una opcion: ");
		System.out.println("1:Listar Plazas Garaje Libre ");
		System.out.println("2:Listar Plazas Garaje Ocupadas ");
		System.out.println("3:Reservar Plaza");
		

		Scanner in = new Scanner(System.in);
		Integer opcion =in.nextInt();
		boolean resultado=false;
		System.out.println("Ha elegido la opción :" +opcion);
		
		switch (opcion) {
		case 1:
			controlador.listarPlazasLibres();
			break;

		case 2:
			controlador.listarPlazasOcupadas();
			break;
		case 3:
			resultado=controlador.reservarPlaza();
			break;
		default:
			System.out.println("ERROR");
			break;
		}
		
		if(opcion==3&&resultado) {
			System.out.println("Se ha reservado tu plaza");
		}else if(opcion==3){
			System.out.println("No hay plazas disponibles");
		}
		iniciarAplicacion();
		in.close();
	}
	
	

	public static void generarComponentes() {

		// CODIGOCLASE

		// PLAZAS

		Plaza[] plazas = new Plaza[30];

		for (int i = 0; i < plazas.length; i++) {
			Plaza plazaTemp = new Plaza();
			plazaTemp.setNumeroPlaza(i + 1);
			if (i < 10) {
				plazaTemp.setPrecio(50);
			} else if (i < 20) {
				plazaTemp.setPrecio(75);
			} else {
				plazaTemp.setPrecio(100);
			}

			plazas[i] = plazaTemp;

		}
		

		garaje.setPlazas(plazas);
		controlador=new ControladorGarajeConArrays();

		/*
		 * MICODIGO //VEHICULOS for (int i = 0; i < 5; i++) { Random rn = new Random();
		 * int range = 10000 ; int randomNum = rn.nextInt(range) + 100;
		 * 
		 * String matricula = String.valueOf(randomNum).concat("AAA"); Vehiculo vehiculo
		 * = new Vehiculo(); vehiculo.setMatricula(matricula); vehiculos.add(vehiculo);
		 * }
		 * 
		 * //CLIENTES for (int i = 0; i < 4; i++) { Cliente cliente = new Cliente();
		 * Random rn = new Random(); int range = 100000000 ; int randomNum =
		 * rn.nextInt(range) + 100;
		 * 
		 * String nif = String.valueOf(randomNum).concat("B"); cliente.setNif(nif);
		 * String nombre = "Cliente"+(i+1); cliente.setNombreCompleto(nombre);
		 * cliente.setVehiculo(vehiculos.get(i)); clientes.add(cliente); }
		 * 
		 * //PLAZAS for (int i = 0; i < 30; i++) { Plaza plaza = new Plaza();
		 * plaza.setPrecio(80.00); plazas.add(plaza); }
		 * 
		 * for (int j = 0; j < clientes.size(); j++) { Plaza plaza = plazas.get(j);
		 * plaza.setCliente(clientes.get(j)); }
		 * 
		 * //GARAJE for (int i = 0; i < 1; i++) { garaje.setPlazas(plazas); }
		 * System.out.println(garaje);
		 */

	}
	
	public static Garaje getGaraje() {
		return garaje;
		
	}
}
