package pizzeria;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App {
  public static void main(final String[] arg) {
    System.out.println("Pizzeria open");
    createPizzas();
    createAccount("@keke");

    Account account = AccountDao.read(1L, Account.class);
    // update account
    account.setEmail("@rocky2");
    AccountDao.update(account, Account.class);

    createOrder(account);

    // selection des pizzas
    List<Pizza> pizzaSelection = new ArrayList<>();
    selectPizza(2L, pizzaSelection);
    selectPizza(5L, pizzaSelection);

    // add selection to order
    Order order = OrderDao.read(1L, Order.class);
    order.setPizzas(pizzaSelection);
    OrderDao.update(order, Order.class);

    Order lastOrder = OrderDao.read(1L, Order.class);
    // afficher order
    System.out.println("la commande");
    System.out.println(lastOrder.getPizzas());
    System.out.println("Pizzeria closed");
  }

  private static void selectPizza(final long pizzaId, final List<Pizza> selection) {
    List<Pizza> pizzaSelection = new ArrayList<>();
    Pizza pizza1 = PizzaDao.read(pizzaId, Pizza.class);
    selection.add(pizza1);
    System.out.println("Pizza " + pizza1.getName() + "selected.");
  }

  private static void createPizzas() {
    List<Pizza> pizzas = new ArrayList<>();
    pizzas.add(new Pizza("Reine", 10.5));
    pizzas.add(new Pizza("Orientale", 16.5));
    pizzas.add(new Pizza("Indienne", 14.5));
    pizzas.add(new Pizza("Norvegienne", 11.5));
    pizzas.add(new Pizza("Margherita", 8.5));

    PizzaService pizzaService = new PizzaService();
    pizzaService.recordList(pizzas);
  }

  private static void showPizzas() {
    for (Pizza a : PizzaDao.readAll(Pizza.class)) {
      System.out.println(a);
    }
  }

  private static void findPizzaByName(final String name) {
    for (Pizza a : PizzaDao.readByName(name, Pizza.class)) {
      System.out.println(a);
    }
  }

  private static void createAccount(final String email) {
    Account account1 = new Account();
    account1.setEmail(email);
    account1.setUuid(UUID.randomUUID().toString());
    AccountDao.create(account1);
  }

  private static void createOrder(final Account account) {
    Order order = new Order();
    order.setAccount(account);
    order.setUuid(UUID.randomUUID().toString());
    order.setPizzas(new ArrayList<>());
    OrderDao.create(order);
  }

}
