
package mg.itu.appsolute.modele;

import java.util.Date;

/**
 *
 * @author davra
 */
public class Album extends BaseModele{
    private String img;
    private Date dateAlbum;
    private int actu;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDateAlbum() {
        return dateAlbum;
    }

    public void setDateAlbum(Date dateAlbum) {
        this.dateAlbum = dateAlbum;
    }

    public int getActu() {
        return actu;
    }

    public void setActu(int actu) {
        this.actu = actu;
    }
    
    @Override
    public int getId(){
        return this.id;
    }
    
    
}
