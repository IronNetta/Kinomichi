package inscription;

import personne.Personne;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Inscription {
    static ArrayList<Personne> inscrit = new ArrayList<>();

    public void read() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterEleve(scanner);
                    break;
                case 2:
                    listerEleve();
                    break;
                case 3:
                    rechercherEleveParPrenom(scanner);
                    break;
                case 4:
                    rechercherEleveParNom(scanner);
                    break;
                case 5:
                    modifierEleve(scanner);
                    break;
                case 6:
                    supprimerEleve(scanner);
                    break;
                case 0:
                    System.out.println("Fermeture de l'application.");
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        } while (choix != 0);

        scanner.close();
    }

    static void afficherMenu() {
        System.out.println("\n--- Menu Gestion des eleves ---");
        System.out.println("1. Ajouter un eleve");
        System.out.println("2. Lister les eleves");
        System.out.println("3. Rechercher un eleve par prenom");
        System.out.println("4. Rechercher un eleve par nom");
        System.out.println("5. Modifier un eleve");
        System.out.println("6. Supprimer un eleve");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    static void ajouterEleve(Scanner scanner) {

        System.out.print("Entrez le nom de l'eleve: ");
        String nom = scanner.nextLine().trim();
        if (nom.isEmpty() || existeNom(nom)) {
            System.out.println("Nom invalide ou déjà utilisé.");
            return;
        }

        System.out.print("Entrez le prenom: ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez le club: ");
        String club = scanner.nextLine();

        System.out.print("Entrez l'adresse email: ");
        String mail = scanner.nextLine();

        System.out.print("Attendez-vous un payement de cet eleve ? (oui/non): ");
        boolean payement = scanner.nextLine().equalsIgnoreCase("oui");

        Personne nouvelEleve = new Personne(nom, prenom, club, mail, payement);

        System.out.println("Coordonnées de l'eleve:");
        System.out.println(nouvelEleve);
        System.out.print("Confirmer l'ajout ? (oui/non): ");
        if (scanner.nextLine().equalsIgnoreCase("oui")) {
            inscrit.add(nouvelEleve);
            System.out.println("Eleve ajouté avec succès.");
        } else {
            System.out.println("Ajout annulé.");
        }
    }

    static void listerEleve() {
        if (inscrit.isEmpty()) {
            System.out.println("Aucun eleve enregistré.");
            return;
        }
        for (Personne inscrits : inscrit) {
            System.out.println("Nom: " + inscrits.getNom() + ", Prenom: " + inscrits.getPrenom() + "Club: "
                    + inscrits.getClub() + ", Email: " + inscrits.getMail());
        }
    }

    static void rechercherEleveParPrenom(Scanner scanner) {
        if (inscrit.isEmpty()) {
            System.out.println("Aucun eleve enregistré.");
            return;
        }

        System.out.print("Entrez le prenom de l'eleve: ");
        String prenom = scanner.nextLine().trim();

        Personne p = trouverEleveParPrenom(prenom);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Aucun eleve trouvé avec ce prenom.");
        }
    }

    static void rechercherEleveParNom(Scanner scanner) {
        if (inscrit.isEmpty()) {
            System.out.println("Aucun eleve enregistré.");
            return;
        }

        System.out.print("Entrez le nom de l'eleve: ");
        String nom = scanner.nextLine().trim();

        Personne p = trouverEleveParNom(nom);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Aucun eleve trouvé avec ce nom.");
        }
    }

    static void modifierEleve(Scanner scanner) {
        if (inscrit.isEmpty()) {
            System.out.println("Aucun eleve enregistré.");
            return;
        }

        System.out.print("Entrez le nom de l'eleve à modifier: ");
        String nom = scanner.nextLine().trim();

        Personne p = trouverEleveParNom(nom);
        if (p != null) {
            System.out.println(p);

            int choix = -1;
            while (choix != 0) {
                System.out.println("Que souhaitez-vous modifier ?");
                System.out.println("1. Nom\n2. Prenom\n3. Clubl\n4. mail\n5.payement\n0. Annuler");

                if (scanner.hasNextInt()) {
                    choix = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix) {
                        case 1:
                            System.out.print("Entrez le nouveau nom: ");
                            String nouveauNom = scanner.nextLine().trim();
                            if (!existeNom(nouveauNom)) {
                                p.setNom(nouveauNom);
                                System.out.println("Nom mis à jour.");
                            } else {
                                System.out.println("Nom déjà utilisé.");
                            }
                            break;
                        case 2:
                            System.out.print("Entrez le nouveau prenom: ");
                            p.setPrenom(scanner.nextLine());
                            System.out.println("Prenom mis à jour.");
                            break;
                        case 3:
                            System.out.print("Entrez le nouveau club: ");
                            p.setClub(scanner.nextLine());
                            System.out.println("Club mis à jour.");
                            break;
                        case 4:
                            System.out.print("Entrez le nouveau email: ");
                            p.setMail(scanner.nextLine());
                            System.out.println("Email mis à jour.");
                            break;
                        case 5:
                            System.out.print("Attendez-vous un payement ? (oui/non): ");
                            p.setPayemmentEnCours(scanner.nextLine().equalsIgnoreCase("oui"));
                            System.out.println("Statut du payement mis à jour.");
                            break;
                        case 0:
                            System.out.println("Modification annulée.");
                            return;
                        default:
                            System.out.println("Choix invalide, veuillez réessayer.");
                    }
                } else {
                    System.out.println("Entrée non valide, veuillez entrer un nombre.");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Aucun eleve trouvé avec ce numéro.");
        }
    }

    static void supprimerEleve(Scanner scanner) {
        if (inscrit.isEmpty()) {
            System.out.println("Aucun eleve enregistré.");
            return;
        }

        System.out.print("Entrez le nom de l'eleve à supprimer: ");
        String nom = scanner.nextLine().trim();

        Personne p = trouverEleveParNom(nom);
        if (p != null) {
            if (p.isPayemmentEnCours()) {
                System.out.println("Impossible de supprimer un eleve avec un payement en cours.");
            } else {
                System.out.println(p);
                System.out.print("Confirmer la suppression ? (oui/non): ");
                if (scanner.nextLine().equalsIgnoreCase("oui")) {
                    inscrit.remove(p);
                    System.out.println("eleve supprimé.");
                } else {
                    System.out.println("Suppression annulée.");
                }
            }
        } else {
            System.out.println("Aucun eleve trouvé avec ce numéro.");
        }
    }

    static Personne trouverEleveParPrenom(String prenom) {
        for (Personne p : inscrit) {
            if (Objects.equals(p.getPrenom(), prenom)) {
                return p;
            }
        }
        return null;
    }

    static Personne trouverEleveParNom(String nom) {
        for (Personne p : inscrit) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }

    static boolean existeNom(String nom) {
        for (Personne p : inscrit) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

}
