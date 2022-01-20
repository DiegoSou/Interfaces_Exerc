package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = scan.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(scan.next());
		System.out.print("Contract value: ");
		double value = scan.nextDouble();
		
		Contract contract = new Contract(number, date, value);
		
		System.out.print("Enter number of installments: ");
		int installments = scan.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, installments);
		
		System.out.println("Installments: ");
		for (Installment x : contract.getInstallments()) {
			System.out.println(x);
		}
		
		scan.close();
	}

}
