package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.GlobalITPage;

public class TC_06_NewsToolTipVerification extends TC_05_PresenceOfAwardsLable
{
	@Test(priority = 5)
	public void verificationOfNewsTooltip() throws Exception
	{
		//new BeCognizantHome(driver).goToGlobalIT();
		int mismatchCount = new GlobalITPage(driver).getNumberOfMismatchingTooltip();
		Assert.assertEquals(mismatchCount,0,"Tooltip Mismatch");
	}
}
