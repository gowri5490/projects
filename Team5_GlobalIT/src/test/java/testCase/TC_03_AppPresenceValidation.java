package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.GlobalITPage;

public class TC_03_AppPresenceValidation extends TC_02_DropDownValidation
{
	@Test(priority = 2)
	public void appVerification() throws Exception 
	{
		//new BeCognizantHome(driver).goToGlobalIT();
		String[] apps = new GlobalITPage(driver).getAppName();
		Assert.assertEquals( apps.length>0 , true , "No Apps found" );
	}
}
