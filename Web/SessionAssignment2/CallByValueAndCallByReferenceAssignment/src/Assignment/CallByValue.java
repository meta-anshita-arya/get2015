package Assignment;

/**
 * @author Anshita
 *
 */
class CallByValue{  
	 int data=10;  
	  
	 void change(int data){  
	 data=data+10;//changes will be in the local variable only  
	 }  
	     
	 public static void main(String args[]){  
	   CallByValue callByValue=new CallByValue();  
	  
	   System.out.println("before change "+callByValue.data);  
	   callByValue.change(20);  
	   System.out.println("after change "+callByValue.data);  
	  
	 }  
	}  