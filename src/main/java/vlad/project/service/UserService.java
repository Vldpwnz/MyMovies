package vlad.project.service;

import java.util.List;

import vlad.project.Entities.User;

public interface UserService {
	
	List<User> findAll();
	User getUserById(Long id);

}
