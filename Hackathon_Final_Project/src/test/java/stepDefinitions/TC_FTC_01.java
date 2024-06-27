package stepDefinitions;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.WebDevPage;

public class TC_FTC_01 {
	
	
	HomePage hp = new HomePage(BaseClass.getDriver());
	WebDevPage wdp = new WebDevPage(BaseClass.getDriver());

	@Given("Search for {string}")
	public void search_for(String string) throws InterruptedException {
		
		hp.searchCourse(string);
		hp.clickSearchButton();
	}

	@Given("Select the required check box")
	public void select_the_required_check_box() throws InterruptedException {
		
		wdp.clickEnglishCheckBox();
		wdp.clickBeginnerCheckBox();

	}

	@Then("Click the first course")
	public void click_the_first_course() throws InterruptedException {

		wdp.clickFirstCourse();
		
	}

	@Then("The first course page should be opened")
	public void the_first_course_page_should_be_opened() {
		
		Assert.assertEquals(hp.checkSearchPage(), true);

	}
}
