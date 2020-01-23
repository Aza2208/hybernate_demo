package kg.zeroone.java.crudapp.controller;

import kg.zeroone.java.crudapp.entity.Car;
import kg.zeroone.java.crudapp.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    private String getAll(Model model) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("message"+ "Get all cars");
        return "Cars";
    }

    @GetMapping()
    private List<Car> findAllByName(@PathVariable String name) {
        return carService.findAllByName(name);
    }
}