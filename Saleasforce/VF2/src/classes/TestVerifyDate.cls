@isTest
public class TestVerifyDate {
	@isTest static void testWarmTemp() {
        date date1 = date.newInstance(1983, 7, 15);
        date date2 = date.newInstance(1983, 7, 18);
       date re=  VerifyDate.CheckDates(date1,date2);
        System.assertEquals(date2,re);
    }
    @isTest static void testWarmTemp1() {
        date date1 = date.newInstance(1983, 7, 15);
        date date2 = date.newInstance(1983, 8, 18);
         date date3 = date.newInstance(1983, 7, 31);
       date re=  VerifyDate.CheckDates(date1,date2);
        System.assertEquals(date3,re);
    }
}