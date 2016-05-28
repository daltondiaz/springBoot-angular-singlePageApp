package dalton.example.angular.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dalton.example.angular.person.PersonRepository;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	
	private PersonRepository personRepository;
	
	@Autowired
	public CurrentUserDetailsService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	/**
	 * The default of parent class the method is loadUserByUsername, so its necessary implement
	 * but in our project the User/Person will login using email.
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return personRepository.findOneByEmail(email);
	}

}
