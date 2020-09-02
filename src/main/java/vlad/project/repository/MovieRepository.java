package vlad.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vlad.project.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findAll();

}
