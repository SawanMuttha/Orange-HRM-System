package stepDefinitions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.Login;

public class LoginPageSteps extends BaseClass
{
	Login loginModule;
	
	@Before
    public void setUp()
    {
      System.out.println("Before Hook Method Running....");
    }
     			
	@Given("^Open the Login Page of Orange HRM$")
	public void openLoginPage() throws Throwable
	{
		initialization();

		loginModule = new Login();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@When("^Enter Valid UserName and Password$")
	public void enterValidCredentials() throws Throwable
	{
		loginModule.enterCredentials(prop.getProperty("UserName"), prop.getProperty("Password"));
	}
	
	@And("^Click on Login Button$")
	public void clickOnLoginButton() throws Throwable
	{
		loginModule.login();
	}
	
	@Then("^It Will Display the DashBoard of Orange HRM System$")
	public void dashBoardPage() throws Throwable
	{
		String ActualURL = driver.getCurrentUrl();
		
		String ExpectedURL = prop.getProperty("DashBoardPage");

		Assert.assertEquals(ExpectedURL, ActualURL);
		
		System.out.println("User Logged In Successfully");
	}
	
	@When("^Click on Forgot Password Link$")
	public void clickOnForgotPasswordLink() throws Throwable
	{
		loginModule.forgotPasswordLink();
	}
	
	@Then("^It Will Display the Forgot Password Page of Orange HRM System$")
	public void forgotPasswordPage() throws Throwable
	{
	  int i=driver.findElements(By.xpath("//h1[contains(text(),'Forgot Your Password?')]")).size();
	  
	  if(i==0)
	  {
		  Assert.fail("Forgot Password Link is Not Working");
	  } 
	  else
	  {
		  System.out.println("Forgot Password Link is Working - Test Case is Pass");
	  } 
		
	}
	
	@And("^Click on Cancel Button$")
	public void clickOnCancelButton() throws Throwable
	{
		loginModule.forgotPasswordCancel();
	}
	
	@Then("^It Will Display the Login Page of Orange HRM System$")
	public void loginPage() throws Throwable
	{
        String ActualURL = driver.getCurrentUrl();
		
		String ExpectedURL = prop.getProperty("LoginPageurl");

		Assert.assertEquals(ExpectedURL, ActualURL);
		
		System.out.println("User Logged In Successfully");		
	}
	

	@When("^User Click on Login Button$")
	public void clickLoginButton() throws Throwable
	{
		loginModule.clickLogin();
	}
	
	@Then("^UserName Field will Show the Validation Message$")
	public void usernameValidationMessage() throws Throwable 
	{
		 WebElement UserNameMessage=driver.findElement(By.xpath("//span[@id='txtUsername-error']"));
		 if(UserNameMessage.isDisplayed())
		 {
			 System.out.println("UserName Validation is Showing - Test Case is Pass");
			 
			 System.out.println("Validation of UserName is "+ loginModule.userNameMessage());
		 } 
		 else
		 {
			 Assert.fail("UserName Validation is Not Showing - Test Case is Fail");
		 } 
	}
	
	@Then("^Password Field will Show the Validation Message$")
	public void passwordValidationMessage() throws Throwable
	{
		WebElement PasswordMessage=driver.findElement(By.xpath("//span[@id='txtPassword-error']"));
		if(PasswordMessage.isDisplayed())
		{
			 System.out.println("Password Validation is Showing - Test Case is Pass");
			 
			 System.out.println("Validation of Password is "+ loginModule.passwordMessage());
		 } 
		 else
		 {
			 Assert.fail("Password Validation is Not Showing - Test Case is Fail");
		 } 
	}
	

	@When("^User Click on LinkedIn Icon$")
	public void ClickOnLinkedInIcon() throws Throwable
	{
		loginModule.linkedin();
	}
	
	@Then("^OrangeHRM LinkedIn Page Will be Open$")
	public void verifyLinkedInPage() throws Throwable
	{
      loginModule.windowHandels();
      
	  String ExpectedURL=prop.getProperty("LinkedIn");
		    
	  String ActualURL=driver.getCurrentUrl();
		    
	  Assert.assertEquals(ActualURL, ExpectedURL);	
	}
	
	@When("^User Click on Facebook Icon$")
	public void ClickOnFacebookIcon() throws Throwable 
	{
		loginModule.facebook();
	}
	
	@Then("^OrangeHRM Facebook Page Will be Open$")
	public void verifyFacebookPage() throws Throwable
	{
		loginModule.windowHandels();
		
	    String ExpectedURL=prop.getProperty("Facebook");
	    
	    String ActualURL=driver.getCurrentUrl();
	    
	    Assert.assertEquals(ActualURL, ExpectedURL);	    
	}
	
	@When("^User Click on Twitter Icon$")
	public void ClickOnTwitterIcon() throws Throwable 
	{
		loginModule.twitter();
	}
	
	@Then("^OrangeHRM Twitter Page Will be Open$")
	public void verifyTwitterPage() throws Throwable 
	{
		loginModule.windowHandels();
		
		String ExpectedURL=prop.getProperty("Twitter");
	    
	    String ActualURL=driver.getCurrentUrl();
			    
		Assert.assertEquals(ActualURL, ExpectedURL);	
	}
	

	@When("^User Click on Youtube Icon$")
	public void ClickOnYoutubeIcon() throws Throwable 
	{
		loginModule.youtube();
	}
	
	@Then("^OrangeHRM Youtube Page Will be Open$")
	public void verifyYoutubePage() throws Throwable 
	{
		loginModule.windowHandels();
		
        String ExpectedURL=prop.getProperty("Youtube");
	    
	    String ActualURL=driver.getCurrentUrl();
			    
		Assert.assertEquals(ActualURL, ExpectedURL);	
	}
		
	@After
    public void tearDown(Scenario scenario) throws InterruptedException
    {
      if(scenario.isFailed())
      {
    	  final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    	  
    	  scenario.embed(screenshot, "image/png");
      } 
      
      Thread.sleep(2000);
      
      driver.quit();     
     
    }
		

}
