package prg2;
//to perform allotment function
public class Allotment {

	CollegeList obj = new CollegeList();
	
	//returns 0 if not alloted, 1 if alotted, -1 for wrong input
	int allotToStudent(int choice, String Name){
		
		int result;
		switch (choice){
		case 1:
			result=obj.MLV(Name);
			return result;
			
		case 2:
			result=obj.MIT(Name);
			return result;
			
		case 3:
			result=obj.JCERC(Name);
			return result;
			
		case 4:
			result=obj.ARYA(Name);
			return result;
			
		case 5:
			result=obj.TINJR(Name);
			return result;
			
		default:
			System.out.println("invalid input");
				result=-1;
				return result;
			
		}
		
		
	}
}
