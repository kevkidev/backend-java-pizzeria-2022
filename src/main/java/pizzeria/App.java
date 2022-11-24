package pizzeria;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App {
  public static void main(final String[] arg) {
    System.out.println("Pizzeria running");

    List<Pizza> pizzas = new ArrayList<>();
    pizzas.add(new Pizza("Reine", 10.5, UUID.randomUUID().toString()));
    pizzas.add(new Pizza("Orientale", 16.5, UUID.randomUUID().toString()));
    pizzas.add(new Pizza("Indienne", 14.5, UUID.randomUUID().toString()));
    pizzas.add(new Pizza("Norvegienne", 11.5, UUID.randomUUID().toString()));
    pizzas.add(new Pizza("Margherita", 8.5, UUID.randomUUID().toString()));
    PizzaService pizzaService = new PizzaService();
    pizzaService.recordList(pizzas);

    for (Pizza a : PizzaDao.readAll()) {
      System.out.println(a);
    }

    Pizza newPizzaSetting =
        new Pizza("La Keke", 18.5, "aec02c86-c5c1-4a45-a186-1311c07320d2");
    PizzaDao.update(newPizzaSetting);

    PizzaDao.delete("e54ca02e-e4cc-4d6c-aae0-659a9fb03530");

  }
}
