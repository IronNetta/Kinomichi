package utils;

import java.util.Scanner;

public abstract class Lecture {
    Scanner scanner = new Scanner(System.in);

    public String lireTexte() {
        return scanner.nextLine();
    }

    public boolean lireBooleen(String message) {
        String reponse = lireTexte();
        System.out.print(message);
        return reponse.equalsIgnoreCase("oui");
    }

    public int lireChoix() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }
}
