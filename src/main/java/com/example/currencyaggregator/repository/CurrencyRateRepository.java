package com.example.currencyaggregator.repository;

import com.example.currencyaggregator.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

    // JpaRepository вже надає методи для роботи з таблицею CurrencyRate:
    //  - findById(id): шукає курс валют за id.
    //  - save(entity): зберігає або оновлює курс валют.
    //  - delete(entity): видаляє курс валют.
    //  - та інші стандартні методи для роботи з базою даних.
}
