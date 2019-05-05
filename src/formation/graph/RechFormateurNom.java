/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.graph;

import formation.DAO.FormateurDAO;
import formation.metier.Formateur;
import formation.metier.Local;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BARCA
 */
public class RechFormateurNom extends javax.swing.JPanel {

    /**
     * Creates new form rechFormateurNom
     */
     FormateurDAO formateurDAO=null;
     Formateur f=null;
    
    DefaultTableModel dft1 = new DefaultTableModel();
    public RechFormateurNom() {
        initComponents();
        dft1.addColumn("idform");
        dft1.addColumn("matricule");
        dft1.addColumn("nom");
        dft1.addColumn("prenom");
        dft1.addColumn("numero");
        dft1.addColumn("rue");
        dft1.addColumn("localite");
        dft1.addColumn("cp");
        dft1.addColumn("tel");
        jTable1.setModel(dft1);

    }
     public void setFormateurDAO(FormateurDAO formateurDAO){
        this.formateurDAO=formateurDAO;
    }
    /**

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNomF = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btRecherche = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        labelNomF.setText("Nom:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idform", "matricule", "nom", "prenom", "numero", "rue", "localite", "cp", "tel"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btRecherche.setText("Rechercher");
        btRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNomF, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomF)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btRecherche)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechercheActionPerformed
        // TODO add your handling code here:
           try{ 
        String nomFormateur=txtNom.getText();
        List<Formateur> alf= formateurDAO.rechFormNom(nomFormateur);
        int nr = dft1.getRowCount();
        for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
        for(Formateur f:alf){
            Vector v = new Vector();
            v.add(f.getIdform());
            v.add(f.getMatricule());
            v.add(f.getNom());
            v.add(f.getPrenom());
            v.add(f.getNumero());
            v.add(f.getRue());
            v.add(f.getLocalite());
            v.add(f.getCp());
            v.add(f.getTel());
            dft1.addRow(v);
           
        }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btRechercheActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRecherche;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelNomF;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
