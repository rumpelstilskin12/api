/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.metier;

/**
 *
 * @author BARCA
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
