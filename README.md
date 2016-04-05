# Projet-M1ALMA-Logiciels-Extensibles

## Description de l'application
* Desciptif général : une plateforme gérant l'ajout d'extensions (plugins) à une application
* Contenu :
  * plateforme : dossier contenant la plateforme qui gère les extensions
  * appli : dossier contenant l'application qui utilise la plateforme
  * extension : dossier contenant les différentes extensions disponibles
  
* Exemple d'utilisation de notre application :
  * La plateforme charge application qui est le plugin principal.
  * L'application demande à la plateforme un plugin dont elle a besoin, ici un afficheur et l'exécute.
  
## Dépendances
  * JRE 1.7 minimum 
  
## Installation
* Dans un terminal, allez dans le dossier /src du projet.
* Tapez la commande suivante qui va servir à compiler le projet :

    `./install.sh`
* Si vous n'avez pas les droits pour lancer le script tapez :

    `chmod +x install.sh`
    `./install.sh`

## Lancer l'application
* Toujours dans un terminal, dans le dossier /src du projet.
* Pour exécuter l'application, tapez la commande suivante :

    `./execute.sh`
* Si vous n'avez pas les droits pour lancer le script tapez :

    `chmod +x execute.sh`
    `./execute.sh`

## Pour développer
* Pour les développements de plugins supplémentaires, veuillez vous référer au manuel développeur.
