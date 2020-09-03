USE mymovies;

INSERT INTO USER(user_name)
	VALUES
	('Tanya'),
	('Vlad'),
	('Slaveg');
	
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