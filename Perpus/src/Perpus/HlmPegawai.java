package Perpus;

import DAO.Dao;
import ENTITAS.Entitas;
import KONEKSI.Koneksi;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HlmPegawai extends javax.swing.JFrame {

    public HlmPegawai() {
        initComponents();
        refresh();
        setNetralCondition();
    }

    Connection conn;
    Entitas en = new Entitas();
    Koneksi kon = new Koneksi();
    Dao dao = new Dao(kon.getConnection());
    List<Entitas> list = new ArrayList();
    List<Entitas> listt = new ArrayList();
    int total;
    
    public void refresh() {
        list = dao.getAll();
        String[][] data = new String[list.size()][6];
        int i = 0;
        for (Entitas li : list) {
            data[i][0] = li.getIsbn();
            data[i][1] = li.getJudul();
            data[i][2] = li.getKategori();
            data[i][3] = li.getNama_pengarang();
            data[i][4] = li.getNama_penerbit();
            data[i][5] = li.getTahun_terbit();
            i++;
        }
        Table1.setModel(new DefaultTableModel(data, new String[]{"ISBN", "JUDUL", "KATEGORI", "NAMA_PENGARANG",
             "NAMA_PENERBIT", "TAHUN_TERBIT"}));
    }
    
    public void setNetralCondition() {
        brshtmbl.setEnabled(true);
        brutmbl.setEnabled(false);
        hpstmbl.setEnabled(false);
        msktmbl.setEnabled(true);
    }
    
    public void setInputTableCondition() {
        brshtmbl.setEnabled(true);
        brutmbl.setEnabled(true);
        hpstmbl.setEnabled(true);
        msktmbl.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        caribuku = new javax.swing.JTextField();
        isbn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pengarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        penerbit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tahun = new javax.swing.JTextField();
        msktmbl = new javax.swing.JButton();
        hpstmbl = new javax.swing.JButton();
        brutmbl = new javax.swing.JButton();
        brshtmbl = new javax.swing.JButton();

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

        jLabel1.setText("Daftar Data Buku");

        jLabel2.setText("Cari Buku");

        caribuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caribukuKeyPressed(evt);
            }
        });

        jLabel3.setText("ISBN");

        jLabel4.setText("Data Buku");

        jLabel5.setText("Judul");

        jLabel6.setText("kategori");

        jLabel7.setText("Nama Pengarang");

        jLabel8.setText("Nama Penerbit");

        jLabel9.setText("Tahun Terbit");

        msktmbl.setText("Masukkan");
        msktmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msktmblActionPerformed(evt);
            }
        });

        hpstmbl.setText("Hapus");
        hpstmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpstmblActionPerformed(evt);
            }
        });

        brutmbl.setText("Perbarui");
        brutmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brutmblActionPerformed(evt);
            }
        });

        brshtmbl.setText("Bersihkan");
        brshtmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brshtmblActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(brshtmbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(brutmbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hpstmbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(msktmbl))
                            .addComponent(tahun)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 167, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(penerbit, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addComponent(pengarang)
                            .addComponent(kategori)
                            .addComponent(judul)
                            .addComponent(isbn))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(caribuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msktmbl)
                    .addComponent(hpstmbl)
                    .addComponent(brutmbl)
                    .addComponent(brshtmbl))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msktmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msktmblActionPerformed
        en.setIsbn(isbn.getText().toString());
        en.setJudul(judul.getText().toString());
        en.setKategori(kategori.getText().toString());
        en.setNama_pengarang(pengarang.getText().toString());
        en.setNama_penerbit(penerbit.getText().toString());
        en.setTahun_terbit(tahun.getText().toString());
        
        boolean input=dao.inputData(en);
        refresh();
        setNetralCondition();
    }//GEN-LAST:event_msktmblActionPerformed

    private void hpstmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpstmblActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Yakin Hapus?", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirm == JOptionPane.YES_OPTION) {
            String hapus = dao.hapus(isbn.getText().toString());
            refresh();
            setNetralCondition();
        }else{
            return;
        }    
    }//GEN-LAST:event_hpstmblActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        isbn.setText(Table1.getValueAt(Table1.getSelectedRow(), 0).toString());
        judul.setText(Table1.getValueAt(Table1.getSelectedRow(), 1).toString());
        kategori.setText(Table1.getValueAt(Table1.getSelectedRow(), 2).toString());
        pengarang.setText(Table1.getValueAt(Table1.getSelectedRow(), 3).toString());
        penerbit.setText(Table1.getValueAt(Table1.getSelectedRow(), 4).toString());
        tahun.setText(Table1.getValueAt(Table1.getSelectedRow(), 5).toString());
        setInputTableCondition();
    }//GEN-LAST:event_Table1MouseClicked

    private void caribukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caribukuKeyPressed
        //String katakunci = combobox.getSelectedItem().toString();
        List<Entitas> list = new ArrayList();
        Dao buku=new Dao(conn);
        list = dao.cariBuku(caribuku.getText().toString());
        String[][] data = new String[list.size()][6];
        int i = 0;
        for (Entitas li : list) {
            data[i][0] = li.getIsbn();
            data[i][1] = li.getJudul();
            data[i][2] = li.getKategori();
            data[i][3] = li.getNama_pengarang();
            data[i][4] = li.getNama_penerbit();
            data[i][5] = li.getTahun_terbit();
            i++;
        }
        Table1.setModel(new DefaultTableModel(data, new String[]{"ISBN",
            "JUDUL", "KATEGORI", "NAMA_PENGARANG", "NAMA_PENERBIT", "TAHUN_TERBIT"}));
    }//GEN-LAST:event_caribukuKeyPressed

    private void brutmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brutmblActionPerformed
        String isbnt=isbn.getText().toString();
        String judult=judul.getText().toString();
        String kategorit=kategori.getText().toString();
        String npet=pengarang.getText().toString();
        String npt=penerbit.getText().toString();
        String tht=tahun.getText().toString();
        
        String update=dao.perbarui(isbnt, judult, kategorit, npet, npt, tht);
        refresh();
        setNetralCondition();
    }//GEN-LAST:event_brutmblActionPerformed

    private void brshtmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brshtmblActionPerformed
        isbn.setText("");
        judul.setText("");
        kategori.setText("");
        pengarang.setText("");
        penerbit.setText("");
        tahun.setText("");
        setNetralCondition();
    }//GEN-LAST:event_brshtmblActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(HlmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlmPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HlmPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JButton brshtmbl;
    private javax.swing.JButton brutmbl;
    private javax.swing.JTextField caribuku;
    private javax.swing.JButton hpstmbl;
    private javax.swing.JTextField isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kategori;
    private javax.swing.JButton msktmbl;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTextField pengarang;
    private javax.swing.JTextField tahun;
    // End of variables declaration//GEN-END:variables
}
