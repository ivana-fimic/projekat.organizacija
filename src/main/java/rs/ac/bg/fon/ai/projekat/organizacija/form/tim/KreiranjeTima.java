/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.form.tim;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.models.ModelTabeleBrojPozicija;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ivana
 */
public class KreiranjeTima extends javax.swing.JDialog {

    /**
     * Creates new form MainForma
     */
    Map<String, Integer> mapa = new HashMap<>();
    List<Pozicija> pozicije;
    List<DetaljiPozicija> brojpozicija = new ArrayList<>();
    ModelTabeleBrojPozicija model;
    Tim t;

    public KreiranjeTima(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        jPanel1.setMaximumSize(new Dimension(600, 200));
        postaviLayout();

        setSize(600, 700);

        setTitle("Kreiranje tima");
        setLocationRelativeTo(null);
        pozicije = KlijentController.getInstance().vratiPozicije();
        popuniComboe();
        cmbPozicija1.setSelectedIndex(-1);
        model = new ModelTabeleBrojPozicija();
        tblBrPozicija1.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPozicija1 = new javax.swing.JComboBox<>();
        txtBrojPozicije1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrPozicija = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblNazivTima = new javax.swing.JLabel();
        lblNazivProjekta = new javax.swing.JLabel();
        lblUkupnoClanova = new javax.swing.JLabel();
        txtNazivTima = new javax.swing.JTextField();
        txtUkupnoClanova = new javax.swing.JTextField();
        cmbProjekti = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbPozicija2 = new javax.swing.JComboBox<>();
        txtBrojPozicije2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBrPozicija1 = new javax.swing.JTable();
        btnDodaj1 = new javax.swing.JButton();
        btnObrisi1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem6.setText("jMenuItem6");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos Detalja Pozicije"));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Naziv Pozicije");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Broj članova");

