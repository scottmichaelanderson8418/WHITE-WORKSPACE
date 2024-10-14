
package com.workshop.app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.workshop.app.service.MyUserDetailService;

// Spring will know this is a security configuration class
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private MyUserDetailService userDetailService;

	@Bean
	AuthenticationProvider authenticationProvider() {
		// DaoAuthenticationProvider is a class from spring security
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Provides a default configuration for me.
	// "Everything behind the /login screen"
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// by customizing the "authorizeHttpRequest" we got rid of the default login we
		// had

		// Note: "CSRF" Cross Site Request Forgery
		// If "CSRF" is enabled all postrequest will be block
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)

				.authorizeHttpRequests(registry -> {
					registry.requestMatchers("/home", "/register/**", "/student/**", "/getAllUsers",
							"/login").permitAll();
					registry.requestMatchers("/admin/**").hasRole("ADMIN");
					registry.requestMatchers("/user/**").hasRole("USER");

					registry.anyRequest().authenticated();

					//
				}).formLogin(httpSecurityFormLoginConfigurer -> {
					httpSecurityFormLoginConfigurer.loginPage("/login")
							.successHandler(new AuthenticationAccessHandler()).permitAll();
				}).build(); // build the HTTP Security

	}

}
