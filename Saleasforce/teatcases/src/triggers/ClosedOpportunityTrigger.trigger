trigger ClosedOpportunityTrigger on Opportunity (after insert,before update) {
   List<Task> taskList = new List<Task>();
   for(Opportunity opp : Trigger.new) {
       if(opp.StageName == 'Closed Won') {
           Task myTask = new Task();
           myTask.Subject = 'Follow Up Test Task';
           myTask.WhatId = opp.Id;
           taskList.add(myTask);
       }
   }
   if(taskList.size() > 0) {
       insert taskList;
   }
}