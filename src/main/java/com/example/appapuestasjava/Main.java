package com.example.appapuestasjava;

import com.example.appapuestasjava.respository.Impl.UsuarioRespoitoryImpl;

public class Main {
    public static void main(String[] args) {
        UsuarioRespoitoryImpl usuarioRespoitory = new UsuarioRespoitoryImpl();
        usuarioRespoitory.updateUsuario();
    }
}
