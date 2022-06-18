package crewcutbarbershop.view;

import crewcutbarbershop.swing.MyTextField;
import crewcutbarbershop.swing.MyPasswordField;
import crewcutbarbershop.swing.Button;
import crewcutbarbershop.controller.PelangganController;
import crewcutbarbershop.entitas.Pelanggan;
import crewcutbarbershop.error.PelangganException;
import crewcutbarbershop.event.PelangganListener;
import crewcutbarbershop.model.PelangganModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;

public class PanelRegisterdanPesan extends javax.swing.JLayeredPane implements PelangganListener{

    private PelangganModel model;
    private PelangganController controller;
    PesanPelanggan rmh = new PesanPelanggan();
    
    public PanelRegisterdanPesan(ActionListener eventRegister) {
        initComponents();
        initRegister(eventRegister);
        initLogin();
        
        model = new PelangganModel();
        model.setListener(this);
        
        controller = new PelangganController();
        controller.setModel(model);
        
        pPesan.setVisible(false);
        pRegister.setVisible(true);
        
        nonaktif();
        bHitung.setEnabled(false);
    }
    
    void aktif(){
        cmdata.setEnabled(true);
        cbgroom.setEnabled(true);
        cbsmooth.setEnabled(true);
        cbhair.setEnabled(true);
        rbbca.setEnabled(true);
        rbbl.setEnabled(true);
        thrg.setEnabled(true);
        tbca.setEnabled(true);
        ttot.setEnabled(true);
        tbl.setEnabled(true);
}
    void bersih(){
        cmdata.setSelectedItem("PILIH");
        cbgroom.setSelected(false);
        cbhair.setSelected(false);
        cbsmooth.setSelected(false);
        bg.clearSelection();
        thrg.setText("");
        tbca.setText("");
        tbl.setText("");
        ttot.setText("");
}
    void nonaktif(){
        cmdata.setEnabled(false);
        cbgroom.setEnabled(false);
        cbsmooth.setEnabled(false);
        cbhair.setEnabled(false);
        rbbca.setEnabled(false);
        rbbl.setEnabled(false);
        thrg.setEnabled(false);
        tbca.setEnabled(false);
        ttot.setEnabled(false);
        tbl.setEnabled(false);
}
    MyTextField txtId = new MyTextField();
    MyTextField txtNama = new MyTextField();
    MyTextField txtEmail = new MyTextField();
    MyTextField txtPassword = new MyTextField();
    MyTextField txtAlamat = new MyTextField();
    MyTextField txtTelepon = new MyTextField();

    public MyTextField gettxtId() {
        return txtId;
    }
    
    public MyTextField gettxtNama() {
        return txtNama;
    }

    public MyTextField gettxtEmail() {
        return txtEmail;
    }

    public MyTextField gettxtPassword() {
        return txtPassword;
    }

    public MyTextField gettxtAlamat() {
        return txtAlamat;
    }

    public MyTextField gettxtTelepon() {
        return txtTelepon;
    }

    private void initRegister(ActionListener eventRegister){
        pRegister.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]10[]10[]15[]push"));
        // judul
        JLabel label = new JLabel("CrewCut Barbershop");
        JLabel label1 = new JLabel("Buat Akun");
        label.setFont(new Font("sansserif",1 ,30));
        label1.setFont(new Font("sansserif",1 ,16));
        label.setForeground(new Color(7, 164,121));
        label1.setForeground(new Color(7, 164,121));
        pRegister.add(label);
        pRegister.add(label1);
        
        // field id
        txtId.setPrefixIcon(new ImageIcon(getClass().getResource("/crewcutbarbershop/icon/user.png")));
        txtId.setHint("Id");
        txtId.setEditable(false);
        txtId.setBackground(new Color(224, 250, 238));
        pRegister.add(txtId, "w 60%");
        
        // field nama    
        txtNama.setPrefixIcon(new ImageIcon(getClass().getResource("/crewcutbarbershop/icon/user.png")));
        txtNama.setHint("Nama");
        pRegister.add(txtNama, "w 60%");
                
        // field email
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/crewcutbarbershop/icon/mail.png")));
        txtEmail.setHint("Email");
        pRegister.add(txtEmail, "w 60%");
        
        // field password
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/crewcutbarbershop/icon/pass.png")));
        txtPassword.setHint("Password");
        pRegister.add(txtPassword, "w 60%");
        
        // field alamat
        txtAlamat.setPrefixIcon(new ImageIcon(getClass().getResource("/crewcutbarbershop/icon/location.png")));
        txtAlamat.setHint("Alamat");
        pRegister.add(txtAlamat, "w 60%");
        
        // field telepon
        txtTelepon.setPrefixIcon(new ImageIcon(getClass().getResource("/crewcutbarbershop/icon/phone.png")));
        txtTelepon.setHint("Telepon");
        pRegister.add(txtTelepon, "w 60%");
        
