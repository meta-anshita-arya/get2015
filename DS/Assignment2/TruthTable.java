package truthtable;

//import java.util.Arrays;

public class TruthTable {

	// to count number of operands
	int countOperand(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			int value = (int) input.charAt(i);
			if ((value >= 65 && value <= 90) || (value >= 97 && value <= 122)) {
				count++;
			}
		}
		return count;

	}

	// to generate truth table and perform operation
	int[][] truthTable(int count, String input) {
		int rows = (int) Math.pow(2, count);
		int array[][] = new int[rows][count];
		for (int i = 0; i < rows; i++) {// to generate table
			int x = 0;
			for (int j = count - 1; j >= 0; j--) {
				array[i][x] = ((i / (int) Math.pow(2, j)) % 2);
				x++;
			}
		}
		int newArray[][] = new int[rows][count + 1];// new array to store

		for (int i = 0; i < rows; i++) {
			int index = 0;
			String expression = "";
			for (int y = 0; y < input.length(); y++) {
				int value = (int) input.charAt(y);
				if ((value >= 65 && value <= 90)
						|| (value >= 97 && value <= 122)) {
					expression = expression + array[i][index];
					index++;
				} else {
					expression = expression + input.charAt(y);
				}
			}
			// array = Arrays.copyOf(array, n+1);
			String result = calculate(expression);
			int res = Integer.parseInt(result);
			// array[i][n] = Integer.parseInt(result);

			for (int j = 0; j < array[i].length; j++) {
				newArray[i][j] = array[i][j];
			}
			newArray[i][count] = res;
		}
		// return array;
		return newArray;
	}

	// to perform claculation
	String calculate(String expression) {
		int i;
		char character;
		// to remove ~
		for (i = 0; i < expression.length(); i++) {
			character = expression.charAt(i);
			if (character == '~') {
				expression = removeNot(expression, i);
			}
		}
		// to remove &
		for (i = 0; i < expression.length(); i++) {
			character = expression.charAt(i);
			if (character == '&')
				expression = removeAND(expression, i);
		}
		// to remove |
		for (i = 0; i < expression.length(); i++) {
			character = expression.charAt(i);
			if (character == '|')
				expression = removeOR(expression, i);
		}
		return expression;
	}

	// to perform Not
	private String removeNot(String expression, int i) {
		String operand;
		if (expression.charAt(i + 1) == '0') {
			operand = "1";
		} else {
			operand = "0";
		}

		String temp = expression.substring(0, i) + operand
				+ expression.substring(i + 2);
		return calculate(temp);
	}

	// to perform And
	private String removeAND(String expression, int i) {
		char operand1 = expression.charAt(i - 1);
		char operand2 = expression.charAt(i + 1);
		String operand, temp;
		if (operand1 == '1' && operand2 == '1') {
			operand = "1";
		} else {
			operand = "0";
		}
		temp = expression.substring(0, i - 1) + operand
				+ expression.substring(i + 2);
		return calculate(temp);
	}

	// to perform Or
	private String removeOR(String expression, int i) {
		char operand1 = expression.charAt(i - 1);
		char operand2 = expression.charAt(i + 1);
		String operand, temp;
		if (operand1 == '0' && operand2 == '0') {
			operand = "0";
		} else {
			operand = "1";
		}
		temp = expression.substring(0, i - 1) + operand
				+ expression.substring(i + 2);
		return calculate(temp);
	}
}
