package com.printdrawingsearch.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.printdrawingsearch.service.MyUserDetailService;

/**
 * Configuration class for security settings.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class.getName());
	@Autowired

	private MyUserDetailService userDetailService;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	/**
	 * Configures the security filter chain.
	 *
	 * @param httpSecurity the HTTP security object
	 * @return the configured security filter chain
	 * @throws Exception if an error occurs during configuration
	 */

	// the security filter chain tells the computer which urls to pass through and
	// which to authenticate
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// we disable csrf to enable post request
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)

				// lambda expression uses the httpSecurity.authorizeHttpRequests method with
				// "registry" as an argument to defined the authorization rules yeah

				.authorizeHttpRequests(registry -> {

					registry.requestMatchers("/home", "/register/**", "/api/authenticate").permitAll();

					registry.requestMatchers("/admin/**").hasRole("ADMIN");

					registry.requestMatchers("/user/**").hasRole("USER");

					registry.anyRequest().authenticated();
				})
				// Allow all users to access the login page
				.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				// Add JWT authentication filter before UsernamePasswordAuthenticationFilter
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				// Build the security filter chain
				.build();
	}

	/**
	 * Provides the user details service.
	 *
	 * @return the user details service
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return userDetailService;
	}

	/**
	 * Provides the authentication provider.
	 *
	 * @return the authentication provider
	 */
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// set the userDetailsService for authentication
		provider.setUserDetailsService(userDetailService);
		// Set password encoder (which is BCryptPasswordEncoder)
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	/**
	 * Creates an AuthenticationManager bean.
	 *
	 * @return the authentication manager
	 */
	@Bean
	public AuthenticationManager authenticationManager() {
		// Create AuthenticationManager using the configured authentication provider
		return new ProviderManager(authenticationProvider());
	}

	/**
	 * Provides the password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Use BCryptPasswordEncoder for password encoding
		return new BCryptPasswordEncoder();
	}
}