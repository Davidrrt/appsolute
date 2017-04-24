/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.itu.utilproject.modele;

/**
 *
 * @author davra
 */
public class Employe extends BaseModele {

    private String nomemp;
    private String metier;
    private String login;
    private String pass;
    private int statut;
    
    public Employe(){
        
    }
    public Employe(String nomemp, String metier, String login, String password, int statut) {
        this.nomemp = nomemp;
        this.metier = metier;
        this.login = login;
        this.pass = password;
        this.statut = statut;
    }
   
    public String getNomemp() {
        return nomemp;
    }

    public void setNomemp(String nomemp) {
        this.nomemp = nomemp;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

 

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }
}
