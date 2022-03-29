package tqsdemo.carmngr.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqsdemo.carmngr.service.CarService;
import tqsdemo.carmngr.data.Car;
import tqsdemo.carmngr.data.CarDTO;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService){
        this.carService = carService;
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody CarDTO car){
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carService.save(car.toCarEntity() );
        return new ResponseEntity<>(saved,status);
    }

    @GetMapping(path ="/cars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping(path ="/cars")
    public ResponseEntity<Car> getCarbyID(@RequestParam Long id){
        HttpStatus status = HttpStatus.OK;
        Car saved = carService.getCarDetails(id);
        return new ResponseEntity<>(saved,status);
    }


    
}
