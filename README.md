# Kinomichi
## Gestion des Élèves

Une application Java simple pour gérer une liste d'élèves, comprenant des fonctionnalités d'ajout, de modification, de suppression et de recherche.

## Table des matières

- [Fonctionnalités](#fonctionnalités)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Structure du projet](#structure-du-projet)
- [Améliorations possibles](#améliorations-possibles)
- [Licence](#licence)

## Fonctionnalités

- Ajouter un élève (nom, prénom, email, club, état du paiement).
- Lister tous les élèves inscrits.
- Rechercher un élève par nom ou prénom.
- Modifier les informations d'un élève.
- Supprimer un élève de la liste.
- Sauvegarder et charger automatiquement les données dans un fichier (`ListeInscrit.txt`).

## Prérequis

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 ou supérieure)
- [Maven](https://maven.apache.org/) (facultatif, si vous souhaitez gérer les dépendances)

## Installation

1. Clonez ce repository :
   ```bash
   git clone https://github.com/IronNetta/Kinomichi.git
   cd Kinomichi
   ```

2. Compilez le projet :
   ```bash
   javac -d bin src/**/*.java
   ```

3. Exécutez le programme :
   ```bash
   java -cp bin Main
   ```

## Utilisation

L'application se lance dans un terminal avec un menu interactif. Vous pouvez naviguer à travers les options pour :

1. Ajouter un élève : Fournissez les informations demandées.
2. Lister les élèves : Affiche tous les élèves inscrits.
3. Rechercher un élève : Entrez un nom ou un prénom pour rechercher.
4. Modifier un élève : Fournissez les informations demandées.
5. Supprimer un élève : Trouvez un élève par nom et supprimez-le.
6. Quitter : Ferme l'application.

Les données sont automatiquement sauvegardées dans un fichier texte pour une utilisation ultérieure.

## Structure du projet

```
src/
├── Inscription.java           # Modèle de gestion des élèves
├── InscriptionView.java       # Interface utilisateur
├── InscriptionController.java # Logique métier et interactions
├── Personne.java              # Classe représentant un élève
├── Main.java                  # Point d'entrée de l'application
```

## Améliorations possibles

- **Validation des doublons :** Empêcher l'ajout d'élèves déjà existants.
- **Amélioration de l'interface utilisateur :** Ajouter une interface graphique avec JavaFX ou Swing.
- **Support des fichiers JSON :** Sauvegarder et charger les données dans un format plus lisible.
- **Recherche avancée :** Permettre une recherche partielle ou par plusieurs critères.

## Licence

Ce projet est sous licence MIT. Consultez le fichier [LICENSE](LICENSE) pour plus d'informations.
