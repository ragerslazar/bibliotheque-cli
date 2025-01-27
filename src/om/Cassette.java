package om;

import java.io.Serializable;

public class Cassette extends Document implements Serializable {
    private String auteur;
    private int duree;

    public Cassette(String pTitre, String pAuteur, int pDuree) {
        super(pTitre);
        this.auteur = pAuteur;
        this.duree = pDuree;
    }

    public String toString() {
        return "Titre: " + this.getTitre() + " Auteur: " + this.auteur + " Durée: " + this.duree + " Date: " + getCreationDate();
    }
}