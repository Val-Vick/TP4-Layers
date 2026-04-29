package Poo2.tp4.p2;

import Poo2.tp4.p2.Modelo.Empleado;
import Poo2.tp4.p2.Persistencia.EnviadorEmail;

public class fakeEnviador implements EnviadorEmail {
	public boolean seEnvio = false;
	@Override
	public void enviarSaludo(Empleado empleado) {
		seEnvio = true;

	}
}
