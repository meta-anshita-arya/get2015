@isTest
public class TestForHindiTeacherTrigger {
    
    @isTest static void doNotAddHindiTeacher (){
        Contact teacher = new Contact(LastName='Teacher',Subjects__c='Hindi');
        Test.startTest();
        Database.SaveResult result=Database.insert(teacher, false);
        Test.stopTest();
        System.assert(!result.isSuccess());
        System.assert(result.getErrors().size() > 0);
        System.assertEquals('Hindi Teacher is not allowed to insert/update',
                            result.getErrors()[0].getMessage());
        
        
        
    }    
}