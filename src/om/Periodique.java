package om;

import java.io.Serializable;

public class Periodique extends Document implements Serializable {
    private String frequence;
    private int page;

    public Periodique(String pTitre, String pFrequence, int pPage) {
        super(pTitre);
        this.frequence = pFrequence;
        this.page = pPage;
    }

    public String toString() {
        return "Titre: " + getTitre() + " Fréquence: " + this.frequence + " Page: " + this.page + " Date: " + getCreationDate();
    }
}
