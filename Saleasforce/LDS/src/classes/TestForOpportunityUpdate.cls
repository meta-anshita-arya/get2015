@isTest
public class TestForOpportunityUpdate {
    @isTest static void opportunityUpdateOnStatusChange(){
        Date date1=Date.newInstance(1960, 3, 17);
        date date2;
        Opportunity opp=new Opportunity(Name='TestOpp',CloseDate=date1,StageName='Prospecting');
        insert opp;
        Date dateOpp=date.today();
        Test.startTest();
        opp.StageName='Closed Lost';
        
        Database.SaveResult result=database.update(opp,false);
        Opportunity oppNew=[Select CloseDate from Opportunity where Name='TestOpp'];
        
        date2=oppNew.CloseDate;
        System.debug(dateOpp);
        System.debug(date2);
        System.assertEquals(dateOpp, date2);
        
        Test.stopTest();
        
        
        System.assert(result.isSuccess());
        
        
    }
}