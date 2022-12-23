package pizzeria.rest.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import pizzeria.repository.PizzaRepository;
import pizzeria.service.PizzaService;

@WebMvcTest(PizzaController.class)
class PizzaControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PizzaService pizzaService;

	@MockBean
	private PizzaRepository pizzaRepository;

	@Test
	void testInfo() throws Exception {

		mockMvc.perform(get("/pizzas/info")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(PizzaController.class.getName())));
	}

}
