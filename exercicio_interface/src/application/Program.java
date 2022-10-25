package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalServices;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro:");
		String model = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("");
		
		CarRental cr = new CarRental(start, finish, new Vehicle(model));
		
		
		System.out.print("Entre o preço por hora: R$");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre o preço por dia: R$");
		double pricePerDay = sc.nextDouble();
		
		RentalServices rs = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxServices());
		
		rs.processInvoice(cr);
		
		System.out.println("FATURA");
		System.out.println("Pagamento básico: " + String.format("R$%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("R$%.2f",cr.getInvoice().getTax()));
		System.out.println("TOTAL: " + String.format("R$%.2f",cr.getInvoice().getTotalPayment()));
		
		sc.close();
	}

}
