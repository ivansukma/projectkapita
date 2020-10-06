package views;

import controllers.BukuController;
import controllers.DetailController;
import models.ModelBuku;
import models.ModelDetail;
import tools.Koneksi;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PengunjungView extends javax.swing.JFrame {
    private Object brshtmbl;
    private Object brutmbl;
    
    public String nama;
    
    public PengunjungView() {
        initComponents();
        refresh();
        getAllDetail();
        this.setTitle("Pencarian Buku");
    }

    public PengunjungView(String na) {
        initComponents();
        refresh();
        getAllDetail();
        this.nama = na;
        buttonBaca.setEnabled(false);
    }

    Connection conn;
    ModelBuku en = new ModelBuku();
    ModelDetail md = new ModelDetail();
    Koneksi kon = new Koneksi();
    
    BukuController dao = new BukuController(kon.getConnection());
    DetailController daoDetail = new DetailController(kon.getConnection());
    
    List<ModelBuku> list = new ArrayList();
    List<ModelBuku> listt = new ArrayList();
    List<ModelDetail> listDet = new ArrayList();
    
    int total;
    int indeks;
    int countDetail;
    boolean isShow = false;
    
    public void refresh() {
        list = dao.getAll();
        String[][] data = new String[list.size()][7];
        int i = 0;
        for (ModelBuku li : list) {
            data[i][0] = li.getIsbn();
            data[i][1] = li.getJudul();
            data[i][2] = li.getKategori();
            data[i][3] = li.getNamaPengarang();
            data[i][4] = li.getNamaPenerbit();
            data[i][5] = li.getTahunTerbit();
            data[i][6] = li.getSinopsis();
            i++;
        }
        
        Table1.setModel(new DefaultTableModel(data, new String[]{"ISBN", "JUDUL", "KATEGORI", "NAMA_PENGARANG"}));
    }
    
    public void getAllDetail() {
        listDet = daoDetail.getAllDetail();
        String[][] data = new String[listDet.size()][4];
        int i = 0;
        for (ModelDetail md : listDet) {
            data[i][0] = md.getId();
            data[i][1] = md.getJudul();
            data[i][2] = md.getNamaUser();
            data[i][3] = md.getTgl();
            
            System.out.print(data[i][0]);
            System.out.print(data[i][1]);
            System.out.print(data[i][2]);
            System.out.println(data[i][3]);
            
            i++;
        }
        this.countDetail = i;
        
        if(isShow) {
            tabelDetail.setModel(new DefaultTableModel(data, new String[]{"Id", "Judul", "NamaUser", "Tanggal"}));
            isShow = false;
        }
    }
    
    public void getDetailBuku() {
        List<ModelDetail> dataDet = new ArrayList();
        DetailController detail = new DetailController(conn);
        dataDet = daoDetail.lihatRecord(judul.getText().toString());
        
        String[][] data = new String[list.size()][4];
        int i = 0;
        for(ModelDetail dd : dataDet) {
            data[i][0] = dd.getId();
            data[i][1] = dd.getJudul();
            data[i][2] = dd.getNamaUser();
            data[i][3] = dd.getTgl();
            i++;
        }
        
        tabelDetail.setModel(new DefaultTableModel(data, new String[]{"Id", "Judul", "NamaUser", "Tanggal"}));
    }
    
    public void clearField() {
        isbn.setText("");
        judul.setText("");
        kategori.setText("");
        pengarang.setText("");
        penerbit.setText("");
        tahun.setText("");
        textSinopsis.setText("");
        
        buttonBaca.setEnabled(false);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        caribuku = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        judul = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pengarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        penerbit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tahun = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textSinopsis = new javax.swing.JTextArea();
        buttonBaca = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelDetail = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Selamat Datang Di Menu Pencarian Buku");

        caribuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caribukuKeyPressed(evt);
            }
        });

        jLabel2.setText("Cari Buku");

        isbn.setEditable(false);

        judul.setEditable(false);

        jLabel3.setText("ISBN");

        jLabel5.setText("Judul");

        jLabel6.setText("kategori");

        kategori.setEditable(false);

        jLabel7.setText("Nama Pengarang");

        pengarang.setEditable(false);

        jLabel8.setText("Nama Penerbit");

        penerbit.setEditable(false);

        jLabel9.setText("Tahun Terbit");

        tahun.setEditable(false);

        jLabel4.setText("Data Buku");

        jLabel10.setText("Sinopsis");

        textSinopsis.setEditable(false);
        textSinopsis.setColumns(20);
        textSinopsis.setRows(5);
        jScrollPane2.setViewportView(textSinopsis);

        buttonBaca.setText("Baca");
        buttonBaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(89, 89, 89)
                        .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(judul))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonBaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(buttonBaca)
                .addContainerGap())
        );

        jLabel11.setText("Record Buku");

        tabelDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelDetail);

        jButton1.setText("Lihat Semua");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
       buttonBaca.setEnabled(true);
        
        indeks = Table1.getSelectedRow();
        ModelBuku dataBuku = list.get(indeks);
        
        isbn.setText(dataBuku.getIsbn());
        judul.setText(dataBuku.getJudul());
        kategori.setText(dataBuku.getKategori());
        pengarang.setText(dataBuku.getNamaPengarang());
        penerbit.setText(dataBuku.getNamaPenerbit());
        tahun.setText(dataBuku.getTahunTerbit());
        textSinopsis.setText(dataBuku.getSinopsis());
        
        getDetailBuku();
    }//GEN-LAST:event_Table1MouseClicked

    private void caribukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caribukuKeyPressed
        //String katakunci = combobox.getSelectedItem().toString();
         List<ModelBuku> list = new ArrayList();
        BukuController buku=new BukuController(conn);
        list = dao.cariBuku(caribuku.getText().toString());
        String[][] data = new String[list.size()][7];
        int i = 0;
        for (ModelBuku li : list) {
            data[i][0] = li.getIsbn();
            data[i][1] = li.getJudul();
            data[i][2] = li.getKategori();
            data[i][3] = li.getNamaPengarang();
            data[i][4] = li.getNamaPenerbit();
            data[i][5] = li.getTahunTerbit();
            data[i][6] = li.getSinopsis();
            i++;
        }
        Table1.setModel(new DefaultTableModel(data, new String[]{"ISBN",
            "JUDUL", "KATEGORI", "NAMA_PENGARANG", "NAMA_PENERBIT", "TAHUN_TERBIT"}));
    }//GEN-LAST:event_caribukuKeyPressed

    private void buttonBacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBacaActionPerformed
        getDetailBuku();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        
        String id = String.valueOf(this.countDetail+1);
        md.setId(id);
        md.setJudul(judul.getText().toString());
        md.setNamaUser(this.nama);
        md.setTgl(formatter.format(date));
        
        boolean input = daoDetail.inputuser(md);
        getAllDetail();
        getDetailBuku();
        
        clearField();
    }//GEN-LAST:event_buttonBacaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.isShow = true;
        getAllDetail();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
      
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PengunjungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengunjungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengunjungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengunjungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengunjungView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton buttonBaca;
    private javax.swing.JTextField caribuku;
    private javax.swing.JTextField isbn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kategori;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTextField pengarang;
    private javax.swing.JTable tabelDetail;
    private javax.swing.JTextField tahun;
    private javax.swing.JTextArea textSinopsis;
    // End of variables declaration//GEN-END:variables
}
