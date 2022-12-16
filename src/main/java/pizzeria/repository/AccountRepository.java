package pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pizzeria.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
