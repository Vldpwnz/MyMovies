package vlad.project.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider
	implements AuthenticationProvider{
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String rawPassword = authentication.getCredentials().toString();
		
		CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		return checkPassword(userDetails, rawPassword);
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication
				.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private Authentication checkPassword(CustomUserDetails user, String rawPassword) {
		
		if(passwordEncoder.matches(rawPassword, user.getPassword())) {
			return new UsernamePasswordAuthenticationToken(
					user.getUsername(),
					user.getPassword(),
					user.getAuthorities()
					);
			} else {
				throw new BadCredentialsException("Something went wrong");
		}
		
		
	}
	
	

}
