package pizzeria;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Entity
@Table(schema = "schema1", name = "pizza")
public class Pizza {
  @Id
  private String id;
  private String name;
  private BigDecimal price;

  Pizza() {

  }

  Pizza(final String id) {
    this.id = id;
  }

  Pizza(final String name, final double price, final String id) {
    // keep 2 digits after the comma
    this.name = name;
    this.price = new BigDecimal(price);
    this.price.setScale(2);
    this.id = id;
  }



  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public BigDecimal getPrice() {
    return price;
  }


  public void setPrice(BigDecimal price) {
    this.price = price;
  }


}