        // button
        Button cnddaftar = new Button();
        cnddaftar.setBackground(new Color(7, 164,121));
        cnddaftar.setForeground(new Color(255, 255, 255));
        cnddaftar.setText("Daftar");
        pRegister.add(cnddaftar, "w 40%, h 10%");
        cnddaftar.addActionListener(eventRegister);
        cnddaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    daftarButton();
                } catch (PelangganException ex) {
                    Logger.getLogger(PanelRegisterdanPesan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelRegisterdanPesan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void daftarButton() throws PelangganException, SQLException{
        controller.insertPelanggan(this);
        controller.resetPelanggan(this);
    }
    
    private void initLogin(){
       
    }
        
    public void showRegister(boolean show){
        if(show){
            pRegister.setVisible(true);
            pPesan.setVisible(false);
        }else{
            pRegister.setVisible(false);
            pPesan.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        pPesan = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        ttot = new javax.swing.JTextField();
        bHitung = new javax.swing.JButton();
        bBersih = new javax.swing.JButton();
        bKeluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pData = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmdata = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        thrg = new javax.swing.JTextField();
        pPaket = new javax.swing.JPanel();
        cbgroom = new javax.swing.JCheckBox();
        cbhair = new javax.swing.JCheckBox();
        cbsmooth = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pPayment = new javax.swing.JPanel();
        rbbca = new javax.swing.JRadioButton();
        rbbl = new javax.swing.JRadioButton();
        tbca = new javax.swing.JTextField();
        tbl = new javax.swing.JTextField();
        pRegister = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        pPesan.setBackground(new java.awt.Color(255, 255, 255));

        judul.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        judul.setText("Total");

        ttot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotActionPerformed(evt);
            }
        });

        bHitung.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        bHitung.setText("Hitung");
        bHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHitungActionPerformed(evt);
            }
        });

        bBersih.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        bBersih.setText("Bersih");
        bBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBersihActionPerformed(evt);
            }
        });

        bKeluar.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        bKeluar.setText("Keluar");
        bKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKeluarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CrewCut Barbershop");

        pData.setBackground(new java.awt.Color(85, 239, 196));
        pData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        pData.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tipe");

        cmdata.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Reguler", "Premier" }));
        cmdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdataActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Harga");

        thrg.setEditable(false);
        thrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pDataLayout = new javax.swing.GroupLayout(pData);
        pData.setLayout(pDataLayout);
        pDataLayout.setHorizontalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(57, 57, 57)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(thrg)
                    .addComponent(cmdata, 0, 184, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDataLayout.setVerticalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmdata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(thrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPaket.setBackground(new java.awt.Color(85, 239, 196));
        pPaket.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paket", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        pPaket.setForeground(new java.awt.Color(0, 0, 0));
        pPaket.setPreferredSize(new java.awt.Dimension(403, 122));

        cbgroom.setBackground(new java.awt.Color(85, 239, 196));
        cbgroom.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cbgroom.setText("Grooming");
        cbgroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbgroomActionPerformed(evt);
            }
        });

        cbhair.setBackground(new java.awt.Color(85, 239, 196));
        cbhair.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cbhair.setText("Hair Coloring");
        cbhair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhairActionPerformed(evt);
            }
        });

        cbsmooth.setBackground(new java.awt.Color(85, 239, 196));
        cbsmooth.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cbsmooth.setText("Smoothing");
        cbsmooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsmoothActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel5.setText("Rp. 50.000");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel6.setText("Rp. 125.000");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel7.setText("Rp. 200.000");

        javax.swing.GroupLayout pPaketLayout = new javax.swing.GroupLayout(pPaket);
        pPaket.setLayout(pPaketLayout);
        pPaketLayout.setHorizontalGroup(
            pPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPaketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbgroom)
                    .addComponent(cbhair)
                    .addComponent(cbsmooth))
                .addGap(38, 38, 38)
                .addGroup(pPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPaketLayout.setVerticalGroup(
            pPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPaketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbgroom)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbhair)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbsmooth)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPayment.setBackground(new java.awt.Color(85, 239, 196));
        pPayment.setBorder(javax.swing.BorderFactory.createTitledBorder("Cara Pembayaran"));
        pPayment.setPreferredSize(new java.awt.Dimension(403, 122));

        rbbca.setBackground(new java.awt.Color(85, 239, 196));
        bg.add(rbbca);
        rbbca.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        rbbca.setText("Bank BCA");
        rbbca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbbcaActionPerformed(evt);
            }
        });

        rbbl.setBackground(new java.awt.Color(85, 239, 196));
        bg.add(rbbl);
        rbbl.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        rbbl.setText("Other Bank");
        rbbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbblActionPerformed(evt);
            }
        });

        tbca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPaymentLayout = new javax.swing.GroupLayout(pPayment);
        pPayment.setLayout(pPaymentLayout);
        pPaymentLayout.setHorizontalGroup(
            pPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbbca)
                    .addComponent(rbbl))
                .addGap(47, 47, 47)
                .addGroup(pPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbca, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pPaymentLayout.setVerticalGroup(
            pPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbbca)
                    .addComponent(tbca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbbl)
                    .addComponent(tbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pPesanLayout = new javax.swing.GroupLayout(pPesan);
        pPesan.setLayout(pPesanLayout);
        pPesanLayout.setHorizontalGroup(
            pPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPesanLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPesanLayout.createSequentialGroup()
                        .addComponent(bHitung)
                        .addGap(44, 44, 44)
                        .addComponent(bBersih)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPesanLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bKeluar)
                            .addGroup(pPesanLayout.createSequentialGroup()
                                .addComponent(judul)
                                .addGap(58, 58, 58)
                                .addComponent(ttot, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pPesanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(pPaket, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(pData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPesanLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pPesanLayout.setVerticalGroup(
            pPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPesanLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(pData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(judul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bHitung)
                    .addComponent(bBersih)
                    .addComponent(bKeluar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(pPesan, "card3");

        pRegister.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pRegisterLayout = new javax.swing.GroupLayout(pRegister);
        pRegister.setLayout(pRegisterLayout);
        pRegisterLayout.setHorizontalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pRegisterLayout.setVerticalGroup(
            pRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        add(pRegister, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void ttotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotActionPerformed

    private void bHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHitungActionPerformed
        thrg.setText(Double.toString(rmh.getHrg()));
        ttot.setText(Double.toString(rmh.getTotal()));
    }//GEN-LAST:event_bHitungActionPerformed

    private void bBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBersihActionPerformed
        bersih();
        aktif();
        bHitung.setEnabled(true);
    }//GEN-LAST:event_bBersihActionPerformed

    private void bKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKeluarActionPerformed
        int x;
        x = JOptionPane.showConfirmDialog(null, "Yakin mau keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION){
            System.exit(0);
        }else{
            return;
        }
    }//GEN-LAST:event_bKeluarActionPerformed

    private void cmdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdataActionPerformed
        rmh.setKelas(cmdata.getSelectedItem().toString());
        rmh.setSeleksiKelas();
        thrg.setText(Double.toString(rmh.getHrg()));
    }//GEN-LAST:event_cmdataActionPerformed

    private void rbbcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbbcaActionPerformed
        if(!rbbca.isSelected()){
        }
        
        rmh.setCara(rbbca.getText());
        rmh.setSeleksiCara();
        tbca.setText(Double.toString(rmh.getBiaya()));
    }//GEN-LAST:event_rbbcaActionPerformed

    private void rbblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbblActionPerformed
        rmh.setCara(rbbl.getText());
        rmh.setSeleksiCara();
        tbl.setText(Double.toString(rmh.getBiaya()));
    }//GEN-LAST:event_rbblActionPerformed

    private void cbgroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbgroomActionPerformed
        String g;

        if(cbgroom.isSelected()){
            g = cbgroom.getText();
            rmh.setGroom(g);
            rmh.getGroom();
        }else{
            g = " ";
            rmh.setGroom(g);
            rmh.getGroom();
        }
    }//GEN-LAST:event_cbgroomActionPerformed

    private void cbhairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhairActionPerformed
        String h;

        if(cbhair.isSelected()){
            h = cbhair.getText();
            rmh.setHair(h);
            rmh.getHair();
        }else{
            h = " ";
            rmh.setHair(h);
            rmh.getHair();
        }
    }//GEN-LAST:event_cbhairActionPerformed

    private void cbsmoothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsmoothActionPerformed
        String s;

        if(cbsmooth.isSelected()){
            s = cbsmooth.getText();
            rmh.setSmooth(s);
            rmh.getSmooth();
        }else{
            s = " ";
            rmh.setSmooth(s);
            rmh.getSmooth();
        }
    }//GEN-LAST:event_cbsmoothActionPerformed
    private void tbcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbcaActionPerformed
       
    }//GEN-LAST:event_tbcaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBersih;
    private javax.swing.JButton bHitung;
    private javax.swing.JButton bKeluar;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JCheckBox cbgroom;
    private javax.swing.JCheckBox cbhair;
    private javax.swing.JCheckBox cbsmooth;
    private javax.swing.JComboBox cmdata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel judul;
    private javax.swing.JPanel pData;
    private javax.swing.JPanel pPaket;
    private javax.swing.JPanel pPayment;
    private javax.swing.JPanel pPesan;
    private javax.swing.JPanel pRegister;
    private javax.swing.JRadioButton rbbca;
    private javax.swing.JRadioButton rbbl;
    private javax.swing.JTextField tbca;
    private javax.swing.JTextField tbl;
    private javax.swing.JTextField thrg;
    private javax.swing.JTextField ttot;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onInsert(Pelanggan pelanggan) {
    }
}