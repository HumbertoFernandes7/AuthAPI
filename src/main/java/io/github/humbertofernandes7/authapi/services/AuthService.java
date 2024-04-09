package io.github.humbertofernandes7.authapi.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import io.github.humbertofernandes7.authapi.dtos.inputs.AuthInput;
import io.github.humbertofernandes7.authapi.entites.UsuarioEntity;
import io.github.humbertofernandes7.authapi.repositories.UsuarioRepository;

@Service
public class AuthService implements UserDetailsService {

	private static final String SECRET_KEY = "my-secret-2hj3bbs6rl7cy3n5e67e3";
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return usuarioRepository.findByEmail(email);

	}

	public String obtenToken(AuthInput authInput) {
		UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(authInput.getEmail());
		return geraTokenJwt(usuarioEntity);
	}

	public String geraTokenJwt(UsuarioEntity usuarioEntity) {
		try {

			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

			String token = JWT.create().
					withIssuer("auth-api")
					.withClaim("id", usuarioEntity.getId())
					.withSubject(usuarioEntity.getEmail())
					.withClaim("cargo", usuarioEntity.getRole().toString())
					.withExpiresAt(geraDataExpiracaoToken()).sign(algorithm);

			return token;

		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao tentar gerar o token! " + exception.getMessage());
		}

	}


	public String validaTokenJwt(String token) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

			return JWT.require(algorithm)
					.withIssuer("auth-api")
					.build().verify(token)
					.getSubject();

		} catch (JWTVerificationException jwtVerificationException) {
			return jwtVerificationException.getMessage();
		}
	}
	

	private Instant geraDataExpiracaoToken() {
		return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
	}
}
