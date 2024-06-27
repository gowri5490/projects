package testCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.BeCognizantHome;

public class TC_02_DropDownValidation extends TC_01_UserDetailValidation
{
	@Test(priority = 1)
	public void dropDownValidation() throws Exception 
	{
		String pageTitel = new BeCognizantHome(driver).getTitel();
		Assert.assertEquals(pageTitel,"Global IT");
	}

}
