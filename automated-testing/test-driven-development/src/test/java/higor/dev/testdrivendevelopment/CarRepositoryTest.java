package higor.dev.testdrivendevelopment;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void getCar_returnsCarDetails() throws Exception{
				
		/*If the carRepository was using save before the findByName it would still in the cache
		 * until the findByName command. So, with persistAndFlush, it will send the data to database
		 * then findByName would find it, recreate the new object and put it on cache.
		 * With save() would test only the cache*/
		Car savedCar = entityManager.persistAndFlush(new Car("prius", "Hybrid"));
		
		/*Will take the first level cache and flush it to the database*/
		Car car = carRepository.findByName("prius");
		
		Assertions.assertThat(car.getName()).isEqualTo(savedCar.getName());
		Assertions.assertThat(car.getType()).isEqualTo(savedCar.getType());
		
	}
	
}
