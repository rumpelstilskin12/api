
package formation.metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * classe metier de gestion de cours
 * @author Walid Kherbache
 * @version 1.0
 */
public class Cours {
    
    protected int idcours;
    protected String matiere;
    protected int heures;
    private Set <SessionCours> sessioncours=new HashSet<>();
    public Cours() {
    }

    public Cours(int idcours, String matiere, int heures) {
        this.idcours = idcours;
        this.matiere = matiere;
        this.heures = heures;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    @Override
    public String toString() {
        return "Cours{" + "idcours=" + idcours + ", matiere=" + matiere + ", heures=" + heures + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Cours other = (Cours) obj;
        if (!Objects.equals(this.matiere, other.matiere)) {
            return false;
        }
        return true;
    }
    
    
    
}
