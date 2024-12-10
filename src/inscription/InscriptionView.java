package inscription;

import personne.Personne;

import java.util.Scanner;

public class InscriptionView {
    private final Scanner scanner = new Scanner(System.in);

    public void afficherMenu() {
        System.out.println("\n--- Menu Gestion des eleves ---");
        System.out.println("1. Ajouter un élève");
        System.out.println("2. Lister les élèves");
        System.out.println("3. Rechercher un élève par prénom");
        System.out.println("4. Rechercher un élève par nom");
        System.out.println("5. Modifier un élève");
        System.out.println("6. Supprimer un élève");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    public int lireChoix() {
        return scanner.nextInt();
    }

    public Personne lireNouvelEleve() {
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Club : ");
        String club = scanner.nextLine();
        System.out.print("Email : ");
        String mail = scanner.nextLine();
        System.out.print("Paiement (oui/non) : ");
        boolean paiement = scanner.nextLine().equalsIgnoreCase("oui");

        return new Personne(nom, prenom, club, mail, paiement);
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
}
