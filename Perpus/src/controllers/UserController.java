package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ModelUser;

public class UserController {
    private Connection conn = null;
    
    public UserController(Connection con){
        this.conn = con;
    }
    
    public List<ModelUser> getUser() {
        List<ModelUser> get = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareCall("SELECT * FROM tb_user");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ModelUser entity = new ModelUser();
                entity.setUsername(resultSet.getString(1));
                entity.setPassword(resultSet.getString(2));
                get.add(entity);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return get;
    }
    
    public boolean inputuser(ModelUser entity) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO tb_user (user, pass, email, no_handphone) "
                    + "VALUES(?,?,?,?)");
            
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getNoTelp());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
