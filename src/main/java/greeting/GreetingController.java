package greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService greetService;
	
	@GetMapping("/sample/greeting")
	public String greeting() {
		return greetService.greeting();
	}

}
