package vlad.project.service;

import java.util.List;

import vlad.project.entities.User;

public interface UserService {
	
	List<User> findAll();
	User getUserById(Long id);
	User findByUserName(String username);

}
