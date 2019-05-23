/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.CoursDAO;
import formation.DAO.SessionCoursDAO;
import formation.metier.Cours;
import formation.metier.Local;
import formation.metier.SessionCours;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BARCA
 */
public class RechCoursMatiere extends javax.swing.JPanel {

    /**
     * Creates new form RechCoursMatiere
     */
    CoursDAO coursDAO=null;
    SessionCoursDAO sessionCoursDAO=null;
    Cours c=null;
    
    DefaultTableModel dft1 = new DefaultTableModel();
    public RechCoursMatiere() {
        initComponents();
        dft1.addColumn("idcours");
        dft1.addColumn("matiere");
        dft1.addColumn("heures");
        jTable1.setModel(dft1);
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

        labelMatiere = new javax.swing.JLabel();
        txtMatiere = new javax.swing.JTextField();
        btRechercher = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        labelMatiere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelMatiere.setForeground(new java.awt.Color(0, 153, 255));
        labelMatiere.setText("matiere");

        txtMatiere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMatiere.setForeground(new java.awt.Color(255, 255, 255));

        btRechercher.setBackground(new java.awt.Color(153, 153, 153));
        btRechercher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btRechercher.setText("rechercher");
        btRechercher.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));
        btRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercherActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idcours", "matiere", "heures"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recherche d'un cours selon sa matière");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(labelMatiere)
                                .addGap(134, 134, 134)
                                .addComponent(txtMatiere))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(btRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMatiere))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btRechercher)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechercherActionPerformed
        // TODO add your handling code here:
         try{ 
             String matiere =txtMatiere.getText();
        
        List<Cours> alc= coursDAO.rechCoursMat(matiere);
       
        int nr = dft1.getRowCount();
        for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
        for(Cours m:alc){
            Vector v = new Vector();
            v.add(m.getIdcours());
            v.add(m.getMatiere());
            v.add(m.getHeures());
            dft1.addRow(v);
           
        }                      
        
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
       }
    
    }//GEN-LAST:event_btRechercherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRechercher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelMatiere;
    private javax.swing.JTextField txtMatiere;
    // End of variables declaration//GEN-END:variables
}
