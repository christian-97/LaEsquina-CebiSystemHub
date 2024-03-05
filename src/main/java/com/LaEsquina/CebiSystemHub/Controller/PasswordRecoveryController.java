package com.LaEsquina.CebiSystemHub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LaEsquina.CebiSystemHub.Model.IdRequest;
import com.LaEsquina.CebiSystemHub.Model.Usuario;
import com.LaEsquina.CebiSystemHub.Service.UsuarioService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequestMapping("/recuperar-contrasena")
public class PasswordRecoveryController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/buscar")
    public ResponseEntity<Object> obtenerUsuarioPorId(@RequestBody IdRequest idRequest) {
        try {
            Long id = idRequest.getId();
            Usuario usuario = usuarioService.getUsuarioById(id);
            if (usuario != null) {
                // Aquí se envía el correo electrónico
                enviarCorreo(usuario.getCorreo(), usuario.getNombre(), usuario.getPassword());
                return ResponseEntity.ok("Correo enviado exitosamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("El ID debe ser un número.");
        }
    }

    private void enviarCorreo(String destinatario, String nombreUsuario, String contrasena) {
        // Configurar las propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        // Configurar el autenticador
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("christhiangutierrezrosas@gmail.com", "meobohnzmrsoredy");
            }
        };

        // Crear una nueva sesión de correo
        Session session = Session.getInstance(props, auth);

        try {
            // Crear un mensaje de correo
            Message message = new MimeMessage(session);
       
            
            message.setFrom(new InternetAddress("christhiangutierrezrosas@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject("Recuperación de contraseña");
            
            // Codificar el texto del mensaje con UTF-8
            String mensajeCodificado = MimeUtility.encodeText("Hola " + nombreUsuario + ",\n\n"
                    + "Tu nombre de usuario es: " + nombreUsuario + "\n"
                    + "Tu contraseña es: " + contrasena + "\n\n"
                    + "Por favor, cambia tu contraseña después de iniciar sesión.\n\n"
                    + "Saludos,", "UTF-8", "B");
            
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            
            message.setText(mensajeCodificado);


            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");

        } catch (MessagingException | UnsupportedEncodingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }

}
