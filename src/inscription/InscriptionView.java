package inscription;

import activite.Activite;
import activite.ActiviteController;
import personne.Personne;
import utils.IPrintList;
import utils.Lecture;

import java.util.List;
import java.util.Scanner;

public class InscriptionView extends Lecture implements IPrintList<Personne> {
    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private final Scanner scanner = new Scanner(System.in);

    public void afficherListe(List list) {
        if (list.isEmpty()) {
            System.out.println("Aucun élève disponible.");
        } else {
            System.out.println("Liste des élèves :");
            for (Object item : list) {
                System.out.println(item);
            }
        }
    }

    public void afficherMenu() {
        System.out.println("\n--- Menu Gestion des eleves ---");
        System.out.println("1. Ajouter un élève");
        System.out.println("2. Lister les élèves");
        System.out.println("3. Rechercher un élève par prénom");
        System.out.println("4. Rechercher un élève par nom");
        System.out.println("5. Modifier un élève");
        System.out.println("6. Supprimer un élève");
        System.out.println("7. Gérer les activités");
        System.out.println("8. Gérer les tarifs");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }


    public Personne lireNouvelEleve(ActiviteController activiteController) {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Club : ");
        String club = scanner.nextLine();
        String mail = getEmail();
        System.out.print("Paiement en cour? (oui/non) : ");
        boolean paiement = scanner.nextLine().equalsIgnoreCase("oui");

        Personne nouvelEleve = new Personne(nom, prenom, club, mail, paiement);

        // Ajouter des activités
        boolean ajoutActivites = true;
        while (ajoutActivites) {
            System.out.println("Voulez-vous ajouter une activité existante ? (oui/non) : ");
            if (!scanner.nextLine().equalsIgnoreCase("oui")) {
                ajoutActivites = false;
                break;
            }

            activiteController.listerActivites();
            System.out.print("Nom de l'activité : ");
            String nomActivite = scanner.nextLine();
            Activite activite = activiteController.rechercherActivite(nomActivite);

            if (activite != null) {
                nouvelEleve.ajouterActivite(activite);
            } else {
                System.out.println("Activité introuvable.");
            }
        }

        return nouvelEleve;
    }

    private boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    private String getEmail() {
        String email;
        do {
            System.out.print("Email : ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("L'email '" + email + "' est invalide. Exemple : jeandupont@monmail.com");
            }
        } while (!isValidEmail(email));
        return email;
    }

    public void afficherEleve(Personne eleve) {
        if (eleve != null) {
            System.out.println(eleve);
        } else {
            System.out.println("Aucun élève trouvé.");
        }
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public String lireNom() {
        System.out.print("Entrez le nom : ");
        return scanner.nextLine();
    }

    public String lirePrenom() {
        System.out.print("Entrez le prénom : ");
        return scanner.nextLine();
    }

    public String lireText(String champ) {
        System.out.print("Entrez le nouveau " + champ + " : ");
        return scanner.nextLine();
    }

    public boolean lireBoolean(String message) {
        return scanner.nextLine().equalsIgnoreCase("oui");
    }

    public void afficherMenuModificationEleve(Personne eleve) {
    }

}
