package com.recebeai.gestaoentregasapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@EnableRabbit
@SpringBootApplication
public class GestaoEntregasApiApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(GestaoEntregasApiApplication.class, args);
    }

}
