@isTest
public class TestContactsForAccount {
     @testSetup static void addCOntacts(){
         Account testAccount= new Account(Name='test');
         insert testAccount;
         Contact testContact = new Contact(LastName='testContact',AccountId= testAccount.Id);
         insert testContact;
         Contact testContact1 = new Contact(LastName='testContact1',AccountId= testAccount.Id);
         insert testContact1;
         Contact testContact2 = new Contact(LastName='testContact3');
         insert testContact2; 
        }
    
    @isTest static void testCheckContactInAccount1() {
        Contact test = [Select Id From Contact  where  LastName = 'testContact'];
        Contact test2 = [Select Id From Contact  where  LastName = 'testContact1'];
        System.debug('********'+test.Id);
        ContactsForAccount.CheckContactInAccount(test.Id);
        Account test1 = [Select Id,ContactIDs__c From Account  where  Name = 'test'];
        String test3 = test.id+','+test2.id;
     	System.assertEquals(test3, test1.ContactIDs__c);
        ContactsForAccount.CheckContactInAccount(test.Id);
     	System.assertEquals(test3, test1.ContactIDs__c);
    }
}