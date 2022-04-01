package tqsdemo.carmngr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import tqsdemo.carmngr.data.Car;
import tqsdemo.carmngr.data.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    
    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarDetails(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car findCarByModel(String model){
        return carRepository.findByModel(model);
    }
    
}
