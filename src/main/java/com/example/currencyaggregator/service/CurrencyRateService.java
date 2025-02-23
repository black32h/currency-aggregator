package com.example.currencyaggregator.service;

import com.example.currencyaggregator.model.CurrencyRate;
import com.example.currencyaggregator.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyRateService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    // Метод для отримання всіх курсів валют з бази даних
    public List<CurrencyRate> getAllRates() {
        // Повертаємо всі курси валют, які зберігаються в базі даних
        return currencyRateRepository.findAll();  // Отримуємо всі курси з бази даних
    }
}
//@Service: Цей клас позначений анотацією @Service, що вказує Spring, що це сервісний клас, який відповідає за бізнес-логіку.
//
//        currencyRateRepository: Автоматично інжектується репозиторій для роботи з таблицею CurrencyRate в базі даних.
//
//        Метод getAllRates():
//
//Використовує метод findAll() репозиторію CurrencyRateRepository, щоб отримати всі записи (курси валют) з бази даних.
//Повертає список курсів валют у вигляді List<CurrencyRate>
