package com.everis.alicante.courses.becajava.garage.interfaces.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.becajava.garage.Garagemain;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.interfaces.ReservaDAO;

public class ReservaDAOFileImp implements ReservaDAO {

	@Override
	public void createReserva(Reserva reserva) throws IOException {

		File file = new File("src/resources/Reserva.txt");
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.newLine();
		buffer.write(reserva.convierteTxt());
		buffer.close();
	}
	
	public Map<String,Reserva> readReserva() throws IOException {

		//buscar un fichero
		
		
		Map<String,Reserva> reservas= new TreeMap<String,Reserva>();
		File file= new File("src/resources/Reserva.txt");
		FileReader reader= new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		String linea;
		while((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("CODIGO_RESERVA")||linea.isEmpty()) {
			Reserva reserva = new Reserva();
			String[] temp= linea.split(";");
			reserva.setCodigoReserva(temp[0]);
			Plaza plaza=Garagemain.getGaraje().getPlazas().get(Integer.parseInt(temp[1]));
			reserva.setPlaza(plaza);
			
			Cliente cliente=Garagemain.getGaraje().getClientes().get(temp[2]);
			reserva.setCliente(cliente);
	
			reservas.put(reserva.getCodigoReserva(),reserva);
			}
		}
		
		return reservas;
	}
//
//	public static void main(String args[]) throws IOException {
//
//		Reserva reserva = new Reserva();
//
//		Cliente cliente = new Cliente();
//		cliente.setNif("123456");
//
//		Plaza plaza = new Plaza();
//		plaza.setNumeroPlaza(1);
//
//		Vehiculo vehiculo = new Vehiculo();
//		vehiculo.setMatricula("21313 GFH");
//
//		cliente.setVehiculo(vehiculo);
//		reserva.setCliente(cliente);
//		reserva.setPlaza(plaza);
//		reserva.setFechaReserva(Calendar.getInstance().getTime());
//		ReservaDAO dao = new ReservaDAOFileImp();
//		dao.saveReserva(reserva);
//	}



}