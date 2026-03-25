package dao;

import model.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDAO {

    public List<Fournisseur> getAllFournisseurs() {

        List<Fournisseur> list = new ArrayList<>();
        String sql = "SELECT * FROM FOURNISSEUR";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Fournisseur f = new Fournisseur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("contact")
                );
                list.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
