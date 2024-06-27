package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.GlobalITPage;

public class TC_04_PresenceOfNewsLable extends TC_03_AppPresenceValidation
{
	@Test(priority = 3)
	public void presenceOfNewsLable() throws Exception
	{
		//new BeCognizantHome(driver).goToGlobalIT();
		String newsLable = new GlobalITPage(driver).getLableTextOfNews();
		Assert.assertEquals(newsLable,"IT News","Not found");
	}
}
