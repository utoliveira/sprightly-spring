package higor.dev.testdrivendevelopment;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

	@MockBean
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
	
	@Test
	public void getCarDetails_returnsCarInfo() {
		
		//arrange
		BDDMockito.given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));
		
		//act
		Car car = carService.getCarDetails("prius");
		
		//assert
		Assertions.assertThat(car.getName()).isEqualTo("prius");
		Assertions.assertThat(car.getType()).isEqualTo("hybrid");
		
	}
	
	@Test(expected = CarNotFoundException.class)
	public void getCarDetails_notFound() throws Exception{
		BDDMockito.given(carRepository.findByName(BDDMockito.anyString())).willReturn(null);
		carService.getCarDetails("prius");
	}
	
}
