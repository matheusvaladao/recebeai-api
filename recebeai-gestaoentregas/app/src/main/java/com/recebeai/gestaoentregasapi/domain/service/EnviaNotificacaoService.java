package com.recebeai.gestaoentregasapi.domain.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnviaNotificacaoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String message) {
        System.out.println("Mensagem enviada");
        rabbitTemplate.convertAndSend(this.queue.getName(), message);
    }
}