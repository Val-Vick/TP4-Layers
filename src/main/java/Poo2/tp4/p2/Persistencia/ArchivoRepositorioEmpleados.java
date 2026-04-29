package Poo2.tp4.p2.Persistencia;

import Poo2.tp4.p2.Modelo.Empleado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ArchivoRepositorioEmpleados implements RepositorioEmpleados{
	private String rutaArchivo;

	public ArchivoRepositorioEmpleados(String ruta) {
		this.rutaArchivo = ruta;
	}

	@Override
	public List<Empleado> obtenerTodos() {
		try {
			return Files.lines(Paths.get(rutaArchivo))
					.map(linea -> {
						String[] datos = linea.split(",");
						String apellido = datos[0].trim();
						String nombre = datos[1].trim();
						LocalDate fecha = LocalDate.parse(datos[2].trim(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
						String email = datos[3].trim();
						return new Empleado(apellido, nombre, fecha, email);
					})
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException("no se pudo leer el archivo de empleados", e);
		}
	}
}
