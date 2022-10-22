package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.printf("Product #%d data: %n", i);
			System.out.println("Common, used or imported? (c/u/i): ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: $");
			Double price =  sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Custom fee: $");
				Double CustomFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, CustomFee));
			}
			if(ch == 'u') {
				sc.nextLine();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureDate = sc.nextLine();
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			if(ch == 'c') {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("Price Tags: ");
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
		
		
		
		sc.close();

	}

}
