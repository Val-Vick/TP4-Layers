package Poo2.tp4.p2;

import Poo2.tp4.p2.Modelo.Empleado;
import Poo2.tp4.p2.Persistencia.RepositorioEmpleados;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class testEnviarSaludosDeCumpleanios {
	@Test
	void testEnviarSaludosSoloAQuienesCumplenHoy() {
		var angus = new Empleado("Young", "Angus", LocalDate.of(1982, 10, 8), "angus@acdc.com");
		var brian = new Empleado("Johnson", "Brian", LocalDate.of(1975, 9, 11), "brian@acdc.com");

		RepositorioEmpleados repoFake = new fakeRepositorioEmpleados();
	}}
