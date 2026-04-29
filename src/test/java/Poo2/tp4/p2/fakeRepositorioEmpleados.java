package Poo2.tp4.p2;

import Poo2.tp4.p2.Modelo.Empleado;
import Poo2.tp4.p2.Persistencia.RepositorioEmpleados;

import java.util.List;

public class fakeRepositorioEmpleados implements RepositorioEmpleados {

	@Override
	public List<Empleado> obtenerTodos() {
		return List.of();
	}
}
