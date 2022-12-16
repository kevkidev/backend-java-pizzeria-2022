package pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzeria.domain.Pizza;
import pizzeria.repository.PizzaRepository;

@Service
public class PizzaService {

  private PizzaRepository repository;

  public PizzaService(@Autowired final PizzaRepository repository) {
    super();
    this.repository = repository;
  }

  public void recordList(final List<Pizza> pizzas) {
    try {
      if (pizzas.isEmpty()) {
        throw new Exception("Impossible d'enregistrer une liste vide");
      }

      for (Pizza p : pizzas) {
        repository.save(p);
      }

    } catch (NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible d'enregistrer une liste null");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void showPizzas() {
    for (Pizza a : repository.findAll()) {
      System.out.println(a);
    }
  }

  private void showPizzaByName(final String name) {
    for (Pizza a : repository.findByName(name)) {
      System.out.println(a);
    }
  }

  public Pizza findPizzaById(long pizzaId) {
    return repository.findById(pizzaId).get();
  }

  public void addPizzaToSelection(final long pizzaId, final List<Pizza> selection) {
    Pizza pizza = findPizzaById(pizzaId);
    selection.add(pizza);
    System.out.println("Pizza " + pizza.getName() + "selected.");
  }

}
