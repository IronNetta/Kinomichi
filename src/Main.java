import inscription.Inscription;
import inscription.InscriptionController;
import inscription.InscriptionView;

public class Main {
    public static void main(String[] args) {
        Inscription model = new Inscription();
        InscriptionView view = new InscriptionView();
        InscriptionController controller = new InscriptionController(model, view);
        controller.demarrer();
    }
}
