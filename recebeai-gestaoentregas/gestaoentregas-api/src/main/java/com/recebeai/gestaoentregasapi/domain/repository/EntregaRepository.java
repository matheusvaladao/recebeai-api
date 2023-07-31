package com.recebeai.gestaoentregasapi.domain.repository;

import com.recebeai.gestaoentregasapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
