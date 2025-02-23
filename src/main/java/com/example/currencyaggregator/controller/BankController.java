package com.example.currencyaggregator.controller;

import com.example.currencyaggregator.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Позначає клас як контролер, що працює з HTTP-запитами
public class BankController {

    @Autowired
    private BankService bankService;  // Впроваджуємо сервіс для роботи з курсами валют

    // Ендпоінт для оновлення курсів валют
    @GetMapping("/api/updateRates")  // Отримуємо HTTP GET запит на "/api/updateRates"
    public String updateRates() {
        bankService.saveBankRates();  // Викликаємо метод для оновлення курсів валют через сервіс
        return "Курси валют були успішно оновлені!";  // Повідомлення про успішне оновлення
    }
}

//@RestController — це спеціалізація анотації @Controller, яка поєднує в собі функціональність контролера та автоматично конвертує повернуті значення в формат JSON. У цьому випадку ми не використовуємо шаблони для відображення HTML, а відправляємо дані в форматі тексту або JSON.
//@Autowired — дозволяє Spring автоматично впроваджувати залежність. У цьому випадку — сервіс BankService.
//@GetMapping("/api/updateRates") — анотація, що вказує на обробку GET запитів за шляхом /api/updateRates. Цей ендпоінт буде використовуватися для ініціювання оновлення курсів валют.
//       
