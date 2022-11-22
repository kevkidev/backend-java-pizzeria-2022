package pizzeria;

public class App {
  public static void main(final String[] arg) {
    System.out.println("Pizzeria running");

    PizzaDao.readAll();
    PizzaDao.create(new Pizza("Margherita", 8d));
    PizzaDao.readAll();


    // Pizza pizza = PizzaDao.read("03253c86-5c0b-411d-a5fc-552fdfd9d269");
    // pizza.setName("Napolitaine");
    // System.out.println(pizza);
    // PizzaDao.update(pizza);
    // PizzaDao.readAll();
    //
    //
    // PizzaDao.delete("9c76fc4f-1654-4121-b2d4-be8f5eab0fce");
    // PizzaDao.readAll();
  }
}
