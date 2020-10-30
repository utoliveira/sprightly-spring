package higor.dev.testdrivendevelopment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/cars/{name}")
	public Car getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}
	
	
}
