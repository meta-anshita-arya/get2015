@isTest
public class TestRestrictContactByName {
	@isTest
    public static void test1(){
        Contact con=new Contact(LastName='INVAIDNAME');
        Contact con1=new Contact(LastName='INVALIDNAME');
       
        Test.startTest();
        Database.SaveResult result = Database.insert(con, false);
        Database.SaveResult result1 = Database.insert(con1, false);
        Test.stopTest();
        
        System.assert(result.isSuccess());
        System.assert(!result1.isSuccess());



        
    }
}