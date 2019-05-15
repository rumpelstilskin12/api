/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.builder;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author BARCA
 */
public class Formateur {
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
    protected String num;
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

    //private Set <Infos> info =new HashSet<>();
 /**
 * constructeur paramétré
 * @param idform identifiant unique du formateur
 * @param matricule matricule unique du formateur
 * @param nom nom du formateur 
 * @param prenom prénom du formateur
 * @param num numéro de l'adresse
 * @param rue rue de l'adresse
 * @param localite localité de l'adresse
 * @param cp code postal de l'adresse
 * @param tel téléphone du client
 */
    public Formateur(FormateurBuilder fb) {
        this.idform =fb.idform;
        this.matricule =fb.matricule;
        this.nom =fb.nom;
        this.prenom = fb.prenom;
        this.num = fb.num;
        this.rue = fb.rue;
        this.localite = fb.localite;
        this.cp = fb.cp;
        this.tel = fb.tel;
    }
    
     /**
    * getter idform
    * @return identifiant du formateur
    */
    public int getIdform() {
        return idform;
    }
     /**
    * getter matricule
    * @return matricule du formateur
    */
    public String getMatricule() {
        return matricule;
    }
     /**
    * getter nom
    * @return nom du formateur
    */
    public String getNom() {
        return nom;
    }
     /**
    * getter prenom
    * @return prenom du formateur
    */
    public String getPrenom() {
        return prenom;
    }
     /**
    * getter numero
    * @return numero du formateur
    */
    public String getNumero() {
        return num;
    }
     /**
    * getter rue
    * @return rue du formateur
    */
    public String getRue() {
        return rue;
    }
     /**
    * getter localite
    * @return localite du formateur
    */
    public String getLocalite() {
        return localite;
    }
     /**
    * getter cp
    * @return cp du formateur
    */
    public int getCp() {
        return cp;
    }
     /**
    * getter tel
    * @return tel du formateur
    */
    public String getTel() {
        return tel;
    }
    
    /*public Set<Infos> getInfo() {
        return info;
    }

    /*public void setInfo(Set<Infos> info) {
        this.info = info;
    }
    
    
 /**
 * méthode toString
 * @return informations complètes
 */
    @Override
    public String toString() {
        return "Formateur{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + num + ", rue=" + rue + ", localite=" + localite + ", cp=" + cp + ", tel=" + tel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idform;
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
    
     public static class FormateurBuilder{
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
   * prénom du formateur
   */
	protected String prenom;
   /**
    * numéro 
    */
        protected String num;
   /**
    * rue 
    */
	protected String rue;
   /**
    * localité
    */
	protected String localite;
  
   /**
   * code postal du formateur
   */
	protected int cp;
   /**
    * numéro de téléphone du formateur
    */
	protected String tel;
        

        public FormateurBuilder setIdform(int idform) {
            this.idform = idform;
            return this;
        }
        
        public FormateurBuilder setMatricule(String matricule){
            this.matricule=matricule;
            return this;
        }
        public FormateurBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public FormateurBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

       
        public FormateurBuilder setCp(int cp) {
            this.cp = cp;
            return this;
        }

        public FormateurBuilder setLocalite(String localite){
            this.localite=localite;
            return this;
        }

        public FormateurBuilder setRue(String rue) {
            this.rue = rue;
            return this;
        }

        public FormateurBuilder setNum(String num) {
            this.num = num;
            return this;
        }

        public FormateurBuilder setTel(String tel){
            this.tel=tel;
            return this;
        }
        public Formateur build() throws Exception{
             if(idform<=0 ||matricule==null || nom==null || prenom==null) throw new Exception("informations de construction incomplètes");
            return new Formateur(this);
        }

}
    
    
}
