package com.LaEsquina.CebiSystemHub.frank;


import java.util.List;



public interface UserService {

    List<User> usuarios();
    User buscarUsuarioId(Long id);
    User guardarUsuario(User usuario);
    void cambioEstado(Long id, boolean estado);
    boolean existeCorreoElectronico(String correoElectronico);

}
