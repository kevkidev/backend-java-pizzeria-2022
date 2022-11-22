package pizzeria;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class PizzaDao {

  public static void create(final Pizza newPizza) {
    try (Connection dbConnection = (new DatabaseManager()).getConnection();
        Statement statement = dbConnection.createStatement();) {
      
      UUID uuid = UUID.randomUUID();

      statement.executeUpdate("INSERT INTO schema1.PIZZA ( ID, NAME, PRICE) VALUES ('"
          + uuid.toString()
          + "', '"
          + newPizza.getName() + "'," + newPizza.getPrice() + ");");
      dbConnection.commit();
      dbConnection.close();

    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible de creer le statement!");
    }
  }

  public static void readAll() {
    try (Connection dbConnection = (new DatabaseManager()).getConnection();
        Statement statement = dbConnection.createStatement();) {

      ResultSet allPizzas = statement.executeQuery("SELECT * FROM schema1.PIZZA");
      while (allPizzas.next()) {
        String id = allPizzas.getString("ID");
        String name = allPizzas.getString("NAME");
        BigDecimal price = allPizzas.getBigDecimal("PRICE");
        System.out.println("[id=" + id + " name=" + name + " price=" + price + "]");
      }

      allPizzas.close();
      dbConnection.close();

    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible de creer le statement!");
    }
  }


  public static Pizza read(final String id) {
    Pizza pizza = null;
    try (Connection dbConnection = (new DatabaseManager()).getConnection();
        Statement statement = dbConnection.createStatement();) {

      ResultSet result =
          statement.executeQuery("SELECT * FROM schema1.PIZZA WHERE ID='" + id + "'");

      while (result.next()) {
        pizza = new Pizza(result.getString("NAME"), result.getDouble("PRICE"));
        pizza.setId(UUID.fromString(id));

        System.out.println("[id=" + pizza.getId() + " name=" + pizza.getName() + " price="
            + pizza.getPrice() + "]");
      }
      result.close();
      dbConnection.close();
      
    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible de creer le statement!");
    }
    return pizza;
  }

  
  public static void update(final Pizza newPizza) {
    try (Connection dbConnection = (new DatabaseManager()).getConnection();
        Statement statement = dbConnection.createStatement();) {

      StringBuilder query = new StringBuilder("UPDATE schema1.PIZZA set NAME='");
      query.append(newPizza.getName()).append("', PRICE=").append(newPizza.getPrice())
          .append(" WHERE ID='").append(newPizza.getId().toString()).append("';");

      System.out.println(query);
      statement.executeUpdate(query.toString());

      dbConnection.commit();
      dbConnection.close();

    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible de creer le statement!");
    }
  }

  public static void delete(final String id) {
    try (Connection dbConnection = (new DatabaseManager()).getConnection();
        Statement statement = dbConnection.createStatement();) {

      StringBuilder query = new StringBuilder("DELETE FROM schema1.PIZZA where ID='");
      query.append(id).append("'");
      statement.executeUpdate(query.toString());
      dbConnection.commit();
      dbConnection.close();

    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible de creer le statement!");
    }
  }
}
