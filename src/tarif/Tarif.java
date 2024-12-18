package tarif;

import activite.Activite;

import java.util.ArrayList;
import java.util.List;

public class Tarif {
    private String type; // Exemple : "Instructeur", "Participant"
    private double prixParActivite;
    private double prixLogement;
    private double prixSouper;
    private List<Activite> activites = new ArrayList<>(); // Liste des activités associées

    public Tarif(String type, double prixParActivite, double prixLogement, double prixSouper) {
        this.type = type;
        this.prixParActivite = prixParActivite;
        this.prixLogement = prixLogement;
        this.prixSouper = prixSouper;
    }

    // Getters et setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrixParActivite() {
        return prixParActivite;
    }

    public void setPrixParActivite(double prixParActivite) {
        this.prixParActivite = prixParActivite;
    }

    public double getPrixLogement() {
        return prixLogement;
    }

    public void setPrixLogement(double prixLogement) {
        this.prixLogement = prixLogement;
    }

    public double getPrixSouper() {
        return prixSouper;
    }

    public void setPrixSouper(double prixSouper) {
        this.prixSouper = prixSouper;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void ajouterActivite(Activite activite) {
        activites.add(activite);
    }

    public void retirerActivite(Activite activite) {
        activites.remove(activite);
    }

    @Override
    public String toString() {
        return "Tarif {" +
                "type='" + type + '\'' +
                ", prixParActivite=" + prixParActivite +
                ", prixLogement=" + prixLogement +
                ", prixSouper=" + prixSouper +
                ", activites=" + activites +
                '}';
    }
}
