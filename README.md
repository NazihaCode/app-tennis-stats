Tennis-stats
C'est une Spring Boot REST API Application permettant de retourner les statistiques des joueurs de tennis.
Les données ont été récupérés depuis le fichier headtohead.json

1- Récupérer les sources
git@github.com:NazihaCode/app-tennis-stats.git

2- Builder et Lancer l'application

le serveur se lance à l'url http://localhost:8080/tennis-stats/api.

GET	/players	
retourne les joueurs triée du meilleur au moins bon.

GET	/player/{id}
retourne les informations d’un joueur grâce à son ID.

GET	/countryByTheBestRatio
retourne le pays qui a le plus grand ratio de parties gagnées.

GET	/imcAverage
retourne l'IMC moyen de tous les joueurs.

GET	/median 
retourne La médiane de la taille des joueurs.

4- Déploiement
L'application a été déployé sur Heroku et elle est accèssible via https://app-tennis-stats.herokuapp.com/tennis-stats/api/
