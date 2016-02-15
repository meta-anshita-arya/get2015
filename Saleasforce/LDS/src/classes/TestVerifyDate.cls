@isTest
private class TestVerifyDate {
@isTest static void DateWithin30Daysif() {
    Date date1=Date.newInstance(1960, 3, 17);
    Date date2=Date.newInstance(1960, 1, 15);
    Date date4=Date.newInstance(1960, 3, 31);
    Date date3=VerifyDate.CheckDates(date1, date2);
       System.assertEquals(date4,date3);
   }
   
 @isTest static void DateWithin30Days2() {
    Date date1=Date.newInstance(1960, 3, 17);
    Date date2=Date.newInstance(1960, 5, 15);
    Date date4=Date.newInstance(1960, 3, 31);
    Date date3=VerifyDate.CheckDates(date1, date2);
       System.assertEquals(date4,date3);
   }
   
   @isTest static void DateWithin30Days3() {
    Date date1=Date.newInstance(1960, 3, 17);
    Date date2=Date.newInstance(1960, 3, 20);
   
    Date date3=VerifyDate.CheckDates(date1, date2);
       System.assertEquals(date2,date3);
   }
}