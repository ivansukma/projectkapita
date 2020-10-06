package controller;

import daos.BukuDao;
import java.sql.Connection;
import java.util.ArrayList;
import models.Buku;
import tools.Koneksi;
import java.util.List;

public class BukuController {
    
    public String inputDataBuku(String isbn, String judul, String kategori, String NamaPenerbit,String NamaPengarang,String Sinopsis,String TahunTerbit) {
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        BukuDao bukuDao = new BukuDao(conn);
        Buku buku = new Buku();
        buku.setIsbn(isbn);
        buku.setJudul(judul);
        buku.setKategori(kategori);
        buku.setNamaPenerbit(NamaPenerbit);
        buku.setNamaPengarang(NamaPengarang);
        buku.setSinopsis(Sinopsis);
        buku.setTahunTerbit(TahunTerbit);
        if(bukuDao.inputData(buku)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public String updateBuku(String isbn, String judul, String kategori, String NamaPenerbit,String NamaPengarang,String Sinopsis,String TahunTerbit) {
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        BukuDao bukuDao = new BukuDao(conn);
        Buku buku = new Buku();
        buku.setIsbn(isbn);
        buku.setJudul(judul);
        buku.setKategori(kategori);
        buku.setNamaPenerbit(NamaPenerbit);
        buku.setNamaPengarang(NamaPengarang);
        buku.setSinopsis(Sinopsis);
        buku.setTahunTerbit(TahunTerbit);
        if(bukuDao.perbarui(buku)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public String hapusBuku(String isbn) {
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        BukuDao bukuDao = new BukuDao(conn);
        if (bukuDao.hapus(isbn)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public List<Buku> cariBuku(String judul) {
        List<Buku> lb = new ArrayList();
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        BukuDao bukuDao = new BukuDao(conn);
        lb = bukuDao.cariBuku(judul);
        if(lb != null) {
            System.out.println("Success");
            return lb;
        }else {
            System.out.println("Fail");
            return null;
        }
    }
    
    public List<Buku> getBuku() {
        List<Buku> lb = new ArrayList();
        Koneksi inputBuku = new Koneksi();
        Connection conn = inputBuku.getConnection();
        BukuDao bukuDao = new BukuDao(conn);
        lb = bukuDao.getAll();
        if (lb != null) {
            System.out.println("Success");
            return lb;
        } else {
            System.out.println("Fail");
            return null;
        }
    }
}