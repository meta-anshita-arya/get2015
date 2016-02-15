trigger MaxLimit on Student__c (before insert) {
 Set<String> setOfClassId = new Set<String>();
  for(student__C student :Trigger.new)
  {
     setOfClassId.add(student.Class__c);
  }
   
  for(Class__c classToCheck : [Select id,NumberOfStudents__c,MaxSize__c from class__c where id IN :setOfClassId]){
      if(classToCheck.NumberOfStudents__c >= classToCheck.MaxSize__c){
          setOfClassId.remove(classToCheck.id);
      }
   }
    for(student__C student :Trigger.new)
        
 	{
        if(!setOfClassId.contains(student.Class__c)){
         student.addError('Cannot insert more student. Class max size limit exceeded.');
        }
    }    
}