import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fuber.CabServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public CabServiceImpl getCabService() {
		return new CabServiceImpl();
	}
}