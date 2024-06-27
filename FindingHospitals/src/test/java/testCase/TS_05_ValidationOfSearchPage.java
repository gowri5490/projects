package testCase;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TS_05_ValidationOfSearchPage extends BaseClass
{

	int i=1;
	List<String> outputs = new ArrayList<String>(); 
	@Test(priority=21)
	public void dropDownVerification() throws Exception
	{
		logger.info("*******TS_05_ValidationOfSearchPage has started*******");
		logger.info("*****TC_21 Dropdown Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		searchElements.profession(occupation);
		logger.info("entered occupation in searchbox");
		searchElements.automateGenderDropdown();
		logger.info("gender selected");
		Thread.sleep(5000);
		searchElements.automatepatientStoriesDropdown();
		logger.info("patient story selected");
		Thread.sleep(5000);
		searchElements.automateExperienceDropdown();
		logger.info("experience selected");
		Thread.sleep(5000);
		String experienceSelectionMsg = searchElements.experienceValidation();
		logger.info("captured experience from the selection");
		searchElements.fees();
		logger.info("fees selected");
		String validateGender = searchElements.genderValidation();
		logger.info("captured gender from the results");
		String validatePatientStories = searchElements.patientStoriesValidation();
		logger.info("captured patient stories from the results");
		String validateExperience = searchElements.experienceValidation();
		logger.info("captured experience from the results");
		System.out.println(validateGender);
		System.out.println(validatePatientStories);
		System.out.println(validateExperience);
		logger.info("displayed the captured values");
		writer.writeText(validateGender);
		writer.writeText(validatePatientStories);
		writer.writeText(validateExperience);
		outputs.add(validateGender);
		outputs.add(validatePatientStories);
		outputs.add(validateExperience);
		capture.captureScreenShot(driver, "/Search/DropDown");
		Assert.assertEquals(experienceSelectionMsg.equals(validateExperience), true);
		logger.info("*****TC_21 Dropdown Validation has been closed*****");
	}

	@Test(priority=22)
	public void professionVerification() throws Exception
	{
		logger.info("*****TC_22 Profession Verification has started*****");
		outputs.add("TEST-CASE-"+i++);
		searchElements.profession(occupation);
		logger.info("entered occupation in searchbox");
		searchElements.automateGenderDropdown();
		logger.info("gender selected");
		Thread.sleep(5000);
		searchElements.automatepatientStoriesDropdown();
		logger.info("patient story selected");
		Thread.sleep(5000);
		searchElements.automateExperienceDropdown();
		logger.info("experience selected");
		Thread.sleep(5000);
		searchElements.fees();
		List<WebElement> prof_list = searchElements.professionVerification();
		logger.info("captured profession from the result list");
        for(WebElement x: prof_list)
        {
        	if(x.getText().equals(occupation))
        	{
        		logger.info("captured profession mathces the searched profession");
        		System.out.print("Profession Matched :");
        		writer.writeText("Profession Matched :");
        		outputs.add("Profession Matched :");
        		System.out.print(x.getText());
        		writer.writeText(x.getText());
        		outputs.add(x.getText());
        		capture.captureScreenShot(driver, "/Search/Verification of search");
        		Assert.assertTrue(true);
        		break;
        	}
        	else
        	{
        		logger.error("captured does not profession mathces the searched profession");
        		System.out.println("Wrong Profession");
        		writer.writeText("Wrong Profession");
        		outputs.add("Wrong Profession");
        		Assert.assertTrue(false);
        	}	
        }
        logger.info("*****TC_22 Profession Verification has been closed*****");
	}

	@Test(priority=23)
	public void professionValidation() throws Exception
	{
		logger.info("*****TC_23 Print Doctor Details has started*****");
		outputs.add("TEST-CASE-"+i++);
		searchElements.profession(occupation);
		logger.info("entered occupation in searchbox");
		List<WebElement> doctorlist = searchElements.printDoctorsDetails();
		logger.info("captures the doctors list from the results");
		int j = 1;
		System.out.println("Doctors List: \n");
		outputs.add("Doctors List: \n");
		writer.writeText("Doctors List: \n");
		for(WebElement a: doctorlist)
		{
			System.out.println(a.getText());
			outputs.add(a.getText());
			writer.writeText(a.getText());
			System.out.println("");
			j++;
			if(j>5)
				break;			
		}
		logger.info("displayed the doctors list");
		capture.captureScreenShot(driver, "/Search/Profession");
		Assert.assertEquals(doctorlist.size()>0, true);
		logger.info("*****TC_23 Print Doctor Details has been closed*****");
	}
	
	@Test(priority=24)
	public void userVerification() throws Exception
	{
		logger.info("*****TC_24 Invalid Search has started*****");
		outputs.add("TEST-CASE-"+i++);
		searchElements.profession("jashkjh");
		logger.info("entered invalid occupation in searchbox");
		String message = searchElements.invalidSearch();
		logger.info("entered invalid occupation in searchbox");
		System.out.println(message);
		outputs.add(message);
		writer.writeText(message);
		capture.captureScreenShot(driver, "/Search/Invalid Search");
		Assert.assertEquals(message.equals("We couldn't find any doctors for you"), true);
		logger.info("*****TC_24 Invalid Search has been closed*****");
	}
	
	@Test(priority=25)
	public void verifyLocation() throws Exception
	{
		logger.info("*****TC_25 Location Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		searchElements.profession(occupation);
		logger.info("entered occupation in searchbox");
		String result = searchElements.matchLocation();
		logger.info("captured the location from the search results");
		System.out.println(result);
		outputs.add(result);
		writer.writeText(result);
		excel.write(outputs, "Test-Scenario-5");
		capture.captureScreenShot(driver, "/Search/Location");
		Assert.assertEquals(result.contains(searchElements.getCities()), true);
		logger.info("*****TC_25 Location Validation has been closed*****");
		logger.info("*******TS_05_ValidationOfSearchPage has been closed*******");
	}


}
