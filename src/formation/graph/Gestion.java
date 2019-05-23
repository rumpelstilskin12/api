/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.CoursDAO;
import formation.DAO.FormateurDAO;
import formation.DAO.LocalDAO;
import formation.DAO.SessionCoursDAO;
import formation.DAO.VueHeuresSessionDAO;
import formation.DAO.VueSessionCoursFormateurDAO;
import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import myconnections.DBConnection;
/**
 *
 * @author BARCA
 */
public class Gestion extends javax.swing.JFrame {

    /**
     * Creates new form GestionLocal
     */
    CardLayout cardl;
    public Gestion() {
        initComponents();
        cardl=(CardLayout)this.getContentPane().getLayout();
         Connection dbConnect = DBConnection.getConnection();
   
        if (dbConnect == null) {
            System.out.println("connection invalide");
            JOptionPane.showMessageDialog(this,"connexion invalide","ERREUR",JOptionPane.ERROR_MESSAGE);
        }
         
 
    LocalDAO localDAO = new LocalDAO();
    localDAO.setConnection(dbConnect);
    creationLocal1.setLocalDAO(localDAO);
    rechLocalDescription1.setLocalDAO(localDAO);
    rechLocalSigle1.setLocalDAO(localDAO);
    
    CoursDAO coursDAO = new CoursDAO();
    coursDAO.setConnection(dbConnect);
    creationCours1.setCoursDAO(coursDAO);
    rechCoursIdcours1.setCoursDAO(coursDAO);
    rechCoursMatiere1.setCoursDAO(coursDAO);
    
    FormateurDAO formateurDAO = new FormateurDAO();
    formateurDAO.setConnection(dbConnect);
    creationFormateur1.setFormateurDAO(formateurDAO);
    rechFormateurMatricule1.setFormateurDAO(formateurDAO);
    rechFormateurNom1.setFormateurDAO(formateurDAO);
    
    SessionCoursDAO sessionCoursDAO = new SessionCoursDAO();
    sessionCoursDAO.setConnection(dbConnect);
    creationSessionCours1.setSessionCoursDAO(sessionCoursDAO);
    rechSessionCours1.setSessionCoursDAO(sessionCoursDAO);
    rechCoursIdcours1.setSessionCoursDAO(sessionCoursDAO);
    
    
    VueHeuresSessionDAO vueHeuresSessionDAO = new VueHeuresSessionDAO();
    vueHeuresSessionDAO.setConnection(dbConnect);
    vueHeuresSessionG1.setVueHeuresSessionDAO(vueHeuresSessionDAO);
    
    VueSessionCoursFormateurDAO vueSessionCoursFormateurDAO = new VueSessionCoursFormateurDAO();
    vueSessionCoursFormateurDAO.setConnection(dbConnect);
    vueSessionCoursFormateurG1.setVueSessionCoursFormateurDAO(vueSessionCoursFormateurDAO);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home1 = new formation.graph.home();
        rechLocalDescription1 = new formation.graph.RechLocalDescription();
        rechLocalSigle1 = new formation.graph.RechLocalSigle();
        creationFormateur1 = new formation.graph.CreationFormateur();
        rechFormateurNom1 = new formation.graph.RechFormateurNom();
        rechFormateurMatricule1 = new formation.graph.RechFormateurMatricule();
        creationLocal1 = new formation.graph.CreationLocal();
        creationSessionCours1 = new formation.graph.CreationSessionCours();
        rechCoursIdcours1 = new formation.graph.RechCoursIdcours();
        rechCoursMatiere1 = new formation.graph.RechCoursMatiere();
        vueHeuresSessionG1 = new formation.graph.VueHeuresSessionG();
        vueSessionCoursFormateurG1 = new formation.graph.VueSessionCoursFormateurG();
        rechSessionCours1 = new formation.graph.RechSessionCours();
        creationCours1 = new formation.graph.CreationCours();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuHome = new javax.swing.JMenu();
        MenuCours = new javax.swing.JMenu();
        itemCreatC = new javax.swing.JMenuItem();
        itemRechIdcours = new javax.swing.JMenuItem();
        itemRechMat = new javax.swing.JMenuItem();
        MenuFormateur = new javax.swing.JMenu();
        itemCreatF = new javax.swing.JMenuItem();
        itemRechMatricule = new javax.swing.JMenuItem();
        itemRechNom = new javax.swing.JMenuItem();
        MenuInfos = new javax.swing.JMenu();
        MenuLocal = new javax.swing.JMenu();
        itemCreat = new javax.swing.JMenuItem();
        itemRechS = new javax.swing.JMenuItem();
        itemRechDesc = new javax.swing.JMenuItem();
        MenuSessionCours = new javax.swing.JMenu();
        itemSessionCours = new javax.swing.JMenuItem();
        itemRechSessionCours = new javax.swing.JMenuItem();
        MenuVueAffichage = new javax.swing.JMenu();
        vueHeuresSession = new javax.swing.JMenuItem();
        vueSessionCoursFormateur = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(home1, "cardHome");
        getContentPane().add(rechLocalDescription1, "cardRechDesc");
        getContentPane().add(rechLocalSigle1, "cardRechSigle");
        getContentPane().add(creationFormateur1, "cardCreationFormateur");
        getContentPane().add(rechFormateurNom1, "cardRechFormNom");
        getContentPane().add(rechFormateurMatricule1, "cardRechFormMatricule");
        getContentPane().add(creationLocal1, "cardCreation");
        getContentPane().add(creationSessionCours1, "cardSessionCours");
        getContentPane().add(rechCoursIdcours1, "cardRechCoursIdcours");
        getContentPane().add(rechCoursMatiere1, "cardRechCoursMatiere");
        getContentPane().add(vueHeuresSessionG1, "cardHeuresSession");
        getContentPane().add(vueSessionCoursFormateurG1, "cardVueSessionCoursForm");
        getContentPane().add(rechSessionCours1, "cardRechSessionCours");
        getContentPane().add(creationCours1, "card16");

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        MenuHome.setBackground(new java.awt.Color(255, 255, 255));
        MenuHome.setText("Accueil");
        MenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuHomeMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuHome);

