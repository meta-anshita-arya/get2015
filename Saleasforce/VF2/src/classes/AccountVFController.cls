public class AccountVFController {

   public string BillingCity{get;set;}
   public string BillingState{get;set;}
   public string BillingCountry{get;set;}

   public List<Account> createAccountList{get;set;}

   public void searchRecords(){
       createAccountList= new list<Account>();
       string Query = 'SELECT id,name,billingcity,billingCountry,billingState FROM Account where ';
       if(string.isBlank(BillingCity)  && string.isBlank(BillingState) && string.isBlank(BillingCountry)) 
      {
           Query = 'SELECT id,name,billingcity,billingCountry,billingState FROM Account';
   	}    
       if(!(string.isBlank(BillingCity)))
       {
            Query = Query + 'billingcity LIKE \'%'+BillingCity+'%\' AND ';
       
       }
       if(!(string.isBlank(BillingCountry)))
       {
           Query = Query + ' billingcountry  LIKE  \'%'+BillingCountry+'%\' AND ';
       }
       if(!(string.isBlank(BillingState)))
       {
         Query = Query +  ' billingstate LIKE  \'%'+BillingState+'%\' AND ';
       }
       if(Query.substring(Query.length()-4,Query.length()).equals('AND '))
       {
       Query= Query.substring(0,Query.length()-4);
       }
       Query = Query + ' limit 100';
       createAccountList= Database.query(Query);                  
   }
}