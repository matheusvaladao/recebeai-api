package com.recebeai.recebeaienvianotificacao;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@EnableRabbit
@SpringBootApplication
public class RecebeaiEnvianotificacaoApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(RecebeaiEnvianotificacaoApplication.class, args);
    }

}
