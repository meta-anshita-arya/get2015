import java.util.Scanner;

public class PaymentMode {
	Scanner sc = new Scanner(System.in);

	public void creditCard(double price) {// for credit card
		System.out.println("Enter your cc value");
		System.out.println("IT MUST BE INTEGER VALUE");

		int ccValue = sc.nextInt();
		System.out.println("Enter your csv value");
		System.out.println("IT MUST BE INTEGER VALUE");
		int csvValue = sc.nextInt();
		System.out.println("Your processing as follows");

		System.out.println("ccValue-" + ccValue + "	csv value->" + csvValue
				+ "	amount detected->" + price);
	}

	public void wallet(double price) {// for wallet
		System.out.println("Your amount is detected with price" + price);

	}

	public void netBanking(double price) {// for net banking
		System.out.println("enter your bank detail------");
		System.out.println("enter your bank name");
		String bankName = sc.next();
		System.out.println("enter your user name");
		String userName = sc.next();
		System.out.println("enter your password");
		sc.next();
		System.out.println("Your processing as follows");
		System.out.println("bank name-" + bankName + "	User Name->" + userName
				+ "	amount detected->" + price);

	}

}
