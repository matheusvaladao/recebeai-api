package com.recebeai.gestaocomprasapi.domain.repository;

import com.recebeai.gestaocomprasapi.domain.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
