/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.CoursDAO;
import formation.metier.Cours;
import javax.swing.JOptionPane;

/**
 *
 * @author BARCA
 */
public class RechCoursIdcours extends javax.swing.JPanel {

    /**
     * Creates new form RechCoursIdcours
     */
    CoursDAO coursDAO=null;
    Cours c=null;
    public RechCoursIdcours() {
        initComponents();
    }
     
    public void setCoursDAO(CoursDAO coursDAO){
        this.coursDAO=coursDAO;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelIdcours = new javax.swing.JLabel();
        labelMatiere = new javax.swing.JLabel();
        labelHeures = new javax.swing.JLabel();
        txtIdcours = new javax.swing.JTextField();
        txtMatiere = new javax.swing.JTextField();
        txtHeures = new javax.swing.JTextField();
        btRecherche = new javax.swing.JButton();
        btMaj = new javax.swing.JButton();
        btSupprimer = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));

        labelIdcours.setText("idcours");

        labelMatiere.setText("matiere");

        labelHeures.setText("heures");

        btRecherche.setText("rechercher");
        btRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercheActionPerformed(evt);
            }
        });

        btMaj.setText("maj");
        btMaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMajActionPerformed(evt);
            }
        });

        btSupprimer.setBackground(new java.awt.Color(153, 153, 153));
        btSupprimer.setText("supprimer");
        btSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIdcours)
                    .addComponent(labelMatiere)
                    .addComponent(labelHeures)
                    .addComponent(btRecherche))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMatiere, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(txtIdcours)
                            .addComponent(txtHeures))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btMaj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btSupprimer)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdcours)
                    .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMatiere)
                    .addComponent(txtMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHeures)
                    .addComponent(txtHeures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRecherche)
                    .addComponent(btMaj)
                    .addComponent(btSupprimer))
                .addContainerGap(155, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechercheActionPerformed
        // TODO add your handling code here:
        try{
             int idcours= Integer.parseInt(txtIdcours.getText());
             c=coursDAO.read(idcours);
             txtMatiere.setText(c.getMatiere());
             txtHeures.setText(""+c.getHeures());
             JOptionPane.showMessageDialog(this,"cours trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
    }                                           
    }//GEN-LAST:event_btRechercheActionPerformed

    private void btMajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMajActionPerformed
        // TODO add your handling code here:
        try{  
             int idcours=Integer.parseInt(txtIdcours.getText());
              String matiere=txtMatiere.getText();
             int heures=Integer.parseInt(txtHeures.getText());
             Cours c= new Cours(idcours,matiere,heures);
             coursDAO.update(c);
             JOptionPane.showMessageDialog(this,"cours mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);
       
             }
        catch(Exception e){
                   JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_btMajActionPerformed

    private void btSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSupprimerActionPerformed
        // TODO add your handling code here:
         try{
             int idcours=Integer.parseInt(txtIdcours.getText());
             coursDAO.delete(c);
             txtMatiere.setText("");
             txtHeures.setText("");
             
             JOptionPane.showMessageDialog(this,"cours effacé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btSupprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMaj;
    private javax.swing.JButton btRecherche;
    private javax.swing.JButton btSupprimer;
    private javax.swing.JLabel labelHeures;
    private javax.swing.JLabel labelIdcours;
    private javax.swing.JLabel labelMatiere;
    private javax.swing.JTextField txtHeures;
    private javax.swing.JTextField txtIdcours;
    private javax.swing.JTextField txtMatiere;
    // End of variables declaration//GEN-END:variables
}
