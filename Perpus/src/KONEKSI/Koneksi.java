package KONEKSI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    
    public Connection con = null;
    public String Driver;
    public String url;
    public String user;
    public String pass;
    
    public Koneksi(){
        Driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/db_perpus";
        user = "root";
        pass = "";
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Connection getConnection(){
        return this.con;
    }
    
    public static void main(String[] args) {
        Koneksi kon = new Koneksi();
        System.out.println(kon.getConnection());
    }
}
