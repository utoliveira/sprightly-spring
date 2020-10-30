package higor.dev.testdrivendevelopment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarService carService;
	
	@MockBean 
	private CarRepository carRepository;
	
	@Test
	public void getCar_shouldReturnCar() throws Exception{
		
		BDDMockito.given(carService.getCarDetails(BDDMockito.anyString())).willReturn(new Car("prius", "hybrid"));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("name").value("prius"))
			.andExpect(MockMvcResultMatchers.jsonPath("type").value("hybrid"));
	}
	
	@Test
	public void getCar_notFound() throws Exception{
		
		BDDMockito.given(carService.getCarDetails(BDDMockito.anyString())).willThrow(CarNotFoundException.class);

		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
			.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void getCar_withoutParams() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
		.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
}
