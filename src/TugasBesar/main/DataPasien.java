package TugasBesar.main;

import TugasBesar.Entity.Pasien;
import TugasBesar.Implement.PasienImplement;
import TugasBesar.Interfaces.PasienInterfaces;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataPasien extends javax.swing.JFrame {

    /**
     * Creates new form DataPasien
     */
    Pasien ap = new Pasien();
    List<Pasien> record = new ArrayList<>();
    List<Pasien> recordDataPasien = new ArrayList<>();
    PasienInterfaces dbServices;
   
    int row;
    static int no_antrian;

    DefaultTableModel model;

    void load(String nama) {
        try {
            record = dbServices.getAll(nama + "");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void isiTabel() {
        jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        Object data[][] = new Object[record.size()][6];
        int i = 0;
        for (Pasien ap : record) {
            data[i][0] = ap.getNo_antrian();
            data[i][1] = ap.getId_pasien();
            data[i][2] = ap.getNama().toUpperCase();
            data[i][3] = ap.getTgl_lahir();
            data[i][4] = ap.getGender();
            data[i][5] = ap.getAlamat();
            i++;

        }

        String judul[] = {"No Antrian", "Id Pasien", "Nama Lengkap", "Tgl Lahir", "Gender", "Alamat"};
        jTable3.setModel(new DefaultTableModel(data, judul));
    }

    void initAwal() {
        load("");
        isiTabel();
    }

    void bersihkan() {
        idpasien.setText("");
        nama.setText("");
        tgl_lahir.setText("");
        gender.setText("");
        alamat.setText("");
    }

    void setUtilityEdit() {
        ap.setId_pasien(idpasien.getText());
        ap.setNama(nama.getText());
        ap.setTgl_lahir(tgl_lahir.getText());
        ap.setGender(gender.getText());
        ap.setAlamat(alamat.getText());
    }

    public DataPasien() {
        initComponents();

        setTitle("Data Pasien");
        setResizable(false);
        setLocationRelativeTo(null);

        dbServices = new PasienImplement();
        initAwal();
        jTable3.getSelectionModel().
                addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        row = jTable3.getSelectedRow();
                        if (row != -1) {
                            Pasien ap = record.get(row);
                            no_antrian = ap.getNo_antrian();
                            System.out.println("noAntre:" + no_antrian);
                            idpasien.setText(ap.getId_pasien() + "");
                            nama.setText(ap.getNama() + "");
                            tgl_lahir.setText(ap.getTgl_lahir() + "");
                            gender.setText(ap.getGender() + "");
                            alamat.setText(ap.getAlamat() + "");
                        }
                    }
                });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idpasien = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        tgl_lahir = new javax.swing.JTextField();
        gender = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        EDIT = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jButton3_HAPUS = new javax.swing.JButton();
        jButton1_CARI = new javax.swing.JButton();
        tempatcari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        KELUAR = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA ANTRIAN PASIEN");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(592, 614));
        setResizable(false);
        setSize(new java.awt.Dimension(592, 612));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("HEALTHCHART");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(445, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 590, 40);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nama :");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Pasien :");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tgl Lahir :");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gender :");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Alamat :");

        idpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpasienActionPerformed(evt);
            }
        });

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        tgl_lahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_lahirActionPerformed(evt);
            }
        });

        gender.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        EDIT.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        EDIT.setText("EDIT");
        EDIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EDITMouseClicked(evt);
            }
        });
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });

        simpan.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        jButton3_HAPUS.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton3_HAPUS.setText("HAPUS");
        jButton3_HAPUS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3_HAPUSMouseClicked(evt);
            }
        });
        jButton3_HAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_HAPUSActionPerformed(evt);
            }
        });

        jButton1_CARI.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton1_CARI.setText("CARI");
        jButton1_CARI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1_CARIMouseClicked(evt);
            }
        });
        jButton1_CARI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_CARIActionPerformed(evt);
            }
        });

        tempatcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempatcariActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No Antrian", "Id Pasien", "Nama", "Tgl Lahir", "Gender", "Alamat"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        KELUAR.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        KELUAR.setText("KELUAR");
        KELUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KELUARActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jButton1.setText("BERSIHKAN");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATA ANTRIAN PASIEN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel5))))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idpasien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl_lahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3_HAPUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EDIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(KELUAR)))
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tempatcari, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1_CARI, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idpasien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(EDIT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(simpan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton3_HAPUS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempatcari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1_CARI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(KELUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(662, 662, 662))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 40, 590, 580);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        ap.setId_pasien(idpasien.getText());
        ap.setNama(nama.getText());
        ap.setTgl_lahir(tgl_lahir.getText());
        ap.setGender(gender.getText());
        ap.setAlamat(alamat.getText());

        try {
            dbServices.insert(ap);
            JOptionPane.showMessageDialog(null, "Data Tersimpan.");
            bersihkan();
            initAwal();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Cek Inputan Anda");
        }
    }//GEN-LAST:event_simpanActionPerformed


    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void tgl_lahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_lahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_lahirActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void idpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpasienActionPerformed

    private void KELUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KELUARActionPerformed
        Register rg = new Register();
        rg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_KELUARActionPerformed

    private void jButton3_HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_HAPUSActionPerformed
        int hapus = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus data ini ?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (hapus == JOptionPane.YES_OPTION) {
            int no = no_antrian;
            try {
                dbServices.delete(no);
            } catch (SQLException ex) {
                Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, ex);
            }
            initAwal();
            bersihkan();
        }


    }//GEN-LAST:event_jButton3_HAPUSActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void jButton1_CARIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_CARIActionPerformed
        load(tempatcari.getText().toString());
        isiTabel();        
    }//GEN-LAST:event_jButton1_CARIActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

    }//GEN-LAST:event_jTable3MouseClicked

    private void tempatcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempatcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempatcariActionPerformed

    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
        
        try {
//            setUtilityEdit();
//Pasien p = new Pasien();
//p.setNo_antrian(no_antrian);
        ap.setNo_antrian(no_antrian);
            ap.setId_pasien(idpasien.getText());
            ap.setNama(nama.getText());
            ap.setTgl_lahir(tgl_lahir.getText());
            ap.setGender(gender.getText());
            ap.setAlamat(alamat.getText());
            
            System.out.println("ap no:" + ap.getNo_antrian());
            System.out.println("ap id:" + ap.getId_pasien());
            System.out.println("ap tgl:" + ap.getTgl_lahir());
            System.out.println("ap nm:" + ap.getNama());
            System.out.println("ap alm:" + ap.getAlamat());
            System.out.println("ap gdr:" + ap.getGender());
            try {
                dbServices.update(ap);
                initAwal();
                bersihkan();
                JOptionPane.showMessageDialog(null, "Data Tersimpan !");
            } catch (SQLException ex) {
                Logger.getLogger(DataPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error !");
        }
    }//GEN-LAST:event_EDITActionPerformed

    private void EDITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMouseClicked
        try {
            String sql = "UPDATE pasien SET id_pasien='" + idpasien.getText() + "',nama ='" + nama.getText()
                    + "',tgl_lahir='" + tgl_lahir.getText() + "',gender='" + gender.getText() + "',alamat='" + alamat.getText() + "' WHERE id_pasien='" + idpasien.getText() + "'";

            JOptionPane.showMessageDialog(null, "Berhasil Edit");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_EDITMouseClicked

    private void jButton3_HAPUSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3_HAPUSMouseClicked
        int hapus = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data ini?",
                "konfirmasi", JOptionPane.YES_NO_OPTION);

        if (hapus == JOptionPane.YES_OPTION) {
            int no = no_antrian;
            try {
                dbServices.delete(no);

            } catch (SQLException ex) {
                Logger.getLogger(DataPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
            initAwal();
            bersihkan();

        }
    }//GEN-LAST:event_jButton3_HAPUSMouseClicked

    private void jButton1_CARIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1_CARIMouseClicked

    }//GEN-LAST:event_jButton1_CARIMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        bersihkan();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPasien().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EDIT;
    private javax.swing.JButton KELUAR;
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField gender;
    private javax.swing.JTextField idpasien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1_CARI;
    private javax.swing.JButton jButton3_HAPUS;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField nama;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField tempatcari;
    private javax.swing.JTextField tgl_lahir;
    // End of variables declaration//GEN-END:variables
}
