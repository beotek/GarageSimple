package com.everis.alicante.courses.becajava.garage.interfaces.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.becajava.garage.Garagemain;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.interfaces.ClienteDAO;

public class ClienteDAOFileImpl implements ClienteDAO {

	@Override
	public Map<String, Cliente> readClientes() throws IOException {

		//buscar un fichero
		
		
		Map<String,Cliente> clientes= new TreeMap<String,Cliente>();
		File file= new File("src/resources/Clientes.txt");
		FileReader reader= new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String linea;
		while((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("NIF")||linea.isEmpty()) {
			Cliente cliente = new Cliente();
			String[] temp= linea.split(";");
			cliente.setNif(temp[0]);
			cliente.setNombreCompleto(temp[1]);
			Map<String,Vehiculo> vehiculos = Garagemain.getGaraje().getVehiculos();
			Vehiculo vehiculo = vehiculos.get(temp[2]);
			cliente.setVehiculo(vehiculo);
			clientes.put(cliente.getNif(),cliente);
			}
		}
		
		return clientes;
	}

	@Override
	public void createCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	


}
