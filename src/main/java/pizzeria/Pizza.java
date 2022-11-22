package pizzeria;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.ToString;

@ToString
public class Pizza {
  private UUID id;
  private String name;
  private BigDecimal price;

  Pizza() {

  }


  Pizza(final String name, final double price) {
    // keep 2 digits after the comma
    this.name = name;
    this.price = new BigDecimal(price);
    this.price.setScale(2);
  }



  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
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
