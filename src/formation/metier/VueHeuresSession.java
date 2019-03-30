package formation.metier;

/**
 * classe metier de gestion VueHeuresSession
 * @author Walid Kherbache
 * @version 1.0
 */
public class VueHeuresSession {
    protected int idsesscours;
    protected int totalHeures;

    public VueHeuresSession() {
    }

    public VueHeuresSession(int idsesscours, int totalHeures) {
        this.idsesscours = idsesscours;
        this.totalHeures= totalHeures;
    }

    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

    public int getTotalHeures() {
        return totalHeures;
    }

    public void setTotalHeures(int totalHeures) {
        this.totalHeures = totalHeures;
    }

    @Override
    public String toString() {
        return "VueHeuresSession{" + "idsesscours=" + idsesscours + ", totalHeures=" + totalHeures + '}';
    }
    
    
    
}
