
package formation.DAO;

import java.sql.*;
import java.util.*;
import formation.metier.Local;

/**
 * classe de mappage poo-relationnel local
 *
 * @author Kherbache Walid
 * @version 1.0
 * @see Local
 */
public class LocalDAO extends DAO <Local> {
   
    /**
     * création d'un local sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj local à créer
     * @return local créé
     */
    @Override
    public Local create(Local obj) throws SQLException {

        String req1 = "insert into api_local(sigle,places,description) values(?,?,?)";
        String req2 = "select idlocal from api_local where sigle=? and places= ? and description =?";
        
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            
            pstm1.setString(1, obj.getSigle());
            pstm1.setInt(2, obj.getPlaces());
            pstm1.setString(3, obj.getDescription());
            
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation de local, aucune ligne créée");
            }
            pstm2.setString(1, obj.getSigle());
            pstm2.setInt(2, obj.getPlaces());
            pstm2.setString(3, obj.getDescription());
            
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idlocal = rs.getInt(1);
                    obj.setIdlocal(idlocal);
                    return read(idlocal);
                } else {
                    throw new SQLException("erreur de création local, record introuvable");
                }
            }
        }
    }
    /**
     * 
     * @param idlocal
     * @return Local trouvé
     * @throws SQLException id local inconnu 
     */
    @Override
    public Local read (int idlocal) throws SQLException {

        String req = "select * from api_local where idlocal = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idlocal);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    
                    return new Local(idlocal,sigle,places,description);

                } else {
                    throw new SQLException("id local inconnu");
                }

            }
        }
    }
    
    /**
     * récupération des données d'un local sur base de son sigle
     *
     * @throws SQLException sigle local inconnu
     * @param sigle sigle du local
     * @return local trouvé
     */
    
    public Local readSigle(String sigle) throws SQLException {

        String req = "select * from api_local where sigle = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, sigle);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    
                    int idlocal = rs.getInt("IDLOCAL");
                   
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    
                    return new Local(idlocal,sigle,places,description);

                } else {
                    throw new SQLException("sigle local inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du local sur base de son sigle
     *
     * @return Local
     * @param obj local à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Local update(Local obj) throws SQLException {
        String req = "update api_local set places=?,description=? where sigle=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(3, obj.getSigle());
            pstm.setInt(1, obj.getPlaces());
            pstm.setString(2, obj.getDescription());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne client mise à jour");
            }
            return readSigle(obj.getSigle());
        }
    }

    /**
     * effacement d'un local sur base de son sigle
     *
     * @throws SQLException erreur d'effacement
     * @param obj local à effacer
     */
    @Override
    public void delete(Local obj) throws SQLException {

        String req = "delete from api_local where sigle=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getSigle());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne effacée ====> le local n'existe pas");
            }else{
                System.out.println("Le local a bien été supprimé ");
            }

        }
    }

     
 
    /**
     * Recherche d'un local sur base de sa description
     * 
     * @param localRdesc
     * @return Local
     * @throws SQLException erreur local introuvable
     */
     
     public List<Local> rechLocalDesc(String localRdesc) throws SQLException {
        List<Local> plusieurs = new ArrayList<>();
        String req = "select * from api_local where LOWER(description) like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+localRdesc+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idlocal = rs.getInt("IDLOCAL");
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");
                    
                    plusieurs.add(new Local(idlocal,sigle,places,description));
                }

                if (!trouve) {
                    throw new SQLException("local inconnu");
                } else {
                    return plusieurs;
                }
            }
        }
        
        
    }
    

}


