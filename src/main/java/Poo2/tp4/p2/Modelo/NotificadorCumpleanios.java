package Poo2.tp4.p2.Modelo;

import Poo2.tp4.p2.Persistencia.*;
import java.time.LocalDate;

public class NotificadorCumpleanios {
	private final RepositorioEmpleados repositorio;
	private final EnviadorEmail emailService;

	public NotificadorCumpleanios(RepositorioEmpleados repo, EnviadorEmail email) {
		this.repositorio = repo;
		this.emailService = email;
	}

	public void enviarSaludos(LocalDate hoy) {
		repositorio.obtenerTodos().stream().filter(e -> e.esMiCumpleanios(hoy)).forEach(emailService::enviarSaludo);
	}
}