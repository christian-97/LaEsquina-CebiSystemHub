package com.LaEsquina.CebiSystemHub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
                enviarCorreo(usuario.getCorreo(), usuario.getUsername(), usuario.getPassword(),usuario.getNombre(),usuario.getApellido());
                return ResponseEntity.ok("Correo enviado exitosamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("El ID debe ser un número.");
        }
    }

    private void enviarCorreo(String destinatario, String username, String contrasena, String nombre,String apellido ) {
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
            
            String Cabecera = MimeUtility.encodeText("Recuperación de contraseña CebiSystemHub", "UTF-8", "B");
            
            message.setSubject(Cabecera);
            
            // Codificar el nombre de usuario y la contraseña con UTF-8
            String nombreUsuarioCodificado = MimeUtility.encodeText(nombre, "UTF-8", "B");
            String contrasenaCodificada = MimeUtility.encodeText(contrasena, "UTF-8", "B");
            
            
            // Construir el cuerpo del mensaje
            String cuerpoMensaje = "Estimado(a) " + nombre + " " + apellido + ",\n\n"
                    + "Espero que este mensaje te encuentre bien. Quisiera informarte que hemos recibido una solicitud para recuperar tu contraseña en nuestro sistema.\n\n"
                    + "A continuación, encontrarás tus credenciales de acceso:\n\n"
                    + "Nombre de usuario: " + username + "\n"
                    + "Contraseña: " + contrasena + "\n\n"
                    + "Por razones de seguridad, te recomendamos cambiar tu contraseña una vez que hayas iniciado sesión.\n\n"
                    + "Si no solicitaste esta acción, por favor ignora este mensaje o ponte en contacto con nuestro equipo de soporte.\n\n"
                    + "Gracias por confiar en nosotros.\n\n"
                    + "Atentamente,\n"
                    + "Cebicheria La Esquina";


                         
            message.setText(cuerpoMensaje);
            
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");


            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");

        } catch (MessagingException | UnsupportedEncodingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }

}
