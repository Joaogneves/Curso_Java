package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalServices {
	private Double pricePerHour;
	private Double pricePerDay;
	
	private BrazilTaxServices brts;

	public RentalServices(Double pricePerHour, Double pricePerDay, BrazilTaxServices brts) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.brts = brts;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public BrazilTaxServices getBrts() {
		return brts;
	}

	public void setBrts(BrazilTaxServices brts) {
		this.brts = brts;
	}
	
	public void processInvoice(CarRental carRental) {
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60;
		double basicPayment;
		if(hours >= 12.0) {
			basicPayment = pricePerDay * Math.ceil(hours / 24.0);
		}
		else {
			basicPayment = pricePerHour * Math.ceil(hours);
		}
		
		double tax = brts.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
}
