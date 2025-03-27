package com.anithcode.Banking_App.service;

import com.anithcode.Banking_App.entity.Account;
import com.anithcode.Banking_App.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService{

  @Autowired
  AccountRepository repository;

  @Override
  public Account createAccount(Account account) {
    Account account_saved = repository.save(account);
    return account_saved;
  }

  @Override
  public Account getAccountDetailsByAccountNumber(Long accountNumber) {
    Optional<Account> account = repository.findById(accountNumber);
    if(account.isEmpty()){
      throw new RuntimeException("Account is not present");
    }
    Account account_found = account.get();
    return account_found;
  }

  @Override
  public List<Account> getAllAccountDetails() {
    List<Account> listOfAccounts = repository.findAll();
    return listOfAccounts;
  }

  @Override
  public Account depositAmount(Long accountNumber, Double amount) {
    Optional<Account> account = repository.findById(accountNumber);
    if(account.isEmpty()){
      throw new RuntimeException("Account is not present");
    }
    Account accountPresent = account.get();
    Double depositedBalance = accountPresent.getBalance()+amount;
    accountPresent.setBalance(depositedBalance);
    repository.save(accountPresent);

    return accountPresent;
  }

  @Override
  public Account withDrawAmount(Long accountNumber, Double amount) {
    Optional<Account> account = repository.findById(accountNumber);
    if(account.isEmpty()){
      throw new RuntimeException("Account is not present");
    }
    Account accountPresent = account.get();
    Double accountBalance = accountPresent.getBalance()-amount;
    accountPresent.setBalance(accountBalance);
    repository.save(accountPresent);

    return accountPresent;
  }

  @Override
  public void closeAccount(Long accountNumber) {
    Optional<Account> account = repository.findById(accountNumber);
    if(account.isEmpty()){
      throw new RuntimeException("Account is not present");
    }
    Account accountPresent = account.get();
    repository.delete(accountPresent);

  }
}
