package truthtable;

import java.util.Scanner;
//main class
public class TruthMain {
public static void main(String arg[])
{
	Scanner scanner=new Scanner(System.in);
	TruthTable truthtable = new TruthTable();
	System.out.print("enter expression");
	String input=scanner.next();
	int count=truthtable.countOperand(input);
	int array[][]=truthtable.truthTable(count,input);
	System.out.println("result");
	for(int i=0;i<array.length;i++)//print truth table
	{
		for(int j=0;j<array[i].length;j++)
		{
			System.out.print(array[i][j]+" ");
		}
		System.out.println();
	}
	scanner.close();
}
}
