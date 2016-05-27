package dalton.example.angular.security;

import org.springframework.security.core.authority.AuthorityUtils;

import dalton.example.angular.person.Person;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private Person person;
	private static final long serialVersionUID = -6638797107845713113L;
	
	public CurrentUser(Person person) {
		super(person.getEmail(), person.getPassword(), AuthorityUtils.createAuthorityList(person.getRole().toString()));
		this.person = person;
	}
	
	public String getEmail(){
		return this.person.getEmail();
	}
	
	public long getId(){
		return this.person.getId();
	}
	
	public Role getRole(){
		return this.person.getRole();
	}

	
	

}
