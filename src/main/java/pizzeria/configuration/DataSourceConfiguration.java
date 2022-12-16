package pizzeria.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfiguration {

  @Value("${datasource.schema}")
  private String schema;
  @Value("${datasource.username}")
  private String username;
  @Value("${datasource.password}")
  private String password;
  @Value("${datasource.driver.class.name}")
  private String driverClassName;
  @Value("${datasource.url}")
  private String url;

  @Bean
  DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setSchema(schema);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);

    return dataSource;
  }

}
