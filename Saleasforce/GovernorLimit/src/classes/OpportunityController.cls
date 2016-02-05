public class OpportunityController {

    public static void populateInOpportunity(List<Opportunity> oppList) {
     
        for(Opportunity opp:oppList){
           
              
                if(opp.BillToContact__c != null && opp.Manager__c == null)
                {
                    opp.Manager__c =opp.AccountId;
                }
          
            
        }
     
    }
}