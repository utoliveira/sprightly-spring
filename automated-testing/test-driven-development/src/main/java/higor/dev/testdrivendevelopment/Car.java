package higor.dev.testdrivendevelopment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Car {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Getter @Setter @NonNull
	private String name;

	@Getter @Setter @NonNull
	private String type;
	
}
