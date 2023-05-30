package pomClases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains elements locators and respective business libraries of contact us page
 * @author MUKESH GOWDA
 *
 */
public class ContactUsPage 
{
	//Declaration
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement logo;
	
	@FindBy(name="name")
	private WebElement fullNameTF;
	@FindBy(name="sender")
	private WebElement emailTF;
	 @FindBy(name="subject")
	 private WebElement subjectTF;
	 
	 @FindBy(name="message")
	 private WebElement messageBox;
	 
	 @FindBy(xpath="//button[text()='Send us mail']")
	 private WebElement sendUsEmailButton;
	 
	 
	//Initialization
		
		public ContactUsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		/**
		 * This method returns logo
		 * @return
		 */
       public WebElement getLogo() 
       {
	      return logo;
        }
       /**
        * This  method is used to send the contact details
        * @param name
        * @param subject
        * @param email
        * @param message
        */
       public  void sendDetails(String FullName, String Email, String Subject, String Message)
       {
    	   fullNameTF.sendKeys(FullName);
    	   emailTF.sendKeys(Email);
    	   subjectTF.sendKeys(Subject);
    	   messageBox.sendKeys(Message);
    	   sendUsEmailButton.click();;
    	   
       }
}
