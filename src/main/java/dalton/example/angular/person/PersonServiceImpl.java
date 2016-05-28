package dalton.example.angular.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import dalton.example.angular.security.Role;

@Component
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person create(Person person) throws Exception {
		person.setRole(Role.USER);
		person.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
		return personRepository.save(person);
	}

}
