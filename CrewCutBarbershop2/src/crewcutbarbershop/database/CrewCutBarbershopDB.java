package crewcutbarbershop.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import crewcutbarbershop.implementasi.PelangganImplementasi;
import crewcutbarbershop.service.PelangganInterface;
import java.sql.Connection;
import java.sql.SQLException;

public class CrewCutBarbershopDB {
    
    private static Connection koneksi;
    private static PelangganInterface pelangganInterface;
    
    public static Connection getConnection() throws SQLException{
        if (koneksi==null) {
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/crewcutbarbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            koneksi = dataSource.getConnection();
        }
        return koneksi;
    }
    
    // konsep singleton
    public static PelangganInterface getPelangganInterface() throws SQLException{
        
        if (pelangganInterface==null) {
            pelangganInterface = new PelangganImplementasi(getConnection());
        }
        return pelangganInterface;
    }
}
