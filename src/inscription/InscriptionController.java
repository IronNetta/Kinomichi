package inscription;

import java.util.List;

import activite.Activite;
import activite.ActiviteController;
import activite.ActiviteView;
import personne.Personne;
import tarif.TarifController;
import tarif.TarifView;

public class InscriptionController {
    private final Inscription model;
    private final InscriptionView view;
    private final ActiviteController activiteController;
    private final TarifController tarifController;

    public InscriptionController(
            Inscription model,
            InscriptionView view,
            ActiviteController activiteController,
            TarifController tarifController
    ) {
        if (model == null || view == null || activiteController == null || tarifController == null) {
            throw new IllegalArgumentException("Les dépendances ne peuvent pas être nulles.");
        }
        this.model = model;
        this.view = view;
        this.activiteController = activiteController;
        this.tarifController = tarifController;
    }

    public void demarrer() {
        model.charger();

        int choix;
        do {
            view.afficherMenu();
            choix = view.lireChoix();

            switch (choix) {
                case 1 -> ajouterEleve();
                case 2 -> listerEleves();
                case 3 -> rechercherParPrenom();
                case 4 -> rechercherParNom();
                case 5 -> modifierEleve();
                case 6 -> supprimerEleve();
                case 7 -> gererActivites();
                case 8 -> gererTarifs();
                case 0 -> view.afficherMessage("Fermeture de l'application.");
                default -> view.afficherMessage("Choix invalide. Réessayez.");
            }
        } while (choix != 0);
    }

    private void gererActivites() {
        activiteController.demarrer();
    }

    private void gererTarifs() {
        tarifController.demarrer();
    }

    public void ajouterEleve() {
        Personne nouvelEleve = view.lireNouvelEleve(activiteController);
        model.ajouterEleve(nouvelEleve);
        view.afficherMessage("Élève ajouté avec succès.");
    }

    public void listerEleves() {
        List<Personne> eleves = model.listerEleves();
        if (eleves.isEmpty()) {
            view.afficherMessage("Aucun élève inscrit.");
        } else {
            for (int i = 0; i < eleves.size(); i++) {
                System.out.println((i + 1) + ". " + eleves.get(i));
            }
        }
    }

    private void rechercherParPrenom() {
        String prenom = view.lirePrenom();
        Personne eleve = model.rechercherEleve(e -> e.getPrenom().equalsIgnoreCase(prenom));
        view.afficherEleve(eleve);
    }

    private void rechercherParNom() {
        String nom = view.lireNom();
        Personne eleve = model.rechercherEleve(e -> e.getNom().equalsIgnoreCase(nom));
        view.afficherEleve(eleve);
    }

    private void supprimerEleve() {
        String nom = view.lireNom();
        Personne eleve = model.rechercherEleve(e -> e.getNom().equalsIgnoreCase(nom));
        if (eleve != null) {
            model.supprimerEleve(eleve);
            view.afficherMessage("Élève supprimé avec succès.");
        } else {
            view.afficherMessage("Aucun élève trouvé.");
        }
    }

    public void modifierEleve() {
        String nom = view.lireNom();
        Personne eleve = model.rechercherEleve(e -> e.getNom().equalsIgnoreCase(nom));

        if (eleve == null) {
            view.afficherMessage("Aucun élève trouvé avec ce nom.");
            return;
        }

        boolean modificationTerminee = false;
        while (!modificationTerminee) {
            view.afficherMenuModificationEleve(eleve);

            int choix = view.lireChoix();
            switch (choix) {
                case 1 -> eleve.setNom(view.lireNom());
                case 2 -> eleve.setPrenom(view.lirePrenom());
                case 3 -> eleve.setClub(view.lireText("club"));
                case 4 -> eleve.setMail(view.lireText("email"));
                case 5 -> eleve.setPayemmentEnCours(view.lireBoolean("Attendez-vous un paiement ?"));
                case 0 -> modificationTerminee = true;
                default -> view.afficherMessage("Choix invalide. Réessayez.");
            }
        }

        model.sauvegarder();
        view.afficherMessage("Élève modifié et sauvegardé avec succès.");
    }
}
