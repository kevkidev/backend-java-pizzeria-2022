package pizzeria;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTests {

	@Autowired
	AppRest appRest;

	@Test
	void testControllerLoading() {
		assertThat(appRest).isNotNull();
	}

}
