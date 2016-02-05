trigger ExampleTrigger on Contact (after insert, after delete) {
    if (Trigger.isInsert) {
        Integer recordCount = Trigger.New.size();
        // Call a utility method from another class
        EmailManager.sendMail('anshita.arya@metacube.com', 'Trailhead Trigger Tutorial',' contact(s) were inserted.');
    }
    else if (Trigger.isDelete) {
        // Process after delete
    }
}