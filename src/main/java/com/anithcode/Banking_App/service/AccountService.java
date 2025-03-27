package com.anithcode.Banking_App.service;

import com.anithcode.Banking_App.entity.Account;

import java.util.List;

public interface AccountService {
  public Account createAccount(Account account);
  public Account getAccountDetailsByAccountNumber(Long accountNumber);
  public List<Account> getAllAccountDetails();
  public Account depositAmount(Long accountNumber,Double amount);
  public Account withDrawAmount(Long accountNumber,Double amount);
  public void closeAccount(Long accountNumber);
}
