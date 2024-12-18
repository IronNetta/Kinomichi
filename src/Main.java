import activite.Activite;
import activite.ActiviteController;
import activite.ActiviteView;
import inscription.Inscription;
import inscription.InscriptionController;
import inscription.InscriptionView;
import tarif.TarifController;
import tarif.TarifView;

public class Main {
    public static void main(String[] args) {
        Activite activiteModel = new Activite();
        ActiviteView activiteView = new ActiviteView();
        ActiviteController activiteController = new ActiviteController(activiteModel, activiteView);

        TarifView tarifView = new TarifView();
        TarifController tarifController = new TarifController(tarifView, activiteController);

        Inscription inscriptionModel = new Inscription();
        InscriptionView inscriptionView = new InscriptionView();
        InscriptionController inscriptionController = new InscriptionController(inscriptionModel, inscriptionView,
                activiteController, tarifController);

        inscriptionController.demarrer();
    }
}
