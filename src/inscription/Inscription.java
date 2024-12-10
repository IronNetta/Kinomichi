package inscription;

import personne.Personne;

import java.io.*;
import java.util.ArrayList;

public class Inscription {
    private static final String FILE_NAME = "ListeInscrit.txt";
    private ArrayList<Personne> inscrit = new ArrayList<>();

    public void ajouterEleve(Personne eleve) {
        inscrit.add(eleve);
        sauvegarder();
    }

    public ArrayList<Personne> listerEleves() {
        return inscrit;
    }

    public Personne rechercherParNom(String nom) {
        return inscrit.stream().filter(e -> e.getNom().equalsIgnoreCase(nom)).findFirst().orElse(null);
    }

    public Personne rechercherParPrenom(String prenom) {
        return inscrit.stream().filter(e -> e.getPrenom().equalsIgnoreCase(prenom)).findFirst().orElse(null);
    }

    public void supprimerEleve(Personne eleve) {
        inscrit.remove(eleve);
        sauvegarder();
    }

    public void sauvegarder() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inscrit);
            oos.flush();
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            inscrit = (ArrayList<Personne>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Aucune donnée existante. Nouvelle liste créée.");
        }
    }
}