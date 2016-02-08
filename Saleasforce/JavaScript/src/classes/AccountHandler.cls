public class AccountHandler 
{
	public static Account insertNewAccount( String john)
    {

       Account act = new Account (Name=john) ;
     try
       {
        insert act;
       }
        catch(Exception e)
        {
            return null;
        }
         return act;
       }
}