package crewcutbarbershop.view;

import crewcutbarbershop.swing.ButtonOutLine;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {
    
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener eventlist;
    private MigLayout layout;
    private JLabel title;
    private JLabel logo;
    private JLabel desc;
    private JLabel desc1;
    private ButtonOutLine button;
    private boolean isLogin;
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]15[]15[]50[]push");
        setLayout(layout);
        init();
    }

    private void init(){
        // logo
        logo = new JLabel();
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crewcutbarbershop/icon/crwcut.png"))); // NOI18N
        add(logo);

        // title
        title = new JLabel("Selamat Datang!");
        title.setFont(new Font("sansserif", 1, 11));
        title.setForeground(new Color(245, 245, 245));
        add(title);
        
        //desc
        desc = new JLabel("Kami siap melayani anda dengan yang terbaik.");
        desc.setFont(new Font("sansserif", 1, 11));
        desc.setForeground(new Color(245, 245, 245));
        add(desc);
        
        //desc1
        desc1 = new JLabel("Pilih paket yang sesuai dengan selera kamu dibawah ini.");
        desc1.setFont(new Font("sansserif", 1, 11));
        desc1.setForeground(new Color(245, 245, 245));
        add(desc1);
        
        //button
        button = new ButtonOutLine();
        button.setBackground(new Color(255,255,255));
        button.setForeground(new Color(255,255,255));
        button.setText("Pilih paket");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea) {
                eventlist.actionPerformed(ea);
            }
        });
        add(button,"w 60%, h 10%");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint grad = new GradientPaint(0, 0, new Color(85, 239, 196), 0, getHeight(), new Color(0, 184, 148));
        g2.setPaint(grad);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    public void addEvent(ActionListener eventlist){
        this.eventlist = eventlist;
    }
    
    public void registerLeft(double v){
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(logo, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc1, "pad 0 -" + v + "% 0 0");
    }
    
    public void registerRight(double v){
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(logo, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc1, "pad 0 -" + v + "% 0 0");
    }
    
    public void loginLeft(double v){
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(logo, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    public void loginRight(double v){
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(logo, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    private void login(boolean login){
        if(this.isLogin!=login){
            if(login){
                title.setText("Halo, teman!");
                desc.setText("Masukkan Informasi Pribadi");
                desc1.setText("dan menikmati layanan kami");
                button.setText("Daftar");
            }else{
                title.setText("Selamat Datang!");
                desc.setText("Kami siap melayani anda dengan yang terbaik.");
                desc1.setText("Pilih paket yang sesuai dengan selera kamu disini.");
                button.setText("Pilih paket");
            }
            this.isLogin = login;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}