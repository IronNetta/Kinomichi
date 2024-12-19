package activite;

import utils.IPrintList;
import utils.Lecture;

import java.util.List;
import java.util.Scanner;

public class ActiviteView extends Lecture implements IPrintList<Activite> {
    private final Scanner scanner = new Scanner(System.in);

    public void afficherListe(List list) {
        if (list.isEmpty()) {
            System.out.println("Aucune activité disponible.");
        } else {
            System.out.println("Liste des activités :");
            for (Object item : list) {
                System.out.println(item);
            }
        }
    }

    public Activite demanderNouvelleActivite() {
        System.out.print("Nom de l'activité : ");
        String nom = scanner.nextLine();
        System.out.print("Durée en heures : ");
        int heuresStage = scanner.nextInt();
        scanner.nextLine();
        boolean logement = lireBooleen("Inclut un logement ? (oui/non) :");
        boolean repasSoir = lireBooleen("Inclut un souper ? (oui/non) : ");
        boolean estWeekend = lireBooleen("Est-ce un stage de weekend ? (oui/non) : ");


        return new Activite(nom, heuresStage, logement, repasSoir, estWeekend);
    }

    public String demanderNomActivite() {
        System.out.print("Nom de l'activité : ");
        return scanner.nextLine();
    }

    public void afficherMenuActivites() {
        System.out.println("\n--- Gestion des Activités ---");
        System.out.println("1. Ajouter une activité");
        System.out.println("2. Lister les activités");
        System.out.println("3. Modifier une activité");
        System.out.println("4. Supprimer une activité");
        System.out.println("0. Retour au menu principal");
        System.out.print("Votre choix : ");
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public Activite lireNouvelleActivite() {
        System.out.print("Nom de l'activité : ");
        String nom = lireTexte();
        System.out.print("Durée (en heures) : ");
        int duree = lireEntier();
        boolean logement = lireBooleen("Inclut un logement ? (oui/non) :");
        boolean souper = lireBooleen("Inclut un souper ? (oui/non) : ");
        boolean weekend = lireBooleen("Est-ce un stage de weekend ? (oui/non) : ");

        return new Activite(nom, duree, logement, souper, weekend);
    }

    public String lireTexte(String prompt) {
        System.out.print(prompt);
        return lireTexte();
    }

    public int lireEntier() {
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un entier valide : ");
            scanner.next();
        }
        return scanner.nextInt();
    }

}

