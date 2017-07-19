package com.everis.alicante.courses.becajava.garage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.controller.ControladorGarajeConArrays;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.interfaces.ControladorGaraje;
import com.everis.alicante.courses.becajava.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.interfaces.PlazaDAOFileImp;

public class Garagemain {

	// static List<Vehiculo> vehiculos = new ArrayList<>();
	// static List<Cliente> clientes = new ArrayList<>();
	// static List<Plaza> plazas = new ArrayList<>();
	static Garaje garaje = new Garaje();
	static ControladorGaraje controlador;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// 4 clientes

		// 5 vehiculos

		// 30 plazas de garaje

		// 1 garaje

		generarComponentes();

		// iniciar aplicacion o listar menú

		iniciarAplicacion();
		
		

	}

	private static void iniciarAplicacion() throws IOException {
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
	
	

	public static void generarComponentes() throws  IOException {

		garaje = new Garaje();
		PlazaDAO plazaDao = new PlazaDAOFileImp();
		
		List<Plaza> plazas = plazaDao.readPlazas();
		
		garaje.setPlazas(plazas);
		controlador = new ControladorGarajeConArrays();
		
		
	}
	
	public static Garaje getGaraje() {
		return garaje;
		
	}
}
