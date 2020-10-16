package vlad.project.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vlad.project.entities.User;
import vlad.project.service.UserServiceImpl;

@Service
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private UserServiceImpl userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No such user");
		}
		
		return new SecurityUser(user);
	}

}
