package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		List<TaxPayer> list = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				TaxPayer tp = new Individual(name, anualIncome, healthExpenditures);
				list.add(tp);
			}
			if(ch == 'c') {
				System.out.print("Number of employees? ");
				Integer numberOfEmpoyees = sc.nextInt();
				TaxPayer tp = new Company(name, anualIncome, numberOfEmpoyees);
				list.add(tp);
			}
		}
		
		
		System.out.println();
		System.out.println("TAXES PAYD: ");
		for(TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $" + String.format("%.2f",tp.tax()));
		}
		double soma = 0.0;
		for(TaxPayer tp : list) {
			soma += tp.tax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", soma));
		sc.close();
	}

}
