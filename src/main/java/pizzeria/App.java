package pizzeria;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pizzeria.configuration.DataSourceConfiguration;
import pizzeria.configuration.DefaultConfiguration;
import pizzeria.service.AccountService;
import pizzeria.service.OrderService;
import pizzeria.service.PizzaService;
import pizzeria.service.PizzeriaService;

public class App {
	public static void main(final String[] arg) {
		System.out.println("Pizzeria open");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// register autant de config voulu
		context.register(DataSourceConfiguration.class);
		context.register(DefaultConfiguration.class);
		context.refresh();

		PizzaService pizzaService = context.getBean(PizzaService.class);
		OrderService orderService = context.getBean(OrderService.class);
		AccountService accountService = context.getBean(AccountService.class);
		PizzeriaService pizzeriaService = context.getBean(PizzeriaService.class);

		pizzeriaService.build(pizzaService, orderService, accountService);
	}
}
