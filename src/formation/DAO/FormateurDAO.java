package formation.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import formation.metier.Formateur;


public class FormateurDAO extends DAO <Formateur> {
    
    @Override
    public Formateur create(Formateur obj) throws SQLException {

        String req1 = "insert into api_formateur(matricule,nom,prenom,numero,rue,localite,cp,tel) values(?,?,?,?,?,?,?,?)";
        String req2 = "select idform from api_formateur where LOWER(nom)=? and prenom= ?";
        
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
            pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getPrenom());
            
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

    @Override
    public Formateur update(Formateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Formateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
