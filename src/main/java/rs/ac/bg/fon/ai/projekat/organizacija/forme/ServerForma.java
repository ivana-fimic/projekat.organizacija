/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.forme;

import java.io.IOException;
import rs.ac.bg.fon.ai.projekat.organizacija.thread.ThreadServer;
import javax.swing.JOptionPane;


/**
 *
 * @author Ivana
 */
public class ServerForma extends javax.swing.JFrame {

    /**
     * Creates new form ServerForma
     */
    private ThreadServer threadServer;

    public ServerForma() {
        initComponents();
        lblStatus.setText("Server je ugasen!");
        btnPokreni.setEnabled(true);
        btnZaustavi.setEnabled(false);
        setTitle("Serverska forma");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnZaustavi = new javax.swing.JButton();
        btnPokreni = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnZaustavi.setText("Zaustavi server");
        btnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviActionPerformed(evt);
            }
        });

        btnPokreni.setText("Pokreni sever");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Status");
        lblStatus.setToolTipText("");

        jMenu1.setText("Konfiguracija baze");

        jMenuItem1.setText("Izmeni konfiguraciju");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnZaustavi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPokreni)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZaustavi)
                    .addComponent(btnPokreni))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new KonfiguracijaBaze(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        if (threadServer == null || !threadServer.isAlive()) {
            threadServer = new ThreadServer();
            threadServer.start();
            lblStatus.setText("Server je pokrenut!");
            btnZaustavi.setEnabled(true);
            btnPokreni.setEnabled(false);
        }
    }//GEN-LAST:event_btnPokreniActionPerformed

    private void btnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviActionPerformed
        try {
            if (threadServer.getServerSocket() != null && threadServer.getServerSocket().isBound()) {
                if (threadServer.getListaPrijavljenih().size() != 0 && threadServer.getListaNiti().size() != 0) {
                    
                    JOptionPane.showMessageDialog(this, "Jos uvijek nisu svi klijenti odjavljeni.Ne mozete ugasiti server","GRESKA", JOptionPane.INFORMATION_MESSAGE);
                return;
                }else{
                        threadServer.getServerSocket().close();
                        System.out.println("Server je zaustavljen!");
                        lblStatus.setText("Server je zaustavljen!");
                        btnZaustavi.setEnabled(false);
                        btnPokreni.setEnabled(true);
                    }
                
            }
        } catch (IOException ex) {
            System.out.println("Greska prilikom zaustavljanja servera!" + ex.getMessage());
        }

    }//GEN-LAST:event_btnZaustaviActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JButton btnZaustavi;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
