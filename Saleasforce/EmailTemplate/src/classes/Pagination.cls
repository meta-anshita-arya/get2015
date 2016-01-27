public class Pagination
{
public string BillingCity{get;set;}
private integer totalRecs = 0;
private integer OffsetSize = 0;
private integer LimitSize= 10;
public Pagination()
{
totalRecs = [select count() from account];
}
public List<account> getacclist()
{
    String Query;
     if(string.isBlank(BillingCity)  ) 
      {
           Query = 'SELECT id,name,billingcity,billingCountry,billingState FROM Account';
   	}    
       else
       {
            Query = Query + 'billingcity LIKE \'%'+BillingCity+'%\'';
       
       }
    
    
List<account> acc = Database.Query(Query);
System.debug('Values are ' + acc);
return acc;
}
public void FirstPage()
{
OffsetSize = 0;
}
public void previous()
{
OffsetSize = OffsetSize - LimitSize;
}public void next()
{
OffsetSize = OffsetSize + LimitSize;
}public void LastPage()
{
OffsetSize = totalrecs - math.mod(totalRecs,LimitSize);
}
public boolean getprev()
{
if(OffsetSize == 0)
return true;
else
return false;
}
public boolean getnxt()
{
if((OffsetSize + LimitSize) > totalRecs)
return true;
else
return false;
}
}