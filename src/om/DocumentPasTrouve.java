package om;

public class DocumentPasTrouve extends BiblioException {
    private String index;

    //Si aucun document n'est associé à un index.
    public DocumentPasTrouve(String Biblio, String index) {
        super(Biblio);
        this.index = index;
    }

    public String toString() {
        return "Erreur ! Cette bibliothèque ne contient pas de documents ayant pour index: " + this.index;
    }
}
