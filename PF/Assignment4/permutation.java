import java.util.Scanner;

//program to perform permutation of a given string
public class permutation {

	String result = "";

	public static void main(String args[]) {
		String input, output;
		permutation object = new permutation();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input string"); // input string
		input = scan.nextLine();
		output = object.generatePermutations("", input); // calling funcctio
		System.out.println(output);
		scan.close();
	}

	String generatePermutations(String beginningString, String endingString) // recursive
																				// function
																				// to
																				// perform
																				// permutation
																				// of
																				// string
	{

		if (endingString.length() <= 1) {
			result = result + " " + beginningString + endingString;
		} else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);
					generatePermutations(
							beginningString + endingString.charAt(i), newString); // recursive
																					// calling
																					// of
																					// function
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
		return result;
	}

}
