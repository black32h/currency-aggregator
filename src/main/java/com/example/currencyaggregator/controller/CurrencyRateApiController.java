package com.example.currencyaggregator.controller;

import com.example.currencyaggregator.model.CurrencyRate;
import com.example.currencyaggregator.service.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  // Позначає клас як контролер для обробки HTTP-запитів, який повертає дані у форматі JSON
@RequestMapping("/api")  // Вказує загальний шлях для всіх методів у цьому контролері
public class CurrencyRateApiController {

    @Autowired
    private CurrencyRateService currencyRateService;  // Впроваджуємо сервіс для отримання курсів валют

    // Метод для отримання всіх курсів валют в форматі JSON
    @GetMapping("/exchange-rates")  // Обробляє GET запит на шлях "/api/exchange-rates"
    public List<CurrencyRate> getAllRates() {
        return currencyRateService.getAllRates();  // Викликаємо метод сервісу для отримання всіх курсів валют
    }
}


//@RestController — анотація, яка вказує, що клас є контролером для обробки HTTP-запитів та повертає дані у форматі JSON (замінюючи традиційний HTML).
//@RequestMapping("/api") — визначає базовий шлях для всіх методів в цьому контролері. Всі шляхи будуть починатися з /api.
//@GetMapping("/exchange-rates") — обробляє GET запит за шляхом /api/exchange-rates і повертає список курсів валют у форматі JSON.
// 
