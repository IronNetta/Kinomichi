package personne;

import java.io.Serializable;
import java.util.Objects;

public class Personne implements Serializable {

    private String nom;
    private String prenom;
    private String club;
    private String mail;
    private boolean payemmentEnCours;

    public Personne() {
    }
    public Personne(String nom, String prenom, String club, String mail, boolean payemmentEnCours) {
        this.nom = Objects.requireNonNull(nom);
        this.prenom = Objects.requireNonNull(prenom);
        this.club = club;
        this.mail = mail;
        this.payemmentEnCours = payemmentEnCours;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", club='" + club + '\'' +
                ", mail='" + mail + '\'' +
                ", payemmentEnCours=" + payemmentEnCours +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isPayemmentEnCours() {
        return payemmentEnCours;
    }

    public void setPayemmentEnCours(boolean payemmentEnCours) {
        this.payemmentEnCours = payemmentEnCours;
    }
}
