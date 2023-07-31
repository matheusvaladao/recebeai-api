package com.recebeai.gestaocomprasapi.domain.repository;

import com.recebeai.gestaocomprasapi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
