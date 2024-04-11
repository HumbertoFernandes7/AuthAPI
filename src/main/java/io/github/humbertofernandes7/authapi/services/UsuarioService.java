package io.github.humbertofernandes7.authapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.humbertofernandes7.authapi.entites.UsuarioEntity;
import io.github.humbertofernandes7.authapi.exceptions.BadRequestBussinessException;
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
			throw new BadRequestBussinessException("Email já cadastrado no sistema!");
		}
		
		String senhaCriptografada = passwordEncoder.encode(usuarioEntity.getSenha());
		usuarioEntity.setSenha(senhaCriptografada);
		
		return usuarioRepository.save(usuarioEntity);
	}

	public void verificaEmailCadastrado(String email) {
		UsuarioEntity emailEncontrado = usuarioRepository.findByEmail(email);
		if(emailEncontrado != null) {
			return;
		}
		throw new BadRequestBussinessException("Email não cadastrado no sistema");
	}
}
