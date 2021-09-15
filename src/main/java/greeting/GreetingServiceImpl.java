package greeting;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	@Override
	public String greeting() {
		return "Hi, I am Jiazhen Ruan.";
	}

}
