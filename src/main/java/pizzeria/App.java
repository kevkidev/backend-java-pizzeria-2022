package pizzeria;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pizzeria.configuration.DefaultConfiguration;
import pizzeria.domain.Account;
import pizzeria.domain.Order;
import pizzeria.domain.Pizza;
import pizzeria.service.AccountService;
import pizzeria.service.OrderService;
import pizzeria.service.PizzaService;

public class App {
  public static void main(final String[] arg) {
    System.out.println("Pizzeria open");

    ApplicationContext context = new AnnotationConfigApplicationContext(DefaultConfiguration.class);

    PizzaService pizzaService = context.getBean(PizzaService.class);
    OrderService orderService = context.getBean(OrderService.class);
    AccountService accountService = context.getBean(AccountService.class);

    createPizzas(pizzaService);
    accountService.createAccount("@keke");

    Account account = accountService.findAccountById(1L);

    // update account
    account.setEmail("@rocky2");
    accountService.updateAccount(account);

    orderService.createOrder(account);

    // selection des pizzas
    List<Pizza> pizzaSelection = new ArrayList<>();
    pizzaService.addPizzaToSelection(2L, pizzaSelection);
    pizzaService.addPizzaToSelection(5L, pizzaSelection);

    // add selection to order
    Order order = orderService.findOrderById(1L);
    order.setPizzas(pizzaSelection);
    orderService.updateOrder(order);

    Order lastOrder = orderService.findOrderById(1L);

    // afficher order
    System.out.println("la commande");
    System.out.println(lastOrder.getPizzas());
    System.out.println("Pizzeria closed");
  }

  private static void createPizzas(final PizzaService pizzaService) {
    List<Pizza> pizzas = new ArrayList<>();
    pizzas.add(new Pizza("Reine", 10.5));
    pizzas.add(new Pizza("Orientale", 16.5));
    pizzas.add(new Pizza("Indienne", 14.5));
    pizzas.add(new Pizza("Norvegienne", 11.5));
    pizzas.add(new Pizza("Margherita", 8.5));

    pizzaService.recordList(pizzas);
  }

}
