package robot.agregator.jobs.sites.recherche;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import robot.agregator.jobs.loaders.MyDriver;

public class JobOpportunit_JobList {

	public static ArrayList<Offre> listeJobOppIt = new ArrayList<>();

	public static List<Offre> recupererOffres() {

		for (int i = 0; i < 2; i++) {
			List<WebElement> jobs = MyDriver.driver
					.findElements(By.partialLinkText("\"https://www.jobopportunit.com/"));
			List<WebElement> jobTitle = MyDriver.driver.findElements(By.cssSelector(".job-title"));
			List<WebElement> jobSummary = MyDriver.driver.findElements(By.cssSelector(".job-title"));
			List<WebElement> jobLocation = MyDriver.driver.findElements(By.cssSelector(".job-city"));
			List<WebElement> jobDate = MyDriver.driver.findElements(By.cssSelector(".job-date.timeago"));

			String link = " ";
			String title = jobTitle.get(i).getAttribute("title").toLowerCase();
			String summary = jobSummary.get(i).getText();
			String location = jobLocation.get(i).getText();

			// récuperer la date sur le site
			String publicationDate = jobDate.get(i).getText();

			// spliter le texte pour ne récuperer que le chiffre
			String[] b = publicationDate.split(" ");
			String datepub = b[3];

			// transformer la date en long pour la soustraire à la date du jour
			long datepubli = Long.parseLong(datepub);
			LocalDate datpub = null;

			switch (b[4]) {
			case "minutes":
				datpub = LocalDate.now();
				break;

			case "heures":
				datpub = LocalDate.now();
				break;

			case "jours":
				datpub = LocalDate.now().minusDays(datepubli);
				break;

			case "mois":
				datepubli = datepubli * 30;
				datpub = LocalDate.now().minusDays(datepubli);
				break;
			}

			// condition de filtre des offres
			// if (title.contains("testeur")) {

			Offre offre = new Offre(title, link, summary, location, datpub, "JOB_OPPORUTINITY");

			listeJobOppIt.add(offre);
			// }

		}
		for (Offre offre : listeJobOppIt) {

			System.out.println(offre);
		}

		return listeJobOppIt;
	}

}
