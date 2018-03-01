DROP TABLE IF EXISTS amis;
DROP TABLE IF EXISTS liked;
DROP TABLE IF EXISTS actualite;
DROP TABLE IF EXISTS comptes;
 
CREATE TABLE comptes(
 	login text NOT NULL,
 	password text NOT NULL,
 	nom text NOT NULL,
 	prenom text NOT NULL,
 	role text DEFAULT 'client',
 	naissance date,
 	email text NOT NULL UNIQUE,
 	photo text,
 	visibilite_mur int DEFAULT 0 CHECK( visibilite_mur BETWEEN 0 AND 2 ),
 	CONSTRAINT PK_comptes PRIMARY KEY (login) 
);

INSERT INTO comptes(login,password,nom,prenom,email) VALUES('alexis.lambois','root','Lambois','Alexis','test@gmail.com');

CREATE TABLE amis(
 	cno1 text,
 	cno2 text,
 	depuis timestamp,
 	CONSTRAINT PK_amis PRIMARY KEY (cno1,cno2),
 	CONSTRAINT FK_comptes1 FOREIGN KEY (cno1) REFERENCES comptes(login),
 	CONSTRAINT FK_comptes2 FOREIGN KEY (cno2) REFERENCES comptes(login)
);
 
CREATE TABLE actualite(
 	ano serial,
 	contenu text NOT NULL,
 	date_ecriture timestamp NOT NULL,
 	ecrit_par text,
 	CONSTRAINT PK_actualite PRIMARY KEY (ano),
 	CONSTRAINT FK_comptes FOREIGN KEY (ecrit_par) REFERENCES comptes(login)
);
 
CREATE TABLE liked(
 	liker_par text,
 	actualite int,
 	statut int CHECK( statut BETWEEN 0 AND 1 ) NOT NULL,
 	CONSTRAINT PK_liked PRIMARY KEY (liker_par,actualite),
 	CONSTRAINT FK_comptes FOREIGN KEY (liker_par) REFERENCES comptes(login),
 	CONSTRAINT FK_actualite FOREIGN KEY (actualite) REFERENCES actualite(ano)
);

--INSERT INTO comptes(login,password,naissance,nom,prenom,email,photo) VALUES('toto','123',TO_DATE('01/01/0001', 'DD/MM/YYYY'),'Phillipe','Mathieu','test','https://i.imgur.com/1eJ1q0V.jpg');
INSERT INTO comptes(login,password,nom,prenom,email,photo) VALUES('toto','123','Phillipe','Mathieu','test','https://i.imgur.com/1eJ1q0V.jpg');
INSERT INTO comptes(login,password,nom,prenom,email) VALUES('titi','123','Phillipe','Mathieu','test1');
INSERT INTO comptes(login,password,nom,prenom,email,role) VALUES('tata','123','Hauspie','Michael','test2','invite');
INSERT INTO comptes(login,password,nom,prenom,email) VALUES('tete','123','test','test','test3');
INSERT INTO amis VALUES('toto','titi',CURRENT_TIMESTAMP);
INSERT INTO amis VALUES('tete','tata',CURRENT_TIMESTAMP);
INSERT INTO amis VALUES('titi','tata',CURRENT_TIMESTAMP);
INSERT INTO amis VALUES('titi','alexis.lambois','20171015 15:00:00'::timestamp);
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('Jadore les pizzas !',CURRENT_TIMESTAMP,'toto');
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('Jaime les pommes',CURRENT_TIMESTAMP,'titi');
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('Je suis au toilette',CURRENT_TIMESTAMP,'titi');
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('Je mennuie','20171015 15:00:00'::timestamp,'tata');
INSERT INTO liked VALUES('tata',1,0);
INSERT INTO liked VALUES('toto',1,0);
INSERT INTO liked VALUES('tata',2,0);
INSERT INTO liked VALUES('toto',3,0);

SELECT concat('<a href=\"',liker_par,'\">',liker_par,'</a>') FROM liked WHERE actualite=1;
