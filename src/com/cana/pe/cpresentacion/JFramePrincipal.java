/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cana.pe.cpresentacion;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diang
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnbillete = new javax.swing.JMenu();
        btnBillete = new javax.swing.JMenuItem();
        btnCompañia = new javax.swing.JMenuItem();
        btnBillet = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        btnbillete.setText("Compra");

        btnBillete.setText("Cliente");
        btnBillete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBilleteActionPerformed(evt);
            }
        });
        btnbillete.add(btnBillete);

        btnCompañia.setText("Compañia");
        btnCompañia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompañiaActionPerformed(evt);
            }
        });
        btnbillete.add(btnCompañia);

        btnBillet.setText("Billete");
        btnBillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBilletActionPerformed(evt);
            }
        });
        btnbillete.add(btnBillet);

        jMenuBar1.add(btnbillete);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBilleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBilleteActionPerformed
        JPanelCliente cll;
        try {
            cll = new JPanelCliente();
            cll.setSize(800, 531);
        cll.setLocation(0,0);
        principal.removeAll();
        principal.add(cll, BorderLayout.CENTER);
        principal.revalidate();
        principal.revalidate();
        principal.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }//GEN-LAST:event_btnBilleteActionPerformed

    private void btnCompañiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompañiaActionPerformed
        JPanelCompania cal;
        try {
            cal = new JPanelCompania();
              cal.setSize(776, 530);
        cal.setLocation(0,0);
        principal.removeAll();
        principal.add(cal, BorderLayout.CENTER);
        principal.revalidate();
        principal.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_btnCompañiaActionPerformed

    private void btnBilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBilletActionPerformed
      JPanelBillete cal;
        try {
            cal = new JPanelBillete();
            cal.setSize(776, 530);
        cal.setLocation(0,0);
        principal.removeAll();
        principal.add(cal, BorderLayout.CENTER);
        principal.revalidate();
        principal.repaint();
        } catch (SQLException ex) {
           Logger.getLogger(JFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_btnBilletActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnBillet;
    private javax.swing.JMenuItem btnBillete;
    private javax.swing.JMenuItem btnCompañia;
    private javax.swing.JMenu btnbillete;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel principal;
    // End of variables declaration//GEN-END:variables
}
