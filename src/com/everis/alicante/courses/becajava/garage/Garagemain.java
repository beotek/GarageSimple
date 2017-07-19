package com.everis.alicante.courses.becajava.garage;

import java.io.IOException;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.controller.ControladorGarajeConArrays;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.ClienteDAOFileImpl;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.PlazaDAOFileImp;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.ReservaDAOFileImp;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.VehiculoDAOFileImp;
import com.everis.alicante.courses.becajava.interfaces.ClienteDAO;
import com.everis.alicante.courses.becajava.interfaces.ControladorGaraje;
import com.everis.alicante.courses.becajava.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.interfaces.VehiculoDAO;

public class Garagemain {


	static Garaje garaje = new Garaje();
	static ControladorGaraje controlador;

	public static void main(String[] args) throws IOException {

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
		System.out.println("4:Listar Clientes");

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
		case 4:
			controlador.listarClientes();
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
		ReservaDAO reservaDao= new ReservaDAOFileImp();
		ClienteDAO clienteDao = new ClienteDAOFileImpl();
		VehiculoDAO vehiculoDao=new VehiculoDAOFileImp();
		
		
		garaje.setPlazas(plazaDao.readPlazas());
	
		garaje.setVehiculos(vehiculoDao.readVehiculos());
		garaje.setClientes(clienteDao.readClientes());
		garaje.setReservas(reservaDao.readReserva());
		controlador = new ControladorGarajeConArrays();
		
		
	}
	
	public static Garaje getGaraje() {
		return garaje;
		
	}
}
