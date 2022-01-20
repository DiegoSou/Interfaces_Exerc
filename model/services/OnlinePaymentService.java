package model.services;

public interface OnlinePaymentService {
	
//	taxa cobrada pelo serviço de pagamento online
	double paymentFee(double amount);
//	juros das parcelas
	double interest(double amount, int months);
}
