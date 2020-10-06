package tools;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUser("root");
                dataSource.setPassword("");
                dataSource.setUrl("jdbc:mysql://localhost:3306/db_perpus");
                connection = dataSource.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    public static void main(String[] args) {
        System.out.println(connection);
    }
}