package pizzeria.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pizzeria.repository.AccountDao;
import pizzeria.repository.OrderDao;
import pizzeria.repository.PizzaDao;
import pizzeria.service.AccountService;
import pizzeria.service.OrderService;
import pizzeria.service.PizzaService;

@Configuration
@ComponentScan
public class DefaultConfiguration {

  @Bean
  public PizzaDao pizzaDao() {
    return new PizzaDao();
  }

  @Bean
  public PizzaService pizzaService() {
    return new PizzaService(pizzaDao());
  }

  @Bean
  public OrderDao orderDao() {
    return new OrderDao();
  }

  @Bean
  public OrderService orderService() {
    return new OrderService(orderDao());
  }

  @Bean
  public AccountDao accountDao() {
    return new AccountDao();
  }

  @Bean
  public AccountService accountService() {
    return new AccountService(accountDao());
  }
}
