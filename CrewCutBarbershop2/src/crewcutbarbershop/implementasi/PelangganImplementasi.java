package crewcutbarbershop.implementasi;

import crewcutbarbershop.entitas.Pelanggan;
import crewcutbarbershop.error.PelangganException;
import crewcutbarbershop.service.PelangganInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PelangganImplementasi implements PelangganInterface{

    private Connection koneksi;

    public PelangganImplementasi(Connection koneksi) {
        this.koneksi = koneksi;
    }
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN (NAMA, EMAIL, PASSWORD, ALAMAT, TELEPON) VALUES (?,?,?,?,?)";
    
    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        /** fungsi preparedstatement
         * untuk menghindari SQLInjection oleh serangan para hacker
         * yang bisa merubah value-value variabel inputan data
         */
        PreparedStatement statement = null;
        try {
            koneksi.setAutoCommit(false);
            
            statement = koneksi.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getEmail());
            statement.setString(3, pelanggan.getPassword());
            statement.setString(4, pelanggan.getAlamat());
            statement.setString(5, pelanggan.getTelepon());
            
            ResultSet result = statement.getGeneratedKeys();
            if(result.next()){
                pelanggan.setId(result.getInt(1));
            }
            
            statement.executeUpdate();
            koneksi.commit();
            
        } catch (SQLException e) {
            try {
                koneksi.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } // setiap statement harus dikasih finally (close)
        finally{
            try {
                koneksi.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement!=null){
                try {
                    statement.close();
                }catch (SQLException e) {
                }                
            }
        }
    }
}