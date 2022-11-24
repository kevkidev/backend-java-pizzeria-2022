package pizzeria;

import java.sql.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseManager {

  private Connection connection;
  private EntityManagerFactory entityManagerFactory;
  private EntityManager entityManager;
  private static DatabaseManager databaseManager;

  private DatabaseManager() {
    entityManagerFactory = Persistence.createEntityManagerFactory("com.kevkidev.pizzeria.jpa");
    entityManager = entityManagerFactory.createEntityManager();
  }

  public Connection getConnection() {
    return connection;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public static DatabaseManager getInstance() {
    if (null == databaseManager) {
      return new DatabaseManager();
    }
    return databaseManager;
  }
}
