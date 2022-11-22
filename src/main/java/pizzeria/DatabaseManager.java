package pizzeria;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

  private Connection connection;

  public Connection getConnection() {
    return connection;
  }

  DatabaseManager() {
    if (null == connection) {
      connect();
    }
  }

  private void connect() {

    try {
      Class.forName("org.postgresql.Driver");

      Properties props = readProperties();

      final String PORT = "db.port";
      final String IP = "db.ip";

      // the final url must look like that jdbc:postgresql://IP:PORT/pizzeria";
      StringBuilder url = new StringBuilder();
      url.append("jdbc:postgresql://").append(props.getProperty(IP)).append(":")
          .append(props.getProperty(PORT)).append("/pizzeria");

      final String USER = "db.user";
      final String SECRET = "db.secret";
      final String AS_SSL = "db.as-ssl";

      props.setProperty("user", props.getProperty(USER));
      props.setProperty("password", props.getProperty(SECRET));
      props.setProperty("ssl", props.getProperty(AS_SSL));

      readProperties();
      this.connection = DriverManager.getConnection(url.toString(), props);

      connection.setAutoCommit(Boolean.FALSE);

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("Impossible de trouver le driver JDBC!");

    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Impossible de se connceter a la base!");
    }

  }

  private Properties readProperties() {

    final String fileName = "config.properties"; // from src/main/resources

    try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {

      Properties prop = new Properties();

      // load a properties file
      prop.load(input);

      return prop;

    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException("Impossible de lire les paramètres de connection à la base!");
    }
  }

}
