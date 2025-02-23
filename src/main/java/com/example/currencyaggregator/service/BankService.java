package com.example.currencyaggregator.service;

import com.example.currencyaggregator.model.Bank;
import com.example.currencyaggregator.model.CurrencyRate;
import com.example.currencyaggregator.repository.BankRepository;
import com.example.currencyaggregator.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class BankService {

    // Створення RestTemplate для здійснення HTTP-запитів
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @Autowired
    private BankRepository bankRepository;

    // Метод для отримання курсів валют і збереження їх у базу даних
    public void saveBankRates() {
        // URL для API НБУ, яке повертає курси валют
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

        try {
            // Виконання GET-запиту до API НБУ для отримання курсу валют
            List<Map<String, Object>> rates = restTemplate.getForObject(url, List.class);
            if (rates != null) {
                // Шукаємо банк у базі за кодом "NBU"
                Bank bank = bankRepository.findByCode("NBU");
                if (bank == null) {
                    // Якщо банк не знайдений, створюємо новий запис для НБУ
                    bank = new Bank();
                    bank.setCode("NBU");
                    bank.setName("Національний банк України");
                    bankRepository.save(bank);
                }

                // Проходимо по кожному отриманому курсу і зберігаємо їх в базу даних
                for (Map<String, Object> rateData : rates) {
                    CurrencyRate currencyRate = new CurrencyRate();
                    currencyRate.setCurrencyCode((String) rateData.get("cc")); // Код валюти
                    currencyRate.setCurrencyName((String) rateData.get("txt")); // Назва валюти
                    currencyRate.setRate(new BigDecimal(rateData.get("rate").toString())); // Курс валюти

                    // Форматуємо дату отримання курсу валюти
                    String exchangeDateString = (String) rateData.get("exchangedate");
                    LocalDate exchangeDate = LocalDate.parse(exchangeDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                    currencyRate.setExchangeDate(exchangeDate); // Дата курсу
                    currencyRate.setBank(bank); // Прив'язка до банку (НБУ)
                    currencyRateRepository.save(currencyRate); // Збереження в базу даних
                }
            }
        } catch (Exception e) {
            // Логування помилки, якщо виникла проблема з отриманням даних
            System.out.println("Помилка при отриманні курсів з URL: " + url);
            e.printStackTrace();
        }
    }
}
//RestTemplate: Використовується для здійснення HTTP-запитів до зовнішнього API НБУ, щоб отримати курси валют у форматі JSON.
//
//saveBankRates(): Основний метод, який виконує наступні дії:
//
//Отримує список курсів валют з API НБУ.
//        Перевіряє, чи є в базі даних запис для "Національний банк України" (NBU). Якщо такого банку немає, створює новий.
//Проходить по отриманих курсах валют і для кожної валюти створює запис у базі даних для кожного курсу, прив'язуючи його до банку.
//        currencyRateRepository.save(currencyRate): Зберігає новий курс валюти в базу даних.
//
//Логування помилок: Якщо виникає помилка під час отримання даних, вона логуються в консоль, що допомагає в налагодженні
