package dalton.example.angular.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value ="/user/new", method = RequestMethod.GET)
	public Person createPerson(	Person user){
		
		try {
			return personService.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
