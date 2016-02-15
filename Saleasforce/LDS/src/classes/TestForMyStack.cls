@IsTest
public class TestForMyStack  {
   @isTest static void testPushMethod(){
      MyStack test=new MyStack();
       test.push(new Account(Name='abc'));
       Account TestAcc = (Account)test.peek();
       system.assertEquals('abc',TestAcc.Name);
       
      }
    @isTest static void testPopMethod(){
       MyStack test=new MyStack();
       test.push(new Account(Name='abc'));
       Account TestAcc = (Account)test.pop();
       system.assertEquals('abc',TestAcc.Name);
    }
   
   @isTest static void testNullPopMethod(){
       MyStack test=new MyStack();
       Account TestAcc = (Account)test.pop();
       system.assertEquals(null,TestAcc);    
      }
        
   @isTest static void testNullPeekMethod(){
       MyStack test=new MyStack();
       Account TestAcc = (Account)test.peek();
       system.assertEquals(null,TestAcc); 
      }
}