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
public class Local extends Subject{
    
   protected int idlocal;
   protected String sigle;
   protected int places;
   protected String descriptions;
   private Set<SessionCours> session=new HashSet<>();

    public Local() {
    }

    public Local(int idlocal, String sigle, int places, String descriptions) {
        this.idlocal = idlocal;
        this.sigle = sigle;
        this.places = places;
        this.descriptions = descriptions;
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
        notifyObservers();
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Set<SessionCours> getSession() {
        return session;
    }

    public void setSession(Set<SessionCours> session) {
        this.session = session;
    }

   

    @Override
    public String toString() {
        return "Local{" + "idlocal=" + idlocal + ", sigle=" + sigle + ", places=" + places + ", descriptions=" + descriptions + ", s=" + session+ '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idlocal;
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
        if (this.idlocal != other.idlocal) {
            return false;
        }
        return true;
    }
   
   @Override
    public String getNotification() {
        return "nouveau local "+sigle+"";
    }
}
