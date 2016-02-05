public class RandomContactFactory {
   public static List<Contact> generateRandomContacts( Integer numContacts, String name) {
       List<Contact> con = new List<Contact>();
       for(Integer i=0;i<numContacts;i++) {
           Contact c = new Contact(FirstName ='Test' + i, LastName = name);
           con.add(c);
       }
return con;
   }
}