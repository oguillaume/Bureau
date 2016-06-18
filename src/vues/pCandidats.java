/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import bdd.Base;
import bdd.Election;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import services.CandidatService;
import services.ElectionService;

/**
 *
 * @author adm
 */
public class pCandidats extends javax.swing.JPanel {
    private final Base base = new Base();
    /**
     * Creates new form pCandidats
     */
    public pCandidats() {
        initComponents();
    }

    public JTable getjTableCandidat() {
        return jTableCandidat;
    }

    public JComboBox getjBoxElection() {
        return jBoxElection;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNomCand = new javax.swing.JTextField();
        jPrenomCand = new javax.swing.JTextField();
        jPhoto = new javax.swing.JTextField();
        jLabelNomCand = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCandidat = new javax.swing.JTable();
        jLabelPrenomCand = new javax.swing.JLabel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelProg = new javax.swing.JLabel();
        jAccroche = new javax.swing.JTextField();
        jLabelElection = new javax.swing.JLabel();
        jBoxElection = new javax.swing.JComboBox();
        AjouterBoutonC = new javax.swing.JButton();
        ModifierBoutonC = new javax.swing.JButton();
        RetirerBoutonC = new javax.swing.JButton();
        jIdCandidat = new javax.swing.JLabel();
        AnnulerBoutonC = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 102));
        setPreferredSize(new java.awt.Dimension(650, 300));

        jLabelNomCand.setText("Nom");

        jTableCandidat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nom", "Prenom"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCandidat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCandidatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCandidat);

        jLabelPrenomCand.setText("Prenom");

        jLabelPhoto.setText("Photo");

        jLabelProg.setText("Accroche");

        jLabelElection.setText("Election");

        jBoxElection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "election" }));
        jBoxElection.setToolTipText("election");

        AjouterBoutonC.setBackground(new java.awt.Color(102, 255, 102));
        AjouterBoutonC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Lancer.jpg"))); // NOI18N
        AjouterBoutonC.setText("Ajouter");
        AjouterBoutonC.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        AjouterBoutonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterBoutonCActionPerformed(evt);
            }
        });

        ModifierBoutonC.setBackground(new java.awt.Color(102, 102, 255));
        ModifierBoutonC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Etoile.jpg"))); // NOI18N
        ModifierBoutonC.setText("Modifier");
        ModifierBoutonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierBoutonCActionPerformed(evt);
            }
        });

        RetirerBoutonC.setBackground(new java.awt.Color(255, 153, 0));
        RetirerBoutonC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Rond.jpg"))); // NOI18N
        RetirerBoutonC.setText("Retirer");
        RetirerBoutonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirerBoutonCActionPerformed(evt);
            }
        });

        AnnulerBoutonC.setBackground(new java.awt.Color(255, 51, 51));
        AnnulerBoutonC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/Arreter.jpg"))); // NOI18N
        AnnulerBoutonC.setText("Annuler");
        AnnulerBoutonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerBoutonCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomCand)
                    .addComponent(jLabelPrenomCand)
                    .addComponent(jLabelPhoto)
                    .addComponent(jLabelProg)
                    .addComponent(jLabelElection))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(AjouterBoutonC)
                        .addGap(36, 36, 36)
                        .addComponent(ModifierBoutonC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(RetirerBoutonC)
                        .addGap(18, 18, 18)
                        .addComponent(AnnulerBoutonC)
                        .addGap(417, 417, 417))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jNomCand, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPrenomCand, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jAccroche, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jBoxElection, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(358, 358, 358)
                    .addComponent(jIdCandidat)
                    .addContainerGap(642, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNomCand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNomCand))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPrenomCand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrenomCand))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPhoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProg)
                            .addComponent(jAccroche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabelElection))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBoxElection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AjouterBoutonC)
                        .addComponent(ModifierBoutonC))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AnnulerBoutonC)
                        .addComponent(RetirerBoutonC)))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addComponent(jIdCandidat)
                    .addContainerGap(174, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCandidatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCandidatMouseClicked
        int numeroLigne=jTableCandidat.getSelectedRow();
        int idCandidat=(int)jTableCandidat.getValueAt(numeroLigne, 0);
        String nom=(String)jTableCandidat.getValueAt(numeroLigne, 1);
        String prenom=(String)jTableCandidat.getValueAt(numeroLigne,2);
        jNomCand.setText(nom);
        jPrenomCand.setText(prenom);
        jIdCandidat.setVisible(false);
        jIdCandidat.setText(String.valueOf(idCandidat));
    }//GEN-LAST:event_jTableCandidatMouseClicked

    private void AjouterBoutonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterBoutonCActionPerformed
        CandidatService serviceCandidat = new CandidatService();
        ElectionService serviceElection = new ElectionService();
        Connection connexion = base.connexion();
        int idElection = Integer.parseInt(jBoxElection.getSelectedItem().toString());
        Election election = serviceElection.chargerElection(base.connexion(), idElection);
        serviceCandidat.creerCandidat(connexion, jNomCand.getText(), jPrenomCand.getText(), "", jAccroche.getText(), jPhoto.getText(), election);
        base.deconnexion(connexion);
    }//GEN-LAST:event_AjouterBoutonCActionPerformed

    private void ModifierBoutonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierBoutonCActionPerformed
        CandidatService serviceCandidat = new CandidatService();
        ElectionService serviceElection = new ElectionService();
        Connection connexion = base.connexion();
        int idElection = Integer.parseInt(jBoxElection.getSelectedItem().toString());
        Election election = serviceElection.chargerElection(base.connexion(), idElection);
        serviceCandidat.creerCandidat(connexion, jNomCand.getText(), jPrenomCand.getText(), "",
                jAccroche.getText(), jPhoto.getText(), election);
        int idCndidat=Integer.parseInt(jIdCandidat.getText());
        base.deconnexion(connexion);
    }//GEN-LAST:event_ModifierBoutonCActionPerformed

    private void RetirerBoutonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirerBoutonCActionPerformed
        Connection connexion = base.connexion();
        CandidatService serviceCandidat = new CandidatService();
        int id=jTableCandidat.getSelectedRow();
        serviceCandidat.retirerCandidat(connexion,id);
        base.deconnexion(connexion);
    }//GEN-LAST:event_RetirerBoutonCActionPerformed

    private void AnnulerBoutonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerBoutonCActionPerformed
        /*       VueChoix choixvue =new VueChoix();  // à revoir
        this.dispose();
        choixvue.show();*/
    }//GEN-LAST:event_AnnulerBoutonCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterBoutonC;
    private javax.swing.JButton AnnulerBoutonC;
    private javax.swing.JButton ModifierBoutonC;
    private javax.swing.JButton RetirerBoutonC;
    private javax.swing.JTextField jAccroche;
    private javax.swing.JComboBox jBoxElection;
    private javax.swing.JLabel jIdCandidat;
    private javax.swing.JLabel jLabelElection;
    private javax.swing.JLabel jLabelNomCand;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JLabel jLabelPrenomCand;
    private javax.swing.JLabel jLabelProg;
    private javax.swing.JTextField jNomCand;
    private javax.swing.JTextField jPhoto;
    private javax.swing.JTextField jPrenomCand;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCandidat;
    // End of variables declaration//GEN-END:variables
}
