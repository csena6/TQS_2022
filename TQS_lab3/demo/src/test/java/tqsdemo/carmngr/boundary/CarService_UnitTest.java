package tqsdemo.carmngr.boundary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import tqsdemo.carmngr.data.Car;
import tqsdemo.carmngr.data.CarRepository;
import tqsdemo.carmngr.service.CarService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarService_UnitTest {
    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    public void setup(){
        Car vroom = new Car("mercedes","gla");
        Car mcqueen = new Car("bmw","320d");
        Car slowy = new Car("toyota","corolla");
        vroom.setId(111L);

        List<Car> allCars = Arrays.asList(vroom,mcqueen,slowy);

        Mockito.when(carRepository.findByModel(vroom.getModel())).thenReturn(vroom);
        Mockito.when(carRepository.findByModel(slowy.getModel())).thenReturn(slowy);
        Mockito.when(carRepository.findByModel("wrong_Model")).thenReturn(null);
        Mockito.when(carRepository.findById(vroom.getId())).thenReturn(Optional.of(vroom));
        Mockito.when(carRepository.findAll()).thenReturn(allCars);
        Mockito.when(carRepository.findById(-88L)).thenReturn(Optional.empty());
    }

    @Test
    void whenSearchValidModel_thenCarShouldBeFound(){
        String model ="gla";
        Car found = carService.findCarByModel(model);
        assertThat(found.getMaker()).isEqualTo(model);
    }

    @Test
    
    
}
