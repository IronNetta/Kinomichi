package tarif;

import activite.Activite;
import activite.ActiviteController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TarifController {
    private final List<Tarif> tarifs = new ArrayList<>();
    private final TarifView view;
    private final ActiviteController activiteController; // Pour gérer les activités

    public TarifController(TarifView view, ActiviteController activiteController) {
        this.view = view;
        this.activiteController = activiteController;
    }

    public void demarrer() {
        int choix;
        do {
            afficherMenu();
            choix = lireChoix();

            switch (choix) {
                case 1 -> ajouterTarif();
                case 2 -> listerTarifs();
                case 3 -> modifierTarif();
                case 4 -> supprimerTarif();
                case 5 -> associerActiviteTarif();
                case 0 -> view.afficherMessage("Retour au menu principal.");
                default -> view.afficherMessage("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }

    private void afficherMenu() {
        System.out.println("\n--- Gestion des Tarifs ---");
        System.out.println("1. Ajouter un tarif");
        System.out.println("2. Lister les tarifs");
        System.out.println("3. Modifier un tarif");
        System.out.println("4. Supprimer un tarif");
        System.out.println("5. Associer une activité à un tarif");
        System.out.println("0. Retour au menu principal");
        System.out.print("Votre choix : ");
    }


    private int lireChoix() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Choix invalide
        }
    }

    public void ajouterTarif() {
        Tarif nouveauTarif = view.saisirNouveauTarif();
        tarifs.add(nouveauTarif);
        view.afficherMessage("Tarif ajouté avec succès.");
    }

    public void listerTarifs() {
        if (tarifs.isEmpty()) {
            view.afficherMessage("Aucun tarif enregistré.");
        } else {
            view.afficherListeTarifs(tarifs);
        }
    }

    public void associerActiviteTarif() {
        String typeTarif = view.saisirTypeTarif();
        Tarif tarif = rechercherTarif(typeTarif);

        if (tarif == null) {
            view.afficherMessage("Tarif introuvable.");
            return;
        }

        view.afficherMessage("Liste des activités disponibles :");
        activiteController.listerActivites();
        String nomActivite = view.saisirNomActivite();
        Activite activite = activiteController.rechercherActivite(nomActivite);

        if (activite != null) {
            tarif.ajouterActivite(activite);
            view.afficherMessage("Activité associée au tarif avec succès.");
        } else {
            view.afficherMessage("Activité introuvable.");
        }
    }

    public void modifierTarif() {
        String type = view.saisirTypeTarif();
        Tarif tarif = rechercherTarif(type);
        if (tarif != null) {
            view.modifierTarif(tarif);
            view.afficherMessage("Tarif modifié avec succès.");
        } else {
            view.afficherMessage("Tarif introuvable.");
        }
    }

    public void supprimerTarif() {
        String type = view.saisirTypeTarif();
        Tarif tarif = rechercherTarif(type);
        if (tarif != null) {
            tarifs.remove(tarif);
            view.afficherMessage("Tarif supprimé avec succès.");
        } else {
            view.afficherMessage("Tarif introuvable.");
        }
    }

    private Tarif rechercherTarif(String type) {
        return tarifs.stream().filter(t -> t.getType().equalsIgnoreCase(type)).findFirst().orElse(null);
    }
}

