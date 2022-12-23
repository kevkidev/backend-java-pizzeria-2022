package pizzeria;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AppRestTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Value("${pizzeria.message.welcome}")
	private String welcomeMessage;

	@Test
	void testHttpRequest() {
		String response = restTemplate.getForObject("http://localhost:2022/", String.class);
		assertThat(response).isEqualTo(welcomeMessage);
	}

}
