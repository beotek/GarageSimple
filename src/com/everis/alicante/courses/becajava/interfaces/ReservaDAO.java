package com.everis.alicante.courses.becajava.interfaces;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Reserva;

public interface ReservaDAO {
	
	public void createReserva(Reserva reserva) throws IOException;
	
	public Map<String,Reserva> readReserva() throws IOException;
}
