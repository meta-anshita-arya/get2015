@isTest
public class TestClassController {
    @testSetup static void addClass(){
        Class__c testClass = new Class__c(Name__c = 'tenth',MaxSize__c=3);
        insert testClass;
        Student__c std = new Student__c(Name = 'abc' , LastName__c = 'aaa', Class__c = testClass.Id);
        insert std;
    }
    
    @isTest static void testStudentsList() {
        Class__c test = [Select Id From Class__c  where  Name__c = 'tenth'];
        List<String> testList =  ClassController.getStudentList(test.Id);
        System.assertEquals(1, testList.size());
    }
    
    @isTest static void testgetMapOfClass() {
        System.assertEquals(1,  ClassController.getMapOfClass().size());
    }
         
    @isTest static void testgetWorkingDays() {
        Date date1=Date.newInstance(2016, 1, 6);
        Date date2=Date.newInstance(2016, 1, 8);
     	System.assertEquals(3,ClassController.getWorkingDays(date1, date2));
       }
   
}