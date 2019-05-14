/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

/**
 *
 * @author BARCA
 */
public class Infos {
    protected int idinfos;
    protected int nb;
    protected int idform;
    private SessionCours sessionCours;

    public Infos() {
    }

    public Infos(SessionCours sessionCours) {
        this.sessionCours = sessionCours;
    }

    public Infos(int idinfos, int nb, int idform, SessionCours sessionCours) {
        this.idinfos = idinfos;
        this.nb = nb;
        this.idform = idform;
        this.sessionCours = sessionCours;
    }
    
    public int getIdinfos() {
        return idinfos;
    }

    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public SessionCours getSessionCours() {
        return sessionCours;
    }

    public void setS(SessionCours sessionCours) {
        this.sessionCours = sessionCours;
    }
    
    
    
}
