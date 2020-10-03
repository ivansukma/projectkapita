package controllers;

import models.Entitas;
import models.ModelBuku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BukuController {
    private Connection conn = null;

    public BukuController(Connection con) {
        this.conn = con;
    }
    
    public List<Entitas> getUser() {
        List<Entitas> get = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareCall("SELECT * FROM usser");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Entitas entity = new Entitas();
                entity.setUser(resultSet.getString(1));
                entity.setPass(resultSet.getString(2));
                get.add(entity);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public List<Entitas> getPegawai() {
        List<Entitas> get = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareCall("SELECT * FROM pegawai");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Entitas entity = new Entitas();
                entity.setPegawai(resultSet.getString(1));
                entity.setPas(resultSet.getString(2));
                get.add(entity);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public boolean inputData(ModelBuku entity) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO tb_buku (isbn,judul,kategori,nama_pengarang,nama_penerbit,tahun_terbit) "
                    + "VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, entity.getIsbn());
            preparedStatement.setString(2, entity.getJudul());
            preparedStatement.setString(3, entity.getKategori());
            preparedStatement.setString(4, entity.getNamaPengarang());
            preparedStatement.setString(5, entity.getNamaPenerbit());
            preparedStatement.setString(6, entity.getTahunTerbit());
            preparedStatement.setString(7, entity.getSinopsis());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean inputuser(Entitas entity) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO usser (user,pass) "
                    + "VALUES(?,?)");
            
            preparedStatement.setString(1, entity.getUser());
            preparedStatement.setString(2, entity.getPass());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<ModelBuku> getAll() {
        List<ModelBuku> get = new ArrayList();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = conn.prepareCall("SELECT * FROM perpus_new");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ModelBuku entity = new ModelBuku();
                entity.setIsbn(resultSet.getString(1));
                entity.setJudul(resultSet.getString(2));
                entity.setKategori(resultSet.getString(3));
                entity.setNamaPengarang(resultSet.getString(4));
                entity.setNamaPenerbit(resultSet.getString(5));
                entity.setTahunTerbit(resultSet.getString(6));
                entity.setSinopsis(resultSet.getString(7));
                get.add(entity);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public List<ModelBuku> cariBuku(String judul) {
        List<ModelBuku> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM tb_buku WHERE judul LIKE '%" + judul + "%' OR nama_pengarang LIKE '%" + 
                    judul + "%' OR nama_penerbit LIKE '%" + judul + "%' OR tahun_terbit LIKE '%" + judul + "%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                ModelBuku t = new ModelBuku();
                t.setIsbn(rs.getString(1));
                t.setJudul(rs.getString(2));
                t.setKategori(rs.getString(3));
                t.setNamaPengarang(rs.getString(4));
                t.setNamaPenerbit(rs.getString(5));
                t.setTahunTerbit(rs.getString(6));
                t.setSinopsis(rs.getString(7));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public String hapus(String isbn) {
        String hasil = "Tidak Berhasil dihapus";
        String query = "DELETE FROM tb_buku WHERE isbn='" + isbn + "'";
        Statement st;
        try {
            st = conn.createStatement();
            if (st.executeUpdate(query) > 0) {
                hasil = "Berhasil dihapus";
            }
        } catch (Exception e) {
        }
        return hasil;
    }
    
    public String perbarui(String isbn, String judul, String kategori, String nama_pengarang, String nama_penerbit, 
            String tahun_terbit,String sinopsis) {
        String hasil = "Tidak Berhasil diperbarui";
        String sql = "UPDATE tb_buku SET isbn='" + isbn + "',judul='" + judul + "',kategori='" + kategori + "'"
                + ",nama_pengarang = '" + nama_pengarang + "',nama_penerbit = '" + nama_penerbit + 
                "',tahun_terbit = '" + tahun_terbit + "', sinopsis = '"+ sinopsis+"' WHERE isbn = '" + isbn + "'";
        Statement st;
        try {
            st = conn.createStatement();
            if (st.executeUpdate(sql) > 0) {
                hasil = "Berhasil diupdate";
            }
        } catch (Exception e) {
        }
        return hasil;
    }
    
}
