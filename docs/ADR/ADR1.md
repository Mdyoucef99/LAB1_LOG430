# ADR1 : Choix de la plateforme d’exécution 

## CONTEXTE 
Dans le cadre de ce laboratoire, il faut développer une architecture 2-tier de type client/serveur.
Le client représente une console d’où il est possible d’exécuter plusieurs actions.
Le serveur représente une base de données PostgreSQL.

## Décision
Dans ce laboratoire, le langage de programmation utilisé sera Java et la plateforme sera Java aussi : JDK 17 (LTS) comme environnement d’exécution.
Le packaging sera un JAR exécutable. La raison du choix de cette plateforme et language est la documentation disponible ainsi que l’expérience de l’étudiant (moi) avec celle-ci.

## Status 
Accepté

## Conséquences 

- Facile à implémenter dans le pipeline CI/CD, car les images Docker « openjdk:17 » existent déjà, ce qui facilite la configuration.

- Gestion des chemins des librairies à faire manuellement.



Référence template : Decision record template by Michael Nygard (https://github.com/joelparkerhenderson/architecture-decision-record/tree/main/locales/en/templates/decision-record-template-by-michael-nygard)




