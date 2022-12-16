package pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pizzeria.domain.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

  Pizza[] findByName(String name);

}
