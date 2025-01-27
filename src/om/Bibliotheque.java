package om;

import java.io.*;
import java.util.*;

public class Bibliotheque implements Serializable {
    private Vector<Document> tdocument = new Vector<Document>();
    private HashMap<String, Vector<Document>> index = new HashMap<String, Vector<Document>>();
    private String nom;

    public Bibliotheque(String pNom) {
        this.nom = pNom;
    }

    public void ajouterDocument(Document pDoc) {
        tdocument.add(pDoc);
    }

    public String toString() {
        return this.getNom();
    }

    public String getNom() {
        return this.nom;
    }

    public Enumeration<Document> documents() {
        System.out.println("Les documents existants sont: ");
        Enumeration<Document> enu = tdocument.elements();
        return enu;
    }

    public void ajouterIndex(Document pDoc, String str) {
        if (index.containsKey(str)) {
            System.out.println("Clé déjà ajouté");
        } else {
            index.put(str, new Vector<Document>());
        }
        index.get(str).add(pDoc);
    }

    public Enumeration<String> trouverIndexDocument(Document pDoc) { //Trouvez l'index d'un document
        System.out.println("Le document " + pDoc.getTitre() + " possède les indexes:");
        Vector<String> keys = new Vector<>();
        for (HashMap.Entry<String, Vector<Document>> entry : index.entrySet()) {
            if (entry.getValue().contains(pDoc)) {
                keys.add(entry.getKey());
            }
        }
        return Collections.enumeration(keys);
    }

    public Enumeration<Document> trouverDocumentIndex(String str) { //Trouvez les documents qui ont pour index ...
        if (index.getOrDefault(str, new Vector<Document>()).size() == 0 ) {
            DocumentPasTrouve dpt = new DocumentPasTrouve(this.nom, str);
            System.out.println(dpt);
        } else {
            System.out.println("Les documents ayant pour index " + str + " sont:");
        }
        return Collections.enumeration(index.getOrDefault(str, new Vector<Document>()));
    }

    public Enumeration<String> indexes() {
        System.out.println("Les indexes disponibles sont: ");
        Vector<String> indexes = new Vector<String>();
        for (HashMap.Entry<String, Vector<Document>> entry : index.entrySet()) {
            indexes.add(entry.getKey());
        }
        return Collections.enumeration(indexes);
    }
}