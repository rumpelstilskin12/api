/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.Infos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import myconnections.DBConnection;

/**
 *
 * @author BARCA
 */
public class InfosDAO extends DAO <Infos> {

    Connection dbConnect = DBConnection.getConnection();
    @Override
    public Infos create(Infos obj) throws SQLException {
        String req1 = "insert into api_infos(nb,idform,idsesscours) values(?,?,?)";
        String req2 = "select id_infos from api_infos where idform =? and idsesscours =?";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {

            pstm1.setInt(1, obj.getNb());
            pstm1.setInt(2, obj.getIdform());
            pstm1.setInt(3, obj.getIdsesscours());
            

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation d'infos, aucune ligne n'a été créée");
            }

            pstm2.setInt(1, obj.getIdform());
            pstm2.setInt(2, obj.getIdsesscours());
            
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idinfos = rs.getInt(1);
                    obj.setIdinfos(idinfos);
                    return read(idinfos);
                } else {
                    throw new SQLException("Erreur de création dans la table infos, introuvable");
                }
            }
        
    }
    }
    @Override
    public Infos read(int idinfos) throws SQLException {
       String req = "select * from api_infos where id_infos =?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idinfos);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    int nb = rs.getInt("NB");
                    int idform = rs.getInt("IDFORM");
                    int idsesscours = rs.getInt("IDSESSCOURS");
                    
                    

                    return new Infos(idinfos,nb,idform, idsesscours);
                } else {
                    throw new SQLException("Formateur inconnu");
                }

            }
        }
    }
    @Override
    public Infos update(Infos obj) throws SQLException {
         String req = "update api_infos set nb=?,idform=?,idsesscours=?"
                + " where id_infos=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            
            pstm.setInt(4, obj.getIdinfos());
            pstm.setInt(1, obj.getNb());
            pstm.setInt(2, obj.getIdform());
            pstm.setInt(3, obj.getIdsesscours());
            

            int n = pstm.executeUpdate();

            System.out.println("Informations mise à jour !");

        } catch (SQLException e) {
            System.out.println("Aucune ligne infos a été mise à jour");
        }
        return obj;
    }

    @Override
    public void delete(Infos obj) throws SQLException {
        String req = "delete from api_infos where id_infos=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdinfos());
            int n = pstm.executeUpdate();

            System.out.println("Ligne de la table infos a été correctement supprimé de la base de données ! ");

        } catch (SQLException e) {
            System.out.println("Aucune ligne effacée : le formateur n'existe pas dans la BDD !");
        }
    }

    
    
}
