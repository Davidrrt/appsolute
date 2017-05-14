package mg.itu.appsolute.charts;

import java.util.Random;

/**
 *
 * @author davra
 */
public class Bar {

    private String titre;
    private int data;
    private String color;
    private String entete;

    public String getEntete() {
        return entete;
    }

    public void setEntete(String entete) {
        this.entete = entete;
    }

    
    public void setColor(String color) {
        this.color = color;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat() / 2f;
        float b = rand.nextFloat() / 2f;
        String colo = "rgba(" + r + "," + g + "," + b + ",0.5)";
        return colo;
    }

}
