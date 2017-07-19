package com.everis.alicante.courses.becajava.garage.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.Garagemain;
import com.everis.alicante.courses.becajava.garage.domain.Camion;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Coche;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.domain.Moto;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.impl.ReservaDAOFileImp;
import com.everis.alicante.courses.becajava.interfaces.Aparcable;
import com.everis.alicante.courses.becajava.interfaces.ControladorGaraje;
import com.everis.alicante.courses.becajava.interfaces.ReservaDAO;

public class ControladorGarajeConArrays implements ControladorGaraje {

	@Override
	public void listarPlazasLibres() {
		List<Plaza> plazasLibres=new ArrayList<>();
		
		List<Plaza> plazas=Garagemain.getGaraje().getPlazas();
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);
			if(plaza.getLibre()) {
				plazasLibres.add(plaza);
			}
			
		}
		
		for(Plaza plaza: plazasLibres) {
			System.out.println(plaza);
		}
		
		
	}

	@Override
	public void listarPlazasOcupadas() {
		List<Plaza> plazasLibres=new ArrayList<>();
		
		List<Plaza> plazas=Garagemain.getGaraje().getPlazas();
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);
			if(!plaza.getLibre()) {
				plazasLibres.add(plaza);
			}
			
		}
		
		for(Plaza plaza: plazasLibres) {
			System.out.println(plaza);
		}
		
		
	}

	@Override
	public boolean reservarPlaza() throws IOException {
		
		Cliente cliente = new Cliente();
		Vehiculo vehiculo=null;
		ReservaDAO dao= new ReservaDAOFileImp();
		Scanner in=new Scanner(System.in);
		System.out.println("Introduce el nombre del cliente");
		cliente.setNombreCompleto(in.nextLine());
		System.out.println("Introduce el nif");
		cliente.setNif(in.nextLine());
		System.out.println("tipo de vehiculo");
	
		System.out.println("Tipo de vehiculo del propietario:");
		System.out.println("1-Coche" );
		System.out.println("2-Moto" );
		System.out.println("3-Camión" );
		in =new Scanner(System.in);
		switch(in.nextInt()) {
		case 1:
			vehiculo=new Coche();
			break;
		case 2:
			vehiculo = new Moto();
			break;
		case 3:
			vehiculo=new Camion();
			break;
		default:
			break;
		}
		
		in =new Scanner(System.in);
		System.out.println("Introduce la matricula del vehiculo");
		vehiculo.setMatricula(in.nextLine());
		cliente.setVehiculo(vehiculo);
		
		
		//lógica de si hay vacias
		//si hay plazas libres seteamos un cliente a la plaza que queramos
		boolean hayplaza=false;
		Garaje garaje=Garagemain.getGaraje();
		List<Plaza>plazas=garaje.getPlazas();
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);
			
			if(plaza.getLibre()&& vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza=true;
				
				Reserva reserva =new Reserva();
				reserva.setCliente(cliente);
				reserva.setPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				dao.createReserva(reserva);
				
				return hayplaza;
			}
		}
		return hayplaza;

		
	}

	@Override
	public void listarClientes() throws IOException {
		Map<String,Cliente> clientes= Garagemain.getGaraje().getClientes();
		
	}

	
}
