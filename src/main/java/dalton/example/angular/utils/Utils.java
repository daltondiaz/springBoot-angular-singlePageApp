package dalton.example.angular.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {

	// If necessary generate a password
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
