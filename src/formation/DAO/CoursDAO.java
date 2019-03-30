/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.Cours;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe de mappage poo-relationnel cours
 *
 * @author Kherbache Walid
 * @version 1.0
 * @see Cours
 */
public class CoursDAO extends DAO <Cours> {
    
    /**
     * création d'un cours sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj cours à créer
     * @return cours créé
     */
    @Override
    public Cours create(Cours obj) throws SQLException {

        String req1 = "insert into api_cours(matiere,heures) values(?,?)";
        String req2 = "select idcours from api_cours where matiere=? and heures= ?";
        
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            
            pstm1.setString(1, obj.getMatiere());
            pstm1.setInt(2, obj.getHeures());
            
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation de cours, aucune ligne créée");
            }
            pstm2.setString(1, obj.getMatiere());
            pstm2.setInt(2, obj.getHeures());
            
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idcours = rs.getInt(1);
                    obj.setIdcours(idcours);
                    return read(idcours);
                } else {
                    throw new SQLException("erreur de création de cours, record introuvable");
                }
            }
        }
    }
     /**
     * récupération des données d'un cours sur base de son identifiant
     *
     * @throws SQLException idcours inconnu
     * @param idcours identifiant du cours
     * @return cours trouvé
     */
    @Override
    public Cours read (int idcours) throws SQLException {

        String req = "select * from api_cours where idcours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idcours);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String matiere = rs.getString("Matiere");
                    int heures = rs.getInt("Heures");
                    return new Cours (idcours,matiere,heures);

                } else {
                    throw new SQLException("idcours inconnu");
                }

            }
        }
    }
   
    

    /**
     * mise à jour des données du cours sur base de son identifiant
     *
     * @return cours
     * @param obj cours à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    
    @Override
    public Cours update(Cours obj) throws SQLException {
        String req = "update api_cours set matiere=?,heures=? where idcours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(3, obj.getIdcours());
            pstm.setString(1, obj.getMatiere());
            pstm.setInt(2, obj.getHeures());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne cours mise à jour");
            }
            return read(obj.getIdcours());
        }
    }

    /**
     * effacement du cours sur base de son identifiant
     *
     * @throws SQLException erreur de suppression du cours
     * @param obj cours à effacer
     */
    @Override
    public void delete(Cours obj) throws SQLException {

        String req = "delete from api_cours where idcours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdcours());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne effacée ====> le cours n'existe pas");
            }else{
                System.out.println("Le cours a bien été supprimé ");
            }

        }
    }

        
 
    
     
    /**
     * Recherche Cours par matiere
     * @param coursRechMatiere
     * @return liste de cours
     * @throws SQLException cours inconnu
     */
     
     public List<Cours> rechCoursMat(String coursRechMatiere) throws SQLException {
        List<Cours> plusieurs = new ArrayList<>();
        String req = "select * from api_cours where LOWER(matiere) like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+coursRechMatiere+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idcours = rs.getInt("IDCOURS");
                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");
                
                    
                    plusieurs.add(new Cours(idcours,matiere,heures));
                }

                if (!trouve) {
                    throw new SQLException("Le cours est inconnu, il n'a pu être trouvé");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    
}
