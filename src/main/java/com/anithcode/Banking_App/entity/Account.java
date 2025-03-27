package com.anithcode.Banking_App.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;


@Table(name="accounts")
@Entity
@JsonPropertyOrder({ "id", "accountHolderName", "balance" })
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long accountNumber;

  @Column(name="account_holder_name")
  private String account_holder_name;

  @Column(name="balance")
  private double balance;

  public Account() {

  }

  public Account(long accountNumber, String accountHolderName,double balance) {
    this.accountNumber = accountNumber;
    this.account_holder_name = accountHolderName;
    this.balance = balance;
  }

  public long getId() {
    return accountNumber;
  }

  public void setId(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountHolderName() {
    return account_holder_name;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.account_holder_name = accountHolderName;
  }

  public double getBalance(){
    return balance;
  }

  public void setBalance(double balance){
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Account{" +
        "accountNumber=" + accountNumber +
        ", accountHolderName='" + account_holder_name + '\'' +
        ", balance=" + balance +
        '}';
  }
}
