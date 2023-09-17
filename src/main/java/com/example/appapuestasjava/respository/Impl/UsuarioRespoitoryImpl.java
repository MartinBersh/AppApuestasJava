package com.example.appapuestasjava.respository.Impl;

import com.example.appapuestasjava.ConexionDB;
import com.example.appapuestasjava.Usuario;
import com.example.appapuestasjava.respository.UsuarioRepositpory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRespoitoryImpl implements UsuarioRepositpory {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    private Usuario createUsuario(ResultSet resultSet) throws
            SQLException {
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(resultSet.getLong("id"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setEstado(resultSet.getInt("estado"));
        usuario.setSaldo(resultSet.getInt("saldo"));

        return usuario;
    }


    @Override
    public boolean validarCorreo(String email) throws SQLException {
        boolean validar = true;
        int count = 0;
        String sql;
        sql = "SELECT COUNT(*) AS rowcount FROM usuario WHERE usuario.email = ?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1,email);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            count = rs.getInt("rowcount");
        }
        if (count > 0){
            validar = false;
        }
        return validar;
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        String sql;
        if (usuario.getId_Usuario() != null && usuario.getId_Usuario() > 0) {
            sql = "UPDATE Usuarios SET name=?, email=? WHERE id_Usuario=?";
        } else {
            sql = "INSERT INTO Usuarios (name, email) VALUES(?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());

            if (usuario.getId_Usuario() != null && usuario.getId_Usuario() > 0) {
                stmt.setLong(3, usuario.getId_Usuario());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
