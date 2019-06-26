package robot.agregator.jobs.pageObjects.Apec;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import robot.agregator.jobs.loaders.MyDriver;
import robot.agregator.jobs.sites.recherche.Offre;

public class ApecPageActions {

	public void setPoste() {
		MyDriver.driver.findElement(By.id(ApecIDs.ID_SearchJob)).sendKeys("testeur logiciel");
	}

	public void setVille() {
		MyDriver.driver.findElements(By.cssSelector(ApecIDs.Search_Where_Class)).get(0).sendKeys("alpes maritimes");
		MyDriver.driver.findElement(By.cssSelector(ApecIDs.Search_Where_Class)).sendKeys(Keys.ENTER);
	}

	public void clickSearch() {
		MyDriver.driver.findElement(By.cssSelector(ApecIDs.Button_Search_Class)).click();
	}
	
	public void filterSearch() {
		MyDriver.driver.findElement(By.cssSelector(ApecIDs.DATE_SORT_BUTTON)).click();
	}

	public List<Offre> recupererOffres() {
		ArrayList<Offre> listeApec = new ArrayList<>();

		for (int i = 0; i < 3; i++) {

			Offre offre = new Offre();
			offre.setLink(getOfferLink(i));
			offre.setLocation(getOfferLocation(i));
			offre.setPublicationDate(getOfferPublicationDate(i));
			offre.setSummary(getOfferSummary(i));
			offre.setTitle(getOfferTitle(i));
			offre.setWebsite("APEC");
		}
		return listeApec;
	
	}
	
	private String getOfferTitle(int i) {
		return MyDriver.driver.findElements(By.cssSelector("offre-title ng-binding")).get(i).getText();
	}

	private String getOfferSummary(int i) {
		return MyDriver.driver.findElements(By.cssSelector("p.detail")).get(i).getText();
	}

	private LocalDate getOfferPublicationDate(int i) {
		String dat = MyDriver.driver.findElements(By.cssSelector("pull-left.offre-date")).get(i).getText();
		LocalDate date = LocalDate.parse(dat);
		return date;
	}

	private String getOfferLocation(int i) {
		return MyDriver.driver.findElement(By.cssSelector(".pull-left span.ng-scope")).getText();
	}

	private String getOfferLink(int i) {
		return MyDriver.driver.findElements(By.cssSelector(".offre-title a")).get(i).getText();
	}

}
