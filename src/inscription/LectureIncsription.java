package inscription;

import personne.Personne;

import java.io.*;

public class LectureIncsription {

    private static void saveInscription(Personne inscrit) {
        try (FileOutputStream f = new FileOutputStream("Liste Inscrit");
                ObjectOutput s = new ObjectOutputStream(f)) {
            s.writeObject(inscrit);
            s.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Inscription loadInscription() {
        Inscription inscrit;
        try (FileInputStream in = new FileInputStream("Liste Inscrit");
                ObjectInputStream s = new ObjectInputStream(in)) {
            inscrit = (Inscription) s.readObject();
        } catch (IOException e) {
            inscrit = new Inscription();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return inscrit;
    }

    private static void removeInscription() {
        try (FileOutputStream f = new FileOutputStream("Liste Inscrit");
                ObjectOutput s = new ObjectOutputStream(f)) {
            s.writeObject(new Inscription());
            s.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void modificationInscription(Personne inscrit) {
        try (FileOutputStream f = new FileOutputStream("Liste Inscrit");
                ObjectOutput s = new ObjectOutputStream(f)) {
            s.writeObject(inscrit);
            s.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
