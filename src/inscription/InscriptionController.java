package inscription;

import personne.Personne;

public class InscriptionController {
    private final Inscription model;
    private final InscriptionView view;

    public InscriptionController(Inscription model, InscriptionView view) {
        this.model = model;
        this.view = view;
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
                case 6 -> supprimerEleve();
                case 0 -> view.afficherMessage("Fermeture de l'application.");
                default -> view.afficherMessage("Choix invalide. Réessayez.");
            }
        } while (choix != 0);
    }

    private void ajouterEleve() {
        Personne nouvelEleve = view.lireNouvelEleve();
        model.ajouterEleve(nouvelEleve);
        view.afficherMessage("Élève ajouté avec succès.");
    }

    private void listerEleves() {
        for (Personne eleve : model.listerEleves()) {
            view.afficherEleve(eleve);
        }
    }

    private void rechercherParPrenom() {
        String prenom = view.lirePrenom();
        Personne eleve = model.rechercherParPrenom(prenom);
        view.afficherEleve(eleve);
    }

    private void rechercherParNom() {
        String nom = view.lireNom();
        Personne eleve = model.rechercherParNom(nom);
        view.afficherEleve(eleve);
    }

    private void supprimerEleve() {
        String nom = view.lireNom();
        Personne eleve = model.rechercherParNom(nom);
        if (eleve != null) {
            model.supprimerEleve(eleve);
            view.afficherMessage("Élève supprimé avec succès.");
        } else {
            view.afficherMessage("Aucun élève trouvé.");
        }
    }
}