package pomClases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class contains elements and respective libraries of selenium training  page
 * @author MUKESH GOWDA
 *
 */
public class SeleniumTrainingPage 
{
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	@FindBy(id="quantity")
	private WebElement quantity;
	@FindBy(id="add")
	private WebElement plusButton;
	@FindBy(xpath="//button[@ondblclick='addtocart()']")
 private WebElement addToCartButton;
	@FindBy(xpath="//div[@class='callout callout-success']/span")
	private WebElement itemAddedMessage;
	
	//Initialization
	
	public SeleniumTrainingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	/**
	 * This method returns page header
	 * @return
	 */
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	/**
	 * This method is used to fetch the quantity of product
	 * @return 
	 */
    public String getQuantity()
    {
    	return quantity.getAttribute("value");
    			
    }
    /**
     * This method is used to double click on plus button
     * @param web
     */
    
    public void doubleClickPlusButton(WebDriverUtility web)
    {
    	web.doubleclickOnElement(plusButton);
    }
    /**
     * This method is used to click on add to cart button
     */
    public void clickAddToCart()
    {
    	addToCartButton.click();
    }
    /**
     * This method is used to fetch item added message
     * @return
     */
    
    public String getItemAddedMessage()
    {
    	return itemAddedMessage.getText();
    }
}


