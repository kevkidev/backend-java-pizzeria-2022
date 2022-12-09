package pizzeria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzeria.domain.Pizza;
import pizzeria.repository.PizzaDao;

@Service
public class PizzaService {

  private PizzaDao pizzaDao;

  public PizzaService(@Autowired final PizzaDao pizzaDao) {
    super();
    this.pizzaDao = pizzaDao;
  }

  public void recordList(final List<Pizza> pizzas) {
    try {
      if (pizzas.isEmpty()) {
        throw new Exception("Impossible d'enregistrer une liste vide");
      }

      for (Pizza p : pizzas) {
        pizzaDao.create(p);
      }

    } catch (NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible d'enregistrer une liste null");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void showPizzas() {
    for (Pizza a : pizzaDao.readAll(Pizza.class)) {
      System.out.println(a);
    }
  }

  private void findPizzaByName(final String name) {
    for (Pizza a : pizzaDao.readByName(name, Pizza.class)) {
      System.out.println(a);
    }
  }

  public Pizza findPizzaById(long pizzaId) {
    return pizzaDao.read(pizzaId, Pizza.class);
  }

  public void addPizzaToSelection(final long pizzaId, final List<Pizza> selection) {
    Pizza pizza = findPizzaById(pizzaId);
    selection.add(pizza);
    System.out.println("Pizza " + pizza.getName() + "selected.");
  }

}
