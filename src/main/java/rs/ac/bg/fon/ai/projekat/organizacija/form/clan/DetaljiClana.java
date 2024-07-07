/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.form.clan;

import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.form.tim.DetaljiTima;
import rs.ac.bg.fon.ai.projekat.organizacija.models.ModelTabeleClan;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.Moodovi;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
 *
 * @author Ivana
 */
public class DetaljiClana extends javax.swing.JDialog {

    /**
     * Creates new form DetaljiClana
     */
    ModelTabeleClan model;
    private Clan clan;
    Moodovi moodTabele;
    private PretraziClana roditelj1;
    private DetaljiClana roditelj2;

    public JComboBox<Pozicija> getCmbPozicija() {
        return cmbPozicija;
    }

    public void setCmbPozicija(JComboBox<Pozicija> cmbPozicija) {
        this.cmbPozicija = cmbPozicija;
    }

    public JComboBox<Tim> getCmbTim() {
        return cmbTim;
    }

    public void setCmbTim(JComboBox<Tim> cmbTim) {
        this.cmbTim = cmbTim;
    }

    public JTextField getTxtFakultet() {
        return txtFakultet;
    }

    public void setTxtFakultet(JTextField txtFakultet) {
        this.txtFakultet = txtFakultet;
    }

    public JTextField getTxtGodinaStudija() {
        return txtGodinaStudija;
    }

    public void setTxtGodinaStudija(JTextField txtGodinaStudija) {
        this.txtGodinaStudija = txtGodinaStudija;
    }

    public JTextField getTxtIme() {
        return txtIme;
    }

    public void setTxtIme(JTextField txtIme) {
        this.txtIme = txtIme;
    }

    public JTextField getTxtPrezime() {
        return txtPrezime;
    }

    public void setTxtPrezime(JTextField txtPrezime) {
        this.txtPrezime = txtPrezime;
    }

    public DetaljiClana(javax.swing.JDialog parent, boolean modal, Clan c, Moodovi mood) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Detalji clana");
        popuniComboe();
        
         if (parent instanceof PretraziClana) {
            roditelj1 = (PretraziClana) parent;
        } else {
            roditelj2 = (DetaljiClana) parent;
        }

        clan = c;
        if (mood == Moodovi.PRIKAZ) {
            txtIme.setEditable(false);
            txtPrezime.setEditable(false);
            txtGodinaStudija.setEditable(false);
            txtFakultet.setEditable(false);
            cmbPozicija.setEnabled(false);
            cmbTim.setEnabled(false);
            btnSacuvajIzmene.setEnabled(false);
        }
        
        txtIme.setText(clan.getIme());
        txtPrezime.setText(clan.getPrezime());
        txtGodinaStudija.setText(String.valueOf(clan.getGodStudija()));
        txtFakultet.setText(clan.getFakultet());
        cmbPozicija.setSelectedItem(clan.getPozicija());
        cmbTim.setSelectedItem(clan.getTim());
        
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFakultet = new javax.swing.JTextField();
        cmbTim = new javax.swing.JComboBox<>();
        cmbPozicija = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtGodinaStudija = new javax.swing.JTextField();
        btnSacuvajIzmene = new javax.swing.JButton();
        btnIzmena = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbPozicija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPozicijaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tim:");

        jLabel1.setText("Ime:");

        jLabel6.setText("Pozicija:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Godina studija:");

        jLabel4.setText("Fakultet:");

