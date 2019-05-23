package formation.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import formation.metier.Formateur;

/**
 * classe de mappage poo-relationnel formateur
 *
 * @author Kherbache Walid
 * @version 1.0
 * @see Formateur
 */

public class FormateurDAO extends DAO <Formateur> {
    
 
    /**
     * création d'un formateur sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj formateur à créer
     * @return formateur créé
     */
    @Override
    public Formateur create(Formateur obj) throws SQLException {

        String req1 = "insert into api_formateur(matricule,nom,prenom,numero,rue,localite,cp,tel) values(?,?,?,?,?,?,?,?)";
        String req2 = "select idform from api_formateur where matricule=? and nom=? and prenom=?";
        
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            
            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setString(4,obj.getNumero());
            pstm1.setString(5,obj.getRue());
            pstm1.setString(6,obj.getLocalite());
            pstm1.setInt(7,obj.getCp());
            pstm1.setString(8,obj.getTel());
            
            
            
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur d'insertion de formateur, aucun formateur n'a été inseré");
            }
            pstm2.setString(1, obj.getMatricule());
            pstm2.setString(2, obj.getNom());
            pstm2.setString(3, obj.getPrenom());
            
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idform = rs.getInt(1);
                    obj.setIdform(idform);
                    return read(idform);
                } else {
                    throw new SQLException("erreur d'insertion de formateur, record introuvable");
                }
            }
        }
    }
     /**
     * récupération des données d'un formateur sur base de son identifiant
     *
     * @throws SQLException matricule du formateur inconnu
     * @param idform identifiant du formateur
     * @return formateur trouvé
     */  
    @Override
    public Formateur read (int idform) throws SQLException {

        String req = "select * from api_formateur where idform = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idform);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String matricule = rs.getString("Matricule");
                    String nom = rs.getString("Nom");
                    String prenom = rs.getString("Prenom");
                    String numero = rs.getString("numero");
                    String rue = rs.getString("rue");
                    String localite = rs.getString("localite");
                    int cp = rs.getInt("cp");
                    String tel = rs.getString("tel");
                    
                    return new Formateur(idform,matricule,nom,prenom,numero,rue,localite,cp,tel);

                } else {
                    throw new SQLException("matricule du formateur inconnu");
                }

            }
        }
    }
     /**
     * récupération des données d'un formateur sur base de son matricule
     *
     * @throws SQLException matricule formateur inconnu
     * @param matricule matricule du formateur
     * @return formateur trouvé
     */
    public Formateur readMatricule(String matricule) throws SQLException {

        String req = "select * from api_formateur where matricule = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, matricule);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    
                    int idform = rs.getInt("IDFORM");
                   
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String numero = rs.getString("NUMERO");
                    String rue = rs.getString("RUE");
                    String localite = rs.getString("LOCALITE");
                    int cp = rs.getInt("CP");
                    String tel = rs.getString("tel");
                    return new Formateur(idform,matricule,nom,prenom,numero,rue,localite,cp,tel);

                } else {
                    throw new SQLException("Matricule formateur inconnu");
                }

            }
        }
    }
    /**
     * mise à jour des données du formateur sur base de son matricule
     *
     * @return formateur
     * @param obj Formateur à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Formateur update(Formateur obj) throws SQLException {
        String req = "update api_formateur set nom=?,prenom=?,numero=?,rue=?,localite=?,cp=?,tel=? where matricule=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            //pstm.setInt(8, obj.getIdlocal());
            pstm.setString(8, obj.getMatricule());
            pstm.setString(1, obj.getNom());
            pstm.setString(2, obj.getPrenom());
            pstm.setString(3, obj.getNumero());
            pstm.setString(4, obj.getRue());
            pstm.setString(5, obj.getLocalite());
            pstm.setInt(6, obj.getCp());
            pstm.setString(7, obj.getTel());
            
            
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Le formateur n'a pas été mis à jour");
            }
            return readMatricule(obj.getMatricule());
        }
    }
    
    /**
     * effacement d'un formateur sur base de son matricule
     *
     * @throws SQLException erreur d'effacement
     * @param obj formateur à effacer
     */
    @Override
    public void delete(Formateur obj) throws SQLException {
        String req = "delete from api_formateur where matricule=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getMatricule());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Le formateur n'a pas été supprimé");//le formateur que vous voulez supprimer n'existe pas
            }else{
                System.out.println("Le formateur a bien été supprimé ");
            }

        }
        catch (SQLIntegrityConstraintViolationException icve) {
        throw new SQLException("Impossible à supprimer ===> le record est lié à la table infos");
        }
    }
    /**
     * Recherche d'un formateur sur base de son nom
     * 
     * @param rechFormNom
     * @return formateur
     * @throws SQLException erreur formateur introuvable
     */
    public List<Formateur> rechFormNom(String rechFormNom) throws SQLException {
        List<Formateur> plusieurs = new ArrayList<>();
        String req = "select * from api_formateur where LOWER(nom) like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+rechFormNom+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idform = rs.getInt("IDFORM");
                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String numero = rs.getString("NUMERO");
                    String rue = rs.getString("RUE");
                    String localite = rs.getString("LOCALITE");
                    int cp = rs.getInt("CP");
                    String tel = rs.getString("tel");
                    
                    plusieurs.add(new Formateur(idform,matricule,nom,prenom,numero,rue,localite,cp,tel));
                }

                if (!trouve) {
                    throw new SQLException("formateur inexistant");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    
    
}
