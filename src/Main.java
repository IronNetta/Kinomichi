import activite.Activite;
import activite.ActiviteController;
import activite.ActiviteView;
import inscription.Inscription;
import inscription.InscriptionController;
import inscription.InscriptionView;

public class Main {
    public static void main(String[] args) {
        Activite activiteModel = new Activite();
        ActiviteView activiteView = new ActiviteView();
        ActiviteController activiteController = new ActiviteController(activiteModel, activiteView);

        Inscription inscriptionModel = new Inscription();
        InscriptionView inscriptionView = new InscriptionView();
        InscriptionController inscriptionController = new InscriptionController(inscriptionModel, inscriptionView, activiteController,activiteModel);

        inscriptionController.demarrer();
    }
}
