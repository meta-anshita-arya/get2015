
import java.util.Stack;

//class to perform conversion from infix to postfix
public class StackFunction {
	protected static StackNode start;
	protected static StackNode end;
	public static int size;

	// to perform push operation
	public static void push(String item) {
		StackNode nptr = new StackNode(item);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLink(start);
			start = nptr;
		}

	}

	// to perform pop operation
	public static String pop() {
		String string = start.data;
		start = start.getLink();
		size--;
		return string;
	}

	// to retrive data
	public static String peak() {
		String string = start.data;

		return string;
	}

	// to check whether operand or not
	boolean isOperand(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 0 && ch <= '9'))
			return true;
		else
			return false;

	}

	// to check whether operator or not
	private boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		return false;
	}

	// to check precedence of operator
	private boolean checkPrecedenceOfOperator(char c1, char c2) {
		if ((c2 == '+' || c2 == '-') && (c1 == '+' || c1 == '-')) {
			return true;
		} else if ((c2 == '*' || c2 == '/')
				&& (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/')) {
			return true;
		}

		else {
			return false;
		}
	}

	// function to perform conversion from infix to postfix
	public String convert(String infix) {
		// equivalent postfix is empty initially
		String postfix = "";
		// stack to hold symbols
		Stack<Character> s = new Stack<>();
		// symbol to denote end of stack
		s.push('#');
		for (int i = 0; i < infix.length(); i++) {
			// symbol to be processed
			char inputSymbol = infix.charAt(i);
			if (isOperator(inputSymbol)) {
				while (checkPrecedenceOfOperator(inputSymbol, s.peek())) {
					postfix += s.pop();
				}
				s.push(inputSymbol);
			} else if (inputSymbol == '(') {
				// push if left parenthesis
				s.push(inputSymbol);
				postfix += '(';
			} else if (inputSymbol == ')') {
				// repeatedly pops if right parenthesis until left parenthesis
				// is found

				while (s.peek() != '(') {
					postfix += s.pop();
				}

				postfix += ')';
				s.pop();
			} else {
				postfix += inputSymbol;
			}
		}
		// pops all elements of stack left
		while (s.peek() != '#')// peek
		{
			postfix += s.pop();
		}
		return postfix;
	}

}
