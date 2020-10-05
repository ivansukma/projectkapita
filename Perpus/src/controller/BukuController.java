/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.BukuDao;
import java.sql.Connection;
import models.Buku;
import tools.Koneksi;

/**
 *
 * @author ivanr
 */
public class BukuController {    
    String simpanBuku(String isbn, String judul,String tahun ){
        
       Koneksi simpanbukuKoneksi=new Koneksi();
            Connection c = simpanbukuKoneksi.getConnection();
            BukuDao bukuDao = new BukuDao(c);
            Buku buku = new Buku();
            buku.setIsbn(isbn);
            buku.setJudul(judul);
            buku.setTahunTerbit(tahun);
            if (bukuDao.inputData(buku))
                return "berhasil";
            else 
                return "gagal";
            
    }
}
