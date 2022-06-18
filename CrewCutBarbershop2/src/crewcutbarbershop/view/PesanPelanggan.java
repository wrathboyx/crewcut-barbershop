package crewcutbarbershop.view;

public class PesanPelanggan {

    public String kelas, groom, hair, smooth, cara;
    public double hrg = 0, hrg_g = 0, hrg_h = 0, hrg_s = 0, biaya = 0, total = 0;
    
    public void setKelas(String val){
        kelas = val;
    }
    public String getKelas(){
        return kelas;
    }
    public void setSeleksiKelas(){
        if(kelas.equalsIgnoreCase("Reguler")){
            hrg = 25000;
        }else if(kelas.equalsIgnoreCase("Premier")){
            hrg = 100000;
        }else if(kelas.equalsIgnoreCase("Sultan")){
            hrg = 200000;
        }else{
            hrg = 0;
        }
    }
    public void setGroom(String val){
        groom = val;
    }
    public double getGroom(){
        if(groom.equalsIgnoreCase("Grooming")){
            hrg_g = 50000;
        }else{
            hrg_g = 0;
        }
        return hrg_g;
    }
    public void setHair(String val){
        hair = val;
    }
    public double getHair(){
        if(hair.equalsIgnoreCase("Hair Coloring")){
            hrg_h = 125000;
        }else{
            hrg_h = 0;
        }
        return hrg_h;
    }
    public void setSmooth(String val){
        smooth = val;
    }
    public double getSmooth(){
        if(smooth.equalsIgnoreCase("Smoothing")){
            hrg_s = 200000;
        }else{
            hrg_s = 0;
        }
        return hrg_s;
    }
    public double getHrg(){
        return hrg;
    }
    public void setCara(String val){
        cara = val;
    }
    public String getCara(){
        return cara;
    }
    public double getBiaya(){
        return biaya;
    }
    public void setSeleksiCara(){
        if(cara.equalsIgnoreCase("Bank BCA")){
            biaya = 6500;
        }else if(cara.equalsIgnoreCase("Other Bank")){
            biaya = 10000;
        }else{
            biaya = 0;
        }
    }
    public double getTotal(){
        return (hrg + hrg_g + hrg_h + hrg_s + biaya);
    }
}