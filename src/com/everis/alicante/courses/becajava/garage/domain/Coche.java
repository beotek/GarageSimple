package com.everis.alicante.courses.becajava.garage.domain;
import com.everis.alicante.courses.becajava.interfaces.Aparcable;

public class Coche extends Vehiculo implements Aparcable {
	
	private String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public void aparcar() {
		System.out.println("Puedo aparcar");
		
	}

}
