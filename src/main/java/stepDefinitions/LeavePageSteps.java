package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.Leave;
import modules.Login;

public class LeavePageSteps extends BaseClass
{
    Login loginModule;
    
    Leave leaveModule;
       	
      
    @Before
    public void setUp()
    {
      System.out.println("Before Hook Method Running....");
    }
    
	@Given("^Login to Orange HRM System$")
	public void openLoginPage() throws Throwable
	{
		initialization();

		loginModule = new Login();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		loginModule.enterCredentials(prop.getProperty("UserName"), prop.getProperty("Password"));
		
		loginModule.login();
				
		leaveModule = new Leave();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

	@When("^click on Apply Leave then apply leave page will open$")
	public void clickOnApplyLeave() throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement home=driver.findElement(By.xpath("//span[contains(text(),'Home')]"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Home')]")));
		
		home.click();	
		
		Thread.sleep(2500);
		
		leaveModule.applyLeave();
	}
	
	@Then("^user will fill Valid \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void applyFullDayLeave(String LeaveTypes, String Fromdate, String Todate) throws Throwable 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Apply')]")));
				
		leaveModule.selectLeaveType(LeaveTypes);
		
		leaveModule.selectDates(Fromdate, Todate);
			
		//leaveModule.selectDuration(duration);				
	}
	
	@And("^click on apply$")
	public void clickOnApply() throws Throwable
	{
		leaveModule.apply();  
	}
	
	@Then("^It will add the Leave$")
	public void addtheLeave() throws Throwable 
	{
		Thread.sleep(1200);
		
        String Message=leaveModule.LeaveMessage();
		
		System.out.println(Message);
		
		leaveModule.ok();	
				
    }
    
	@After
    public void tearDown(Scenario scenario)
    {
      if(scenario.isFailed())
      {
    	  final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    	  
    	  scenario.embed(screenshot, "image/png");
      } 
           
    }
		


}
