package pizzeria.service;

import java.util.List;
import pizzeria.enitity.Pizza;
import pizzeria.repository.PizzaDao;

public class PizzaService {

  public void recordList(final List<Pizza> pizzas) {
    try {
      if (pizzas.isEmpty()) {
        throw new Exception("Impossible d'enregistrer une liste vide");
      }

      for (Pizza p : pizzas) {
        PizzaDao.create(p);
      }

    } catch (NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible d'enregistrer une liste null");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
