package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	 SoftAssert softAssert = new SoftAssert();
	
	 @Test (priority = 1, groups = "smoke")  //create new user test@test.com  
	  public void createUser() {
		  System.out.println("I am in home test");
		  System.out.println("Before assertion");
		  Assert.assertTrue(2 > 3, "Verifying Element");  //We use regular Assert in industry, Not soft Assert because we do not want to run the specific test if it is fails.
		  System.out.println("After assertion");
		  Assert.assertEquals("abc", "abc");
	  }
	 
	 @Test (priority = 2, dependsOnMethods = "createUser") //Edit new user test@test.com
	  public void editUser() {
		  System.out.println("Before assertion");
		  softAssert.assertTrue(2 > 3, "Verifing Element");
		  System.out.println("After assertion");
		  softAssert.assertAll();  //Similar to error collector in JUnit.
	  }
	 
	 @Test (priority = 3, dependsOnMethods = "editUser") //Delete new user test@test.com
	  public void deleteUser() {
		 System.out.println("I am in end test");
		 System.out.println("Before Assertion");
		 softAssert.assertTrue(2 > 3, "Verifing Element");
		 System.out.println("After assertion");
		 softAssert.assertEquals("abc", "abc1");
		 System.out.println("After second assert"); 
		 softAssert.assertAll();
		 
	  }
	 
	 //Notes: We have add priorities to run the tests in specific order. and DependendsOnMethods to skip the test if it is dependent upon other test that failed.
}
