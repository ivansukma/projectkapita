package controllers;

import models.ModelPegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PegawaiController {
    Connection conn;
    public PegawaiController(Connection con) {
        this.conn = con;
    }
    
    public List<ModelPegawai> getPegawai() {
        List<ModelPegawai> get = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareCall("SELECT * FROM tb_pegawai");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ModelPegawai entity = new ModelPegawai();
                entity.setPegawai(resultSet.getString(1));
                entity.setPas(resultSet.getString(2));
                get.add(entity);
            }
        } catch (Exception e) {
        }
        return get;
    }
}
