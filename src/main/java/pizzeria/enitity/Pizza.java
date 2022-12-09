package pizzeria.enitity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "schema1", name = "PIZZA")
public class Pizza extends MotherEntity {

  private String name;
  private BigDecimal price;

  // @ManyToMany(mappedBy = "pizzas", fetch = FetchType.EAGER)
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "ORDER_PIZZA",
      joinColumns = @JoinColumn(name = "PIZZA_ID", referencedColumnName = "ID", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID",
          nullable = false))
  private List<Order> orders;

  Pizza() {
    super();
  }

  public Pizza(final String name, final double price) {
    super();
    this.name = name;
    this.price = new BigDecimal(price);
    // keep 2 digits after the comma
    this.price.setScale(2);
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

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public void update(MotherEntity source) {
    Pizza s = (Pizza) source;
    name = s.name;
    price = s.price;
    orders = s.orders;
  }

}
