package crewcutbarbershop.service;

import crewcutbarbershop.entitas.Pelanggan;
import crewcutbarbershop.error.PelangganException;

public interface PelangganInterface {
    
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;
}
