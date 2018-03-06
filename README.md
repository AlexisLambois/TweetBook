#Déploiement
##Le lien suivant mets à votre disposition un serveur tomcat entièrement fonctionnel.
##----

Vous saisir du répertoire/context TweetBook

Vous munir absolument des librairies suivantes ( voir le répertoire lib du serveur fournis ) :
	jstl-1.2.jar
	postgresql-9.3-1102.jdbc41.jar
	servlet-api.jar
	jsp-api.jar

Configurer le fichier /TweetBook/META-INF/context.xml
	Il faut renseigner :
		-le "username" ( ici lamboisa )
		-le "password" ( ici moi )
		-le "driverClassName" ( ici org.postgresql.Driver )
		-l'url ( ici jdbc:postgresql://psqlserv/da2i )
	
	Une modification du paramètre :
		- 
