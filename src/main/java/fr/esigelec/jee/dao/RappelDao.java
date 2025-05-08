package fr.esigelec.jee.dao;

import java.sql.*;
import java.util.ArrayList;
import fr.esigelec.jee.Model.Rappel;

public class RappelDao extends ConnectionDao {
    public RappelDao() {
        super();
    }

    public ArrayList<Rappel> getRappelsRecents() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Rappel> rappels = new ArrayList<>();
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM rappels ORDER BY date_rappel DESC");
            while (rs.next()) {
                rappels.add(new Rappel(
                    rs.getDate("date_rappel"),
                    rs.getString("motif"),
                    rs.getString("marque")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources
        }
        return rappels;
    }
}