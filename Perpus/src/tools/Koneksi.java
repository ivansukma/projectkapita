package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Koneksi {
    
    public Connection con = null;
    
    public Koneksi(){
        try
        {
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_perpus","root","");
            JOptionPane.showMessageDialog(null,"connected with "+con.toString());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"not connect to server and message is"+e.getMessage());
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
