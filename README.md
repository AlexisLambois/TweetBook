# Déploiement
## Le lien suivant mets à votre disposition un serveur tomcat entièrement fonctionnel.
## --https://github.com/AlexisLambois/TweetBook.git--

### 1)Vous saisir du répertoire/context TweetBook

### 2)Vous munir absolument des librairies suivantes ( voir le répertoire lib du serveur fournis ) :
	jstl-1.2.jar
	postgresql-9.3-1102.jdbc41.jar
	servlet-api.jar
	jsp-api.jar

### 3)Configurer le fichier /TweetBook/META-INF/context.xml
	Il faut renseigner :
		-le "username" ( ici lamboisa )
		-le "password" ( ici moi )
		-le "driverClassName" ( ici org.postgresql.Driver )
		-l'url ( ici jdbc:postgresql://psqlserv/da2i )
	
	Une modification du paramètre :
		-le "dataSourceName" ( ici da2i ) 

### 4)Configurer le fichier /TweetBook/WEB-INF/web.xml en modifiant les params-value à selon votre envie
	<context-param>
		<param-name>driver</param-name>
	-->	<param-value>org.postgresql.Driver</param-value>
	</context-param>
	<context-param>
		<param-name>login</param-name>
	-->	<param-value>lamboisa</param-value>
	</context-param>
	<context-param>
		<param-name>mdp</param-name>
	-->	<param-value>moi</param-value>
	</context-param>
	<context-param>
		<param-name>bdd</param-name>
	-->	<param-value>jdbc:postgresql://psqlserv/da2i</param-value>
	</context-param>

### 5)Si vous utlisez POSTGRESQL !!! Lancez le script /TweetBook/sql/create.sql