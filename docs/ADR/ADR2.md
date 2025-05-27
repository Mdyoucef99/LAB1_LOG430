# ADR2 : Stratégie de persistance                                                                

## CONTEXTE 
Le système de caisse doit pouvoir stocker durablement les produits, supporter plusieurs caisses qui accèdent à la même base PostgreSQL et
rester simple à installer et compatible avec l’architecture 2-tier 

## Décision
Dans ce laboratoire la strategie de persistance utilisé est PostgreSQL comme RDBMS.
L'abstraction de la couche de persistance sera accomplie en utilsant ORMLite.Ceci permettra de mapper les tables dans une classe Java.

## Status 
Accepté 

## Conséquences 

- Écrire et maintenir le code : grâce à ORMLite, les entités Java sont directement mappées aux tables et presque aucune requête SQL est utilisé dans le code.

- Changer de DBMS à l’avenir est très simple, car il suffit de remplacer le driver JDBC sans toucher au code grâce à la bibliothèque ORMLite.


Référence template : Decision record template by Michael Nygard (https://github.com/joelparkerhenderson/architecture-decision-record/tree/main/locales/en/templates/decision-record-template-by-michael-nygard)

