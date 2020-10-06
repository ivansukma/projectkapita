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
}