/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author BARCA
 */
public class SessionCours extends Subject {
    
    protected int idsesscours;
    protected java.util.Date datedebut;
    protected java.util.Date datefin;
    protected int nbreinscrits;
    protected int idlocal;
    protected int idcours;
    
    Set<Local> Local=new HashSet();
    Set<Formateur> Formateur=new HashSet();
    public SessionCours() {
    }

    public SessionCours(int idsesscours,java.util.Date datedebut, java.util.Date datefin, int nbreinscrits, int idlocal, int idcours) {
        this.idsesscours = idsesscours;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nbreinscrits = nbreinscrits;
        this.idlocal = idlocal;
        this.idcours = idcours;
    }
    
    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

     public java.util.Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(java.util.Date datedebut) {
        this.datedebut = datedebut;
    }

    public java.util.Date getDatefin() {
        return datefin;
    }

    public void setDatefin(java.util.Date datefin) {
        this.datefin = datefin;
    }
    
    public int getNbreinscrits() {
        return nbreinscrits;
    }

    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    @Override
    public String toString() {
        return "SessionCours{" + "idsesscours=" + idsesscours +/* ", datedebut=" + datedebut + ", datefin=" + datefin + */", nbreinscrits=" + nbreinscrits + ", idlocal=" + idlocal + ", idcours=" + idcours + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idsesscours;
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
        final SessionCours other = (SessionCours) obj;
        if (this.idsesscours != other.idsesscours) {
            return false;
        }
        return true;
    }
    
     
    @Override
    public String getNotification() {
        return "nouveau local "+idlocal+"";
    }
    
}
