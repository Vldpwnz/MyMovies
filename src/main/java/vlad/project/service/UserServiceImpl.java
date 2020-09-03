package vlad.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlad.project.Entities.User;
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
	
	

}
