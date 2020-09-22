package vlad.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vlad.project.entities.Review;


public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	 List<Review> findAll();

}