        MenuCours.setText("Cours");

        itemCreatC.setText("créer ");
        itemCreatC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreatCActionPerformed(evt);
            }
        });
        MenuCours.add(itemCreatC);

        itemRechIdcours.setText("recherche par idcours");
        itemRechIdcours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechIdcoursActionPerformed(evt);
            }
        });
        MenuCours.add(itemRechIdcours);

        itemRechMat.setText("recherche par matiere");
        itemRechMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechMatActionPerformed(evt);
            }
        });
        MenuCours.add(itemRechMat);

        jMenuBar1.add(MenuCours);

        MenuFormateur.setText("Formateur");

        itemCreatF.setText("créer");
        itemCreatF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreatFActionPerformed(evt);
            }
        });
        MenuFormateur.add(itemCreatF);

        itemRechMatricule.setText("recherche par matricule");
        itemRechMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechMatriculeActionPerformed(evt);
            }
        });
        MenuFormateur.add(itemRechMatricule);

        itemRechNom.setText("recherche par nom");
        itemRechNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechNomActionPerformed(evt);
            }
        });
        MenuFormateur.add(itemRechNom);

        jMenuBar1.add(MenuFormateur);

        MenuInfos.setText("Infos");
        jMenuBar1.add(MenuInfos);

        MenuLocal.setText("Local");

        itemCreat.setText("créer");
        itemCreat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreatActionPerformed(evt);
            }
        });
        MenuLocal.add(itemCreat);

        itemRechS.setText("recherche par sigle");
        itemRechS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechSActionPerformed(evt);
            }
        });
        MenuLocal.add(itemRechS);

        itemRechDesc.setText("recherche par description");
        itemRechDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechDescActionPerformed(evt);
            }
        });
        MenuLocal.add(itemRechDesc);

        jMenuBar1.add(MenuLocal);

        MenuSessionCours.setText("SessionCours");

        itemSessionCours.setText("créer");
        itemSessionCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSessionCoursActionPerformed(evt);
            }
        });
        MenuSessionCours.add(itemSessionCours);

        itemRechSessionCours.setText("rechercheSessionCours");
        itemRechSessionCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechSessionCoursActionPerformed(evt);
            }
        });
        MenuSessionCours.add(itemRechSessionCours);

        jMenuBar1.add(MenuSessionCours);

        MenuVueAffichage.setText("Affichage");

        vueHeuresSession.setText("HeuresSession");
        vueHeuresSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vueHeuresSessionActionPerformed(evt);
            }
        });
        MenuVueAffichage.add(vueHeuresSession);

        vueSessionCoursFormateur.setText("SessionCoursFormateur");
        vueSessionCoursFormateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vueSessionCoursFormateurActionPerformed(evt);
            }
        });
        MenuVueAffichage.add(vueSessionCoursFormateur);

        jMenuBar1.add(MenuVueAffichage);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCreatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreatActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "cardCreation");
    }//GEN-LAST:event_itemCreatActionPerformed

    private void itemRechSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechSActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "cardRechSigle");
    }//GEN-LAST:event_itemRechSActionPerformed

    private void itemRechDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechDescActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "cardRechDesc");
    }//GEN-LAST:event_itemRechDescActionPerformed

    private void itemCreatCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreatCActionPerformed
        // TODO add your handling code here:
         cardl.show(this.getContentPane(), "cardCreationCours");
    }//GEN-LAST:event_itemCreatCActionPerformed

    private void itemCreatFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreatFActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "cardCreationFormateur");
    }//GEN-LAST:event_itemCreatFActionPerformed

    private void itemRechMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechMatriculeActionPerformed
        // TODO add your handling code here:
           cardl.show(this.getContentPane(), "cardRechFormMatricule");
    }//GEN-LAST:event_itemRechMatriculeActionPerformed

    private void itemRechNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechNomActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "cardRechFormNom");
    }//GEN-LAST:event_itemRechNomActionPerformed

    private void itemRechIdcoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechIdcoursActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(), "cardRechCoursIdcours");
    }//GEN-LAST:event_itemRechIdcoursActionPerformed

    private void itemRechMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechMatActionPerformed
        // TODO add your handling code here:
         cardl.show(this.getContentPane(), "cardRechCoursMatiere");
    }//GEN-LAST:event_itemRechMatActionPerformed

    private void MenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuHomeMouseClicked
        // TODO add your handling code here:
         cardl.show(this.getContentPane(), "cardHome");
    }//GEN-LAST:event_MenuHomeMouseClicked

    private void itemSessionCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSessionCoursActionPerformed
        // TODO add your handling code here:
         cardl.show(this.getContentPane(), "cardSessionCours");
    }//GEN-LAST:event_itemSessionCoursActionPerformed

    private void vueSessionCoursFormateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vueSessionCoursFormateurActionPerformed
        // TODO add your handling code here:
         cardl.show(this.getContentPane(),"cardVueSessionCoursForm");
    }//GEN-LAST:event_vueSessionCoursFormateurActionPerformed

    private void vueHeuresSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vueHeuresSessionActionPerformed
        // TODO add your handling code here:
         cardl.show(this.getContentPane(), "cardHeuresSession");
    }//GEN-LAST:event_vueHeuresSessionActionPerformed

    private void itemRechSessionCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechSessionCoursActionPerformed
        // TODO add your handling code here:
        cardl.show(this.getContentPane(),"cardRechSessionCours");
    }//GEN-LAST:event_itemRechSessionCoursActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCours;
    private javax.swing.JMenu MenuFormateur;
    private javax.swing.JMenu MenuHome;
    private javax.swing.JMenu MenuInfos;
    private javax.swing.JMenu MenuLocal;
    private javax.swing.JMenu MenuSessionCours;
    private javax.swing.JMenu MenuVueAffichage;
    private formation.graph.CreationCours creationCours1;
    private formation.graph.CreationFormateur creationFormateur1;
    private formation.graph.CreationLocal creationLocal1;
    private formation.graph.CreationSessionCours creationSessionCours1;
    private formation.graph.home home1;
    private javax.swing.JMenuItem itemCreat;
    private javax.swing.JMenuItem itemCreatC;
    private javax.swing.JMenuItem itemCreatF;
    private javax.swing.JMenuItem itemRechDesc;
    private javax.swing.JMenuItem itemRechIdcours;
    private javax.swing.JMenuItem itemRechMat;
    private javax.swing.JMenuItem itemRechMatricule;
    private javax.swing.JMenuItem itemRechNom;
    private javax.swing.JMenuItem itemRechS;
    private javax.swing.JMenuItem itemRechSessionCours;
    private javax.swing.JMenuItem itemSessionCours;
    private javax.swing.JMenuBar jMenuBar1;
    private formation.graph.RechCoursIdcours rechCoursIdcours1;
    private formation.graph.RechCoursMatiere rechCoursMatiere1;
    private formation.graph.RechFormateurMatricule rechFormateurMatricule1;
    private formation.graph.RechFormateurNom rechFormateurNom1;
    private formation.graph.RechLocalDescription rechLocalDescription1;
    private formation.graph.RechLocalSigle rechLocalSigle1;
    private formation.graph.RechSessionCours rechSessionCours1;
    private javax.swing.JMenuItem vueHeuresSession;
    private formation.graph.VueHeuresSessionG vueHeuresSessionG1;
    private javax.swing.JMenuItem vueSessionCoursFormateur;
    private formation.graph.VueSessionCoursFormateurG vueSessionCoursFormateurG1;
    // End of variables declaration//GEN-END:variables
}
