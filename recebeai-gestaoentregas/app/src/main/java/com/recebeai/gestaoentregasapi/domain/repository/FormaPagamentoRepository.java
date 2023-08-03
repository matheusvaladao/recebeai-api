package com.recebeai.gestaoentregasapi.domain.repository;


import com.recebeai.gestaoentregasapi.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}