/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.time.LocalDate;

/**
 *
 * @author BARCA
 */
public class SessionCours extends Subject {
    
    protected int idsesscours;
    protected LocalDate datedebut;
    protected LocalDate datefin;
    protected int nbreinscrits;
    protected int idlocal;
    protected int idcours;

    public SessionCours() {
    }

    public SessionCours(int idsesscours, /*LocalDate datedebut, LocalDate datefin,*/ int nbreinscrits, int idlocal, int idcours) {
        this.idsesscours = idsesscours;
        //this.datedebut = datedebut;
        //this.datefin = datefin;
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

  /*  public LocalDate getDatedebut() {
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
    */
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
