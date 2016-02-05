public class AccountFilterController {
    
    public final Account acc { get; set; }
    public List<String> searchFields { get; private set; }
    public List<Schema.FieldSetMember> searchFields1 { get; private set; }
    public List<Account> accList { get; set; }
    
    private integer totalRecs = 0;
    private integer OffsetSize = 0;
    private integer LimitSize = 10;
    
    /*
public String getBillingCity { get; set; }
public String getBillingState { get; set; }
public String getBillingCountry { get; set; }
*/
    
    public String billingCity {get;set;}
    public String billingState {get;set;}
    public String billingCountry{get;set;}
    
    public AccountFilterController() {
        //acc = new Account();
        
        totalRecs = [select count() from account];
        /*searchFields = new List<String>();
searchFields1 = new List<Schema.FieldSetMember>();

for(Schema.FieldSetMember f : SObjectType.Account.FieldSets.AddressFieldSet.getFields()) {
searchFields.add(f.getFieldPath());
searchFields1.add(f);
}
*/
        //accList = Database.query('SELECT Name, BillingCity, BillingState, BillingCountry FROM Account');
    }
    
    public void fetch() {
        String query = 'SELECT Name, BillingCity, BillingState, BillingCountry FROM Account WHERE ';
        //system.assert(false, billingCity + '***' + billingState  + '$$$' + billingCountry );
        
        if(!String.IsBlank(billingCity)) {
            query += 'BillingCity LIKE \'%' + billingCity + '%\' AND ';
        }
        
        if(!String.IsBlank(billingState)) {
            query += 'BillingState LIKE \'%' + billingState  + '%\' AND ';
        }
        
        if(!String.IsBlank(billingCountry)) {
            query += 'BillingCountry LIKE \'%' + billingCountry + '%\' AND ';
        }
        
        query = query.substring(0, query.length() - 4);
        query += ' LIMIT ' + LimitSize + ' OFFSET ' + OffsetSize;
        
       
        accList = Database.query(query);
        totalRecs = accList.size();
       //system.assert(false, accList.size());
    }
    
    public void FirstPage() {
        OffsetSize = 0;
        fetch();
    }
    
    public void previous() {
        OffsetSize = OffsetSize - LimitSize;
        fetch();
    }
    
    public void next() {
        OffsetSize = OffsetSize + LimitSize;
        fetch();
    }
    
    public void LastPage() {
        OffsetSize = totalrecs - math.mod(totalRecs,LimitSize);
        fetch();
    }
    
    public boolean getprev() {
        if(OffsetSize == 0)
            return true;
        else
            return false;
    }
    
    public boolean getnxt() {
        if((OffsetSize + LimitSize) > totalRecs)
            return true;
        else
            return false;
    }
}