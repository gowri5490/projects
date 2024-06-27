package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.GlobalITPage;
public class TC_05_PresenceOfAwardsLable extends TC_04_PresenceOfNewsLable
{
	@Test(priority = 4)
	public void presenceOfAwardsLable() throws Exception
	{
		//new BeCognizantHome(driver).goToGlobalIT();
		String newsLable = new GlobalITPage(driver).getLableTextOfAwards();
		Assert.assertEquals(newsLable.contains("IT Awards"),true,"Not found");
	}
}
