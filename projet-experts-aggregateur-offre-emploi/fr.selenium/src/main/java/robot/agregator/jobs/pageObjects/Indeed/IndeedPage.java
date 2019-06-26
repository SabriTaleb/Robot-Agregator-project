package robot.agregator.jobs.pageObjects.Indeed;

import java.util.List;

import robot.agregator.jobs.constants.JobsWebSites;
import robot.agregator.jobs.loaders.MyDriver;
import robot.agregator.jobs.sites.recherche.Indeed_JobList;
import robot.agregator.jobs.sites.recherche.Offre;

public class IndeedPage {

	// open indeed page
	public IndeedPage() {
		super();
		System.out.println("\n Welcome to Indeed website for job search");
	}

	public static List<Offre> donneMoiLesOffresIndeed() {
		OpenWebSite();
		performanceActions();
		List<Offre> offresIndeed = Indeed_JobList.recupererOffres();
		// performanceChecks();
		MyDriver.quitDriver();
		return offresIndeed;
	}

	public static void OpenWebSite() {
		new MyDriver();
		MyDriver.driver.get(JobsWebSites.INDEED_HOME_PAGE);
	}

	private static void performanceActions() {
		IndeedPageActions actions = new IndeedPageActions();
		actions.setPoste();
		actions.setVille();
		actions.clickSearch();
		actions.filterSearch();
	}

	public static void performanceChecks() {
		IndeedPageChecks check = new IndeedPageChecks();
		// assertEquals();
		System.out.println("if wrong we don't see it");

	}

}
