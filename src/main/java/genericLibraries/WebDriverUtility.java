package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the reusable methods of WebDriver
 * @author MUKESH GOWDA
 *
 */
public class WebDriverUtility 
{
	
		private WebDriver driver;
		/**
		 * This method is used to launch the browsers
		 * @return 
		 */
		public WebDriver launchBrowser(String browser)
		{
			
			
			switch(browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				break;
			case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
			default:
			System.out.println("Invalid browser data");
		}
			return driver;
		
}
	/**
	 * This method is used to maximize browser
	 */
		public void maximiseBrowser()
		{
			driver.manage().window().maximize();
		}
	/**
	 * This method is used to navigate to the application via url
	 * @param url
	 */
		
		public void navigateToApp(String url) {
			driver.get(url);
		}
		/**
		 * This method waits until element/elements is found
		 * @param time
		 */
	public void waitUntillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait until the element is displayed
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
	   return wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to wait until element is  enabled
	 * @param element
	 * @param time
	 * @param element 
	 * @param time 
	 * @return
	 */
	public WebElement explicitWait( WebElement element, long time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to wait until the  web page title is displayed
	 * @param time
	 * @param title
	 * @return
	 */
	public Boolean explicitWait(long time, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.titleContains(title));
		
	}
	/**
	 * This method is used to mouseHover to an element
	 * @param element
	 */
	public void mouseHover(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param element
	 */
	public void doubleclickOnElement(WebElement element)
	
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on an element 
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop an element to target
	 * @param element
	 * @param target
	 */
	public void dragAndDrop(WebElement element, WebElement target)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, target).perform();
	}
	/**
	 * This method is used to select an element  from dropdown using index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select an element  from dropdown using value
	 * @param value
	 * @param element
	 */
	public void dropdown(String value, WebElement element)
	{
		Select s= new Select(element);
		s.selectByValue(value);
		
	}
	/**
	 * This method is used to select an element  from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element, String text)
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to scroll till element is found
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	/**
	 * This method is used to switch to frame by using index
	 * @param index
	 */
	
	public void swichToFrame(String index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to frame by using id or name attribute value
	 * @param idOrName
	 */
	
	public void switchToFrame(String idOrName)
	{
		driver.switchTo().frame(idOrName);
		
	}
	/**
	 * This method is used to switch to frame using frame element
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to switch back from frame
	 */
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to capture screenshot of window
	 * @param jUtil
	 */
	
	public void takeScreenshot(JavaUtility jUtil)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("./Screenshot/ss_"+jUtil.getCurrentTime()+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	/**
	 * This method is used to handle alert
	 * @param status
	 */
	public void handleAlert(String status)
	{
		Alert al = driver.switchTo().alert();
		if(status.equalsIgnoreCase("OK"))
			al.accept();
		else
			al.dismiss();
	}
	/**
	 * This method is used to switch to child browser
	 */
	public void switchToChildBrowser()
	{
		Set<String> set=driver.getWindowHandles();
		for (String id : set) 
		{
			driver.switchTo().window(id);
			
			
		}
		
			
	}
	/**
	 * This method is used to close the current browser
	 */
	public void  closeCurrentWindow()
	{
		driver.close();
	}
	/**
	 * 
	
	 * This method is used to exit all the browsers
	 */
	public void quitAllWindows()
	{
		driver.quit();
	}

		
		
	}
	



