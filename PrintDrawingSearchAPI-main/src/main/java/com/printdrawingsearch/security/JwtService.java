
package com.printdrawingsearch.security;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Service for managing JWT (JSON Web Token) operations such as generating, validating, and extracting information from
 * tokens.
 */
@Service
public class JwtService {
	Logger logger = LoggerFactory.getLogger(JwtService.class.getName());
	/** The Constant SECRET. */
	// Note: we generate the secret key in the src/text/java classes
	private static final String SECRET = "9179C05047F83F0CF8629483D243C714C863407B970FE3937EEF114FE0CD7F8B7F0D1C510429299ED910CD0381161" +
			"3B285B16E3EE144A846CE40BFBA2929FD1A";

	// this is equal to 30 minutes the JWT will expire after 30 mins
	/** The Constant VALIDITY. */
	// generally it is insecure to have the jwt stay alive much longer than a few
	// hours
	private static final long VALIDITY = TimeUnit.MINUTES.toMillis(30);

	/**
	 * Extracts the username from the given JWT.
	 *
	 * @param jwt the JSON Web Token
	 * @return the username contained in the JWT
	 */
	public String extractUsername(String jwt) {
		Claims claims = Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(jwt).getPayload();
		return claims.getSubject();
	}

	/**
	 * Generates a SecretKey from the predefined secret string.
	 *
	 * @return the SecretKey used for signing and verifying JWTs
	 */
	// the "SECRET" key is encrypted and needs to be decoded
	private SecretKey generateKey() {
		// this will decode the secret key
		byte[] decodedKey = Base64.getDecoder().decode(SECRET);
		// creates a new instance of the SecretKeySpec Class which implements the
		// "SecretKey" interface
		return Keys.hmacShaKeyFor(decodedKey);
	}

	/**
	 * Generates a JWT for the given UserDetails.
	 *
	 * @param userDetails the user details for whom the token is being generated
	 * @return the generated JWT
	 */
	// GenerateToken method passes in the UserDetails
	public String generateToken(UserDetails userDetails) {
		Map<String, String> claims = new HashMap<>();
		claims.put("iss", "https://secure.genuinecoder.com");

		// claims.put("name", "https://secure.genuinecoder.com");
		return Jwts.builder().claims(claims).subject(userDetails.getUsername()).issuedAt(Date.from(Instant.now()))
				.expiration(Date.from(Instant.now().plusMillis(VALIDITY))).signWith(generateKey()).compact();
	}

	/**
	 * Extracts the claims from the given JWT.
	 *
	 * @param jwt the JSON Web Token
	 * @return the claims contained in the JWT
	 */
	private Claims getClaims(String jwt) {
		Claims claims = null;

		return claims = Jwts
				// Creates a new parser for JWTs.
				.parser()
				// Secret key is found by "generateKey()" and used for verifying the jwt's
				// signature
				.verifyWith(generateKey())
				// Builds the JWT parser.
				.build()
				// Parses the JWT string and validates its signature. Throws an exception if the
				// signature is invalid.
				.parseSignedClaims(jwt)
				// Extracts the payload (body) of the JWT, which typically contains the claims
				// (data) about the user.
				.getPayload();
	}

	/**
	 * Validates the given JWT by checking its expiration date.
	 *
	 * @param jwt the JSON Web Token to validate
	 * @return true if the token is valid, false otherwise
	 */
	public boolean isTokenValid(String jwt) {
		Claims claims = getClaims(jwt);
		boolean valid = false;

		if (Date.from(Instant.now()).before(claims.getExpiration())) {
			valid = true;
		}

		return valid;
	}
}
