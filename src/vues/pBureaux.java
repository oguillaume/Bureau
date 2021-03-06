/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import bdd.Base;
import java.sql.Connection;
import javax.swing.JTable;
import services.BureauService;

/**
 *
 * @author adm
 */
public class pBureaux extends javax.swing.JPanel {
    Base base = new Base();
    /**
     * Creates new form pBureaux
     */
    public pBureaux() {
        initComponents();
    }

    public JTable getjTableBureaux() {
        return jTableBureaux;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFieldNom = new javax.swing.JTextField();
        jFieldAdresse = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBureaux = new javax.swing.JTable();
        AjouterBoutonB = new javax.swing.JButton();
        ModifierBoutonB = new javax.swing.JButton();
        RetirerBoutonB = new javax.swing.JButton();
        jFieldId = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 255, 204));
        setPreferredSize(new java.awt.Dimension(600, 300));

        jLabel1.setText("Nom");

        jLabel2.setText("Adresse");

        jTableBureaux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nom", "Adresse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableBureaux.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBureauxMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBureaux);

        AjouterBoutonB.setBackground(new java.awt.Color(102, 204, 0));
        AjouterBoutonB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Lancer.jpg"))); // NOI18N
        AjouterBoutonB.setText("Ajouter");
        AjouterBoutonB.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        AjouterBoutonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterBoutonBActionPerformed(evt);
            }
        });

        ModifierBoutonB.setBackground(new java.awt.Color(51, 51, 255));
        ModifierBoutonB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Etoile.jpg"))); // NOI18N
        ModifierBoutonB.setText("Modifier");
        ModifierBoutonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierBoutonBActionPerformed(evt);
            }
        });

        RetirerBoutonB.setBackground(new java.awt.Color(255, 204, 51));
        RetirerBoutonB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Rond.jpg"))); // NOI18N
        RetirerBoutonB.setText("Retirer");
        RetirerBoutonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirerBoutonBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AjouterBoutonB)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jFieldNom, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addComponent(jFieldAdresse)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(ModifierBoutonB)
                        .addGap(80, 80, 80)
                        .addComponent(RetirerBoutonB)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AjouterBoutonB)
                    .addComponent(ModifierBoutonB)
                    .addComponent(RetirerBoutonB))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterBoutonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterBoutonBActionPerformed
   //     if(jFieldNom.getText().equals("#^[(A-Za-z0-9\'\_)]")){
            
    //    }
    }//GEN-LAST:event_AjouterBoutonBActionPerformed

    private void ModifierBoutonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierBoutonBActionPerformed
       BureauService serviceBureau = new BureauService();
       Connection connexion = base.connexion();
       serviceBureau.modifierBureau(connexion, jFieldNom.getText(),jFieldAdresse.getText(), Integer.parseInt(jFieldId.getText()));
    }//GEN-LAST:event_ModifierBoutonBActionPerformed

    private void RetirerBoutonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirerBoutonBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RetirerBoutonBActionPerformed

    private void jTableBureauxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBureauxMouseClicked
        int numeroLigne=jTableBureaux.getSelectedRow();
        int numBureau=(int)jTableBureaux.getValueAt(numeroLigne, 0);
        String nom=(String)jTableBureaux.getValueAt(numeroLigne, 1);
        String adresse=(String)jTableBureaux.getValueAt(numeroLigne,2);
        jFieldNom.setText(nom);
        jFieldAdresse.setText(adresse);
        jFieldId.setVisible(false);
        jFieldId.setText(String.valueOf(numBureau));
    }//GEN-LAST:event_jTableBureauxMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterBoutonB;
    private javax.swing.JButton ModifierBoutonB;
    private javax.swing.JButton RetirerBoutonB;
    private javax.swing.JTextField jFieldAdresse;
    private javax.swing.JTextField jFieldId;
    private javax.swing.JTextField jFieldNom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBureaux;
    // End of variables declaration//GEN-END:variables
}
