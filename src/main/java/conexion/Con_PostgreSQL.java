package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Con_PostgreSQL {

    static java.sql.Connection con = null;

    public static java.sql.Connection getConPostgreSQL(String Host, String Nom_DB, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            String connectString = "jdbc:postgresql://" + Host + ":5432/" + Nom_DB;
            Connection con = DriverManager.getConnection(connectString, user, pass);
            if (con != null) {
                JOptionPane.showMessageDialog(null, "CONEXION CORRECTA");
            }
            con.close();

        } catch (Exception e) {
            e.getStackTrace();
            JOptionPane.showMessageDialog(null, "Error de seguimiento en getConnection() :" + e.getMessage());
        }
        return con;
    }
}
