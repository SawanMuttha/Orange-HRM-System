package modules;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Login extends BaseClass
{
    
	public Login()
	{
		PageFactory.initElements(driver, this);
	}
 
	  @FindBy(id="txtUsername")
	  WebElement UserName;
	  
	  @FindBy(id="txtPassword")
	  WebElement Password;
	  
	  @FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/button[1]")
	  WebElement LoginBtn;
	  
	  @FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	  WebElement ForgotPassword;
	  
	  @FindBy(id="securityAuthentication_userName")
	  WebElement OrangeHRMUsername;
	  
	  @FindBy(id="btnSearchValues")
	  WebElement ResetPassword;
	  
	  @FindBy(id="btnCancel")
	  WebElement Cancel;
	  
	  @FindBy(xpath="//input[@id='txtUsername']")
	  WebElement RetryUserName;
	  
	  @FindBy(xpath="//input[@id='txtPassword']")
	  WebElement RetryPassword;
	  
	  @FindBy(xpath="//button[@id='btnLogin']")
	  WebElement RetryLogin;
	  
	  @FindBy(xpath="//span[@id='txtUsername-error']")
	  WebElement UserNameValidation;
	  
	  @FindBy(xpath="//span[@id='txtPassword-error']")
	  WebElement PasswordValidation;  
	  
	  @FindBy(xpath="//body/div[@id='wrapper']/div[@id='content']/div[2]/div[2]/a[1]/img[1]")
	  
	  WebElement LinkedIn;
	  
      @FindBy(xpath="//body/div[@id='wrapper']/div[@id='content']/div[2]/div[2]/a[2]/img[1]")
	  
	  WebElement Facebook;
      
      @FindBy(xpath="//body/div[@id='wrapper']/div[@id='content']/div[2]/div[2]/a[3]/img[1]")
      
      WebElement Twitter;
      
      @FindBy(xpath="//body/div[@id='wrapper']/div[@id='content']/div[2]/div[2]/a[4]/img[1]")
      
      WebElement YouTube;
  
	  public void enterCredentials(String username, String password)
	  {
		  UserName.sendKeys(username);
		  
		  Password.sendKeys(password);
	  }
	  
	  public void login()
	  {
		  LoginBtn.click();
		  
		  int i=driver.findElements(By.xpath("//div[contains(text(),'Retry Login')]")).size();
		  
		  if(i==1)
		  {
			  RetryUserName.sendKeys(prop.getProperty("UserName"));
			  
			  RetryPassword.sendKeys(prop.getProperty("Password"));
			  
			  RetryLogin.click();
		  }	 
		  else
		  {
			  System.out.println("Dashboard is Showing - Test Case is Pass");
		  } 
	  }
	  
	  public void forgotPasswordLink()
	  {
		  ForgotPassword.click();
	  }
	  
	  public void forgotPasswordCancel()
	  {
		  Cancel.click(); 	  
	  }
	  
	  public void resetPasswordButton()
	  {
		  ResetPassword.click();
	  }
	  
	  public void enterUserNameToResetPassword()
	  {
		  OrangeHRMUsername.click();
	  }
	  
	  public void clickLogin()
	  {
		  LoginBtn.click();
	  }
	  
	  public String userNameMessage()
	  {
		  return UserNameValidation.getText();
	  }
	  
	  public String passwordMessage()
	  {
		  return PasswordValidation.getText();
	  }
	  
	  public void linkedin()
	  {
		  LinkedIn.click();
	  }
      
	  public void facebook()
	  {
		  Facebook.click();
	  }
	  
	  public void twitter()
	  {
		  Twitter.click();
	  }
	  
	  public void youtube()
	  {
		  YouTube.click();
	  }
	  
	  public void windowHandels()
	  {
	      String currentHandle= driver.getWindowHandle();
			
			Set<String> handles=driver.getWindowHandles();
			for(String actual: handles)
			{
			if(!actual.equalsIgnoreCase(currentHandle)) 
			{		
			  driver.switchTo().window(actual); 
			}
			}	
	  }
  	
}
