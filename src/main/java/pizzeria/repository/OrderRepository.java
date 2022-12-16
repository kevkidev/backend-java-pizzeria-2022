package pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pizzeria.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
