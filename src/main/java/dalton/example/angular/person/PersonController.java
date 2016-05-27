package dalton.example.angular.person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	
	private PersonRepository personRepository;
	
	@RequestMapping("/user/new")
	public String createPerson(Person user){
		
		personRepository.save(user);
		
		return null;
		
	}
}
