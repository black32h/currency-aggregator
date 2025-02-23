package com.example.currencyaggregator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  // Позначає клас як конфігураційний, що містить бін для налаштувань додатку
public class AppConfig {

    // Створюємо бін для RestTemplate, який дозволяє здійснювати HTTP-запити
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();  // Повертає новий екземпляр RestTemplate
    }
}
//@Configuration — ця анотація позначає клас як конфігураційний, який містить визначення бінів для контексту додатку.
//@Bean — анотація використовується для позначення методу, який створює бін для Spring контексту. У цьому випадку метод restTemplate() створює бін типу RestTemplate.
//RestTemplate — це клас, що дозволяє вам робити HTTP-запити, зокрема для отримання даних з інших API, як у вашому випадку для API НБУ
