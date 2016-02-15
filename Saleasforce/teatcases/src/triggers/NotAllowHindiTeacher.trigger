trigger NotAllowHindiTeacher on Contact (before insert,before update) {
       for(Contact contact : Trigger.new)
   {
       if(contact.Subjects__c.Contains('Hindi'))
       {
           contact.addError('Not allowed hindi teacher');
       }
   }
}