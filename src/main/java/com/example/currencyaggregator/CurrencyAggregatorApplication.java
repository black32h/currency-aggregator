package com.example.currencyaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyAggregatorApplication {

    // Головний метод для запуску Spring Boot додатку
    public static void main(String[] args) {
        // Запуск додатку за допомогою SpringApplication.run
        SpringApplication.run(CurrencyAggregatorApplication.class, args);
    }
}
//http://localhost:8081/api/exchange-rates
