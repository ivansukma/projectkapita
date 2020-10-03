package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ModelDetail;

public class DetailController {
    private Connection conn;
    
    public DetailController(Connection con) {
        this.conn = con;
    }
    
        public boolean inputuser(ModelDetail entity) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO tb_detail_userbuku (id, nama_user, judul, ) "
                    + "VALUES(?,?,?, GETDATE())");
            
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getNamaUser());
            preparedStatement.setString(3, entity.getJudul());
            preparedStatement.setString(4, entity.getTgl());
            
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public List<ModelDetail> lihatRecord(String judul) {
        List<ModelDetail> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM tb_detail_userbuku WHERE nama_user LIKE '%" + judul + "%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                ModelDetail mdtl = new ModelDetail();
                mdtl.setId(rs.getInt(1));
                mdtl.setNamaUser(rs.getString(2));
                mdtl.setJudul(rs.getString(3));
                mdtl.setTgl(rs.getString(4));
                get.add(mdtl);
            }
        } catch (Exception e) {
        }
        return get;
    }
}
