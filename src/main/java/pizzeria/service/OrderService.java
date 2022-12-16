package pizzeria.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzeria.domain.Account;
import pizzeria.domain.Order;
import pizzeria.repository.OrderRepository;

@Service
public class OrderService {

  private OrderRepository repository;

  public OrderService(@Autowired final OrderRepository orderDao) {
    super();
    this.repository = orderDao;
  }

  public void createOrder(final Account account) {
    Order order = new Order();
    order.setAccount(account);
    order.setUuid(UUID.randomUUID().toString());
    order.setPizzas(new ArrayList<>());
    repository.save(order);
  }

  public Order findOrderById(long l) {
    return repository.findById(1L).get();
  }

  public void updateOrder(Order order) {
    repository.save(order);
  }
}
