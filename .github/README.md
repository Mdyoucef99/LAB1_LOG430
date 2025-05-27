# Lab1 –  Architecture 2 tiers (Client/Serveur), Persistance

## Description : 
 L’application cible est un système de caisse pour un petit magasin de quartier.

## Exécution de l’application
Dans la VM, le dossier racine ce trouve dans le fichier projects/LAB1_LOG430 .Assurez vous de faire un git -pull pour avoir la derniere version du repo

## Tests unitaires

Les bibliothèques JUnit se trouvent dans le dossier `lib` (`junit-4.13.2.jar` et `hamcrest-core-1.3.jar`). Depuis le dossier racine :

```bash
# Compiler le test
javac -d javac -d LABO1/lab/bin -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" LABO1/lab/tests/lab/tests/AppTest.java

# Exécuter le test
java -cp "LABO1/lab/bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore lab.tests.AppTest
```

## Conteneurisation

Construisez et testez l’image Docker :

```bash
docker build -t lab1_api .
docker run --rm -it --network host lab1_api
```


**Résultat attendu :**

Pour le resultat attendu vous devrier etre capable de lancer l'application et de voir la console avec les options : 

--- MENU CAISSE ---
1. Rechercher produit
2. Enregistrer vente
3. Annuler vente
4. Consulter stock
0. Quitter


## Orchestration avec Docker Compose

Il existe un `docker-compose.yaml` à la racine, lancez :

```bash
docker-compose -d db 
docker-compose run --rm api
```

**Résultat attendu :** 

Vous devriez maintenant être capable de lancer l'application et d'accéder à tous les produits dans la base de données qui est conteneurisée.

Pour arrêter les services :

```bash
docker-compose down
```

La pipeline CI/CD est configurée via **GitHub Actions** et se déclenche à chaque push ou merge request. Elle exécute dans l’ordre :

1. **Lint** (Checkstyle)
2. **Tests unitaires** (JUnit)
3. **Build & publication** de l’image Docker 

Pour suivre l’exécution, ouvrez le dépôt et consultez la section **Actions**.


