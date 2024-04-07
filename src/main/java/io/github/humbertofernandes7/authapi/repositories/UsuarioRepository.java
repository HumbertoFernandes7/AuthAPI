package io.github.humbertofernandes7.authapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.humbertofernandes7.authapi.entites.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UsuarioEntity findByEmail(String email);

}
