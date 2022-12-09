package pizzeria;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "schema1", name = "ACCOUNT")
public class Account extends MotherEntity {
  private String email;

  @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
  private List<Order> orders;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  protected void update(MotherEntity source) {
    Account s = (Account) source;
    email = s.email;
    orders = s.orders;
  }
}
