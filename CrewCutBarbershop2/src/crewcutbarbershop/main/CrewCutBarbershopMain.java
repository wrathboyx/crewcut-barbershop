package crewcutbarbershop.main;

import crewcutbarbershop.error.PelangganException;
import crewcutbarbershop.view.PelangganView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class CrewCutBarbershopMain {
    public static void main(String[] args) throws SQLException, PelangganException{
          
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    PelangganView pelanggan = new PelangganView();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(CrewCutBarbershopMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
