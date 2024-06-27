package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.BeCognizantHome;
import testBase.BaseClass;

public class TC_01_UserDetailValidation extends BaseClass
{
	
	@Test(priority=0)
	public void userVerification() throws Exception
	{
		String mail = new BeCognizantHome(driver).getUserDetails();
		Assert.assertEquals(mail.contains("@cognizant.com"), true," Not A Cognizant User");
	}
}
