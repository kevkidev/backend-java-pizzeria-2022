package pizzeria.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzeria.domain.Account;
import pizzeria.repository.AccountDao;

@Service
public class AccountService {

  private AccountDao accountDao;

  public AccountService(@Autowired final AccountDao accountDao) {
    super();
    this.accountDao = accountDao;
  }

  public void createAccount(final String email) {
    Account account1 = new Account();
    account1.setEmail(email);
    account1.setUuid(UUID.randomUUID().toString());
    accountDao.create(account1);
  }

  public Account findAccountById(final long accountId) {
    return accountDao.read(1L, Account.class);
  }

  public void updateAccount(Account account) {
    accountDao.update(account, Account.class);
  }

}
