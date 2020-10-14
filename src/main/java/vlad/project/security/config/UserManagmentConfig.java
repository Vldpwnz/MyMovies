package vlad.project.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserManagmentConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		String password = passwordEncoder.encode("password");
		
		UserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		
		UserDetails user = User.withUsername("vlad")
				.password(password)
				.authorities("read")
				.build();

		userDetailsService.createUser(user);
		return userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
