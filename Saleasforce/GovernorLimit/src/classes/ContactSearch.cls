public class ContactSearch 
{
	public static List<Contact> searchForContacts(String lastName, String mailingPostalCode)
    {
        Contact[] techContacts = [SELECT ID,Name
                          FROM Contact WHERE LastName=:lastName AND MailingPostalCode=:mailingPostalCode];
        return techContacts;
    }
}