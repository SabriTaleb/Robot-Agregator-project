package robot.agregator.jobs.pageObjects.JobOpportunit;

import org.openqa.selenium.By;

import robot.agregator.jobs.loaders.MyDriver;

public class JobOpportunitPageActions {

	protected void SearchChoice() {

		MyDriver.driver.findElement(By.className(JobOpportunit_IDs.Class_JO_SearchText)).sendKeys("testeur");
	}

	protected void clickSearchButton() {
		MyDriver.driver.findElement(By.className(JobOpportunit_IDs.Class_JO_SearchButton)).click();
	}

}
