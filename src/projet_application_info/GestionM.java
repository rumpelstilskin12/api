
package projet_application_info;

import formation.DAO.CoursDAO;
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
import formation.DAO.VueHeuresSessionDAO;
import formation.DAO.VueSessionCoursFormateurDAO;
import formation.metier.Cours;
import formation.metier.Formateur;
import formation.metier.Local;
import formation.metier.VueSessionCoursFormateur;
import myconnections.DBConnection;

public class GestionM {

    Scanner sc = new Scanner(System.in);
    Local localActuel = null;
    private LocalDAO LocalDAO;
    Formateur formateurActuel = null;
    private FormateurDAO FormateurDAO;
    Cours coursActuel = null;
    private CoursDAO CoursDAO;
    private VueSessionCoursFormateurDAO VueSessionCoursFormateurDAO;
    private VueHeuresSessionDAO VueHeuresSessionDAO;

    //constructeur vide
    public GestionM() {
    }

    //Menu Principal de gestion
    public void menuPrincipal() {
        //connexion à la DB
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        LocalDAO = new LocalDAO();
        LocalDAO.setConnection(dbConnect);

        FormateurDAO = new FormateurDAO();
        FormateurDAO.setConnection(dbConnect);

        CoursDAO = new CoursDAO();
        CoursDAO.setConnection(dbConnect);

        VueSessionCoursFormateurDAO = new VueSessionCoursFormateurDAO();
        VueSessionCoursFormateurDAO.setConnection(dbConnect);

        VueHeuresSessionDAO = new VueHeuresSessionDAO();
        VueHeuresSessionDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("==========MENU PRINCIPAL============");
            System.out.println("1.Cours");
            System.out.println("2.Formateur");
            System.out.println("3.Local");
            System.out.println("4.SessionCours");
            System.out.println("5.Quitter");
            System.out.println("choix:");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {

                case 1:
                    menuCours();
                    break;
                case 2:
                    menuFormateur();
                    break;
                case 3:
                    menuLocal();
                    break;
                case 4:
                    menuSessionCours();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix incorrect");

            }
        } while (ch != 5);

        DBConnection.closeConnection();
    }

