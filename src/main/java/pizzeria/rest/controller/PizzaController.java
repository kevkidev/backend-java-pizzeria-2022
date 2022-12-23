package pizzeria.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pizzeria.domain.Pizza;
import pizzeria.repository.PizzaRepository;
import pizzeria.service.PizzaService;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private PizzaRepository pizzaRepository;

//	@PostMapping
//	public Pizza newPizza(@RequestBody Pizza pizza) {
//		return pizzaRepository.save(pizza);
//	}

	@GetMapping("/pizzas")
	public List<Pizza> listAllPizzas() {
		return pizzaRepository.findAll();
	}
//
//	@GetMapping("/pizzas/")
//	public Pizza listAllPizzas() {
//		return new Pizza("test", 23d);
//	}

	@GetMapping("/info")
	public String info() {
		return this.getClass().getName();
	}
}
