package dalton.example.angular.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import dalton.example.angular.SinglePageApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  {SinglePageApplication.class})
@WebAppConfiguration
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
@DatabaseSetup("/dbunit/user/user.xml")
public class PersonServiceTest {
	
	
	@Autowired
	private PersonService personService;
	/**
	 * Can't permit add Person with same email
	 * @throws Exception 
	 */
	@Test
	public void createUser() throws Exception{
		Person p = new Person();
		p.setEmail("user1@email.com");
		p.setName("user");
		p.setPassword("123");
		
		Person person = personService.create(p);
		
		
	}

}
