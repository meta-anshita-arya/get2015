import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//main class
public class ConcordanceMain {
	// main function
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String input = new String();
		System.out.println("Enter the string");
		input = scan.next();
		int length = input.length();
		ConcordanceOfCharacters object = new ConcordanceOfCharacters(input,
				length);// object created
		object.setUniqueCharacters();// to create unique set of characters
		object.concordance();// to perform concordance
		System.out.println("Result=");
		object.print();// to display
	}

}
