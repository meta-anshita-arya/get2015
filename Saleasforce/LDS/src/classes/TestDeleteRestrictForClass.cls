@isTest
public class TestDeleteRestrictForClass {
    @isTest static void doNotAllowDeleteClassHavingFemaleStudents(){
        Class__c class1=new Class__c(Name__c='Fourth',MaxSize__c=40,MyCount__c=0);
        system.debug(class1);
        insert class1;
        Student__c student1= new Student__c(LastName__c='Stud',Class__c=class1.Id,Sex__c='Female');
        insert student1;
        Student__c student2= new Student__c(LastName__c='Stud1',Class__c=class1.Id,Sex__c='Female');
        insert student2;
        
        test.startTest();
        Database.DeleteResult result = Database.delete(class1, false);
        Test.stopTest();
        System.assert(!result.isSuccess());
        System.assert(result.getErrors().size() > 0);
        System.assertEquals('Cannot delete a Class having more than female 1 female student',
                            result.getErrors()[0].getMessage());
        
        
    } 
}