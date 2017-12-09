package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Con_SQLServer {

    static Connection con = null;
    private String Host;
    private String Nom_DB;
    private String User;
    private String Pass;

    public String getHost() {
        return Host;
    }

    public String getNom_DB() {
        return Nom_DB;
    }

    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public void setNom_DB(String Nom_DB) {
        this.Nom_DB = Nom_DB;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public static java.sql.Connection getConnection(String Host, String Nom_DB, String User, String Pass) {
        String connectionUrl = "jdbc:sqlserver://" + Host + ":1433;databaseName=" + Nom_DB;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion" + ex.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            Connection con = DriverManager.getConnection(connectionUrl, User, Pass);
            if (con != null) {
                JOptionPane.showMessageDialog(null, "CONEXION CORRECTA");

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de seguimiento en getConnection() :" + e.getMessage());
        }
        return con;
    }

}