//=================================================================   GESTION COURS  ========================================================================
    //Menu de gestion de cours    
    public void menuCours() {
        int ch = 0;
        do {

            System.out.println(" ======  MENU COURS ======");
            System.out.println("1.creation d'un cours");
            System.out.println("2.recherche cours via son id");
            System.out.println("3.recherche d'un cours");
            System.out.println("4.revenir au menu principal");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajouterCours();
                    break;
                case 2:
                    rechercheCours();
                    break;
                case 3:
                    rechercheMatiere();
                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 5);

    }
    //methode d'ajout de cours

    public void ajouterCours() {
        System.out.print("Veuillez entrer une matiere :");
        String matiere = sc.nextLine();
        System.out.print("Veuillez entrer les heures:");
        int heures = sc.nextInt();
        sc.skip("\n");
        coursActuel = new Cours(0, matiere, heures);
        try {
            coursActuel = CoursDAO.create(coursActuel);
            System.out.println("Cours actuel : " + coursActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }
    //methode de recherche de cours par son identifiant + menu secondaire (modification et suppression) 

    public void rechercheCours() {

        try {
            System.out.println("Veuillez entrer l'id du cours :");
            int id = sc.nextInt();
            sc.skip("\n");
            coursActuel = CoursDAO.read(id);
            System.out.println("Cours recherché : " + coursActuel);

            int choix = 0;
            String option = "";
            sc.skip("\n");
            do {
                do {
                    System.out.println("Menu secondaire :");
                    System.out.println("\t1.Modifier");
                    System.out.println("\t2.Supprimer");
                    System.out.println("\t3.Revenir au menu principal");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-3]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        modificationCours();
                        break;
                    case 2:
                        supprimerCours();
                        break;
                    case 3:
                        menuPrincipal();
                        break;
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    //methode de recherche partielle d'un cours en focntion de sa matiere  

    public void rechercheMatiere() {
        System.out.println("Veuillez entrer la matiere du cours : ");
        String matiere = sc.nextLine().toLowerCase();
        try {
            List<Cours> alc = ((CoursDAO) CoursDAO).rechCoursMat(matiere);
            for (Cours c : alc) {
                System.out.println(c);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    //methode de modification des élements d'un cours

    public void modificationCours() {
        String option = "";
        int choix;
        try {
            do {
                do {
                    System.out.println("Quelle modification voulez-vous apporter ?");
                    System.out.println("\t1.Matiere du cours: ");
                    System.out.println("\t2.Heures de cours: ");
                    System.out.println("\t3.Revenir au menu cours ");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-3]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        System.out.println("Veuillez entrer la matiere du cours: ");
                        String matiere = sc.nextLine();
                        coursActuel.setMatiere(matiere);
                        CoursDAO.update(coursActuel);
                        break;
                    case 2:
                        System.out.println("Veuillez entrer les heures de cours: ");
                        int heures = sc.nextInt();
                        sc.skip("\n");
                        coursActuel.setHeures(heures);
                        CoursDAO.update(coursActuel);
                        break;

                    case 3:
                        menuCours();
                        break;
                }
            } while (choix != 4);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    //methode de suppression d'un cours

    public void supprimerCours() {
        try {
            CoursDAO.delete(coursActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    //=================================================================   GESTION LOCAL  =====================================================================      
    //Menu d'un local    
    public void menuLocal() {
        int ch = 0;
        do {

            System.out.println(" ======  MENU LOCAL ======");
            System.out.println("1.creation d'un local");
            System.out.println("2.recherche exacte local avec sigle");
            System.out.println("3.recherche partielle d'un local sur base de sa description");
            System.out.println("4.revenir au menu principal");
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

                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 5);

    }

    // methode de creation d'un local
    public void creation() {
        System.out.print("Veuillez entrer un sigle de local:");
        String sigle = sc.nextLine();
        System.out.print("Veuillez entrer le nombre de places disponible: :");
        int places = sc.nextInt();
        sc.skip("\n");
        System.out.print("Veuillez entrer une description:");
        String desc = sc.nextLine();

        localActuel = new Local(0, sigle, places, desc);
        try {
            localActuel = LocalDAO.create(localActuel);
            System.out.println("local actuel : " + localActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }
    }

    //methode de recherche d'un local via son sigle + menu secondaire (modification et suppression)
    public void rechercheExacte() {

        try {
            System.out.println("Veuillez entrer le sigle du local :");
            String sigle = sc.nextLine();
            localActuel = LocalDAO.readSigle(sigle);
            System.out.println("Local recherché : " + localActuel);

            int choix = 0;
            String option = "";
            sc.skip("\n");
            do {
                do {
                    System.out.println("Menu secondaire :");
                    System.out.println("\t1.Modifier");
                    System.out.println("\t2.Supprimer");
                    System.out.println("\t3.Revenir au menu principal");
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
                    case 3:
                        menuPrincipal();
                        break;
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    //methode de recherche partielle d'un local en fonction de sa description
    public void recherchePartielle() {
        System.out.println("Veuillez entrer une description : ");
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

    //methode de modification des éléments d 'un local
    public void modification() {
        String option = "";
        int choix;
        try {
            do {
                do {
                    System.out.println("Quelle modification voulez-vous apporter ?");
                    System.out.println("\t1.Nombre de places: ");
                    System.out.println("\t2.Description: ");
                    System.out.println("\t3.Revenir au menu local ");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-3]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        System.out.println("Veuillez entrer le nombres de places: ");
                        int nbr = sc.nextInt();
                        sc.skip("\n");
                        localActuel.setPlaces(nbr);
                        LocalDAO.update(localActuel);
                        break;
                    case 2:
                        System.out.println("Veuillez entrer la description: ");
                        String desc = sc.nextLine();
                        localActuel.setDescription(desc);
                        LocalDAO.update(localActuel);
                        break;

                    case 3:
                        menuLocal();
                        break;
                }
            } while (choix != 4);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    //methode de suppression d'un local

    public void effacement() {
        try {
            LocalDAO.delete(localActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    //=================================================================   GESTION FORMATEUR  ==================================================================   
    //Menu Formateur
    public void menuFormateur() {

        int ch = 0;
        do {

            System.out.println(" ======  MENU FORMATEUR ======");
            System.out.println("1.Insertion de formateur");
            System.out.println("2.Recherche formateur avec matricule");
            System.out.println("3.Recherche partielle sur le nom du formateur");
            System.out.println("4.Revenir au menu principal");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    insertionFormateur();
                    break;
                case 2:
                    rechercheFormMatricule();
                    break;
                case 3:
                    rechFormNom();
                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 5);

    }

    //methode de creation d'un formateur
    public void insertionFormateur() {

        System.out.print("Veuillez entrer un matricule:");
        String matricule = sc.nextLine();
        System.out.print("Veuillez entrer un nom:");
        String nom = sc.nextLine();
        System.out.print("Veuillez entrer un prenom:");
        String prenom = sc.nextLine();
        System.out.println("Veuillez entrer un numero:");
        String numero = sc.nextLine();
        System.out.println("Veuillez entrer une rue:");
        String rue = sc.nextLine();
        System.out.println("Veuillez entrer une localite:");
        String localite = sc.nextLine();
        System.out.println("Veuillez entrer un cp:");
        int cp = sc.nextInt();
        sc.skip("\n");
        System.out.println("Veuillez entrer un tel:");
        String tel = sc.nextLine();

        formateurActuel = new Formateur(0, matricule, nom, prenom, numero, rue, localite, cp, tel);
        try {
            formateurActuel = FormateurDAO.create(formateurActuel);
            System.out.println("formateur actuel : " + formateurActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }
    //methode de recherche d'un formateur en fonction de son matricule + menu secondaire (modification et suppression)

    public void rechercheFormMatricule() {

        try {
            System.out.println("Veuillez entrez le matricule du formateur :");
            String matricule = sc.nextLine();
            formateurActuel = FormateurDAO.readMatricule(matricule);
            System.out.println("Formateur recherché : " + formateurActuel);

            int choix = 0;
            String option = "";
            sc.skip("\n");
            do {
                do {
                    System.out.println("Menu secondaire :");
                    System.out.println("\t1.Modifier");
                    System.out.println("\t2.Supprimer");
                    System.out.println("\t3.Revenir en arrière");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-3]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        modificationFormateur();
                        break;
                    case 2:
                        supprimerFormateur();
                        break;
                    case 3:
                        menuFormateur();
                        break;
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    //methode de recherche partielle d'un formateur en fonction de son nom

    public void rechFormNom() {
        System.out.println("Veuillez saisir un nom: ");
        String nom = sc.nextLine().toLowerCase();
        try {
            List<Formateur> alc = ((FormateurDAO) FormateurDAO).rechFormNom(nom);
            for (Formateur fo : alc) {
                System.out.println(fo);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    //methode de modification des élements d'un formateur
    public void modificationFormateur() {
        String option = "";
        int choix;
        try {

            do {
                do {
                    System.out.println("Quelle modification voulez-vous apporter ?");
                    System.out.println("1.Nom et Prenom:");
                    System.out.println("2.Adresse");
                    System.out.println("3.Changer le numero de tel");
                    System.out.println("4.Revenir à la recherche du formateur");
                    System.out.println("5.Revenir au menu Formateur");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-5]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        System.out.println("Veuillez saisir un nom: ");
                        String nom = sc.nextLine();
                        formateurActuel.setNom(nom);
                        FormateurDAO.update(formateurActuel);
                        System.out.println("Veuillez saisir un prenom");
                        String prenom = sc.nextLine();
                        formateurActuel.setPrenom(prenom);
                        FormateurDAO.update(formateurActuel);
                        break;
                    case 2:
                        System.out.println("Veuillez saisir un numero : ");
                        String numero = sc.nextLine();
                        formateurActuel.setNumero(numero);
                        FormateurDAO.update(formateurActuel);
                        System.out.println("Veuillez saisir la rue: ");
                        String rue = sc.nextLine();
                        formateurActuel.setRue(rue);
                        FormateurDAO.update(formateurActuel);

                        System.out.println("Veuillez saisir la localite: ");
                        String localite = sc.nextLine();
                        formateurActuel.setLocalite(localite);
                        FormateurDAO.update(formateurActuel);
                        System.out.println("Veuillez saisir le code postal: ");
                        int cp = sc.nextInt();
                        formateurActuel.setCp(cp);
                        FormateurDAO.update(formateurActuel);
                        sc.skip("\n");
                        break;

                    case 3:
                        System.out.println("Veuillez saisir un numero : ");
                        String tel = sc.nextLine();
                        formateurActuel.setTel(tel);
                        FormateurDAO.update(formateurActuel);
                        break;
                    case 4:
                        rechercheFormMatricule();
                        break;
                    case 5:
                        menuFormateur();
                }
            } while (choix != 5);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    //methode de suppression d'un formateur

    public void supprimerFormateur() {
        try {
            FormateurDAO.delete(formateurActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    //================================================================= GESTION SESSION COURS ===================================================================  
    //Menu d'une session cours

    public void menuSessionCours() {

        int ch = 0;
        do {

            System.out.println(" ======  MENU SESSION EN COURS ======");
            System.out.println("1.Afficher les sessions cours pour un formateur");
            System.out.println("2.Afficher le total des heures formateurs pour une session");
            System.out.println("3.Revenir au menu principal");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    vueSessionCours();
                    break;
                case 2:
                    vueHeuresSess();
                    break;
                case 3:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("choix incorrect");
            }

        } while (ch != 4);

    }
    //================================================================= GESTION SESSION COURS : LES VUES =========================================================  
    //methode d'affichage de la vue SessionCoursFormateur en fonction de son identifiant formateur

    public void vueSessionCours() {
        VueSessionCoursFormateurDAO vueSession = new VueSessionCoursFormateurDAO();
        System.out.println("Entrer l'id du formateur: ");
        int idform = sc.nextInt();
        sc.skip("\n");
        try {
            System.out.println(vueSession.affichageVue(idform));
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
    }
    //methode d'affichage de la VueHeureSession en fonction de l'idssesscours

    public void vueHeuresSess() {
        VueHeuresSessionDAO vueHeureS = new VueHeuresSessionDAO();
        System.out.println("Entrer l'id de la session en cours: ");
        int idsess = sc.nextInt();
        sc.skip("\n");
        try {
            System.out.println(vueHeureS.affichageVue(idsess));
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }

    }

    //================================================================= Methode de Verification REGEX  ============================================================
    public boolean verifier_chaine(String ch, String regex) {
        return ch.matches(regex);
    }
//========================================================================  MAIN  ===============================================================================

    public static void main(String[] args) {
        GestionM gestion = new GestionM();
        gestion.menuPrincipal();

    }
}
