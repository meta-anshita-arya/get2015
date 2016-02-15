@isTest
public class testForTrigger6 {

    @testSetup static void opportunityTest(){
            Date date1=Date.newInstance(1960, 3, 17);
          Product2 product=new Product2(Name='prd1',price__c=2000,IsActive = true);
       
        insert product;
 System.debug(product);
          Id pricebookId = Test.getStandardPricebookId();
        PricebookEntry pbEntry= new PricebookEntry(Product2Id=product.Id,UnitPrice=7687, Pricebook2Id=pricebookId,IsActive = true);
        
        insert pbEntry;
      System.debug(pbEntry);
        Opportunity opp=new Opportunity(Name='opp',CloseDate=date1,StageName='Prospecting',Pricebook2Id=pbEntry.Pricebook2Id);

        insert opp; 
        System.debug(opp);
         List<OpportunityLineItem> oppNewP=new List<OpportunityLineItem>();
        oppNewP=[Select Id from OpportunityLineItem where OpportunityId=: opp.Id];
        System.debug('Hghfghgf'+ oppNewP);
    }
    @isTest static void checkOpportunityLineItem(){
        Opportunity opp1=[Select id,Custom_status__c from Opportunity where Name='opp'];
        System.debug(opp1);
        test.startTest();
        opp1.Custom_Status__c='Reset';
         Database.SaveResult result=database.update(opp1,false);
        List<OpportunityLineItem> oppNew=new List<OpportunityLineItem>();
        oppNew=[Select Id from OpportunityLineItem where OpportunityId=: opp1.Id];
       System.assertEquals(0,oppNew.size());
        test.stopTest();
        
        
        
        
        
    }   
    
}