        tblBrPozicija.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBrPozicija);

        btnDodaj.setText("DODAJ");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("OBRISI");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jButton1.setText("SACUVAJ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDodaj)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisi)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPozicija1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBrojPozicije1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 205, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(202, 202, 202))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPozicija1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrojPozicije1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setFocusTraversalPolicyProvider(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos Tima"));

        lblNazivTima.setText("Naziv Tima:");

        lblNazivProjekta.setText("Naziv Projekta:");

        lblUkupnoClanova.setText("Ukupan broj članova:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNazivTima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNazivProjekta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUkupnoClanova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNazivTima)
                    .addComponent(txtUkupnoClanova)
                    .addComponent(cmbProjekti, 0, 230, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNazivTima)
                    .addComponent(txtNazivTima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNazivProjekta)
                    .addComponent(cmbProjekti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUkupnoClanova)
                    .addComponent(txtUkupnoClanova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos Detalja Pozicije"));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Naziv Pozicije");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Broj članova");

        tblBrPozicija1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblBrPozicija1);

        btnDodaj1.setText("DODAJ");
        btnDodaj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodaj1ActionPerformed(evt);
            }
        });

        btnObrisi1.setText("OBRISI");
        btnObrisi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisi1ActionPerformed(evt);
            }
        });

        jButton2.setText("SACUVAJ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDodaj1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisi1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPozicija2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBrojPozicije2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 205, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(202, 202, 202))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPozicija2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrojPozicije2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj1)
                    .addComponent(btnObrisi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        String pozicija = cmbPozicija1.getSelectedItem().toString();
        Pozicija poz = new Pozicija();
        for (Pozicija p : pozicije) {
            if (p.getNazivPozicije().equals(pozicija)) {
                poz = p;
            }

        }
        int broj = Integer.parseInt(txtBrojPozicije1.getText());

        DetaljiPozicija p = new DetaljiPozicija(t, poz, broj);
        ModelTabeleBrojPozicija tm = (ModelTabeleBrojPozicija) tblBrPozicija1.getModel();

        if (tm.postojiPozicija(p)) {
            JOptionPane.showMessageDialog(this, "Vec ste uneli tu poziciju za ovaj tim!");
            return;
        }
        tm.dodajPoziciju(p);

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int row = tblBrPozicija.getSelectedRow();

        if (row >= 0) {
            ModelTabeleBrojPozicija tm = (ModelTabeleBrojPozicija) tblBrPozicija.getModel();
            tm.obrisiPoziciju(row);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nazivTima = txtNazivTima.getText();
        String ukupnoClanova = txtUkupnoClanova.getText();
        Projekat p = (Projekat) cmbProjekti.getSelectedItem();
        String nazivProjekta = p.getNazivProjekta();

        List<DetaljiPozicija> brPozicija = new ArrayList<>();
        for (DetaljiPozicija pozIzTabele : model.getPozicije()) {
            brPozicija.add(pozIzTabele);
        }

        String prazniPodaci = daLisuPoljaPrazna(nazivProjekta, nazivTima, ukupnoClanova);
        if (!prazniPodaci.equals("")) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira tim!", "GRESKA", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Polja su prazna: " + prazniPodaci, "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String losFormat = daLiJeDobarFormat(nazivProjekta, nazivTima, ukupnoClanova);
        if (!losFormat.equals("")) {
            JOptionPane.showMessageDialog(this, losFormat, "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int brClanova = Integer.parseInt(ukupnoClanova);
        if (brClanova <= 1) {
            JOptionPane.showMessageDialog(this, "Broj clanova mora biti vece od 1", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String proveraBrojaPozicije = daLiJeDobarUkupanBroj(brClanova, brPozicija);
        if (!proveraBrojaPozicije.equals("")) {
            JOptionPane.showMessageDialog(this, proveraBrojaPozicije, "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        t = new Tim(0, nazivTima, brClanova, p);
        t.setPozicije(pozicije);
        int idTima = t.getIDTima();

        t.setBrojPozicija(brPozicija);
        try {
            t = KlijentController.getInstance().dodajTim(t);
            JOptionPane.showMessageDialog(this, "Sistem je kreirao tim");
            osveziFormu();
        } catch (Exception ex) {
            Logger.getLogger(KreiranjeTima.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDodaj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodaj1ActionPerformed
        String pozicija = cmbPozicija2.getSelectedItem().toString();
        Pozicija poz = new Pozicija();
        for (Pozicija p : pozicije) {
            if (p.getNazivPozicije().equals(pozicija)) {
                poz = p;
            }

        }
        int broj = Integer.parseInt(txtBrojPozicije2.getText());

        DetaljiPozicija p = new DetaljiPozicija(t, poz, broj);
        ModelTabeleBrojPozicija tm = (ModelTabeleBrojPozicija) tblBrPozicija1.getModel();

        if (tm.postojiPozicija(p)) {
            JOptionPane.showMessageDialog(this, "Vec ste uneli tu poziciju za ovaj tim!");
            return;
        }
        tm.dodajPoziciju(p);

    }//GEN-LAST:event_btnDodaj1ActionPerformed

    private void btnObrisi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisi1ActionPerformed
        int row = tblBrPozicija.getSelectedRow();

        if (row >= 0) {
            ModelTabeleBrojPozicija tm = (ModelTabeleBrojPozicija) tblBrPozicija1.getModel();
            tm.obrisiPoziciju(row);
        }
    }//GEN-LAST:event_btnObrisi1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nazivTima = txtNazivTima.getText();
        String ukupnoClanova = txtUkupnoClanova.getText();
        Projekat p = (Projekat) cmbProjekti.getSelectedItem();
        String nazivProjekta = p.getNazivProjekta();

        List<DetaljiPozicija> brPozicija = new ArrayList<>();
        for (DetaljiPozicija pozIzTabele : model.getPozicije()) {
            brPozicija.add(pozIzTabele);
        }

        String prazniPodaci = daLisuPoljaPrazna(nazivProjekta, nazivTima, ukupnoClanova);
        if (!prazniPodaci.equals("")) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira tim!", "GRESKA", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Polja su prazna: " + prazniPodaci, "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String losFormat = daLiJeDobarFormat(nazivProjekta, nazivTima, ukupnoClanova);
        if (!losFormat.equals("")) {
            JOptionPane.showMessageDialog(this, losFormat, "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int brClanova = Integer.parseInt(ukupnoClanova);
        if (brClanova <= 1) {
            JOptionPane.showMessageDialog(this, "Broj clanova mora biti vece od 1", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String proveraBrojaPozicije = daLiJeDobarUkupanBroj(brClanova, brPozicija);
        if (!proveraBrojaPozicije.equals("")) {
            JOptionPane.showMessageDialog(this, proveraBrojaPozicije, "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        t = new Tim(0, nazivTima, brClanova, p);
        t.setPozicije(pozicije);
        int idTima = t.getIDTima();

        t.setBrojPozicija(brPozicija);
        try {
            t = KlijentController.getInstance().dodajTim(t);
            JOptionPane.showMessageDialog(this, "Sistem je kreirao tim");
            upisiUJSON(t);
            osveziFormu();
        } catch (Exception ex) {
            Logger.getLogger(KreiranjeTima.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodaj1;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisi1;
    private javax.swing.JComboBox<String> cmbPozicija1;
    private javax.swing.JComboBox<String> cmbPozicija2;
    private javax.swing.JComboBox<Projekat> cmbProjekti;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNazivProjekta;
    private javax.swing.JLabel lblNazivTima;
    private javax.swing.JLabel lblUkupnoClanova;
    private javax.swing.JTable tblBrPozicija;
    private javax.swing.JTable tblBrPozicija1;
    private javax.swing.JTextField txtBrojPozicije1;
    private javax.swing.JTextField txtBrojPozicije2;
    private javax.swing.JTextField txtNazivTima;
    private javax.swing.JTextField txtUkupnoClanova;
    // End of variables declaration//GEN-END:variables

    private void popuniComboe() throws Exception {
        List<Projekat> projekti = KlijentController.getInstance().vratiProjekte();

        for (Projekat p : projekti) {
            cmbProjekti.addItem(p);

        }
        cmbProjekti.setSelectedIndex(-1);

        for (Pozicija p : pozicije) {
            cmbPozicija2.addItem(p.getNazivPozicije());

        }

    }

    private void osveziFormu() {
        cmbProjekti.setSelectedIndex(-1);
        txtNazivTima.setText("");
        txtUkupnoClanova.setText("");
        cmbPozicija1.setSelectedIndex(-1);
        txtBrojPozicije1.setText("");

        ModelTabeleBrojPozicija tm = (ModelTabeleBrojPozicija) tblBrPozicija1.getModel();
        int rowCount = tm.getRowCount();
        if (rowCount > 0) {
            for (int i = rowCount - 1; i >= 0; i--) {
                tm.obrisiPoziciju(i);
            }
        }
    }

    private String daLisuPoljaPrazna(String nazivProjekta, String nazivTima, String ukupnoClanova) {
        String poruka = "";
        if (nazivProjekta.equals("")) {
            poruka += "Naziv projekta, ";
        }
        if (nazivTima.equals("")) {
            poruka += "Naziv tima, ";
        }
        if (ukupnoClanova.equals("")) {
            poruka += "Ukupno clanova, ";
        }
        return poruka;
    }

    private String daLiJeDobarUkupanBroj(int ukupnoClanova, List<DetaljiPozicija> brPozicija) {
        String poruka = "";
        if (brPozicija.size() <= 0) {
            poruka = "Niste uneli broj članova ni za jednu poziciju";
            return poruka;
        }
        int ukupnoPoPozicijama = 0;
        for (DetaljiPozicija dp : brPozicija) {
            ukupnoPoPozicijama += dp.getBrojPozicija();
        }
        if (ukupnoClanova != ukupnoPoPozicijama) {
            poruka = "Ne poklapa se ukupan broj članova sa brojevima po pozicijama";

        }
        return poruka;
    }

    private String daLiJeDobarFormat(String nazivProjekta, String nazivTima, String ukupnoClanova) {
        String poruka = "";
        if (nazivProjekta.matches(".*\\d+.*")) {
            poruka += "Naziv projekta ne sme sadrzati broj \n";
        }
        if (nazivTima.matches(".*\\d+.*")) {
            poruka += "Naziv tima ne sme sadrzati broj \n";
        }
        if (!(ukupnoClanova.matches(".*\\d+.*"))) {
            poruka += "Ukupan broj clanova mora biti broj \n";
        }
        if (!(nazivProjekta.equals(nazivProjekta.toUpperCase()))) {

            poruka += "Naziv projekta mora imati sva velika slova \n";
        }
        if (Character.isLowerCase(nazivTima.charAt(0))) {
            poruka += "Prvo slovo naziva tima mora biti veliko \n";
        }

        return poruka;
    }

    private void upisiUJSON(Tim t) {
        String filePath = "src/main/resources/tim.json";

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();

        gsonBuilder.setPrettyPrinting();

        gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context)
                -> new com.google.gson.JsonPrimitive(src.toString())
        );

        Gson gson = gsonBuilder.create();

        try (FileWriter out = new FileWriter(filePath)) {
            String jsonString = gson.toJson(t);
            System.out.println("JSON string: " + jsonString);
            out.write(jsonString);
            System.out.println("Uspešno upisano u fajl: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Greška pri pisanju u fajl: " + filePath);
        }
    }

    private void postaviLayout() {
        txtNazivTima.setMaximumSize(new java.awt.Dimension(230, 20));
        txtUkupnoClanova.setMaximumSize(new java.awt.Dimension(230, 20));
        cmbProjekti.setMaximumSize(new java.awt.Dimension(230, 20));
    }

}
