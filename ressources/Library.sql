-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Library;
CREATE DATABASE Library;
USE Library;

-- -----------------------------------------------------------------------------
-- - Construction de la tables des thematiques des livres                    ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Thematic (
	ThemeId				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Name				varchar(30)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Thematic ( ThemeId, Name ) VALUES ( 1, 'Fantastic');
INSERT INTO T_Thematic ( ThemeId, Name ) VALUES ( 2, 'Jeunesse');
INSERT INTO T_Thematic ( ThemeId, Name ) VALUES ( 3, 'Horreur');
INSERT INTO T_Thematic ( ThemeId, Name ) VALUES ( 4, 'Roman');

SELECT * FROM T_Thematic;

-- -----------------------------------------------------------------------------
-- - Construction de la table des livres                                     ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Books (
	BookId				int(4)		PRIMARY KEY AUTO_INCREMENT,
	Title			varchar(24)		NOT NULL,
	Author			varchar(20)		NOT NULL,
	ThemeId			int(4)			NOT NULL,
	FOREIGN KEY(ThemeId) REFERENCES T_Thematic(ThemeId),
	UnitaryPrice	float(8) 		NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 1, 'Star wars empiré' ,	'Georgette Locass' , 1 , 27.7);
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 2, 'Tchoupi picole' , 'Nanard et Raymond' , 2 , 12.25);
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 3, 'Pecresse sous les ponts' ,'Emmanuel Macro' , 4 , 20.22);
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 4, 'Accident Pat patrouille' ,	'La SPA' , 2, 9.5);
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 5, 'Le vampire de Paris' ,	'Eric Zémort' , 3 , 28.9);
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 6, 'Le seigneur des crados' , 'MDR Tolkien' , 1 ,  25.99);
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 7, 'Hanouna tait toi' ,'Arthutur' , 4 , 15.5);
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 8, 'Charlie & les Islamistes' ,	'Albert Camé' , 3 , 20.15 );
INSERT INTO T_Books (BookId, Title, Author, ThemeId, UnitaryPrice) VALUES ( 9, 'Peine pour Marine' ,'Emmanuel Macro' , 4 , 24.04 );

SELECT * FROM T_Books;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Custo (
	IdCusto				int(4)		PRIMARY KEY AUTO_INCREMENT,
	FirstName			varchar(20)	NOT NULL,
	LastName			varchar(20)	NOT NULL,
	Email				varchar(20)	NOT NULL,
	Phone				varchar(20)	NOT NULL,
	Adress				varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Custo (IdCusto, FirstName, LastName, Email, Phone, Adress) VALUES ( 1, 'Laclau' ,	'Tristan',' tlaclau@gmail.com' , '0779504486' , '12 rue machin' );
INSERT INTO T_Custo (IdCusto, FirstName, LastName, Email, Phone, Adress) VALUES ( 2, 'Fix', 'Mathieu', 'fixmath@gmail.com', '0625493518', '5 allée des trucs' );
INSERT INTO T_Custo (IdCusto, FirstName, LastName, Email, Phone, Adress) VALUES ( 3, 'Mauler' , 'Eric', 'merci@hotmail.com', '068945671582', '16 rue de la chose' );
INSERT INTO T_Custo (IdCusto, FirstName, LastName, Email, Phone, Adress) VALUES ( 4, 'Allaire' , 'Sebastien' , 'aseb40@gmail.com', '0789285641', '68 rue là-bas' );
INSERT INTO T_Custo (IdCusto, FirstName, LastName, Email, Phone, Adress) VALUES ( 5, 'Derand' , 'Martial', 'mderand@outlook.fr', '0798468599','14 alléé des autres');
INSERT INTO T_Custo (IdCusto, FirstName, LastName, Email, Phone, Adress) VALUES ( 6, 'El Babili' , 'Mohamed','melbabili@gmail.com','0772855569', '69 rue machin chose' );

SELECT * FROM T_Custo;

