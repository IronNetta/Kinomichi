package inscription;

import personne.Personne;

import java.util.Scanner;

public class InscriptionView {
    private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
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
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    public Personne lireNouvelEleve() {
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Club : ");
        String club = scanner.nextLine();
        String mail;
        mail = getEmail();
        System.out.print("Paiement en cour? (oui/non) : ");
        boolean paiement = scanner.nextLine().equalsIgnoreCase("oui");

        return new Personne(nom, prenom, club, mail, paiement);
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
        System.out.print(message + " (oui/non) : ");
        return scanner.nextLine().equalsIgnoreCase("oui");
    }
}
