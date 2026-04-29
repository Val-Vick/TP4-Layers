package Poo2.tp4.p2.Persistencia;

import Poo2.tp4.p2.Modelo.Empleado;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class Enviador implements EnviadorEmail{

	@Override
	public void enviarSaludo(Empleado empleado) {
		String from = "test@demo.com";
		String destinatario = empleado.email();
		String mensaje = "Feliz cumpleanios " + empleado.nombre() + "!";

		final String username = "e0df53cbfa68b1";
		final String password = "f00bdfa58228e3";

		String host = "sandbox.smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");

		Session session = Session.getInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject("Inscripcion exitosa");
			message.setText(mensaje);

			Transport.send(message);

			System.out.println("Mail enviado ");

		} catch (MessagingException e) {
			throw new RuntimeException("Error enviando mail", e);
		}
	}
}
