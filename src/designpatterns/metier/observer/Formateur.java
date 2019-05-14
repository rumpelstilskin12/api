/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author BARCA
 */
public class Formateur extends Observer{
   /**
   * identifiant unique du formateur
   */
    protected int idform;
   /**
    * matricule unique du formateur
    */
    protected String matricule;
   /**
   * nom du formateur
   */
    protected String nom;
    /**
     * prenom du formateur
     */
    protected String prenom;
    /**
     * numero de rue
     */
    protected String numero;
    /**
     * rue
     */
    protected String rue;
    /**
     * localite
     */
    protected String localite;
    /**
     * code postal de la rue
     */
    protected int  cp;
    /**
     * numero de tel
     */
    protected String tel;
    
    private Set <Infos> info =new HashSet<>();
    
    public Formateur() {
    }

    public Formateur(int idform, String matricule, String nom, String prenom, String numero, String rue, String localite, int cp, String tel) {
        this.idform = idform;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.rue = rue;
        this.localite = localite;
        this.cp = cp;
        this.tel = tel;
    }

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    public void setInfo(Set<Infos> info) {
        this.info = info;
    }
    

    @Override
    public String toString() {
        return "Formateur{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", rue=" + rue + ", localite=" + localite + ", cp=" + cp + ", tel=" + tel + '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idform;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formateur other = (Formateur) obj;
        if (this.idform != other.idform) {
            return false;
        }
        return true;
    }
    
    @Override
    public void update(String msg) {
        System.out.println(prenom+" "+nom+" a reçu le msg :"+msg);
    }
  
}
