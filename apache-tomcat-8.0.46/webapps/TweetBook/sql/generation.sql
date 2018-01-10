DROP TABLE IF EXISTS amis;
DROP TABLE IF EXISTS liked;
DROP TABLE IF EXISTS actualite;
DROP TABLE IF EXISTS compte;

CREATE TABLE compte(
	cno serial,
	login text NOT NULL,
	mdp text NOT NULL,
	nom text NOT NULL,
	prenom text NOT NULL,
	naissance date,
	email text,
	photo text,
	visibilite_mur int DEFAULT 0 CHECK( visibilite_mur BETWEEN 0 AND 2 ),
	CONSTRAINT PK_compte PRIMARY KEY (cno) 
);

CREATE TABLE amis(
	cno1 int,
	cno2 int,
	depuis timestamp,
	CONSTRAINT PK_amis PRIMARY KEY (cno1,cno2),
	CONSTRAINT FK_compte1 FOREIGN KEY (cno1) REFERENCES compte(cno),
	CONSTRAINT FK_compte2 FOREIGN KEY (cno2) REFERENCES compte(cno)
);

CREATE TABLE actualite(
	ano serial,
	contenu text NOT NULL,
	date_ecriture timestamp NOT NULL,
	ecrit_par int,
	CONSTRAINT PK_actualite PRIMARY KEY (ano),
	CONSTRAINT FK_compte FOREIGN KEY (ecrit_par) REFERENCES compte(cno)
);

CREATE TABLE liked(
	liker_par int,
	actualite int,
	CONSTRAINT PK_liked PRIMARY KEY (liker_par,actualite),
	CONSTRAINT FK_compte FOREIGN KEY (liker_par) REFERENCES compte(cno),
	CONSTRAINT FK_actualite FOREIGN KEY (actualite) REFERENCES actualite(ano)
);

INSERT INTO compte(login,mdp,nom,prenom) VALUES('toto','123','Jean','Caron');
INSERT INTO compte(login,mdp,nom,prenom) VALUES('titi','123','Phillipe','Mathieu');
INSERT INTO compte(login,mdp,nom,prenom) VALUES('tata','123','Hauspie','Michael');
INSERT INTO amis VALUES(1,2,'2018-10-15 12:00:00'::timestamp);
INSERT INTO amis VALUES(2,3,'2018-10-15 15:00:00'::timestamp);
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('toto est amis avec titi','2018-10-15 12:00:00'::timestamp,1);
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('titi est amis avec tata','2018-10-15 15:00:00'::timestamp,2);
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('titi est amis avec toto','2018-10-15 12:00:00'::timestamp,2);
INSERT INTO actualite(contenu,date_ecriture,ecrit_par) VALUES('tata est amis avec titi','2018-10-15 15:00:00'::timestamp,3);
INSERT INTO liked VALUES(3,1);
