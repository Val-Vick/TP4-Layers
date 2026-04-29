package Poo2.tp4.p1.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcParticipanteRepositorio implements ParticipanteRepositorio {
	private String url = "jdbc:derby://localhost:1527/participantes";
	private String user = "app";
	private String password = "app";

	@Override
	public void guardar(Participante participante) {
		try (Connection conn = DriverManager.getConnection(url, user, password);
			 PreparedStatement st = conn.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)")) {

			st.setString(1, participante.getNombre());
			st.setString(2, participante.getTelefono());
			st.setString(3, participante.getRegion());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Error al conectar con la base de datos", e);
		}
	}
}
