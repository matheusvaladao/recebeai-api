package com.recebeai.gestaoentregasapi.domain.repository;

import com.recebeai.gestaoentregasapi.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
