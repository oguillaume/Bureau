/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import bdd.Base;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import services.AdminService;

/**
 *
 * @author HP-G61
 */
public class AccueilVue extends javax.swing.JFrame {
    /**
     * Creates new form AccueilVue
     */
    public AccueilVue() {
        Base base = new Base();
        if(base.connexion()==null) {
            this.dispose();
            JOptionPane.showMessageDialog(null,null, "Le fichier de configuration est introuvable !Veuillez le vérifier.",JOptionPane.WARNING_MESSAGE);
        }
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

        NomLabel = new javax.swing.JLabel();
        PasseLabel = new javax.swing.JLabel();
        PasseField = new javax.swing.JPasswordField();
        EnvoyerIdentite = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Entete = new javax.swing.JTextArea();
        NomField = new javax.swing.JTextField();
        jErreur = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elections - Administration");
        setBackground(new java.awt.Color(0, 150, 0));
        setMinimumSize(new java.awt.Dimension(550, 400));
        getContentPane().setLayout(null);

        NomLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomLabel.setForeground(new java.awt.Color(255, 51, 51));
        NomLabel.setText("Identifiant");
        getContentPane().add(NomLabel);
        NomLabel.setBounds(110, 160, 72, 17);

        PasseLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PasseLabel.setForeground(new java.awt.Color(255, 0, 0));
        PasseLabel.setText("Mot de Passe");
        getContentPane().add(PasseLabel);
        PasseLabel.setBounds(110, 190, 80, 20);

        PasseField.setMinimumSize(new java.awt.Dimension(12, 20));
        getContentPane().add(PasseField);
        PasseField.setBounds(210, 190, 109, 30);

        EnvoyerIdentite.setBackground(new java.awt.Color(0, 240, 0));
        EnvoyerIdentite.setForeground(new java.awt.Color(0, 0, 150));
        EnvoyerIdentite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Lancer.jpg"))); // NOI18N
        EnvoyerIdentite.setText("OK");
        EnvoyerIdentite.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        EnvoyerIdentite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnvoyerIdentiteActionPerformed(evt);
            }
        });
        getContentPane().add(EnvoyerIdentite);
        EnvoyerIdentite.setBounds(170, 260, 73, 29);

        jScrollPane1.setOpaque(false);

        Entete.setColumns(20);
        Entete.setRows(5);
        Entete.setText("     Mairie de MaVille - Vosges\n\nBienvenue sur l'espace d'administration\ndes élections");
        Entete.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(Entete);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(61, 0, 320, 100);

        NomField.setMinimumSize(new java.awt.Dimension(12, 20));
        getContentPane().add(NomField);
        NomField.setBounds(210, 150, 109, 30);

        jErreur.setBackground(new java.awt.Color(255, 255, 255));
        jErreur.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jErreur);
        jErreur.setBounds(33, 259, 476, 47);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/urne.jpg"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setInheritsPopupMenu(false);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 530, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnvoyerIdentiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnvoyerIdentiteActionPerformed
        boolean bool;
        Base base= new Base() ;
        AdminService serviceAdmin=new AdminService();
        jErreur.setText("");
        String message="identifiant ou mot de passe erronés,\n veuillez recommencer !";
        System.out.println("nom="+NomField.getText()+"; passe="+PasseField.getText());
        bool=serviceAdmin.verifierAdmin(base.connexion(), NomField.getText(),PasseField.getText());
        if(bool==true){
            System.out.println("bienvenue");
            VueAdministration choixvue =new VueAdministration();
            this.dispose();
            choixvue.show();
        } else if (bool== false){
            jErreur.setText(message);
            System.out.println("oups, erreur");
        }    
    }//GEN-LAST:event_EnvoyerIdentiteActionPerformed
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
            java.util.logging.Logger.getLogger(AccueilVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccueilVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccueilVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccueilVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccueilVue().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Entete;
    private javax.swing.JButton EnvoyerIdentite;
    private javax.swing.JTextField NomField;
    private javax.swing.JLabel NomLabel;
    private javax.swing.JPasswordField PasseField;
    private javax.swing.JLabel PasseLabel;
    private javax.swing.JLabel jErreur;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
