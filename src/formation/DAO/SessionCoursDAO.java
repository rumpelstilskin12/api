/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.SessionCours;
import formation.metier.VueSessionCoursFormateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import myconnections.DBConnection;

/**
 *
 * @author BARCA
 */
public class SessionCoursDAO extends DAO <SessionCours> {
    
    
    /**
     * création d'un local sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj local à créer
     * @return local créé
     */
    @Override
    public SessionCours create(SessionCours obj) throws SQLException {

       String req1 = "insert into api_sessioncours(datedebut,datefin,nbreinscrits,idlocal,idcours) values(?,?,?,?,?)";
        String req2 = "select idsesscours from api_sessioncours where datedebut=? and datefin=? and nbreinscrits=? and idlocal=? and idcours=? ";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
 
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDatedebut()));
            pstm1.setDate(2, java.sql.Date.valueOf(obj.getDatefin()));
            pstm1.setInt(3, obj.getNbreinscrits());
            pstm1.setInt(4, obj.getIdlocal());
            pstm1.setInt(5, obj.getIdcours());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation (session cours), aucune ligne n'a été créée");
            }

           pstm2.setDate(1, java.sql.Date.valueOf(obj.getDatedebut()));
            pstm2.setDate(2, java.sql.Date.valueOf(obj.getDatefin()));
            pstm2.setInt(3, obj.getNbreinscrits());
            pstm2.setInt(4, obj.getIdlocal());
            pstm2.setInt(5, obj.getIdcours());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idsesscours = rs.getInt(1);
                    obj.setIdsesscours(idsesscours);
                    return read(idsesscours);
                } else {
                    throw new SQLException("Erreur de création d'une nouvelle session de cours, introuvable");
                }
            }
        }
    
}

    @Override
    public SessionCours read(int idsesscours) throws SQLException {
         String req = "select * from api_sessioncours where idsesscours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idsesscours);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreinscrits = rs.getInt("NBREINSCRITS");
                    int idlocal = rs.getInt("IDLOCAL");
                    int idcours = rs.getInt("IDCOURS");
                   

                    return new SessionCours(idsesscours, datedebut, datefin, nbreinscrits, idlocal, idcours);
                } else {
                    throw new SQLException("Session de cours inconnue");
                }

            }
        }
    }

    @Override
    public SessionCours update(SessionCours obj) throws SQLException {
        String req = "update api_sessioncours set datedebut=?,datefin=?,nbreinscrits=?,idlocal=?,idcours=?"
                + "where idsesscours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(6, obj.getIdsesscours());
            pstm.setDate(1, java.sql.Date.valueOf(obj.getDatedebut()));
            pstm.setDate(2, java.sql.Date.valueOf(obj.getDatefin()));
            pstm.setInt(3, obj.getNbreinscrits());
            pstm.setInt(4, obj.getIdlocal());
            pstm.setInt(5, obj.getIdcours());
            
            

            int n = pstm.executeUpdate();

            System.out.println("Informations mise à jour !");

        } catch (SQLException e) {
            System.out.println("Aucune ligne session cours n'a été mise à jour");
        }
        return obj;
    }

    @Override
    public void delete(SessionCours obj) throws SQLException {
         String req = "delete from api_sessioncours where idsesscours= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdsesscours());
            int n = pstm.executeUpdate();

            System.out.println("La session de cours a bien été supprimée ! ");

        } catch (SQLException e) {
            System.out.println("Aucune ligne effacée : la session de cours n'existe pas dans la BDD !");
        }
    }
     /**
     * Methode permettant de recuperer la sessioncours d'un formateur 
     *
     * @throws SQLException erreur element inconnu
     */ 
 
    public List<VueSessionCoursFormateur> rech(int idform) throws SQLException {
        List<VueSessionCoursFormateur> vue = new ArrayList<>();
        String req = "select * from session_cours_formateur where idform= ?";
        dbConnect=DBConnection.getConnection();
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idform);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    
                   
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String matiere = rs.getString("MATIERE");
                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreinscrits = rs.getInt("NbreInscrits");
                    vue.add(new VueSessionCoursFormateur(idform,nom,prenom,matiere,datedebut,datefin,nbreinscrits));
                }

                if (!trouve) {
                    throw new SQLException("Element inconnu");
                } else {
                    return vue;
                }
            }
        }
    }
    
    public List<SessionCours> rechSessionCours(int idcours) throws SQLException {
        List<SessionCours> sess = new ArrayList<>();
        String req = "select * from api_sessioncours where idcours= ?";
        dbConnect=DBConnection.getConnection();
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idcours);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    
                   
                    int idsesscours = rs.getInt("idsesscours");
                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreinscrits = rs.getInt("NbreInscrits");
                    int idlocal =rs.getInt("idlocal");
                    sess.add(new SessionCours(idsesscours,datedebut,datefin,nbreinscrits,idlocal,idcours));
                }

                if (!trouve) {
                    throw new SQLException("Element inconnu");
                } else {
                    return sess;
                }
            }
        }
    }
    
    public List<SessionCours> comboSessioncours() throws SQLException{
        List<SessionCours> sesscours = new ArrayList();
        String req = "select * from api_sessioncours";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int idsesscours = rs.getInt("IDSESSCOURS");
                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreinscrits = rs.getInt("NBREINSCRITS");
                    int idlocal = rs.getInt("IDLOCAL");
                    int idcours = rs.getInt("IDCOURS");
                    
                    sesscours.add(new SessionCours(idsesscours, datedebut, datefin, nbreinscrits, idlocal, idcours));
                }
            }
        }
        return sesscours;
}
    
    
}
