package com.anithcode.Banking_App.controller;

import com.anithcode.Banking_App.entity.Account;
import com.anithcode.Banking_App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

  @Autowired
  AccountService service;


  //create the  account
  @PostMapping("/create")
  public ResponseEntity<Account> createAccount(@RequestBody Account account){
    Account createAccount = service.createAccount(account);
    return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
  }

  @GetMapping("/{accountNumber}")
  public Account getAccountByAccountNumber(@PathVariable Long accountNumber){
    Account account = service.getAccountDetailsByAccountNumber(accountNumber);
    return account;
  }

  @GetMapping("/getAllAccounts")
  public List<Account> getAllAccountDetails(){
    List<Account> allAccountDetails = service.getAllAccountDetails();
    return allAccountDetails;
  }

  @PutMapping("/deposit/{accountNumber}/{amount}")
  public Account depositAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
    Account account = service.depositAmount(accountNumber,amount);
    return account;
  }

  @PutMapping("/withdraw/{accountNumber}/{amount}")
  public Account withDrawAmount(@PathVariable Long accountNumber,@PathVariable Double amount){
    Account account = service.withDrawAmount(accountNumber,amount);
    return account;
  }

  @DeleteMapping("/delete/{accountNumber}")
  public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
    service.closeAccount(accountNumber);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
  }
}
