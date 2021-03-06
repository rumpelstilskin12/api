/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.CoursDAO;
import formation.DAO.SessionCoursDAO;
import formation.metier.Cours;
import formation.metier.SessionCours;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    SessionCoursDAO sessionCoursDAO=null;
    SessionCours s=null;
     DefaultTableModel dft1 = new DefaultTableModel();
     SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
    public RechCoursIdcours() {
        initComponents();
        dft1.addColumn("idsesscours");
        dft1.addColumn("date debut");
        dft1.addColumn("date fin");
        dft1.addColumn("nombres d'inscrits");
        dft1.addColumn("idlocal");
        jTable1.setModel(dft1);
    }
     
    public void setCoursDAO(CoursDAO coursDAO){
        this.coursDAO=coursDAO;
    }
    public void setSessionCoursDAO(SessionCoursDAO sessionCoursDAO){
        this.sessionCoursDAO=sessionCoursDAO;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        labelIdcours.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelIdcours.setForeground(new java.awt.Color(0, 153, 255));
        labelIdcours.setText("idcours");

        labelMatiere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelMatiere.setForeground(new java.awt.Color(0, 153, 255));
        labelMatiere.setText("matiere");

        labelHeures.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelHeures.setForeground(new java.awt.Color(0, 153, 255));
        labelHeures.setText("heures");

        btRecherche.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btRecherche.setText("rechercher");
        btRecherche.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));
        btRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercheActionPerformed(evt);
            }
        });

        btMaj.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btMaj.setText("maj");
        btMaj.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));
        btMaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMajActionPerformed(evt);
            }
        });

        btSupprimer.setBackground(new java.awt.Color(153, 153, 153));
        btSupprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btSupprimer.setText("supprimer");
        btSupprimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));
        btSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSupprimerActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Idsesscours", "date debut", "date fin", "nombre d'inscrits", "idlocal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recherche d'un cours selon son idcours");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelIdcours)
                                .addGap(135, 135, 135)
                                .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelMatiere)
                                    .addComponent(labelHeures))
                                .addGap(134, 134, 134)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHeures, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(323, 323, 323))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(btMaj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdcours))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMatiere)
                    .addComponent(txtMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHeures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHeures))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSupprimer)
                    .addComponent(btRecherche)
                    .addComponent(btMaj))
                .addGap(80, 80, 80))
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
             
               //String matiere =txtMatiere.getText();
                List<SessionCours> alc= sessionCoursDAO.rechSessionCours(idcours);
                int nr = dft1.getRowCount();
                for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
                for(SessionCours m:alc){
                    Vector v = new Vector();
                    v.add(m.getIdsesscours());
                    v.add(m.getDatedebut());
                    v.add(m.getDatefin());
                    v.add(m.getNbreinscrits());
                    v.add(m.getIdlocal());
                    dft1.addRow(v);

                    }
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
             //sessionCoursDAO.delete(s); ==> ne pas prendre en compte 
             
             
             JOptionPane.showMessageDialog(this,"cours effacé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR ",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btSupprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMaj;
    private javax.swing.JButton btRecherche;
    private javax.swing.JButton btSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelHeures;
    private javax.swing.JLabel labelIdcours;
    private javax.swing.JLabel labelMatiere;
    private javax.swing.JTextField txtHeures;
    private javax.swing.JTextField txtIdcours;
    private javax.swing.JTextField txtMatiere;
    // End of variables declaration//GEN-END:variables
}
