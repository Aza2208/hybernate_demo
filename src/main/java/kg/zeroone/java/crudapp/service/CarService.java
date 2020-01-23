package kg.zeroone.java.crudapp.service;

import kg.zeroone.java.crudapp.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();

    Optional<Car> findById(Long id);

    Car save(Car car);

    List<Car> findAllByName(String name);
}



