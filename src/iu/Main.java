package iu;

import om.*;

import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;

public class Main {
    public static void panel() {
        System.out.println("\n[1] Créer un document\n[2] Lister les documents\n[3] Rechercher les documents par criètres\n[4] Quitter l'application");
    }

    public static Bibliotheque chargerBiblio() {
        Bibliotheque bib = null;
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                    bib = (Bibliotheque) in.readObject();
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            //Si le fichier n'est pas trouvé, alors la bibliothèque n'existe pas et on la créer.
            System.out.println("Pas de bibliothque trouvée, création de la bibliothèque.");
            bib = new Bibliotheque("Biblio");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bib;
    }
    public static void main(String[] args) {
        Bibliotheque biblio = chargerBiblio();
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        while (true) {
            panel();
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("[1] Créer une cassette\n[2] Créer un livre\n[3] Créer un périodique\n[4] Retour au menu principal");
                    int choix2 = scanner.nextInt();
                    if (choix2 == 1) {
                        System.out.println("Saisissez un titre:");
                        String titre = scanner.next();
                        System.out.println("Saisissez un auteur:");
                        String auteur = scanner.next();
                        System.out.println("Saisissez une durée:");
                        int duree = scanner.nextInt();
                        System.out.println("Saisissez un critère (Laissez vide pour aucun critère):");
                        String critere = scanner.next();

                        Cassette cassette = new Cassette(titre, auteur, duree);
                        biblio.ajouterDocument(cassette);
                        if (critere != "") {
                            biblio.ajouterIndex(cassette, critere);
                        }
                    } else if (choix2 == 4) {
                        continue;
                    }
                    try (FileOutputStream fileOut = new FileOutputStream("person.ser");
                         ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                        out.writeObject(biblio);
                        System.out.println("Bibliothèque serialisé !");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    Enumeration<Document> listeDoc = biblio.documents();
                    while (listeDoc.hasMoreElements()) {
                        Document docInfo = listeDoc.nextElement();
                        System.out.println(docInfo + " | Type: " + docInfo.getClass().getSimpleName());
                    }
//                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
//                        biblio = (Bibliotheque) ois.readObject();
//                        Enumeration<Document> test = biblio.documents();
//                        while (test.hasMoreElements()) {
//                            Document docInfo = test.nextElement();
//                            System.out.println(docInfo);
//                        }
//                    } catch (IOException | ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
                    break;
                case 3:
                    System.out.println("Entrez un critère: ");
                    String crit = scanner.next();
                    Enumeration<Document> docIndex = biblio.trouverDocumentIndex(crit);
                    while (docIndex.hasMoreElements()) {
                        Document docInfo = docIndex.nextElement();
                        System.out.println(docInfo);
                        }
//                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
//                        biblio = (Bibliotheque) ois.readObject();
//                        Enumeration<Document> test = biblio.trouverDocumentIndex(crit);
//                        while (test.hasMoreElements()) {
//                            Document docInfo = test.nextElement();
//                            System.out.println(docInfo);
//                        }
//                    } catch (IOException | ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
                    break;
                case 4:
                    System.exit(200);
                    break;
            }
        }
    }
}