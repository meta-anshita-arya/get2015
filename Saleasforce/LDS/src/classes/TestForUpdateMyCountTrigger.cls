@isTest
public class TestForUpdateMyCountTrigger {
    
    @isTest static void donotAddStudentMoreThanMaxSize(){
        Class__c class1=new Class__c(Name__c='Fourth',MaxSize__c=0,MyCount__c=0);
        insert class1;
        Student__c student1= new Student__c(LastName__c='Stud',Class__c=class1.Id);
        Test.startTest();
        
        Database.SaveResult result=Database.insert(student1, false);
        Test.stopTest();
        System.assert(!result.isSuccess());
        System.assert(result.getErrors().size() > 0);
        System.assertEquals('Class Size Limit Reached. Cannot Add More Students.',
                            result.getErrors()[0].getMessage());
    }    
}