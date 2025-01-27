package om;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Document implements Serializable {
    private String titre;
    private Date creationDate = new Date();

    public Document() {
    }

    public Document(String pTitre) {
        this.titre = pTitre;
    }

    @Override
    public String toString() {
        return "Titre: " + this.titre + " Date: " + this.creationDate;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String pTitre) {
        this.titre = pTitre;
    }

    public String getCreationDate() {
        //Cast de Date a String
        SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");
        String dateString1 = pattern.format(this.creationDate);
        return "Date: " + dateString1;
    }
}
