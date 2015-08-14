package anshitaarya;

import java.util.Scanner;

public class RemoveDuplicateNum {
	public static int[] removeDuplicates(int[] duplicate) {
		int length = duplicate.length;
		int i, j, m = 1, count;

		int[] dup = new int[length];
		dup[0] = duplicate[0];
		for (i = 1; i < length; i++) {
			count = 0;
			for (j = 0; j < i; j++) {
				if (duplicate[i] == dup[j])

				{
					count++;
				}
			}
			if (count == 0) {
				dup[m] = duplicate[i];
				m++;
			}
		}

		return dup;
	}

	public static void main(String args[]) {
		RemoveDuplicateNum obj = new RemoveDuplicateNum();
		Scanner in = new Scanner(System.in);
		System.out.println("enter lenght of array");
		int length = in.nextInt();
		int[] duplicate = new int[length];
		int loop;
		System.out.println("enter elements of array");
		for (loop = 0; loop < length; loop++) {
			duplicate[loop] = in.nextInt();
		}

		int[] output = obj.removeDuplicates(duplicate);
		for (int i = 0; i < 8; i++) {
			System.out.print(output[i]);
		}
	}
}
