# Lab0 – Application Java Simple

## Description

Ce projet contient une application Java minimale qui affiche **Hello World** dans la console.Java est un langage très populaire utilisé dans de nombreux environnements. Il offre une documentation riche qui facilite le débogage lors de l'exécution des tests ainsi que lors de la compilation. De plus, Java s'intègre facilement dans les pipelines CI/CD pour les étapes de lint (Checkstyle), build et déploiement dans Docker.

## Exécution de l’application

Dans la VM, le dossier racine ce trouve dans le fichier projects/LAB0_LOG430 .Assurez vous de faire un git -pull pour avoir la derniere version du repo

Depuis le dossier racine du projet, exécutez le JAR :

```bash
java -jar Lab0_LOG430.jar
```

## Tests unitaires

Les bibliothèques JUnit se trouvent dans le dossier `lib` (`junit-4.13.2.jar` et `hamcrest-core-1.3.jar`). Depuis le dossier racine :

```bash
# Compiler le test
javac -d LABO0/lab/bin -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" LABO0/lab/tests/lab/tests/AppTest.java

# Exécuter le test
java -cp "LABO0/lab/bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore lab.tests.AppTest
```

## Conteneurisation

Construisez et testez l’image Docker :

```bash
docker build -t lab0_api .
docker run --rm lab0_api
```

**Résultat attendu :**

```
Hello World!
```

## Orchestration avec Docker Compose

Il existe un `docker-compose.yaml` à la racine, lancez :

```bash
docker-compose up
```

**Résultat attendu :** `Hello World!`

Pour arrêter les services :

```bash
docker-compose down
```

## Intégration continue (CI/CD)

La pipeline CI/CD est configurée via **GitHub Actions** (ou GitLab CI/CD) et se déclenche à chaque push ou merge request. Elle exécute dans l’ordre :

1. **Lint** (Checkstyle)
2. **Tests unitaires** (JUnit)
3. **Build & publication** de l’image Docker (avec tag personnalisé)

Pour suivre l’exécution, ouvrez le dépôt et consultez la section **Actions**.
