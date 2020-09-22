package vlad.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlad.project.entities.User;
import vlad.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
		
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> result = repository.findById(id);
		User user = null;
		
		if(result.isPresent()) {
			user = result.get();
		}else {
			throw new RuntimeException("User doesn't exist with such id: " + id);
		}
		
		return user;
	}

	@Override
	public User findByUserName(String username) {
		Optional<User> result = repository.findByUserName(username);
		User user = null;
		
		if(result.isPresent()) {
			user = result.get();
		}else {
			throw new RuntimeException("User doesn't exist with such username: " + username);
		}
		return user;
	}

	
	
	

}
