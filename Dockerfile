# Utilise une image de base Java
FROM openjdk:17-jdk-slim

# Crée un dossier pour l'application
WORKDIR /app

# Copie le JAR dans l'image Docker
COPY Lab1_LOG430.jar app.jar

# Copie le dossier LABO1 contenant Magasin.db
COPY LABO1 LABO1

# Commande à exécuter quand le conteneur démarre
ENTRYPOINT ["java", "-jar", "app.jar"]