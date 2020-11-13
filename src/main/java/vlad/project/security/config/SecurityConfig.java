package vlad.project.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider authProvider;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authProvider);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		.defaultSuccessUrl("/home-page", true);
		
		http.authorizeRequests()
			.mvcMatchers("/user/all").hasRole("ADMIN")
			.anyRequest().authenticated();
	}
	
	

}