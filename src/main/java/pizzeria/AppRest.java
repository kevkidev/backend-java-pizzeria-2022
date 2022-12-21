package pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppRest {

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
