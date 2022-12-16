package pizzeria.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import pizzeria.repository.AccountRepository;
import pizzeria.repository.OrderRepository;
import pizzeria.repository.PizzaRepository;
import pizzeria.service.AccountService;
import pizzeria.service.OrderService;
import pizzeria.service.PizzaService;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories("pizzeria.repository")
public class DefaultConfiguration {

  @Bean
  public EntityManagerFactory entityManagerFactory(final DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean
  public PizzaService pizzaService(final PizzaRepository repository) {
    return new PizzaService(repository);
  }

  @Bean
  public OrderService orderService(final OrderRepository repository) {
    return new OrderService(repository);
  }

  @Bean
  public AccountService accountService(final AccountRepository repository) {
    return new AccountService(repository);
  }
}
