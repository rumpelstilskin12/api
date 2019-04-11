
package formation.metier;

import java.util.Objects;

/**
 * classe métier de gestion d'un local
 * @author Walid Kherbache
 * @version 1.0
 * 
 */

public class Local {
    
   protected int idlocal;
   
   protected String sigle;
   
   protected int places;
   
   protected String description;

    public Local() {
    }

    public Local(int idlocal, String sigle, int places, String description) {
        this.idlocal = idlocal;
        this.sigle = sigle;
        this.places = places;
        this.description = description;
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
        final Local other = (Local) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Local{" + "idlocal=" + idlocal + ", sigle=" + sigle + ", places=" + places + ", description=" + description + '}';
    }

   
   
    
}
