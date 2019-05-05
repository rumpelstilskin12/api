/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.CoursDAO;
import formation.DAO.FormateurDAO;
import formation.DAO.LocalDAO;
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
    rechFormateurNom1.setFormateurDAO(formateurDAO);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creationLocal1 = new formation.graph.CreationLocal();
        rechLocalDescription1 = new formation.graph.RechLocalDescription();
        rechLocalSigle1 = new formation.graph.RechLocalSigle();
        creationCours1 = new formation.graph.CreationCours();
        creationFormateur1 = new formation.graph.CreationFormateur();
        rechCoursIdcours1 = new formation.graph.RechCoursIdcours();
        rechCoursMatiere1 = new formation.graph.RechCoursMatiere();
        rechFormateurNom1 = new formation.graph.RechFormateurNom();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuLocal = new javax.swing.JMenu();
        itemCreat = new javax.swing.JMenuItem();
        itemRechS = new javax.swing.JMenuItem();
        itemRechDesc = new javax.swing.JMenuItem();
        MenuCours = new javax.swing.JMenu();
        itemCreatC = new javax.swing.JMenuItem();
        itemRechIdcours = new javax.swing.JMenuItem();
        itemRechMat = new javax.swing.JMenuItem();
        MenuFormateur = new javax.swing.JMenu();
        itemCreatF = new javax.swing.JMenuItem();
        itemRechMatricule = new javax.swing.JMenuItem();
        itemRechNom = new javax.swing.JMenuItem();
        MenuSessionCours = new javax.swing.JMenu();
        MenuInfos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(creationLocal1, "cardCreation");
        getContentPane().add(rechLocalDescription1, "cardRechDesc");
        getContentPane().add(rechLocalSigle1, "cardRechSigle");
        getContentPane().add(creationCours1, "cardCreationCours");
        getContentPane().add(creationFormateur1, "cardCreationFormateur");
        getContentPane().add(rechCoursIdcours1, "cardRechCoursIdcours");
        getContentPane().add(rechCoursMatiere1, "cardRechCoursMatiere");
        getContentPane().add(rechFormateurNom1, "cardRechFormNom");

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

        MenuSessionCours.setText("SessionCours");
        jMenuBar1.add(MenuSessionCours);

        MenuInfos.setText("Infos");
        jMenuBar1.add(MenuInfos);

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
    private javax.swing.JMenu MenuInfos;
    private javax.swing.JMenu MenuLocal;
    private javax.swing.JMenu MenuSessionCours;
    private formation.graph.CreationCours creationCours1;
    private formation.graph.CreationFormateur creationFormateur1;
    private formation.graph.CreationLocal creationLocal1;
    private javax.swing.JMenuItem itemCreat;
    private javax.swing.JMenuItem itemCreatC;
    private javax.swing.JMenuItem itemCreatF;
    private javax.swing.JMenuItem itemRechDesc;
    private javax.swing.JMenuItem itemRechIdcours;
    private javax.swing.JMenuItem itemRechMat;
    private javax.swing.JMenuItem itemRechMatricule;
    private javax.swing.JMenuItem itemRechNom;
    private javax.swing.JMenuItem itemRechS;
    private javax.swing.JMenuBar jMenuBar1;
    private formation.graph.RechCoursIdcours rechCoursIdcours1;
    private formation.graph.RechCoursMatiere rechCoursMatiere1;
    private formation.graph.RechFormateurNom rechFormateurNom1;
    private formation.graph.RechLocalDescription rechLocalDescription1;
    private formation.graph.RechLocalSigle rechLocalSigle1;
    // End of variables declaration//GEN-END:variables
}
