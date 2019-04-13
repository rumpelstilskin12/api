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
public class Infos {
    protected int idinfos;
    protected int nb;
    protected int idform;
    protected int idsesscours;

    public Infos() {
    }

    public Infos(int idinfos, int nb, int idform, int idsesscours) {
        this.idinfos = idinfos;
        this.nb = nb;
        this.idform = idform;
        this.idsesscours = idsesscours;
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

    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }
    
    
    
}
