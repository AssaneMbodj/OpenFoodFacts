package fr.esigelec.jee.dao;

import java.sql.*;
import java.util.ArrayList;
import fr.esigelec.jee.Model.Produit;

public class ProduitDao extends ConnectionDao {
    public ProduitDao() {
        super();
    }

    public Produit getProduitByCode(String codeBarres) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Produit produit = null;
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM produits WHERE code_barres = ?");
            ps.setString(1, codeBarres);
            rs = ps.executeQuery();
            if (rs.next()) {
                produit = new Produit(
                    rs.getString("nom"),
                    rs.getString("ingredients"),
                    rs.getString("code_barres"),
                    rs.getString("url_photo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources (identique à CommuneDao)
        }
        return produit;
    }
}