USE mymovies;

INSERT INTO USER(user_name)
	VALUES
	('Tanya'),
	('Vlad'),
	('Slaveg');
	
INSERT INTO MOVIE(name, description, author, poster_URL)
	VALUES
	('Tenet', 'new movie about time', 'LOLan', 'some url');
	
INSERT INTO MOVIE_USER(user_id, movie_id)
	VALUES 
	(1,1),
	(2,1),
	(3,1);