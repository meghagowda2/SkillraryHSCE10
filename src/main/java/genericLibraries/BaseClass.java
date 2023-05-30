package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomClases.ContactUsPage;
import pomClases.SeleniumTrainingPage;
import pomClases.SkillraryDemoAppPage;
import pomClases.SkillraryHomePage;
import pomClases.TestingPage;

public class BaseClass
{
	protected ProprtiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	 protected SeleniumTrainingPage selenium;
	 protected TestingPage testing;
	 protected ContactUsPage  contact;
	 
	
	
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfiguration()
	{
		property=new ProprtiesUtility();
		excel=new ExcelUtility();
		jutil = new JavaUtility();
		web=new WebDriverUtility();
		property.propertiesInIt(IConstantPath.PROPERTIES_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
	}
	@BeforeMethod
	public void methodConfiguration()
	{
		driver= web.launchBrowser(property.readDataFromProperties("browser"));
		web.maximiseBrowser();
		web.navigateToApp(property.readDataFromProperties("url"));
		web.waitUntillElementFound(Long.parseLong(property.readDataFromProperties("time")));
		
		home = new SkillraryHomePage(driver);
		demoApp=new SkillraryDemoAppPage(driver);
		selenium = new SeleniumTrainingPage(driver);
		testing = new TestingPage(driver);
		contact= new ContactUsPage(driver);
		home.chooseEnglish();
	}
		@AfterMethod
		public void methodTearDown()
		{
			web.quitAllWindows();
		}
		@AfterClass
		public void ClassTearDown()
		{
			excel.closeExcel();
		}

//@AfterTest
//AfterSuite


}
