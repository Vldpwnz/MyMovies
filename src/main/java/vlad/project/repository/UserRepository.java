package vlad.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import vlad.project.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	Optional<User> findById(Long id);

}
