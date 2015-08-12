import java.util.Scanner;

// program of tower of hanoi
public class hanoi {
	
	private static Scanner in;
    String a="";
    
	 public static void main(String[] args) {
		 
		 in = new Scanner(System.in);                         //input number of disks
		 System.out.println("enter number of disk");
		 int a= in.nextInt();
		 hanoi obj=new hanoi();
		 String b= obj.towerofhanoi(a, "A","B","C");           //calling function to implement tower of hanoi
		 System.out.println(b);
	}
	 
	 
	 //function of tower of hanoi
	 String towerofhanoi(int n,String from, String other, String to )
	 {
		 
		 if (n == 0)                                            //check whether number of disk is greater than 0 or not
	           return "empty ";
		 
	        if (n > 0)
	        	towerofhanoi(n-1, from, to, other);             //recursive call of function
	        
	        a=a+"move"+" "+n+" from"+" "+from+" to"+" "+to+",";
	        towerofhanoi(n-1, other, from, to);                  //recursive call of function
	        return a;
	 }
}
