package com.example.currencyaggregator.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity  // Анотація, яка позначає клас як сутність для роботи з базою даних
public class Bank {

    @Id  // Вказує, що це первинний ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоматична генерація значення для id
    private Long id;

    @Column(nullable = false, unique = true)  // Вказує, що поле 'code' не може бути порожнім і має бути унікальним
    private String code;

    private String name;  // Назва банку
    private String logoUrl;  // URL логотипа банку
    private LocalDateTime lastUpdated;  // Дата та час останнього оновлення курсу валют

    // Геттери та сеттери для полів
    public Long getId() {
        return id;  // Отримати id банку
    }

    public void setId(Long id) {
        this.id = id;  // Встановити id банку
    }

    public String getCode() {
        return code;  // Отримати код банку
    }

    public void setCode(String bankCode) {
        this.code = bankCode;  // Встановити код банку
    }

    public String getName() {
        return name;  // Отримати назву банку
    }

    public void setName(String name) {
        this.name = name;  // Встановити назву банку
    }

    public String getLogoUrl() {
        return logoUrl;  // Отримати URL логотипа банку
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;  // Встановити URL логотипа банку
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;  // Отримати дату та час останнього оновлення
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;  // Встановити дату та час останнього оновлення
    }
}
//@Entity — анотація, що позначає клас як сутність для роботи з базою даних.
//@Id — вказує, що це поле є первинним ключем для таблиці в базі даних.
//@GeneratedValue(strategy = GenerationType.IDENTITY) — автоматично генерує значення для поля id, коли створюється новий запис.
//@Column(nullable = false, unique = true) — визначає, що поле code має бути унікальним і не може бути порожнім у таблиці бази даних.
//     
