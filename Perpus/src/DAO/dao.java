package DAO;

import ENTITAS.entitas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dao {
    private Connection conn = null;

    public dao(Connection con) {
        this.conn = con;
    }
    
    public List<entitas> getUser() {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM usser");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setUser(rs.getString(1));
                t.setPass(rs.getString(2));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public List<entitas> getPegawai() {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM pegawai");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setPegawai(rs.getString(1));
                t.setPas(rs.getString(2));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public boolean inputdata(entitas t) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO perpus_new (isbn,judul,kategori,nama_pengarang,nama_penerbit,tahun_terbit) "
                    + "VALUES(?,?,?,?,?,?)");
            ps.setString(1, t.getIsbn());
            ps.setString(2, t.getJudul());
            ps.setString(3, t.getKategori());
            ps.setString(4, t.getNama_pengarang());
            ps.setString(5, t.getNama_penerbit());
            ps.setString(6, t.getTahun_terbit());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean inputuser(entitas t) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO usser (user,pass) "
                    + "VALUES(?,?)");
            
            ps.setString(1, t.getUser());
            ps.setString(2, t.getPass());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<entitas> getall() {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM perpus_new");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setIsbn(rs.getString(1));
                t.setJudul(rs.getString(2));
                t.setKategori(rs.getString(3));
                t.setNama_pengarang(rs.getString(4));
                t.setNama_penerbit(rs.getString(5));
                t.setTahun_terbit(rs.getString(6));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public List<entitas> CariBuku(String judul) {
        List<entitas> get = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareCall("SELECT * FROM perpus_new WHERE judul LIKE '%" + judul + "%' OR nama_pengarang LIKE '%" + 
                    judul + "%' OR nama_penerbit LIKE '%" + judul + "%' OR tahun_terbit LIKE '%" + judul + "%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                entitas t = new entitas();
                t.setIsbn(rs.getString(1));
                t.setJudul(rs.getString(2));
                t.setKategori(rs.getString(3));
                t.setNama_pengarang(rs.getString(4));
                t.setNama_penerbit(rs.getString(5));
                t.setTahun_terbit(rs.getString(6));
                get.add(t);
            }
        } catch (Exception e) {
        }
        return get;
    }
    
    public String hapus(String isbn) {
        String hasil = "Tidak Berhasil dihapus";
        String query = "DELETE FROM perpus_new WHERE isbn='" + isbn + "'";
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
    
    public String Perbarui(String isbn, String judul, String kategori, String nama_pengarang, String nama_penerbit, 
            String tahun_terbit) {
        String hasil = "Tidak Berhasil diperbarui";
        String sql = "UPDATE perpus_new SET isbn='" + isbn + "',judul='" + judul + "',kategori='" + kategori + "'"
                + ",nama_pengarang = '" + nama_pengarang + "',nama_penerbit = '" + nama_penerbit + 
                "',tahun_terbit = '" + tahun_terbit + "' WHERE isbn = '" + isbn + "'";
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
