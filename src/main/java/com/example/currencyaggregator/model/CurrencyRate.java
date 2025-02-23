package com.example.currencyaggregator.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity  // Анотація, що позначає цей клас як сутність для роботи з базою даних
public class CurrencyRate {

    @Id  // Позначає поле 'id' як первинний ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоматична генерація значення для поля 'id'
    private Long id;

    private String currencyCode;  // Код валюти (наприклад, "USD")
    private double exchangeRate;  // Обмінний курс для цієї валюти
    private String currencyName;  // Назва валюти (наприклад, "Долар США")
    private BigDecimal rate;  // Обмінний курс з точністю до 2 знаків після коми
    private LocalDate exchangeDate;  // Дата обміну курсу

    @ManyToOne  // Вказує на зв'язок "багато до одного" з класом Bank
    @JoinColumn(name = "bank_id")  // Зв'язок між валютою та банком (через поле 'bank_id')
    private Bank bank;  // Об'єкт типу Bank, що містить інформацію про банк, який надає цей курс

    // Конструктор без параметрів (для ініціалізації об'єктів без значень)
    public CurrencyRate() {
    }

    // Конструктор з параметрами (для створення об'єкта з заданими значеннями)
    public CurrencyRate(String currencyCode, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    // Геттер для поля 'currencyCode'
    public String getCurrencyCode() {
        return currencyCode;
    }

    // Сеттер для поля 'currencyCode'
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    // Геттер для поля 'exchangeRate'
    public double getExchangeRate() {
        return exchangeRate;
    }

    // Сеттер для поля 'exchangeRate'
    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    // Геттер для поля 'currencyName'
    public String getCurrencyName() {
        return currencyName;
    }

    // Сеттер для поля 'currencyName'
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    // Геттер для поля 'rate'
    public BigDecimal getRate() {
        return rate;
    }

    // Сеттер для поля 'rate'
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    // Геттер для поля 'exchangeDate'
    public LocalDate getExchangeDate() {
        return exchangeDate;
    }

    // Сеттер для поля 'exchangeDate'
    public void setExchangeDate(LocalDate exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    // Геттер для поля 'bank'
    public Bank getBank() {
        return bank;
    }

    // Сеттер для поля 'bank'
    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
//@Entity: Позначає клас як сутність, яку потрібно зберігати в базі даних.
//@Id: Позначає поле як первинний ключ для сутності.
//@GeneratedValue: Вказує на автоматичне створення значення для поля id.
//@ManyToOne: Визначає зв'язок "багато до одного" з класом Bank, що означає, що кожна валюта має лише один банк, але банк може мати багато валют.
//@JoinColumn: Позначає, що цей клас має зв'язок з полем bank_id в таблиці бази даних, що є зовнішнім ключем до таблиці банків.
//Поля:
//
//currencyCode: Код валюти, наприклад "USD" для долара.
//exchangeRate: Курс валюти.
//currencyName: Назва валюти, наприклад "Долар США".
//rate: Точний обмінний курс.
//        exchangeDate: Дата, коли було отримано курс валют.
//        bank: Об'єкт Bank, що містить інформацію про банк, який надає курс.
