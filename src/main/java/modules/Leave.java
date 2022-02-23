package modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class Leave extends BaseClass
{
	public Leave()
	{
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[2]/div[1]/div[1]/dashboard-layout[1]/div[1]/widget-container[1]/div[1]/div[1]/span[1]/span[1]/quick-access-widget[1]/div[1]/div[1]/div[2]/span[1]/div[1]/span[2]/span[3]/div[1]/span[1]/span[1]/img[1]")
	 
	 WebElement ApplyLeave;
	 
	 @FindBy(xpath="//input[@value='-- Select --']")
	 
	 WebElement LeaveType;
	 
	 @FindBy(xpath="//input[@id='from']")
	 
	 WebElement FromDate;
	  
	 @FindBy(xpath="//input[@id='to']")
	 
	 WebElement ToDate;
	 
	 @FindBy(xpath="//textarea[@id='comment']")
	 
	 WebElement Comment;
	 
     @FindBy(xpath="//div[@id='duration_inputfileddiv']")	
     
     WebElement Duration;
     
     @FindBy(xpath="//button[contains(text(),'Apply')]")
     
     WebElement Apply;
     
     @FindBy(xpath="//body/div[@id='application_balance_modal']/div[3]/div[1]/a[1]")
     
     WebElement Ok;
     
     @FindBy(xpath="//body/div[@id='application_balance_modal']/div[2]/div[1]")
     
     WebElement MessageOnLeave;
     
     public void applyLeave()
     {
    	 ApplyLeave.click();    	     
     }
     
     public void selectLeaveType(String LeaveTypes)
     {
    	 LeaveType.click();
    	 
    	 WebElement SelectType=driver.findElement(By.xpath("//span[contains(text(),'"+LeaveTypes+"')]"));
        	 
    	 SelectType.click();
     }
     
     public void selectDates(String Fromdate, String Todate)
     {
    	 FromDate.click();
    	 
    	 FromDate.sendKeys(Fromdate); 
    	 
    	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	     	 
    	 ToDate.click();
    	 
    	 ToDate.clear();
    	 
    	 ToDate.sendKeys(Todate);
     }
     
     public void selectDuration(String duration)
     {
    	
    	WebDriverWait wait = new WebDriverWait(driver,10);
 		
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#duration_inputfileddiv")));
    	     	
    	Duration.click();
    	 
    	WebElement Selectduration=driver.findElement(By.xpath("//span[contains(.,'"+duration+"')]"));
	    
    	Selectduration.click();
    	
    	//ToDate.click();
    	
     }
     
     public void addComment(String comment)
     {
    	 Comment.sendKeys(comment);    	     
     }
     
     public void apply() throws InterruptedException
     {
    	 Thread.sleep(1000);
    	 
    	 Apply.click();    	     
     }
     
     public void ok() throws InterruptedException
     {
    	     	 
    	 Ok.click();
     }
     public String LeaveMessage()
     {
		return MessageOnLeave.getText();
    	 
     }     
        
}
