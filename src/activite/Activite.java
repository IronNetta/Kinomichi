package activite;

import personne.Personne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Activite implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FILE_NAME = "Activite.json";
    private List<Activite> activites = new ArrayList<>();

    private String nom;
    private int heuresStage;
    private boolean logement;
    private boolean repasSoir;
    private boolean estWeekend;

    public Activite() {
    }

    public Activite(String nom, int heuresStage, boolean logement, boolean repasSoir, boolean estWeekend) {
        this.nom = nom;
        this.heuresStage = heuresStage;
        this.logement = logement;
        this.repasSoir = repasSoir;
        this.estWeekend = estWeekend;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getHeuresStage() { return heuresStage; }
    public void setHeuresStage(int heuresStage) { this.heuresStage = heuresStage; }

    public boolean isLogement() { return logement; }
    public void setLogement(boolean logement) { this.logement = logement; }

    public boolean isRepasSoir() { return repasSoir; }
    public void setRepasSoir(boolean repasSoir) { this.repasSoir = repasSoir; }

    public boolean isEstWeekend() { return estWeekend; }
    public void setEstWeekend(boolean estWeekend) { this.estWeekend = estWeekend; }

    @Override
    public String toString() {
        return "Activite{" +
                "nom='" + nom + '\'' +
                ", heuresStage=" + heuresStage +
                ", logement=" + logement +
                ", repasSoir=" + repasSoir +
                ", estWeekend=" + estWeekend +
                '}';
    }

    public void sauvegarder() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(activites);
            oos.flush();
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void charger() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            activites = (ArrayList<Activite>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Aucune donnée existante. Nouvelle liste créée.");
        }
    }
}

