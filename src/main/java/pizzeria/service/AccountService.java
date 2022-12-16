package pizzeria.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzeria.domain.Account;
import pizzeria.repository.AccountRepository;

@Service
public class AccountService {

  private AccountRepository repository;

  public AccountService(@Autowired final AccountRepository accountDao) {
    super();
    this.repository = accountDao;
  }

  public void createAccount(final String email) {
    Account account1 = new Account();
    account1.setEmail(email);
    account1.setUuid(UUID.randomUUID().toString());
    repository.save(account1);
  }

  public Account findAccountById(final long accountId) {
    return repository.findById(accountId).get();
  }

  public void updateAccount(Account account) {
    repository.save(account);
  }

}
