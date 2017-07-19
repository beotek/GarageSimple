package com.everis.alicante.courses.becajava.interfaces;

import java.io.IOException;

import com.everis.alicante.courses.becajava.garage.domain.Reserva;

public interface ReservaDAO {
	
	public void saveReserva(Reserva reserva) throws IOException;
}
