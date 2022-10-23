package application;

import java.util.Scanner;

import model.entities.Account;
import model.excepitions.DomainExcepition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: $");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: $");
			Double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.printf("R$ %.2f %n", acc.getBalance());
			
			System.out.print("Enter amount for withdraw: $");
			Double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println("New Balance $" + acc.getBalance());
		}
		catch(DomainExcepition e){
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		sc.close();

	}

}
