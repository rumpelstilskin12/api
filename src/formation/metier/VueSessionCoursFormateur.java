package formation.metier;

import java.time.LocalDate;

/**
 * classe metier de gestion de VueSessionCoursFormateurs
 * @author Walid Kherbache
 * @version 1.0
 */
public class VueSessionCoursFormateur {
    protected int idform;
    protected String nom;
    protected String prenom;
    protected String matiere;
    protected LocalDate datedebut;
    protected LocalDate datefin;
    protected int nbreinscrits;

    public VueSessionCoursFormateur() {
    }

    public VueSessionCoursFormateur(int idform, String nom, String prenom, String matiere, LocalDate datedebut, LocalDate datefin, int nbreinscrits) {
        this.idform = idform;
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
    }

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public int getNbreinscrits() {
        return nbreinscrits;
    }

    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }

    @Override
    public String toString() {
        return "\nVueSessionCoursFormateur: " + "\n\tidform: " + idform + "\n\tnom: " + nom + "\n\tprenom: " + prenom + "\n\tmatiere: " + matiere + "\n\tdatedebut: " + datedebut + "\n\tdatefin: " + datefin + "\n\tnbreinscrits: " + nbreinscrits ;
    }
    
    
    
}
