package dao;

import java.sql.*;
import model.Utilisateur;

public class UtilisateurDAO {
	public Utilisateur login(String username, String password) {
        String sql = "SELECT * FROM UTILISATEUR WHERE username=? AND password_hash=?";
        try {
        	Connection conn = DBConnection.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
        	ps.setString(1, username);
        	ps.setString(2, password);
        	ResultSet rs = ps.executeQuery();
        	if (rs.next()) {
                return new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password_hash"),
                    rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
       
}
