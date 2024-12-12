## Technologies Utilisées
- **Spring Boot** : Un framework pour la création d'applications Java.
- **Spring Data JPA** : Pour gérer la base de données et les entités.
- **H2 Database** : Base de données en mémoire pour stocker les logs des lancers de dés.
- **Maven** : Outil de gestion des dépendances.

## Etapes

### 1. Créer le Projet Spring Boot
- Utilisez Spring Initializr pour créer le projet avec la dernière version de Spring Boot (LTS).
- Ajoutez les dépendances suivantes :
    - **Spring Web**
    - **Spring Data JPA**
    - **H2 Database**

### 2. Configurer le Projet
- Configurez l'application pour utiliser le port `8081`.
- Définissez le nom du projet comme `dice` dans `application.properties`.

### 3. Classe Dice
- Implémentez une classe `Dice` qui simule les lancers de dés.
- Marquez cette classe avec `@Component` pour permettre l'injection de dépendances.

### 4. Entité DiceRollLog
- Créez une entité JPA `DiceRollLog` avec les champs suivants :
    - `id` : Un identifiant unique pour chaque lancer de dés.
    - `diceCount` : Le nombre de dés lancés.
    - `results` : Une chaîne contenant les résultats du lancer de dés.
    - `timestamp` : Le timestamp du lancer.

### 5. Repository DiceRollLog
- Créez une interface `DiceRollLogRepository` étendant `JpaRepository` pour gérer les entrées `DiceRollLog`.

### 6. Contrôleur de Lancer de Dés
- Créez un contrôleur REST avec les endpoints suivants :
    - `GET /rollDice` : Lance un seul dé.
    - `GET /rollDices/{X}` : Lance `X` dés, où `X` est un paramètre dynamique.

### 7. Service DiceRoll
- Créez un service `DiceRollService` avec une méthode qui :
    - Prend le nombre de dés à lancer comme paramètre.
    - Retourne les résultats du lancer.
    - Sauvegarde l'historique du lancer dans la base de données à l'aide du repository.

### 8. Afficher l'Historique des Lancers
- Ajoutez un endpoint dans le contrôleur `GET /diceLogs` pour récupérer et afficher tous les logs des lancers de dés au format JSON.

### 9. Tests et Validation
- **API Tests**:
    - Les points d'API `/rollDice` et `/rollDices/{X}` ont été testés avec succès et retournent les résultats attendus.
    - L'endpoint `/diceLogs` renvoie correctement les logs de tous les lancés de dés stockés dans la base de données.

- **Vérification de la base de données**:
    - Les résultats des lancés de dés sont correctement enregistrés dans la base de données H2, et les informations sont récupérées via l'API.

## Comment Exécuter le Projet
1. Clonez le repository depuis GitHub.
2. Naviguez vers le dossier du projet et exécutez 