package model.entities;

import model.excepitions.DomainExcepition;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public Double deposit(Double amount) {
		return balance += amount;
	}
	
	public Double withdraw(Double amount) {
		if(amount > balance) {
			throw new DomainExcepition("Not enough balance! Balance: $" + String.format("%.2f", getBalance()));
		}
		if(amount > withdrawLimit) {
			throw new DomainExcepition("the Amount exceeds withdraw limit!  Withdraw limit: $" + String.format("%.2f", getWithdrawLimit()));
		}
		return balance -= amount;
	}

}
