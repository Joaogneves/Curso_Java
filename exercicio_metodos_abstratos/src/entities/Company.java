package entities;

public class Company extends TaxPayer{
	private Integer numberOfEmpoyees;

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmpoyees) {
		super(name, anualIncome);
		this.numberOfEmpoyees = numberOfEmpoyees;
	}

	public Integer getNumberOfEmpoyees() {
		return numberOfEmpoyees;
	}

	public void setNumberOfEmpoyees(Integer numberOfEmpoyees) {
		this.numberOfEmpoyees = numberOfEmpoyees;
	}

	@Override
	public Double tax() {
		Double tax = 0.0;
		if(numberOfEmpoyees < 10) {
			tax = anualIncome * 0.16;
		}
		else {
			tax = anualIncome * 0.14;
		}
		return tax;
	}
	
	
}
