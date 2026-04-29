package Poo2.tp4.p1.UI;

import Poo2.tp4.p1.modelo.JdbcParticipanteRepositorio;
import Poo2.tp4.p1.modelo.ParticipanteRepositorio;

import java.awt.EventQueue;
import java.sql.SQLException;
public class Main {
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParticipanteRepositorio repositorio = new JdbcParticipanteRepositorio();
					new Vista(repositorio);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}
}