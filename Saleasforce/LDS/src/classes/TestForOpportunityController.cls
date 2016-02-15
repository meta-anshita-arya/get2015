@isTest(seeAllData=false)
private class TestForOpportunityController {
    public  static Opportunity o;
    public  static Date day ;
    @testSetup static void methodName() {
        
        
        day= date.newInstance(1990, 11, 21);
        Account acct = new Account(Name='Test Account');
        insert acct;
        Contact con = new Contact(FirstName='Test Account',LastName='vdfvj');
        insert con;
        o=new Opportunity(Name='abc',BillToContact__c=con.Id,AccountId=acct.Id,StageName='rvrgbv',CloseDate=day);
        insert o;
    }
    static testMethod void testForOpportunityTrigger() {
       
        // Verification
        Test.startTest();
        System.assertEquals('0012800000EKV94',o.Manager__c);
        
        Test.stopTest();
    }
    
}