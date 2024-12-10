package inscription;

import personne.Personne;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "ListeInscrit.ser";
    private ArrayList<Personne> inscrit = new ArrayList<>();

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

    private static void afficherMenu() {
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

    private void ajouterEleve(Scanner scanner) {
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
            sauvegarder();
            System.out.println("Eleve ajouté avec succès.");
        } else {
            System.out.println("Ajout annulé.");
        }
    }

    private void listerEleve() {
        if (inscrit.isEmpty()) {
            System.out.println("Aucun élève inscrit.");
        } else {
            System.out.println("Liste des élèves inscrits :");
            for (Personne eleve : inscrit) {
                System.out.println(eleve);
            }
        }
    }

    private void rechercherEleveParPrenom(Scanner scanner) {
        System.out.print("Entrez le prénom de l'élève à rechercher : ");
        String prenom = scanner.nextLine();
        for (Personne eleve : inscrit) {
            if (eleve.getPrenom().equalsIgnoreCase(prenom)) {
                System.out.println(eleve);
                return;
            }
        }
        System.out.println("Aucun élève trouvé avec ce prénom.");
    }

    private void rechercherEleveParNom(Scanner scanner) {
        System.out.print("Entrez le nom de l'élève à rechercher : ");
        String nom = scanner.nextLine();
        for (Personne eleve : inscrit) {
            if (eleve.getNom().equalsIgnoreCase(nom)) {
                System.out.println(eleve);
                return;
            }
        }
        System.out.println("Aucun élève trouvé avec ce nom.");
    }

    private void modifierEleve(Scanner scanner) {
        System.out.print("Entrez le nom de l'élève à modifier : ");
        String nom = scanner.nextLine();
        for (Personne eleve : inscrit) {
            if (eleve.getNom().equalsIgnoreCase(nom)) {
                boolean modificationTerminee = false;
                while (!modificationTerminee) {
                    System.out.println("Que souhaitez-vous modifier ?");
                    System.out.println("1. Prénom");
                    System.out.println("2. Club");
                    System.out.println("3. Adresse email");
                    System.out.println("4. Paiement");
                    System.out.println("0. Terminer et sauvegarder");
                    System.out.print("Votre choix : ");
                    int choix = scanner.nextInt();
                    scanner.nextLine();

                    switch (choix) {
                        case 1:
                            System.out.print("Entrez le nouveau prénom : ");
                            eleve.setPrenom(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Entrez le nouveau club : ");
                            eleve.setClub(scanner.nextLine());
                            break;
                        case 3:
                            System.out.print("Entrez la nouvelle adresse email : ");
                            eleve.setMail(scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("Attendez-vous un paiement ? (oui/non) : ");
                            eleve.setPayemmentEnCours(scanner.nextLine().equalsIgnoreCase("oui"));
                            break;
                        case 0:
                            modificationTerminee = true;
                            break;
                        default:
                            System.out.println("Choix invalide. Réessayez.");
                    }
                }
                sauvegarder();
                System.out.println("Élève modifié avec succès.");
                return;
            }
        }
        System.out.println("Aucun élève trouvé avec ce nom.");
    }

    private void supprimerEleve(Scanner scanner) {
        System.out.print("Entrez le nom de l'élève à supprimer : ");
        String nom = scanner.nextLine();
        for (Personne eleve : inscrit) {
            if (eleve.getNom().equalsIgnoreCase(nom)) {
                inscrit.remove(eleve);
                sauvegarder();
                System.out.println("Élève supprimé avec succès.");
                return;
            }
        }
        System.out.println("Aucun élève trouvé avec ce nom.");
    }

    private boolean existeNom(String nom) {
        for (Personne eleve : inscrit) {
            if (eleve.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    private void sauvegarder() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inscrit);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            inscrit = (ArrayList<Personne>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Aucune donnée existante n'a été trouvée. Une nouvelle liste sera créée.");
        }
    }
}