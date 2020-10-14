USE mymovies;

INSERT INTO USER(user_name, password, enabled)
	VALUES
	('Tanya', 'defaultPassword', 1),
	('Vlad', 'defaultPassword', 1),
	('Slaveg', 'defaultPassword', 1);
	
INSERT INTO AUTHORITIES(user_name, authority)
	VALUES
	('Tanya', 'write'),
	('Vlad', 'write'),
	('Slaveg', 'write');	
INSERT INTO MOVIE(name, description, author, release_year, poster_URL)
	VALUES
	('Tenet', 'new movie about time', 'LOLan', '2020-08-26', 'some url'),
	('Mulan', 'new Disney adaptation of cartoon', 'Someone', '2020-01-26', 'some url'),
	('Smurfs', 'movie about blue funny guys', 'Nice person', '2010-09-21', 'some url');
	
INSERT INTO MOVIE_USER(user_id, movie_id)
	VALUES 
	(1,1),
	(2,1),
	(3,1),
	(1,2),
	(2,3);