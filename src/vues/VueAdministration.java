package vues;

import bdd.Base;
import bdd.BureauDeVote;
import bdd.Candidat;
import bdd.Electeur;
import bdd.Election;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;
import services.BureauService;
import services.CandidatService;
import services.ElecteurService;
import services.ElectionService;

/**
 *
 * @author OlivierGuillaume
 */
public class VueAdministration extends javax.swing.JFrame {
    private final Base base = new Base();
    /**
     * Creates new form VueAdministration
     */
    public VueAdministration() {
        setTitle("Gestion des elections");
        initComponents();
        chargerListeBureau();
        chargerTableElecteur();
        chargerListeElection();
        chargerTableCandidat();
        chargerTableElection();
        chargerListe2Bureaux();
        chargerListeBoxBureaux();
        chargerListeBoxElection();
        chargerTableBureaux();
       
        buildMenu();
    }
    private void buildMenu(){ 
        //création du menu de choix 
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Connexion");
		JMenuItem quitter = new JMenuItem(new QuitterAction("Quitter"));
		menu1.add(quitter);
		menuBar.add(menu1);
 
		JMenu menu2 = new JMenu("A propos");
		JMenuItem aPropos = new JMenuItem(new AProposAction(this, "A propos"));
		menu2.add(aPropos);
		menuBar.add(menu2);
		setJMenuBar(menuBar);
	}
    private void chargerTableElecteur(){
        Connection connexion = base.connexion();
        ElecteurService serviceElecteur = new ElecteurService();
        DefaultTableModel table = (DefaultTableModel) pElecteurs1.getjTableElecteur().getModel();
        List<Electeur> listeElecteurs = serviceElecteur.findAll(connexion);
        for (Electeur elector : listeElecteurs) {
            int id = elector.getIdElecteur();
            String nom = elector.getPersonne().getNom();
            String prenom = elector.getPersonne().getPrenom();
            String adresse = elector.getPersonne().getAdresse();
            String datenaissance = convertSQlStringDateToStringUtilDate(elector.getDatedenaissance().toString());
            Object[] row ={id,nom,prenom,adresse,datenaissance};
            table.addRow(row);
        }
        base.deconnexion(connexion);
    }
    private void chargerListeBureau(){
    // charger la liste des bureaux - Panneau Electeurs
       pElecteurs1.getjBoxBureau().setMaximumRowCount(15);
       pElecteurs1.getjBoxBureau().setBackground(Color.GREEN);  
       BureauService serviceBureau = new BureauService();
       Connection connexion = base.connexion();
       List<BureauDeVote> listeBureaux =serviceBureau.listeBureau(connexion);
       pElecteurs1.getjBoxBureau().setModel(new DefaultComboBoxModel(listeBureaux.toArray()));
       pElecteurs1.getjBoxBureau().setRenderer(new ListCellRenderer(){
           @Override
           public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
               BureauDeVote bureau = (BureauDeVote) value;
               String s=bureau.getNumBureau()+" "+bureau.getLibelle();
               JLabel label = new JLabel(s);
               return label;
           }
       });
       base.deconnexion(connexion);      
    }
    private void chargerTableCandidat(){
        Connection connexion= base.connexion();
        ElectionService serviceElection = new ElectionService();
        CandidatService serviceCandidat = new CandidatService();
        DefaultTableModel table = (DefaultTableModel) pCandidats1.getjTableCandidat().getModel();
        List<Candidat> listCandidats = serviceCandidat.listeCandidat(connexion);
        for (Candidat candidate : listCandidats) {
            int id = candidate.getIdCandidat();
            String nom = candidate.getPersonne().getNom();
            String prenom = candidate.getPersonne().getPrenom();
            Object[] row ={id,nom,prenom};
            table.addRow(row);
        }
        base.deconnexion(connexion);
    }
    private void chargerListeElection(){
    // charger la liste des elections - Panneau Candidats
       pCandidats1.getjBoxElection().setMaximumRowCount(15);
       pCandidats1.getjBoxElection().setBackground(Color.GREEN);    
       Connection connexion = base.connexion();
       ElectionService serviceElection = new ElectionService();
       List<Election> listeElections = serviceElection.listeElection(connexion);
       if(listeElections.size()>0){
           pCandidats1.getjBoxElection().setModel(new DefaultComboBoxModel(listeElections.toArray()));
           pCandidats1.getjBoxElection().setRenderer(new ListCellRenderer() {
               @Override
               public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                   Election elect = (Election) value;
                   String s=elect.getIdElection()+" "+elect.getNom();
                   JLabel label = new JLabel(s);
                   return label;
               }
           });
       }
       base.deconnexion(connexion);       
    }
    private void chargerTableElection(){
        Connection connexion = base.connexion();
        ElectionService serviceElection = new ElectionService();
        DefaultTableModel table = (DefaultTableModel) pElections1.getjTableElection().getModel();
        List<Election> listeElections = serviceElection.listeElection(connexion);
        for(Election elect : listeElections){
            int id = elect.getIdElection();
            String nom = elect.getNom();
            String type = elect.getType();
            String date = convertSQlStringDateToStringUtilDate(elect.getDateElection().toString());
            Object[] row ={id,nom,type,date};
            table.addRow(row);
        }
        base.deconnexion(connexion);
    }
    private void chargerListe2Bureaux(){
        DefaultListModel listeModel = new DefaultListModel();
        Connection connexion= base.connexion();
        BureauService serviceBureau = new BureauService();
        List<BureauDeVote> listeBureaux = serviceBureau.listeBureau(connexion);
        for(BureauDeVote bureaux : listeBureaux){
            String libelle = bureaux.getLibelle();
            String numBureau= bureaux.getNumBureau().toString();
            listeModel.addElement(numBureau+" "+libelle);
        }
        pElections1.getjListeBureaux().setModel(listeModel);    
    }   
    private void chargerListeBoxBureaux(){
    // remplir la liste des bureaux (mode Box)- Panneau resultat
        pResultats1.getjComboBoxBureau().setMaximumRowCount(15);
        pResultats1.getjComboBoxBureau().setBackground(Color.GREEN);  
        BureauService serviceBureau = new BureauService();
        Connection connexion = base.connexion();
        List<BureauDeVote> listeBureaux =serviceBureau.listeBureau(connexion);
        pResultats1.getjComboBoxBureau().setModel(new DefaultComboBoxModel(listeBureaux.toArray()));
        pResultats1.getjComboBoxBureau().setRenderer(new ListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                BureauDeVote bureau = (BureauDeVote) value;
                String s=bureau.getNumBureau()+" "+bureau.getLibelle();
                JLabel label = new JLabel(s);
                return label;
            }
        });
        base.deconnexion(connexion);    
    } 
     private void chargerListeBoxElection(){
    // remplir la liste des elections (mode Box)- Panneau resultat
        pResultats1.getjComboBoxElection().setMaximumRowCount(15);
        pResultats1.getjComboBoxElection().setBackground(Color.GREEN);  
        ElectionService serviceElection = new ElectionService();
        Connection connexion = base.connexion();
        List<Election> listeElections =serviceElection.listeElection(connexion);
        if(listeElections.size()>0){
            pResultats1.getjComboBoxElection().setModel(new DefaultComboBoxModel(listeElections.toArray()));
            pResultats1.getjComboBoxElection().setRenderer(new ListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, 
                        boolean isSelected, boolean cellHasFocus) {
                    Election election =(Election) value;
                    String s=election.getNom();
                    JLabel label = new JLabel(s);
                    return label;
                }
            });
        }
        base.deconnexion(connexion);
     }
     private void chargerTableBureaux(){
        Connection connexion = base.connexion();
       BureauService serviceBureau = new BureauService();
        DefaultTableModel table = (DefaultTableModel) pBureaux1.getjTableBureaux().getModel();
        List<BureauDeVote> listeBureaux = serviceBureau.listeBureau(connexion);
        for(BureauDeVote bur : listeBureaux){
            int id = bur.getNumBureau();
            String nom = bur.getLibelle();
            String adresse = bur.getAdresse();
            System.out.println("coucou la table");
            Object[] row ={id,nom,adresse};
            table.addRow(row);
        }
        base.deconnexion(connexion);
    }
     
    
     public String[] listerFichiers(File repertoire){
         return repertoire.list();
     }
    public static java.sql.Date convertUtiltoSQLDate(java.util.Date javaDate) {
        //conversion de java.util.date -> java.sql.Date
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new java.sql.Date(javaDate.getTime());
        }
        return sqlDate;
    }
    public static String convertSQlStringDateToStringUtilDate(String stringSQLDate){
        //conversion d'une Date SQL en String vers une Date util en String
        // format aaaa-mm-jj vers jj/mm/aaaa
        String stringUtilDate="";
        String annee=stringSQLDate.split("-")[0];
        String mois=stringSQLDate.split("-")[1];
        String jour=stringSQLDate.split("-")[2];
        stringUtilDate+=jour;
        stringUtilDate+="/";
        stringUtilDate+=mois;
        stringUtilDate+="/";
        stringUtilDate+=annee;
        return stringUtilDate;
    }
    // controle de la Date saisie
    public static  boolean controleDate(String jour,String mois,String annee, boolean election){
        boolean controleOK = true;
        int Annee=Integer.parseInt(annee);
        int Mois=Integer.parseInt(mois);
        int Jour=Integer.parseInt(jour);
        if (Annee<1900 || Mois>12 || Mois<0 || Jour<1 || Jour>31)
                 controleOK=false;
        else{
        LocalDate date; date = LocalDate.of(Annee, Mois, Jour);
        if(LocalDate.now().compareTo(date)<0 && election==false){
            controleOK=false;
        }}
        return controleOK;
    }
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VueAdmin = new javax.swing.JTabbedPane();
        pCandidats1 = new vues.pCandidats();
        pElecteurs1 = new vues.pElecteurs();
        pElections1 = new vues.pElections();
        pResultats1 = new vues.pResultats();
        pBureaux1 = new vues.pBureaux();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VueAdmin.addTab("Candidats", pCandidats1);
        VueAdmin.addTab("Electeurs", pElecteurs1);
        VueAdmin.addTab("Elections", pElections1);
        VueAdmin.addTab("Resultats", pResultats1);
        VueAdmin.addTab("Bureaux de vote", pBureaux1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VueAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VueAdmin, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueAdministration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane VueAdmin;
    private vues.pBureaux pBureaux1;
    private vues.pCandidats pCandidats1;
    private vues.pElecteurs pElecteurs1;
    private vues.pElections pElections1;
    private vues.pResultats pResultats1;
    // End of variables declaration//GEN-END:variables

    
}
