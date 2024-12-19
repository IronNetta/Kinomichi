# Documentation du Projet Kinomichi

## Description du Projet
Le projet Kinomichi est une application Java basée sur le modèle **MVC (Modèle-Vue-Contrôleur)**. Elle permet de gérer les inscriptions, les activités et les tarifs dans le contexte d'un système éducatif ou sportif. 

Le projet utilise la sérialisation pour la persistance des données et propose une interface utilisateur interactive via la console.

---

## Structure du Projet

### 1. **Classes Principales**

#### **Main**
- Point d'entrée du programme.
- Initialise les modèles, vues, et contrôleurs, puis démarre le contrôleur principal des inscriptions.

#### **Modèle**
Les classes modèles contiennent les données et leur logique métier :
- **Personne** : Représente un inscrit avec des attributs tels que nom, prénom, mail, et activités associées.
- **Activite** : Définit une activité avec des propriétés comme le nom, la durée, le logement, etc.
- **Inscription** : Gère une liste d'inscrits, avec des fonctionnalités pour ajouter, rechercher et supprimer des personnes.
- **Tarif** : Représente un tarif avec des coûts associés à des activités.

#### **Vue**
Les classes vues gèrent l'interaction avec l'utilisateur via la console :
- **InscriptionView** : Affiche et interagit avec les données liées aux inscriptions.
- **ActiviteView** : Fournit des menus et des entrées pour la gestion des activités.
- **TarifView** : Permet la gestion des tarifs.

#### **Contrôleur**
Les contrôleurs relient les modèles et les vues, orchestrant leurs interactions :
- **InscriptionController** : Gère les opérations relatives aux inscriptions.
- **ActiviteController** : Gère les opérations relatives aux activités.
- **TarifController** : Gère les opérations relatives aux tarifs.

---

### 2. **Points Techniques**

#### Sérialisation
- Les classes `Inscription` et `Activite` utilisent la sérialisation pour sauvegarder et charger des données.
- Les fichiers de sauvegarde :
  - `ListeInscrit.json` pour les inscriptions.
  - `Activite.json` pour les activités.

#### Modèle-Vue-Contrôleur (MVC)
- Les responsabilités sont clairement séparées :
  - Modèle : Gestion des données.
  - Vue : Interface utilisateur.
  - Contrôleur : Logique de l'application.

#### Collections
- Utilisation de **ArrayList** pour stocker des listes d'objets comme les `Personne` ou les `Activite`.
- Utilisation de **Stream API** pour rechercher ou filtrer des éléments.

#### Gestion des Exceptions
- Les blocs `try/catch/finally` sont utilisés pour gérer les erreurs de lecture/écriture des fichiers de sauvegarde.

---

## Fonctionnalités Implémentées

### **Gestion des Inscriptions**
- Ajouter une personne.
- Lister toutes les personnes inscrites.
- Rechercher une personne par prénom ou par nom.
- Modifier les informations d'une personne.
- Supprimer une personne.

### **Gestion des Activités**
- Ajouter une activité.
- Lister toutes les activités.
- Modifier une activité.
- Supprimer une activité.

### **Gestion des Tarifs**
- Ajouter un tarif.
- Lister tous les tarifs.
- Associer une activité à un tarif.
- Modifier ou supprimer un tarif.

---

## Suggestions d'Amélioration

1. **Centralisation de la Sérialisation**
   - Créer une classe abstraite ou une interface pour uniformiser la sauvegarde et le chargement des données.

2. **Ajout de Fonctionnalités Avancées**
   - Implémenter une interface graphique (Swing, JavaFX, ou une application web).
   - Ajouter des rapports générés automatiquement (exemple : rapport des revenus).

3. **Optimisation des Collections**
   - Utiliser des structures comme `Set` pour éviter les doublons.
   - Ajouter des `Map` pour des recherches plus rapides par clé.

4. **Gestion des Tests**
   - Ajouter des tests unitaires pour valider les fonctionnalités critiques.

5. **Amélioration du Code**
   - Uniformiser les noms des méthodes (exemple : `setPayemmentEnCours` devrait être `setPaiementEnCours`).
   - Refactoriser les méthodes redondantes dans une classe utilitaire.

---

## Exécution du Programme
Pour exécuter l'application :
1. Compiler tous les fichiers Java :
   ```bash
   javac *.java
   ```
2. Lancer la classe `Main` :
   ```bash
   java Main
   ```

---

## Auteurs
- **Développeur principal** : De Laet Sebastien

## Licence
Ce projet est sous licence [Nom de la licence, ex: MIT].

