package pizzeria;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class PizzaDao {

  public static void create(final Pizza newPizza) {
    try (Connection dbConnection = (new DatabaseManager()).getConnection();
        Statement statement = dbConnection.createStatement();) {
      
      UUID uuid = UUID.randomUUID();
      PreparedStatement preparedStatement =
          dbConnection.prepareStatement("INSERT INTO schema1.PIZZA ( ID, NAME, PRICE) VALUES (?,?,?)");
      preparedStatement.setString(1, uuid.toString());
      preparedStatement.setString(2, newPizza.getName());
      preparedStatement.setBigDecimal(3, newPizza.getPrice());
      preparedStatement.executeUpdate();

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

      PreparedStatement preparedStatement =
          dbConnection.prepareStatement("SELECT * FROM schema1.PIZZA");
      ResultSet allPizzas = preparedStatement.executeQuery();
          
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
      
      PreparedStatement preparedStatement =
          dbConnection.prepareStatement("SELECT * FROM schema1.PIZZA WHERE ID=?");
      preparedStatement.setString(1, id);
      
      ResultSet result = preparedStatement.executeQuery();
      
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

      PreparedStatement preparedStatement = dbConnection
          .prepareStatement("UPDATE schema1.PIZZA set NAME=?, PRICE=? WHERE ID=?");
      preparedStatement.setString(1, newPizza.getName());
      preparedStatement.setBigDecimal(2, newPizza.getPrice());
      preparedStatement.setString(3, newPizza.getId().toString());
      preparedStatement.executeUpdate();

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

      PreparedStatement preparedStatement =
          dbConnection.prepareStatement("DELETE FROM schema1.PIZZA where ID=?");
      preparedStatement.setString(1, id);
      preparedStatement.executeUpdate();

      dbConnection.commit();
      dbConnection.close();

    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
      System.err.println("Impossible de creer le statement!");
    }
  }
}