        btnSacuvajIzmene.setText("SACUVAJ IZMENE");
        btnSacuvajIzmene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajIzmeneActionPerformed(evt);
            }
        });

        btnIzmena.setText("IZMENI");
        btnIzmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(btnSacuvajIzmene)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIzmena)
                .addGap(81, 81, 81))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIme, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addComponent(txtPrezime)
                        .addComponent(txtGodinaStudija)
                        .addComponent(txtFakultet)
                        .addComponent(cmbTim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbPozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmena)
                    .addComponent(btnSacuvajIzmene))
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(txtGodinaStudija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(txtFakultet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cmbTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cmbPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPozicijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPozicijaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPozicijaActionPerformed

    private void btnIzmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmenaActionPerformed
         try {
            Clan ucitaniClanBaza = KlijentController.getInstance().ucitajClana(clan);
             JOptionPane.showMessageDialog(this, "Sistem je ucitao člana", "POTVRDA", JOptionPane.INFORMATION_MESSAGE);
            new DetaljiClana(this, true, ucitaniClanBaza, Moodovi.IZMENA).setVisible(true);
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzmenaActionPerformed

    private void btnSacuvajIzmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajIzmeneActionPerformed
            try {
            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            String fakultet=txtFakultet.getText();
            String godStudija= txtGodinaStudija.getText();
            Tim tim= (Tim) cmbTim.getSelectedItem();
            Pozicija pozicija=(Pozicija) cmbPozicija.getSelectedItem();
             String prazniPodaci=daLisuPoljaPrazna(ime,prezime,godStudija,fakultet,tim,pozicija);
            if(!prazniPodaci.equals("")){
                 JOptionPane.showMessageDialog(this, "Sistem ne moze da izmeni člana!","Informacija", JOptionPane.INFORMATION_MESSAGE);
                 JOptionPane.showMessageDialog(this, "Polja su prazna: " + prazniPodaci, "GRESKA", JOptionPane.ERROR_MESSAGE);
                 return;
            }
            String losFormat= daLiJeDobarFormat(ime,prezime,godStudija,fakultet);
            if(!losFormat.equals("")){
                 JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti člana", "GRESKA", JOptionPane.ERROR_MESSAGE);
                 JOptionPane.showMessageDialog(this, losFormat, "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            int godinaStudija=Integer.parseInt(txtGodinaStudija.getText());
           Clan c=new Clan(clan.getIDClana(), ime, prezime, godinaStudija, pozicija, tim, fakultet);

            KlijentController.getInstance().izmeniClana(c);
            if (roditelj1 instanceof PretraziClana && roditelj1 != null) {
                roditelj1.refreshTable();
            }
            if (roditelj2 instanceof DetaljiClana && roditelj2 != null) {
                roditelj2.getTxtIme().setText(c.getIme());
                roditelj2.getTxtPrezime().setText(c.getPrezime());
                roditelj2.getTxtGodinaStudija().setText(String.valueOf(c.getGodStudija()));
                roditelj2.getCmbPozicija().setSelectedItem(c.getPozicija());
                roditelj2.getCmbTim().setSelectedItem(c.getTim());
                

            }
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio člana");
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(DetaljiTima.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajIzmeneActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmena;
    private javax.swing.JButton btnSacuvajIzmene;
    private javax.swing.JComboBox<Pozicija> cmbPozicija;
    private javax.swing.JComboBox<Tim> cmbTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtFakultet;
    private javax.swing.JTextField txtGodinaStudija;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniComboe() throws Exception {
        List<Tim> timovi = KlijentController.getInstance().vratiTimove();
        List<Pozicija> pozicije = KlijentController.getInstance().vratiPozicije();
        for (Tim t : timovi) {
            cmbTim.addItem(t);

        }
        cmbTim.setSelectedIndex(-1);
        for (Pozicija p : pozicije) {
            cmbPozicija.addItem(p);

        }
        cmbPozicija.setSelectedIndex(-1);
    }

    private String daLiJeDobarFormat(String ime, String prezime, String godStudija, String fakultet) {
        String poruka = "";
        if(ime.matches(".*\\d+.*")){
            poruka+="Ime ne sme sadrzati broj \n";
        }
        if(ime.contains(" ")){
            poruka+="Ime ne sme sadrzati razmak \n";
        }
         if(prezime.contains(" ")){
            poruka+="Prezime ne sme sadrzati razmak \n";
        }
         if(prezime.matches(".*\\d+.*")){
            poruka+="Prezime ne sme sadrzati broj \n";
        }
         if(Character.isLowerCase(ime.charAt(0))){
             poruka+="Prvo slovo imena mora biti veliko \n";
         }
         
         if(Character.isLowerCase(prezime.charAt(0))){
             poruka+="Prvo slovo prezimena mora biti veliko \n";
         }
         if(!(godStudija.matches(".*\\d+.*"))){
              poruka+="Godina studija mora biti broj \n";
         }
          if (!godStudija.matches("[1-5]+")) {
               poruka+="Godina studija mora biti u intervalu od 1 do 5 \n";
          }
           if(fakultet.matches(".*\\d+.*")){
            poruka+="Fakultet ne sme sadrzati broj \n";
        }
         if(Character.isLowerCase(fakultet.charAt(0))){
             poruka+="Prvo slovo fakulteta mora biti veliko \n";
         }
         
         return poruka;
    }

    private String daLisuPoljaPrazna(String ime, String prezime, String godStudija, String fakultet, Tim tim, Pozicija pozicija) {
       String poruka = "";
        if(ime.equals("")){
             poruka += "Ime, ";
        }
        if(prezime.equals("")){
             poruka += "Prezime, ";
        }
        
       if(godStudija.equals("")){
            poruka += "Godina studija, ";
       }
        
         if(fakultet.equals("")){
            poruka += "Fakultet, ";
       }
         if(tim==null){
               poruka += "Tim, ";
         }
         if(pozicija==null){
             poruka+="Pozicija, ";
         }
        return poruka;
    }
}
