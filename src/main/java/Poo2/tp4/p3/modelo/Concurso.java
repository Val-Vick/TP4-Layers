package Poo2.tp4.p3.modelo;

import Poo2.tp4.p3.persistencia.RegistroInscripcion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
	private String IdNombre;
	private ArrayList<Inscripcion> inscriptos;
	private LocalDate finInscripcion;
	private LocalDate inicioInscripcion;

	public Concurso(String nombre, LocalDate finInscripcion, LocalDate inicioInscripcion, RegistroInscripcion registro) {
		this.IdNombre = nombre;
		this.finInscripcion = finInscripcion;
		this.inicioInscripcion = inicioInscripcion;
		this.registro = registro;
		inscriptos = new ArrayList<>();
	}

	public void inscribirA(Participante participante, LocalDate fechaHoy) {
		if (fechaHoy.isBefore(this.inicioInscripcion) || fechaHoy.isAfter(this.finInscripcion)) {
			throw new RuntimeException("Fuera de fecha de inscripción");
		}

		if (estaInscripto(participante)) {
			throw new RuntimeException("Ya está inscripto");
		}

		Inscripcion nueva = new Inscripcion(participante);
		nueva.asignarPuntos(10, fechaHoy, inicioInscripcion);
		inscriptos.add(nueva);

		registro.guardar(fechaHoy.toString(), participante.getDni().toString(), this.IdNombre);
	}

	public boolean estaInscripto(Participante participante) {
		boolean esta = false;
		if (inscriptos.isEmpty()){
			return esta;
		}

		for (Inscripcion i : inscriptos) {
			if (i.contieneA(participante)) {
				esta = true;
			}
		}

		return esta;
	}
}

