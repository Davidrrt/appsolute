/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.itu.appsolute.modele;

import java.util.Date;

/**
 *
 * @author davra
 */
public class Actualite extends BaseModele{
    
    
    private Date dateactu;
    private int idcategactu;
    private int idautactu;
    private int idsaiactu;
    private String imageactu;
    private String titreactu;
    private String introactu;
    private String contenuactu;

    public Actualite(int idcategactu, Date dateactu, int idautactu, int idsaiactu, String imageactu, String titreactu, String introactu, String contenuactu) {
        this.idcategactu = idcategactu;
        this.dateactu = dateactu;
        this.idautactu = idautactu;
        this.idsaiactu = idsaiactu;
        this.imageactu = imageactu;
        this.titreactu = titreactu;
        this.introactu = introactu;
        this.contenuactu = contenuactu;
    }

    public Actualite() {
        
    }
    
    
    public int getIdcategactu() {
        return idcategactu;
    }

    public void setIdcategactu(int idcategactu) {
        this.idcategactu = idcategactu;
    }

    public Date getDateactu() {
        return dateactu;
    }

    public void setDateactu(Date dateactu) {
        this.dateactu = dateactu;
    }

    public int getIdautactu() {
        return idautactu;
    }

    public void setIdautactu(int idautactu) {
        this.idautactu = idautactu;
    }

    public int getIdsaiactu() {
        return idsaiactu;
    }

    public void setIdsaiactu(int idsaiactu) {
        this.idsaiactu = idsaiactu;
    }

    public String getImageactu() {
        return imageactu;
    }

    public void setImageactu(String imageactu) {
        this.imageactu = imageactu;
    }

    public String getTitreactu() {
        return titreactu;
    }

    public void setTitreactu(String titreactu) {
        this.titreactu = titreactu;
    }

    public String getIntroactu() {
        return introactu;
    }

    public void setIntroactu(String introactu) {
        this.introactu = introactu;
    }

    public String getContenuactu() {
        return contenuactu;
    }

    public void setContenuactu(String contenuactu) {
        this.contenuactu = contenuactu;
    }
    
}
