/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.forme.koordinator;

import java.io.IOException;
import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Admin;
import rs.ac.bg.fon.ai.projekat.organizacija.form.clan.KreirajClana;
import rs.ac.bg.fon.ai.projekat.organizacija.form.clan.PretraziClana;
import rs.ac.bg.fon.ai.projekat.organizacija.form.projekat.KreirajProjekat;
import rs.ac.bg.fon.ai.projekat.organizacija.form.resurs.KreirajResurs;
import rs.ac.bg.fon.ai.projekat.organizacija.form.tim.KreiranjeTima;
import rs.ac.bg.fon.ai.projekat.organizacija.form.tim.PretragaTima;
import rs.ac.bg.fon.ai.projekat.organizacija.form.zadatak.KreirajZadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.form.zadatak.PretraziZadatak;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author Ivana
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma(Admin a) {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Glavna forma");
        setLocationRelativeTo(null);
        lblUlogovani.setText(a.getIme() + " " + a.getPrezime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUlogovani = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnKreiranjeTim = new javax.swing.JMenuItem();
        mnPretragaTimova = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnKreiranjeClana = new javax.swing.JMenuItem();
        mnPrikaziClanove = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnKreiranjeZadatka = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("ODJAVI SE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Dobrodosli u aplikaciju za pracenje rada u studentskoj organizaciji!");

        lblUlogovani.setText("ime");

        jLabel2.setText("Ulogovani koordinator:");

        jMenu1.setText("Timovi");

        mnKreiranjeTim.setText("Kreiranje tima");
        mnKreiranjeTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKreiranjeTimActionPerformed(evt);
            }
        });
        jMenu1.add(mnKreiranjeTim);

        mnPretragaTimova.setText("Pretraga timova");
        mnPretragaTimova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPretragaTimovaActionPerformed(evt);
            }
        });
        jMenu1.add(mnPretragaTimova);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Članovi");

        mnKreiranjeClana.setText("Kreiranje clana");
        mnKreiranjeClana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKreiranjeClanaActionPerformed(evt);
            }
        });
        jMenu2.add(mnKreiranjeClana);

        mnPrikaziClanove.setText("Pretraga clanova");
        mnPrikaziClanove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPrikaziClanoveActionPerformed(evt);
            }
        });
        jMenu2.add(mnPrikaziClanove);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Zadaci");

        mnKreiranjeZadatka.setText("Kreiranje zadatka");
        mnKreiranjeZadatka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKreiranjeZadatkaActionPerformed(evt);
            }
        });
        jMenu3.add(mnKreiranjeZadatka);

        jMenuItem1.setText("Pretraga zadataka");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu8.setText("Projekat");

        jMenuItem5.setText("Kreiraj projekat");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem5);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Resurs");

        jMenuItem6.setText("Kreiraj resurs");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem6);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(lblUlogovani))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int odgovor = JOptionPane.showConfirmDialog(this, "DA LI ZELITE PONOVO DA SE PRIJAVITE?", "Potvrda", JOptionPane.YES_NO_OPTION);
        if (odgovor == JOptionPane.YES_OPTION) {
            try {
                String odjava = KlijentController.getInstance().odjava();
                this.dispose();
                LoginForma pf = new LoginForma();
                pf.setVisible(true);
                JOptionPane.showMessageDialog(this, odjava, "Odjava", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                if (ex instanceof IOException) {
                    JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (odgovor == JOptionPane.NO_OPTION) {
            try {
                String odjava = KlijentController.getInstance().odjava();
                JOptionPane.showMessageDialog(this, odjava, "Odjava", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                if (ex instanceof IOException) {
                    JOptionPane.showMessageDialog(this, "Greska! Pokusajte kasnije!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            new KreirajProjekat(this, true).setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       try {
            new PretraziZadatak(this, true).setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnKreiranjeZadatkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKreiranjeZadatkaActionPerformed
        try {
            new KreirajZadatak(this, true).setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnKreiranjeZadatkaActionPerformed

    private void mnPrikaziClanoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPrikaziClanoveActionPerformed
        try {
            new PretraziClana(this, true).setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnPrikaziClanoveActionPerformed

    private void mnKreiranjeClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKreiranjeClanaActionPerformed

        try {
            new KreirajClana(this, true).setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnKreiranjeClanaActionPerformed

    private void mnPretragaTimovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPretragaTimovaActionPerformed
        new PretragaTima(this, true).setVisible(true);
    }//GEN-LAST:event_mnPretragaTimovaActionPerformed

    private void mnKreiranjeTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKreiranjeTimActionPerformed
        try {
            new KreiranjeTima(this, true).setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnKreiranjeTimActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
 try {
            new KreirajResurs(this, true).setVisible(true);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jMenuItem6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem mnKreiranjeClana;
    private javax.swing.JMenuItem mnKreiranjeTim;
    private javax.swing.JMenuItem mnKreiranjeZadatka;
    private javax.swing.JMenuItem mnPretragaTimova;
    private javax.swing.JMenuItem mnPrikaziClanove;
    // End of variables declaration//GEN-END:variables
}
