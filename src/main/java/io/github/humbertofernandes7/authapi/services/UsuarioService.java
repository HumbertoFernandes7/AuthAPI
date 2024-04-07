package io.github.humbertofernandes7.authapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.humbertofernandes7.authapi.entites.UsuarioEntity;
import io.github.humbertofernandes7.authapi.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public UsuarioEntity cadastrarUsuario(UsuarioEntity usuarioEntity) {
		UsuarioEntity emailExistente = usuarioRepository.findByEmail(usuarioEntity.getEmail());
		
		if(emailExistente != null) {
			throw new RuntimeException("Email Ja Cadastrado");
		}
		
		String senhaCriptografada = passwordEncoder.encode(usuarioEntity.getSenha());
		
		usuarioEntity.setSenha(senhaCriptografada);
		
		return usuarioRepository.save(usuarioEntity);
	}
}
