/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.SessionCoursDAO;
import formation.metier.SessionCours;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author BARCA
 */
public class RechSessionCours extends javax.swing.JPanel {

    SessionCoursDAO sessionCoursDAO = null;
    SessionCours sessionCours = null;
    public RechSessionCours() {
        initComponents();
    }
    
    public void setSessionCoursDAO(SessionCoursDAO sessionCoursDAO) {
        this.sessionCoursDAO = sessionCoursDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btRechercher = new javax.swing.JButton();
        btMaj = new javax.swing.JButton();
        btSupprimer = new javax.swing.JButton();
        lbIdsesscours = new javax.swing.JLabel();
        lbDatedebut = new javax.swing.JLabel();
        lbDatefin = new javax.swing.JLabel();
        lbNbreinscrits = new javax.swing.JLabel();
        lbIdlocal = new javax.swing.JLabel();
        lbIdcours = new javax.swing.JLabel();
        txtIdsesscours = new javax.swing.JTextField();
        txtNbreinscrits = new javax.swing.JTextField();
        txtIdlocal = new javax.swing.JTextField();
        txtIdcours = new javax.swing.JTextField();
        txtDatedebut = new javax.swing.JFormattedTextField();
        txtDatefin = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        btRechercher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btRechercher.setText("rechercher");
        btRechercher.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));
        btRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercherActionPerformed(evt);
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

        btSupprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btSupprimer.setText("supprimer");
        btSupprimer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));
        btSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSupprimerActionPerformed(evt);
            }
        });

        lbIdsesscours.setForeground(new java.awt.Color(255, 255, 255));
        lbIdsesscours.setText("idsesscours");

        lbDatedebut.setForeground(new java.awt.Color(0, 153, 255));
        lbDatedebut.setText("datedebut");

        lbDatefin.setForeground(new java.awt.Color(0, 153, 255));
        lbDatefin.setText("datefin");

        lbNbreinscrits.setForeground(new java.awt.Color(0, 153, 255));
        lbNbreinscrits.setText("nbreinscrits");

        lbIdlocal.setForeground(new java.awt.Color(0, 153, 255));
        lbIdlocal.setText("idlocal");

        lbIdcours.setForeground(new java.awt.Color(0, 153, 255));
        lbIdcours.setText("idcours");

        txtDatedebut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));

        txtDatefin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yy"))));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recherche d'une session cours");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIdlocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIdcours)
                        .addGap(167, 167, 167)
                        .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNbreinscrits)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNbreinscrits, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDatefin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDatefin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDatedebut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDatedebut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIdsesscours)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(btMaj, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(btSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIdsesscours))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatedebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDatedebut))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatefin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDatefin))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNbreinscrits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNbreinscrits))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIdlocal))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIdcours))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRechercher)
                    .addComponent(btMaj)
                    .addComponent(btSupprimer))
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechercherActionPerformed
        // TODO add your handling code here:
        try{
              int idsesscours= Integer.parseInt(txtIdsesscours.getText());
             sessionCours = sessionCoursDAO.read(idsesscours);
             
             txtDatedebut.setText(""+sessionCours.getDatedebut());
             txtDatefin.setText(""+sessionCours.getDatefin());
             
             txtNbreinscrits.setText(""+sessionCours.getNbreinscrits());
             txtIdcours.setText(""+sessionCours.getIdcours());
             txtIdlocal.setText(""+sessionCours.getIdlocal());
             
             JOptionPane.showMessageDialog(this,"Session cours trouvée","succès",JOptionPane.INFORMATION_MESSAGE);
             
             
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
    }

     
    }//GEN-LAST:event_btRechercherActionPerformed

    private void btSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSupprimerActionPerformed
        // TODO add your handling code here:
        try {
                int idsesscours = Integer.parseInt(txtIdsesscours.getText());

                sessionCoursDAO.delete(sessionCours);
                txtIdsesscours.setText("");
                txtDatedebut.setText("");
                txtDatefin.setText("");
                txtNbreinscrits.setText("");
                txtIdcours.setText("");
                txtIdlocal.setText("");
                

                JOptionPane.showMessageDialog(this, "SessionCours effacé", "succès", JOptionPane.INFORMATION_MESSAGE);
             
       
         } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSupprimerActionPerformed

    private void btMajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMajActionPerformed
        // TODO add your handling code here:
           try {

            int idsesscours = Integer.parseInt(txtIdsesscours.getText());
           String datedeb = txtDatedebut.getText();
            int jourd = Integer.parseInt(datedeb.substring(0, 2)); //substring permet de délimiter les nombres que l'on prend de la chaine de caract
            int moisd = Integer.parseInt(datedeb.substring(4, 5));
            int and = Integer.parseInt(datedeb.substring(6));
            
            String datef = txtDatefin.getText();
            int jourf = Integer.parseInt(datef.substring(0, 2)); //substring permet de délimiter les nombres que l'on prend de la chaine de caract
            int moisf = Integer.parseInt(datef.substring(4, 5));
            int anf = Integer.parseInt(datef.substring(6));

            LocalDate datefin = LocalDate.of(anf, moisf, jourf);

            LocalDate datedebut = LocalDate.of(and, moisd, jourd);
            int nbreinscrits = Integer.parseInt(txtNbreinscrits.getText());
            int idlocal = Integer.parseInt(txtIdlocal.getText());
            int idcours = Integer.parseInt(txtIdcours.getText());
            
            SessionCours sessionCoursUp = new SessionCours(idsesscours,datedebut,datefin,nbreinscrits,idlocal,idcours);
            sessionCoursDAO.update(sessionCoursUp);
            JOptionPane.showMessageDialog(this, "SessionCours mis à jour", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btMajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMaj;
    private javax.swing.JButton btRechercher;
    private javax.swing.JButton btSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbDatedebut;
    private javax.swing.JLabel lbDatefin;
    private javax.swing.JLabel lbIdcours;
    private javax.swing.JLabel lbIdlocal;
    private javax.swing.JLabel lbIdsesscours;
    private javax.swing.JLabel lbNbreinscrits;
    private javax.swing.JFormattedTextField txtDatedebut;
    private javax.swing.JFormattedTextField txtDatefin;
    private javax.swing.JTextField txtIdcours;
    private javax.swing.JTextField txtIdlocal;
    private javax.swing.JTextField txtIdsesscours;
    private javax.swing.JTextField txtNbreinscrits;
    // End of variables declaration//GEN-END:variables
}
