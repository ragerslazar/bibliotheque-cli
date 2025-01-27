package om;

import java.io.Serializable;

public class Livre extends Document implements Serializable {
    private int page;
    private String auteur;
    private String editeur;

    public Livre(String pTitre, int pPage, String pAuteur, String pEditeur) {
        super(pTitre);
        this.page = pPage;
        this.auteur = pAuteur;
        this.editeur = pEditeur;
    }

    @Override
    public String toString() {
        return "Titre: " + getTitre() + " Page: " + this.page + " Auteur: " + this.auteur + " Editeur: " + this.editeur + " Date: " + getCreationDate();
    }

    public String test() {
        return "cc";
    }
}
