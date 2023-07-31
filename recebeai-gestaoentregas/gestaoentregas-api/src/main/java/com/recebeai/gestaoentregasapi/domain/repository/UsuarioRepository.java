package com.recebeai.gestaoentregasapi.domain.repository;

import com.recebeai.gestaoentregasapi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
