package crewcutbarbershop.model;

import crewcutbarbershop.database.CrewCutBarbershopDB;
import crewcutbarbershop.entitas.Pelanggan;
import crewcutbarbershop.error.PelangganException;
import crewcutbarbershop.event.PelangganListener;
import crewcutbarbershop.service.PelangganInterface;
import java.sql.SQLException;

public class PelangganModel {
    private Integer id;
    private String nama, email, password, alamat, telepon;

    private PelangganListener listener;

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
    
    // --------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    protected void fireOnInsert(Pelanggan pelanggan){
        if(listener!=null){
            listener.onInsert(pelanggan);
        }
    }
    
    public void insertPelanggan() throws SQLException, PelangganException{
        PelangganInterface dao = CrewCutBarbershopDB.getPelangganInterface();
        Pelanggan pelanggan = new Pelanggan();
        
        pelanggan.setNama(nama);
        pelanggan.setEmail(email);
        pelanggan.setPassword(password);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        
        dao.insertPelanggan(pelanggan);
    }
    
    public void resetPelanggan() throws SQLException, PelangganException{
        setId(0);
        setNama("");
        setEmail("");
        setPassword("");
        setAlamat("");
        setTelepon("");
    }
}