package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Funcionario;
import entities.enums.WorkLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Departamento:");
		String departamento = sc.nextLine();
		
		System.out.println("Dados do Trabalhador");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Salário: ");
		Double salario = sc.nextDouble();
		
		Funcionario funcionario = new Funcionario(name, WorkLevel.valueOf(level), salario, new Departamento(departamento));
 		
		sc.nextLine();
		System.out.println("Quantos contratos tem esse trabalhador ?");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.println("Contrato #" + (i + 1));
			System.out.print("Data (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Valor por hora:");
			Double porHora = sc.nextDouble();
			System.out.print("Duração: ");
			Integer hora = sc.nextInt();
			
			ContratoHora contrato = new ContratoHora(date, porHora, hora);
			funcionario.addContract(contrato);
		}
		
		
		System.out.println();
		System.out.print("Entre com o mês e o ano:(MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		sc.close();
		
		
		System.out.println("Nome: " + funcionario.getName());
		System.out.println("Departamento: " + funcionario.getDepartamento().getDepartamento());
		System.out.print("Renda de " +mesEAno + ": " + String.format("%.2f", funcionario.income(ano, mes)));
	}

}
