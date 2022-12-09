package pizzeria;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Entity
@Table(schema = "schema1", name = "ORDER")
public class Order extends MotherEntity {
  private BigDecimal amount;

  @ManyToOne
  @JoinColumn(name = "ACCOUNT_ID", nullable = false)
  private Account account;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "ORDER_PIZZA",
      joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "PIZZA_ID", referencedColumnName = "ID",
          nullable = false))
  private List<Pizza> pizzas;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public List<Pizza> getPizzas() {
    return pizzas;
  }

  public void setPizzas(List<Pizza> pizzas) {
    this.pizzas = pizzas;
  }

  @Override
  protected void update(MotherEntity source) {
    Order s = (Order) source;
    amount = s.amount;
    account = s.account;
    pizzas = s.pizzas;

  }

}
