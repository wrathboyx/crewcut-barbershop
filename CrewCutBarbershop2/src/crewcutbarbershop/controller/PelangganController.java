package crewcutbarbershop.controller;

import crewcutbarbershop.error.PelangganException;
import crewcutbarbershop.model.PelangganModel;
import crewcutbarbershop.view.PanelRegisterdanPesan;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }
    
    public void insertPelanggan(PanelRegisterdanPesan view){
        String nama = view.gettxtNama().getText();
        String email = view.gettxtEmail().getText();
        String password = view.gettxtPassword().getText();
        String alamat = view.gettxtAlamat().getText();
        String telepon = view.gettxtTelepon().getText();
        
        if(nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong!");
        }else if(nama.length()>255){
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 Karatker!");
        }else if(telepon.length()>12){
            JOptionPane.showMessageDialog(view, "Telepon tidak boleh lebih dari 12 Digit!");
        }else{
            model.setNama(nama);
            model.setEmail(email);
            model.setPassword(password);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Data berhasil ditambahkan!");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan, ", throwable.getMessage()});
            }
        }
    }
    
    public void resetPelanggan(PanelRegisterdanPesan view) throws SQLException, PelangganException{
        model.resetPelanggan();
    }
}