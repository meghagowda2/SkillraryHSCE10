package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class addPythonToCartTest extends BaseClass 
{
	@Test
	
	public void addPythonToMyCartTest()
	{
		SoftAssert soft = new SoftAssert();
		home.clickGearsTab();
		home.clickSkillraryDemOAppLink();
		web.switchToChildBrowser();
		soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
   demoApp.selectCategory(web,1);
   soft.assertEquals(testing.getPageHeader(),"Testing");
   web.scrollTillElement(testing.getPythonImage());
   web.dragAndDrop(testing.getPythonImage(),testing.getCartArea());
   web.scrollTillElement(testing.getFacebookIcon());
   testing.clickFacebookIcon();
   soft.assertAll();
	}

}
