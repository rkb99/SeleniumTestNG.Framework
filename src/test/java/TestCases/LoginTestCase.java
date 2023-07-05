package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.loginpageobjects;
import Resources.Baseclass;
import Resources.Constants;
import Resources.commonMethods;

public class LoginTestCase extends Baseclass{
	
	@Test(dataProvider="testData")
	public void verifyLogin(String username, String password) throws IOException {
		
		
		loginpageobjects lpo=new loginpageobjects(driver);
		
		lpo.enterUsername().sendKeys(username);
		lpo.enterPassword().sendKeys(password);
		lpo.clickOnLogin().click();
		
		commonMethods.verifyAssertions(lpo.errorMessage(), Constants.expectedTextErrorMSg, "Valid Error message is not showing");
		  
	 }
	 
	 
	 //object is class--   
	 //Object[][]-  is return type of dataprovider
	 @DataProvider
	 public Object[][] testData() {   //testData() - is dataprovider name
	  Object[][] data=new Object[3][2]; //create the object of object class
	  data[0][0]=Constants.username1; //1st username
	  data[0][1]=Constants.password1;// 1st password
	  data[1][0]=Constants.username2; //2nd username
	  data[1][1]=Constants.password2; //2nd password
	  data[2][0]=Constants.username3; //3rd username
	  data[2][1]=Constants.password3;  //3rd password
	  
	  return data;
	  
	 }
	 
	 
	 
	 

	 
	 
	 
	 
	 

	 

	}
		
	
	
	