package mg.itu.appsolute.charts;

import java.util.Random;

/**
 *
 * @author davra
 */
public class Pie {
    
    private String nom;
    private int value;
    private String info;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat() / 2f;
        float b = rand.nextFloat() / 2f;
        String colo="rgba("+r+","+g+","+b+",0.5)";
        return colo;
    }

    public String getInfo() {
        String inf=this.info+"("+this.value+"%)";
        return inf;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
