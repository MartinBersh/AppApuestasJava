package com.example.appapuestasjava.respository;

import com.example.appapuestasjava.Usuario;

import java.sql.SQLException;

public interface UsuarioRepositpory {


    public void updateUsuario(Usuario usuario);
    public boolean validarCorreo(String email) throws SQLException;



}
