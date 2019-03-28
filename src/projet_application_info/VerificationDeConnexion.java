/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_application_info;


import java.sql.*;

public class VerificationDeConnexion {

    public static void main(String args[]) {
        Connection dbConnect = null;
        Statement stmt = null;
        ResultSet rs = null;

        String userid = "ora9";
        String password = "Condorcet1501";
        //String server = "mons-oracle12.condorcet.be";
        String server = "mons-oracle12.condorcet.be";
        String port = "1521";
        String database = "orcl.condorcet.be";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@//" + server + ":" + port + "/" + database;
//construit l'URL de la base de données

            dbConnect = DriverManager.getConnection(url, userid, password);
// connexion avec le login et le password
// et récupération d'un objet connection
//récupération des données à partir de la table client
            stmt = dbConnect.createStatement();;
//représente une requête SQL
            rs = stmt.executeQuery("select * from api_formateur ");
//ensemble des lignes répondant à la requête
            while (rs.next()) {
                String nom = rs.getString("NOM");
//ou rs.getString(2);
                String prenom = rs.getString("PRENOM");
//ou rs.getString(3);
                int n = rs.getInt("IDFORM");
                //ou   int n=  rs.getInt(1) ;
                System.out.println(nom + " " + prenom + " " + n);
            }

            // rs.close();// si stmt utilisée pour autre requête
            // stmt.close(); //si dbConnect utilisée pour autre statement
        } catch (SQLException e) {
            System.out.println("erreur SQL " + e);
        } catch (Exception e) {
            System.out.println("erreur " + e);
        } finally {
            //finalement fermer les ressources
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("erreur de fermeture de resultset " + e);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("erreur de fermeture de statement " + e);
            }

            try {
                if (dbConnect != null) {
                    dbConnect.close();
                }
            } catch (SQLException e) {
                System.out.println("erreur de fermeture de connexion " + e);
            }
        }
    }
}
