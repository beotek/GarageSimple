package com.everis.alicante.courses.becajava.garage.interfaces.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.interfaces.VehiculoDAO;

public class VehiculoDAOFileImp implements VehiculoDAO{

	@Override
	public Map<String,Vehiculo> readVehiculos() throws IOException {

		//buscar un fichero
		
		Map<String,Vehiculo> vehiculos= new TreeMap<String,Vehiculo>();
		File file= new File("src/resources/Vehiculos.txt");
		FileReader reader= new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String linea;
		List data=new ArrayList<String>();
		while((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("CODIGO_R")||linea.isEmpty()) {
			Vehiculo vehiculo = new Vehiculo();
			String[] temp= linea.split(";");
			vehiculo.setMatricula(temp[0]);
			vehiculo.setTipoVehiculo(temp[1]);
	
			vehiculos.put(vehiculo.getMatricula(),vehiculo);
			}
		}
		
		return vehiculos;
	}

	@Override
	public void createVehiculo() {
//
//		File file = new File("src/resources/Vehiculos.txt");
//		FileWriter writer = new FileWriter(file,true);
//		BufferedWriter buffer = new BufferedWriter(writer);
//		buffer.newLine();
//		buffer.write(vehiculos.convierteTxt());
//		buffer.close();
		
	}
	
	public Map<String,Vehiculo> readVehiculo() throws IOException {

		//buscar un fichero
		
		
		Map<String,Vehiculo> vehiculos= new TreeMap<String,Vehiculo>();
		File file= new File("src/resources/Vehiculos.txt");
		FileReader reader= new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String linea;
		List data=new ArrayList<String>();
		while((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("MATRICULA")||linea.isEmpty()) {
			Vehiculo vehiculo = new Vehiculo();
			String[] temp= linea.split(";");
			vehiculo.setMatricula(temp[0]);
			vehiculo.setTipoVehiculo(temp[1]);
	
			vehiculos.put(vehiculo.getMatricula(),vehiculo);
			}
		}
		
		return vehiculos;
	}

}
