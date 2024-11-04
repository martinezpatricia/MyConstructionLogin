package com.myconstruction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public boolean validarUsuario(String username, String password) {
        String sql = "SELECT * FROM clientes WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Si hay un resultado, el usuario es válido.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
}
}