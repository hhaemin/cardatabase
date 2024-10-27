package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//이 클래스가 RESTful 웹 서비스의 컨트롤러
@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;

    // 메서드가 매핑되는 엔드포인트 정의
    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        // 자동차를 검색하고 반환
        return carRepository.findAll();
    }
}
