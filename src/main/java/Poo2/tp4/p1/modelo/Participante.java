package Poo2.tp4.p1.modelo;

import java.util.List;

public class Participante {
	private String nombre;
	private String telefono;
	private String region;

	public Participante(String nombre, String telefono, String region) {
		if (nombre == null || nombre.isEmpty()) {
			throw new RuntimeException("debe cargar un nombre");
		}
		if (telefono == null || !validarTelefono(telefono)) {
			throw new RuntimeException("el telefono debe ingresarse de la forma: NNNN-NNNNNN");
		}
		if (!esRegionValida(region)) {
			throw new RuntimeException("region desconocida");
		}
		this.nombre = nombre;
		this.telefono = telefono;
		this.region = region;
	}

	private boolean validarTelefono(String telefono) {
		return telefono.matches("\\d{4}-\\d{6}");
	}

	private boolean esRegionValida(String region) {
		return List.of("China", "US", "Europa").contains(region);
	}

	public String getNombre(){
		return nombre;
	}

	public String getTelefono(){
		return telefono;
	}

	public String getRegion(){
		return region;
	}
}