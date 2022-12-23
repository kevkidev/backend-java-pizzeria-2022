package pizzeria;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@RequestMapping("/api/v1")
@PropertySource("classpath:text.properties")
public class AppRest {

	@Value("${pizzeria.message.welcome}")
	private String welcomeMessage;

	public static void main(String[] args) {
		SpringApplication.run(AppRest.class, args);
	}

	@GetMapping("/")
	public String root() {
		return "Pizzeria is open.";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		// ex: /hello?name=Kevin
		return String.format("Hello %s!", name);
	}

}
