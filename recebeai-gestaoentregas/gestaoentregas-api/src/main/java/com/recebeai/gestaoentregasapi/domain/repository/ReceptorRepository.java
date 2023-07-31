package com.recebeai.gestaoentregasapi.domain.repository;

import com.recebeai.gestaoentregasapi.domain.model.Receptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptorRepository extends JpaRepository<Receptor, Long> {
}
