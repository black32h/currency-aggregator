package com.example.currencyaggregator.controller;

import com.example.currencyaggregator.service.CurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyRateController {

    @Autowired
    private CurrencyRateService currencyRateService;

    // Отображення HTML-сторінки з курсами валют
    // Цей метод обробляє запит на відображення курсу валют на веб-сторінці
    @GetMapping("/rates")
    public String getAllRates(Model model) {
        // Додаємо список курсів валют у модель, щоб передати їх на шаблон HTML
        model.addAttribute("rates", currencyRateService.getAllRates());
        // Повертаємо ім'я шаблону, який буде рендерити сторінку (currencyRates.html)
        return "currencyRates"; // Назва HTML-шаблона
    }
}
//@Controller — ця анотація позначає клас як контролер для обробки HTTP запитів на веб-сторінці.
//@Autowired — автоматично підключає залежності, тут ми підключаємо сервіс для отримання курсів валют.
//@GetMapping("/rates") — цей метод обробляє запит GET за URL /rates.
//        Model — це об'єкт, що використовується для передачі атрибутів до HTML шаблону.
//        model.addAttribute("rates", currencyRateService.getAllRates()) — додаємо курси валют до моделі для подальшого відображення у вигляді списку на веб-сторінці.
//"currencyRates" — ім'я шаблону HTML, який буде використано для рендеринга сторінки
