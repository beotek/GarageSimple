package com.everis.alicante.courses.becajava.garage.interfaces.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.interfaces.PlazaDAO;

public class PlazaDAOFileImp implements PlazaDAO {

	@Override
	public List<Plaza> readPlazas() throws IOException {

		//buscar un fichero
		
		List plazas= new ArrayList<Plaza>();
		File file= new File("src/resources/Plazas.txt");
		FileReader reader= new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String linea;
		List data=new ArrayList<String>();
		while((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("NUMERO_PLAZA")) {
			Plaza plazaTemp=new Plaza();
			String[] temp= linea.split(";");
			plazaTemp.setNumeroPlaza(Integer.parseInt(temp[0]));
			plazaTemp.setPrecio(Double.parseDouble(temp[1]));
			
			plazas.add(plazaTemp);
			}
		}
		
		return plazas;
	}



	@Override
	public void createPlaza(List<Plaza> plazas) {
		
		
	}
	
}
