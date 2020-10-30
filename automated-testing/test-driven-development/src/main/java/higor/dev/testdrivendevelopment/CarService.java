package higor.dev.testdrivendevelopment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public Car getCarDetails(String name) {
		Car car = carRepository.findByName(name);
		
		if(car == null) {
			throw new CarNotFoundException();			
		}
		
		return car;
	}
	
}
