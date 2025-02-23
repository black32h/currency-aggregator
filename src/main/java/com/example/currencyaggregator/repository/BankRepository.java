package com.example.currencyaggregator.repository;

import com.example.currencyaggregator.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {

    // Метод для пошуку банку за його кодом (наприклад, NBU для Національного банку України)
    Bank findByCode(String code);
}
//BankRepository розширює інтерфейс JpaRepository, що дозволяє автоматично отримувати стандартні методи для роботи з базою даних, такі як:
//findById(id): для пошуку запису за його id.
//save(entity): для збереження нового запису або оновлення існуючого.
//delete(entity): для видалення запису.
//та інші.
//Метод findByCode:
//
//Цей метод визначає додаткову функцію для пошуку банку за його унікальним кодом.
//Наприклад, якщо ви передаєте "NBU", метод поверне банк з кодом "NBU" (Національний банк України).
//findByCode є автоматично створеним методом на основі конвенцій Spring Data JPA.
//        Типи:
//
//Bank — це сутність, яка представляє таблицю в базі даних.
//        Long — тип для ідентифікатора запису в таблиці (primary key)
