package tqsdemo.carmngr.boundary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tqsdemo.carmngr.boundary.CarRestController;
import tqsdemo.carmngr.data.Car;
import tqsdemo.carmngr.service.CarService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarRestController.class)
public class CarController_WithMockServiceTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;


    @Test
    void whenPostCar_thenCreateCar() throws Exception {
        Car vroom = new Car("mercedes","gla");

        when( service.save(Mockito.any()) ).thenReturn(vroom);
    }

    @Test
    void giveManyCars_whenGetCars_thenReturnJsonArray() throws Exception{
        Car vroom = new Car("mercedes","gla");
        Car mcqueen = new Car("bmw","320d");
        Car slowy = new Car("toyota","corolla");

        List<Car> allCars = Arrays.asList(vroom,mcqueen,slowy);
        when(service.getAllCars()).thenReturn(allCars);

        mvc.perform(
            get("/api/cars").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].maker", is(vroom.getMaker())))
            .andExpect(jsonPath("$[1].maker", is(mcqueen.getMaker())))
            .andExpect(jsonPath("$[2].maker", is(slowy.getMaker())));
        
        verify(service,times(1)).getAllCars();
    }
}
