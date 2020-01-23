package kg.zeroone.java.crudapp.repository;



import kg.zeroone.java.crudapp.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByNameContainsIgnoreCase(String name);
}