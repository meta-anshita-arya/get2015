import java.util.Scanner;

public class ChainOfResponsiblityinterface {

	public static void main(String[] args) {
		Approver objectMentor = new Mentor();
		Approver objectSeniorMentor = new SeniorMentor();
		Approver objectHrManager = new HrManager();

		objectMentor.SetSuccessor(objectSeniorMentor);
		objectSeniorMentor.SetSuccessor(objectHrManager);
		Scanner scan = new Scanner(System.in);
		System.out.println("enter number of days of leave");
		int leave = scan.nextInt();

		objectMentor.ProcessRequest(leave);

	}

}
