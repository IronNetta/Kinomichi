package tarif;

import java.util.List;
import java.util.Scanner;

public class TarifView {
    private final Scanner scanner = new Scanner(System.in);

    public String saisirTypeTarif() {
        System.out.print("Entrez le type de tarif (Instructeur / Participant) : ");
        return scanner.nextLine();
    }

    public String saisirNomActivite() {
        System.out.print("Entrez le nom de l'activité : ");
        return scanner.nextLine();
    }

    public Tarif saisirNouveauTarif() {
        System.out.print("Type de tarif (Instructeur / Participant) : ");
        String type = scanner.nextLine();

        System.out.print("Prix par activité : ");
        double prixParActivite = lireDouble();

        System.out.print("Prix pour le logement : ");
        double prixLogement = lireDouble();

        System.out.print("Prix pour le souper : ");
        double prixSouper = lireDouble();

        return new Tarif(type, prixParActivite, prixLogement, prixSouper);
    }

    public void modifierTarif(Tarif tarif) {
        System.out.println("Modification du tarif : " + tarif.getType());
        System.out.println("Laissez vide pour conserver les valeurs actuelles.");

        System.out.print("Prix par activité actuel (" + tarif.getPrixParActivite() + ") : ");
        String prixParActiviteInput = scanner.nextLine();
        if (!prixParActiviteInput.isEmpty()) {
            try {
                double nouveauPrix = Double.parseDouble(prixParActiviteInput);
                tarif.setPrixParActivite(nouveauPrix);
            } catch (NumberFormatException e) {
                System.out.println("Valeur invalide. Le prix par activité reste inchangé.");
            }
        }

        System.out.print("Prix logement actuel (" + tarif.getPrixLogement() + ") : ");
        String prixLogementInput = scanner.nextLine();
        if (!prixLogementInput.isEmpty()) {
            try {
                double nouveauPrix = Double.parseDouble(prixLogementInput);
                tarif.setPrixLogement(nouveauPrix);
            } catch (NumberFormatException e) {
                System.out.println("Valeur invalide. Le prix logement reste inchangé.");
            }
        }

        System.out.print("Prix souper actuel (" + tarif.getPrixSouper() + ") : ");
        String prixSouperInput = scanner.nextLine();
        if (!prixSouperInput.isEmpty()) {
            try {
                double nouveauPrix = Double.parseDouble(prixSouperInput);
                tarif.setPrixSouper(nouveauPrix);
            } catch (NumberFormatException e) {
                System.out.println("Valeur invalide. Le prix souper reste inchangé.");
            }
        }

        System.out.println("Tarif modifié : " + tarif);
    }


    public void afficherListeTarifs(List<Tarif> tarifs) {
        System.out.println("\n--- Liste des tarifs ---");
        for (int i = 0; i < tarifs.size(); i++) {
            System.out.println((i + 1) + ". " + tarifs.get(i));
        }
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }

    private double lireDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }
}
