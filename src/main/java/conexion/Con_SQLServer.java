package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Con_SQLServer {

    static java.sql.Connection con = null;

    public static java.sql.Connection getConnection(String Host, String Nom_DB, String User, String Pass) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectionUrl = "jdbc:jtds:sqlserver://" + Host + ":1433;databaseName=" + Nom_DB + ";";
            Connection con = DriverManager.getConnection(connectionUrl, User, Pass);
            if (con != null) {
                JOptionPane.showMessageDialog(null, "CONEXION CORRECTA");

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro de seguimiento en getConnection() :" + e.getMessage());
        }
        return con;
    }

}
