package pizzeria;

public class App {
  public static void main(final String[] arg) {
    System.out.println("Pizzeria running");

    PizzaDao.create(new Pizza("Margherita", 8d));
    PizzaDao.readAll();


    // Pizza pizza = PizzaDao.read("1853f7d2-85b7-410b-8a08-d93749dfd00c");
    // pizza.setName("Napolitaine");
    // System.out.println(pizza);
    // PizzaDao.update(pizza);
    // PizzaDao.readAll();

    // PizzaDao.delete("1853f7d2-85b7-410b-8a08-d93749dfd00c");
    // PizzaDao.readAll();
  }
}
