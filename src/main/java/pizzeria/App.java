package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(final String[] arg) {
    System.out.println("Pizzeria running");

    List<Pizza> pizzas = new ArrayList<>();
    pizzas.add(new Pizza("Reine", 10.5));
    pizzas.add(new Pizza("Orientale", 16.5));
    pizzas.add(new Pizza("Indienne", 14.5));
    pizzas.add(new Pizza("Norvegienne", 11.5));
    pizzas.add(new Pizza("Margherita", 8.5));
    PizzaService pizzaService = new PizzaService();
    pizzaService.recordList(pizzas);
  }
}
