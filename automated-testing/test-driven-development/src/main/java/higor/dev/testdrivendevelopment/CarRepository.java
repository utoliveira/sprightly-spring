package higor.dev.testdrivendevelopment;

import org.springframework.data.repository.CrudRepository;

public interface  CarRepository extends CrudRepository<Car, Integer>{

	Car findByName(String name);
	
}
