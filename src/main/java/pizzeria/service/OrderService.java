package pizzeria.service;

import java.util.ArrayList;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzeria.domain.Account;
import pizzeria.domain.Order;
import pizzeria.repository.OrderDao;

@Service
public class OrderService {

  private OrderDao orderDao;

  public OrderService(@Autowired final OrderDao orderDao) {
    super();
    this.orderDao = orderDao;
  }

  public void createOrder(final Account account) {
    Order order = new Order();
    order.setAccount(account);
    order.setUuid(UUID.randomUUID().toString());
    order.setPizzas(new ArrayList<>());
    orderDao.create(order);
  }

  public Order findOrderById(long l) {
    return orderDao.read(1L, Order.class);
  }

  public void updateOrder(Order order) {
    orderDao.update(order, Order.class);
  }
}
