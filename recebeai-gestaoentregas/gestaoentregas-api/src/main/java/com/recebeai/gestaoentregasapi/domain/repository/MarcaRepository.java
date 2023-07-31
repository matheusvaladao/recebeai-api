package com.recebeai.gestaoentregasapi.domain.repository;

import com.recebeai.gestaoentregasapi.domain.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
