package kg.zeroone.java.crudapp.service.impl;

import kg.zeroone.java.crudapp.entity.Car;
import kg.zeroone.java.crudapp.repository.CarRepository;
import kg.zeroone.java.crudapp.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAllByName(String name) {
        return carRepository.findAllByNameContainsIgnoreCase(name);
    }
}