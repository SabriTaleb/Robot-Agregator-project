package robot.agregator.jobs.pageObjects.Indeed;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import robot.agregator.jobs.loaders.MyDriver;

public class IndeedPageActions {

	
	public void setPoste() {
		MyDriver.driver.findElement(By.id(Indeed_IDs.ID_SearchJob)).sendKeys("testeur logiciel");
	}

	public void setVille() {
		MyDriver.driver.findElement(By.id(Indeed_IDs.ID_SearchWhere)).sendKeys((Keys.chord(Keys.CONTROL, "a")));
		MyDriver.driver.findElement(By.id(Indeed_IDs.ID_SearchWhere)).sendKeys("Alpes Maritimes");
	}

	public void clickSearch() {
		MyDriver.driver.findElement(By.id(Indeed_IDs.ID_SearchWhere)).sendKeys(Keys.ENTER);
	}
	
	public void filterSearch() {
		MyDriver.driver.findElement(By.partialLinkText("date")).click();
	}
}
