package pizzeria;

public class App {
  public static void main(final String[] arg) {
    System.out.println("Pizzeria running");

    PizzaDao.readAll();
    PizzaDao.create(new Pizza("Margherita", 8d));
    PizzaDao.readAll();


    // Pizza pizza = PizzaDao.read("4779a2ca-67ae-47f4-9dff-a3b5df1aab60");
    // pizza.setName("Napolitaine");
    // System.out.println(pizza);
    // PizzaDao.update(pizza);
    // PizzaDao.readAll();

    // PizzaDao.delete("4779a2ca-67ae-47f4-9dff-a3b5df1aab60");
    // PizzaDao.readAll();
  }
}
