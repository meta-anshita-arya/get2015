//Program to find occurrence of elements in a string
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ConcordanceOfCharacters {

	int k = 0;
	Set<Character> setA = new HashSet<Character>();
	String input;
	int length;
	String storeIndex;
	String result[];

	// constructor to initialize input string and its length
	public ConcordanceOfCharacters(String input, int length) {
		this.input = input;
		this.length = length;
		result = new String[length];
	}

	// to create set of unique characters
	void setUniqueCharacters() {
		for (int i = 0; i < length; i++) {
			setA.add(input.charAt(i));
		}
	}

	// to perform concordance
	void concordance() {
		Iterator<Character> itr = setA.iterator();
		while (itr.hasNext()) {
			char element = (char) (itr.next());
			storeIndex = "";
			for (int i = 0; i < length; i++) {
				char tempCharacter = (input.charAt(i));
				if (element == tempCharacter) {
					storeIndex = storeIndex + " " + i;
				}
			}
			result[k] = storeIndex;
			k++;
		}
	}

	//to display
	void print() {
		Iterator<Character> itr1 = setA.iterator();
		while (itr1.hasNext()) {
			for (int i = 0; i < k; i++) {
				char element = itr1.next();
				System.out.println(element + "=[" + result[i] + "]");
			}
		}

	}

}
