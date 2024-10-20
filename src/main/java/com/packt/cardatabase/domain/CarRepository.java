package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    // 브랜드로 자동차 검색
    List<Car> findByBrand(String brand);

    // 색상으로 자동차 검색
    List<Car> findByColor(String color);

    // 연도로 자동차 검색
    List<Car> findByYear(int year);
}
