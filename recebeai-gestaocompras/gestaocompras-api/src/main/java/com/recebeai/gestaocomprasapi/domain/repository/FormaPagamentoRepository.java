package com.recebeai.gestaocomprasapi.domain.repository;


import com.recebeai.gestaocomprasapi.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}