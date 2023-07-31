package com.recebeai.gestaocomprasapi.domain.repository;

import com.recebeai.gestaocomprasapi.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
