
package projet_application_info;

import java.sql.*;
import myconnections.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import formation.DAO.LocalDAO;
import formation.DAO.DAO;
import formation.DAO.FormateurDAO;
import formation.metier.Formateur;
import formation.metier.Local;
import myconnections.DBConnection;

public class GestionM {

    Scanner sc = new Scanner(System.in);
    Local localActuel = null;
    private LocalDAO LocalDAO ;
    Formateur formateurActuel=null;
    private FormateurDAO FormateurDAO;        

    public GestionM() {
    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        LocalDAO = new LocalDAO();
        LocalDAO.setConnection(dbConnect);

        int ch = 0;
        
        do{
            System.out.println("==========MENU PRINCIPAL============");
            System.out.println("1.Cours");
            System.out.println("2.Formateur");
            System.out.println("3.Local");
            System.out.println("4.SessionCours");
            System.out.println("5.Quitter");
            System.out.println("choix:");
            ch=sc.nextInt();
            sc.skip("\n");
            switch(ch){
                
                case 1:
                    //cours();
                    break;
                case 2:
                    menuFormateur();
                    break;
                case 3:
                    menuLocal();
                    break;
                case 4:
                    //sessionCours();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix incorrect");
                    
            }
        }while(ch!=5);
       DBConnection.closeConnection();//à la fin on doit fermer
    }
        
        public void menuLocal(){
         int ch = 0;
         do {
           
            System.out.println(" ======  MENU LOCAL ======\n1.creation \n2.recherche exacte local avec sigle \n3.recherche partielle avec description \n4.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    creation();
                    break;
                case 2:
                    rechercheExacte();
                    break;
                case 3:
                    recherchePartielle();
                    break;
                 /*case 4:
                    modification();
                    break;
                  case 5:
                    effacement();
                    break;
                 */
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 5);
        
    }

    public void creation() {
        System.out.print("Sigle du local:");
        String sigle = sc.nextLine();
        System.out.print("Nombre de places disponible: :");
        int places = sc.nextInt();
        sc.skip("\n");
        System.out.print("Description:");
        String desc = sc.nextLine();

        localActuel = new Local(0, sigle, places, desc);
        try {
            localActuel = LocalDAO.create(localActuel);
            System.out.println("local actuel : " + localActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
        //question why 0 en id 
    }

    public void rechercheExacte() {


        try {
            System.out.println("Entrer le Sigle du local :");
            String sigle = sc.nextLine();
            localActuel = LocalDAO.readSigle(sigle);
            System.out.println("Local recherché : " + localActuel);

            int choix = 0;
            String option = "";
            sc.skip("\n");
            do {
                do {
                    System.out.println("Menu secondaire : \n\t1-Modifier \n\t2-Supprimer \n\t3-Revenir au menu principal");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-3]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        modification();
                        break;
                    case 2:
                        effacement();
                        break;
                    case 3:gestion();
                        break;
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void recherchePartielle() {
        System.out.println("Entrer description : ");
        String description = sc.nextLine().toLowerCase();
        try {
            List<Local> alc = ((LocalDAO) LocalDAO).rechLocalDesc(description);
            for (Local cl : alc) {
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modification() {
        String option = "";
        int choix;
        try {
            //sc.skip("\n");
            do {
                do {
                    System.out.println("Quelle modification voulez-vous apporter ? \n\t1-Nombre de places: \n\t2-Description \n\t3-Revenir au menu precedent");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-3]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        System.out.println("Entrez le nombres de places: ");
                        int nbr = sc.nextInt();
                        localActuel.setPlaces(nbr);
                        LocalDAO.update(localActuel);
                        break;
                    case 2:
                        System.out.println("Entres la description: ");
                        String desc = sc.nextLine();
                        localActuel.setDescription(desc);
                        LocalDAO.update(localActuel);
                        break;

                    case 3:
                        break;
                }
            } while (choix != 4);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void effacement() {
        try {
            LocalDAO.delete(localActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public boolean verifier_chaine(String ch, String regex) {
        return ch.matches(regex);
    }

    public static void main(String[] args) {
        GestionM local = new GestionM();
        local.gestion();
        LocalDAO ld= new LocalDAO();
    }
   public void menuFormateur(){
       
       int ch = 0;
         do {
           
            System.out.println(" ======  MENU FORMATEUR ======\n1.Insertion de formateur \n2.recherche exacte local avec sigle \n3.recherche partielle avec description \n4.fin");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    insertionFormateur();
                    break;
                case 2:
                    rechercheExacte();
                    break;
                case 3:
                    recherchePartielle();
                    break;
                 /*case 4:
                    modification();
                    break;
                  case 5:
                    effacement();
                    break;
                 */
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 5);
        
       
   }
   public void insertionFormateur(){
       
        System.out.print("Entrer le matricule:");
        String matricule = sc.nextLine();
        System.out.print("Entrer le nom:");
        String nom = sc.nextLine();
        System.out.print("Entrer le prenom:");
        String prenom = sc.nextLine();
        System.out.println("Entrer le numero:");
        String numero =sc.nextLine();
        System.out.println("Entrer la rue:");
        String rue =sc.nextLine();
        System.out.println("Entrer la localite:");
        String localite =sc.nextLine();
        System.out.println("Entrer le cp:");
        int cp = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le tel:");
        String tel=sc.nextLine();

        formateurActuel = new Formateur(0,matricule,nom,prenom,numero,rue,localite,cp,tel);//obliger de commencer par 0 =====> ça n'existe pas dans la table 
        try {
            formateurActuel = FormateurDAO.create(formateurActuel);
            System.out.println("formateur actuel : " + formateurActuel);
        } 
        catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
        
       
   }
}
