@isTest
public class TestForJsonController {

    @testSetup static void addAccount(){
        Account testAccount= new Account(Name='test');
     insert testAccount;
    }
   
    
       @isTest static void testCheckContactInAccount1() {
           
     List<Account> acct = [Select Id,Name From Account LIMIT 5];
     String jsonText = JSON.serializePretty(acct);
     System.debug(jsonText+'-------------------------------gffffffffffffffffffffffffj');
         JSonController.parseJson();
    System.debug(JSonController.text1);
           System.assertEquals(jsonText, JSonController.text1);
       }
}