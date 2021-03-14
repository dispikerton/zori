package com.zolotenkov.spring.springboot.zori_zavod;

import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZoriZavodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoriZavodApplication.class, args);
    }

}
