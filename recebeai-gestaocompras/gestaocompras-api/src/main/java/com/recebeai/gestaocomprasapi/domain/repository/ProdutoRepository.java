package com.recebeai.gestaocomprasapi.domain.repository;

import com.recebeai.gestaocomprasapi.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
