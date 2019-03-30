
package formation.DAO;

import formation.metier.VueSessionCoursFormateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import myconnections.DBConnection;

/**
 * classe de mappage poo-relationnel VueSessionCoursFormateur
 *
 * @author Kherbache Walid
 * @version 1.0
 * @see VueSessionCoursFormateur
 */
public class VueSessionCoursFormateurDAO extends DAO<VueSessionCoursFormateur> {

    Connection dbConnect = DBConnection.getConnection();

    /**
     * Methode permettant de recuperer les données de la vue
     *
     * @throws SQLException erreur de l'affichage au niveau de la vue
     */
    public List<VueSessionCoursFormateur> affichageVue(int idform) throws SQLException {
        List<VueSessionCoursFormateur> vue = new ArrayList<>();
        String req = "select * from SESSION_COURS_FORMATEUR where idform=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idform);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String matiere = rs.getString("MATIERE");
                    LocalDate dateDebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate dateFin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreInscrits = rs.getInt("NBREINSCRITS");
                    vue.add(new VueSessionCoursFormateur(idform, nom, prenom, matiere, dateDebut, dateFin, nbreInscrits));
                }
            } catch (SQLException e) {
                System.out.println("Erreur de l'affichage au niveau de la VueSessionCoursFormateur: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Erreur au niveau de la requete Prepared Statement: " + e);
        }
        return vue;
    }
    //=================================================CRUD non utilisé========================================================

    @Override
    public VueSessionCoursFormateur read(int idlocal) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VueSessionCoursFormateur create(VueSessionCoursFormateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VueSessionCoursFormateur update(VueSessionCoursFormateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(VueSessionCoursFormateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
