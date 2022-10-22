package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkLevel;

public class Funcionario {
	private String name;
	private WorkLevel level;
	private Double salario;
	
	private Departamento departamento;
	
	private List<ContratoHora> contratos = new ArrayList<>();
	
	
	
	public Funcionario() {
	}

	public Funcionario(String name, WorkLevel level, Double salario, Departamento departamento) {
		this.name = name;
		this.level = level;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<ContratoHora> getContratos() {
		return contratos;
	}
	
	public void addContract(ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContract(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public double income(int year, int mounth) {
		double soma = salario;
		Calendar cal = Calendar.getInstance();
		for(ContratoHora c : contratos) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR) ;
			int c_mounth = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && mounth == c_mounth) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
	
}
