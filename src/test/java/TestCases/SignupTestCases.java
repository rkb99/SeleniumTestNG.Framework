package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import PageObjectModel.SignuppageObjects;
import PageObjectModel.loginpageobjects;
import Resources.Baseclass;
import Resources.Constants;
import Resources.commonMethods;

public class SignupTestCases extends Baseclass{

	@Test
	public void verifySignup() throws IOException, InterruptedException {
	
		
		loginpageobjects lpo=new loginpageobjects(driver);
		lpo.tryForFree().click();
		
		SignuppageObjects spo=new SignuppageObjects(driver);
		
		Thread.sleep(5000);
		spo.enterFirstName().sendKeys(Constants.firstname);
		
		spo.enterLastName().sendKeys(Constants.lastname);
		
		spo.enterJobTitle().sendKeys(Constants.jobtitle);
		
		spo.clickOnNextButton().click();
		  
		commonMethods.selectDropdown(spo.selectEmployees(), 2);
		
		spo.enterCompanyName().sendKeys("test");
		  
		commonMethods.selectDropdown(spo.selectCountry(), 4);
		 // commonMethods.selectDropdownWithVisbleTExt(spo.selectCountry(), "India");
		  spo.clickOnNextButton().click();
		  
		  commonMethods.verifyAssertions(spo.signupPageConfirmation(), Constants.expectedTextSignupText, "Valid signup text is not showing");
		
		
		
	}
	
}
