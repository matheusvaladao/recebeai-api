package com.recebeai.gestaocomprasapi.domain.repository;

import com.recebeai.gestaocomprasapi.domain.model.Receptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptorRepository extends JpaRepository<Receptor, Long> {
}
