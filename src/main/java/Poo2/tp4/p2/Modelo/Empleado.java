package Poo2.tp4.p2.Modelo;

import java.time.LocalDate;

public record Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String email) {

	public boolean esMiCumpleanios(LocalDate fecha) {
		return fecha.getMonth() == fechaNacimiento.getMonth() &&
				fecha.getDayOfMonth() == fechaNacimiento.getDayOfMonth();
	}
}