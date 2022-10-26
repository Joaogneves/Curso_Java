package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePyamentService;

	public ContractService(OnlinePaymentService onlinePyamentService) {
		this.onlinePyamentService = onlinePyamentService;
	}
	
	public void ProcessContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for(int i=1; i<=months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePyamentService.interest(basicQuota, i);
			double fee = onlinePyamentService.paymentFee(basicQuota + interest);
			double quota = basicQuota + interest + fee;
			contract.getInstallment().add(new Installment(dueDate, quota));
		}
	}
	
}
