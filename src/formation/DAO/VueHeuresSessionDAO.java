/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.DAO;

import formation.metier.VueHeuresSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import myconnections.DBConnection;

/**
 * classe de mappage poo-relationnel VueHeuresSessionCours
 *
 * @author Kherbache Walid
 * @version 1.0
 * @see VueHeuresSession
 */
public class VueHeuresSessionDAO extends DAO <VueHeuresSession>{

    Connection dbConnect=DBConnection.getConnection();
    /**
     * Methode permettant de recuperer les données de la vue
     * @throws SQLException erreur d'affichage de la vue
     */
    public List<VueHeuresSession> affichageVue(int idsesscours) throws SQLException {
        List<VueHeuresSession> vue = new ArrayList<>();
       String req="select * from HEURES_SESSION where idsesscours=?";
        try(PreparedStatement pstm=dbConnect.prepareStatement(req)){
            pstm.setInt(1,idsesscours);
            try(ResultSet rs=pstm.executeQuery()){
                while(rs.next()){
                     int total= rs.getInt("TotalHeures");
                     vue.add(new VueHeuresSession(idsesscours,total));
                }
            }
            catch(SQLException e){
                  System.out.println("Erreur de l'affichage au niveau de la VueHeuresSession: "+e);
             }
        }
        catch(SQLException e){
            System.out.println("Erreur au niveau de la PreparedStatement: "+e);
        }
        return vue;
    }
    
    //=====================================================CRUD non utilisé ====================================================
    @Override
    public VueHeuresSession read(int idlocal) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VueHeuresSession create(VueHeuresSession obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VueHeuresSession update(VueHeuresSession obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(VueHeuresSession obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
