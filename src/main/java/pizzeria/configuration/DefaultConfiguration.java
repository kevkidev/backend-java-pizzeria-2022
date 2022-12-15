package pizzeria.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pizzeria.repository.AccountDao;
import pizzeria.repository.OrderDao;
import pizzeria.repository.PizzaDao;
import pizzeria.service.AccountService;
import pizzeria.service.OrderService;
import pizzeria.service.PizzaService;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DefaultConfiguration {

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    return Persistence.createEntityManagerFactory("com.kevkidev.pizzeria.jpa");
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new JpaTransactionManager(entityManagerFactory());
  }

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
