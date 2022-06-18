package crewcutbarbershop.entitas;

import java.util.Objects;

public class Pelanggan {
    // Mapping entitas ke atribut didalam database ke dalam class Pelanggan
    // Implemen semua variable di database
    private Integer id;
    private String nama, email, password, alamat, telepon;

    public Pelanggan(){
        
    }

    public Pelanggan(String nama, String email, String password, String alamat, String telepon){
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.telepon = telepon;
    }
    
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

    // Generate equals() dan hashCode()
    
    /**Tujuannya untuk mencoba menimplementasi konsep collection didalam entitas,
     * -- hashCode() berguna untuk mengembalikan nilai integer yang unik setiap objek nya yang berbeda
     * -- equals() berguna untuk membandingkan dua buah objek apakah sama atau tidak
     */
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.nama);
        hash = 11 * hash + Objects.hashCode(this.email);
        hash = 11 * hash + Objects.hashCode(this.password);
        hash = 11 * hash + Objects.hashCode(this.alamat);
        hash = 11 * hash + Objects.hashCode(this.telepon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelanggan other = (Pelanggan) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.telepon, other.telepon)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}