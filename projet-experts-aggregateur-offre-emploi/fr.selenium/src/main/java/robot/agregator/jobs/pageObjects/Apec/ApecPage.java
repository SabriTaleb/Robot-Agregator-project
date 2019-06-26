package robot.agregator.jobs.pageObjects.Apec;

import java.util.List;

import robot.agregator.jobs.constants.JobsWebSites;
import robot.agregator.jobs.loaders.MyDriver;
import robot.agregator.jobs.sites.recherche.Offre;

public class ApecPage {

	private static final String APEC_PAGE = "";

	// open apec page
	public ApecPage() {
		super();
		System.out.println("Welcome to APEC website for job search");
	}

	public static List<Offre> donneMoiLesOffresApec() {
		new MyDriver();
		MyDriver.driver.get(JobsWebSites.APEC_HOME_PAGE);
		List<Offre> apecOffres = performActions();
		MyDriver.quitDriver();
		return apecOffres;
	}

	private static List<Offre> performActions() {
		ApecPageActions actions = new ApecPageActions();
		actions.setPoste();
		actions.setVille();
		actions.filterSearch();
		return actions.recupererOffres();
	}

	public static void performanceChecks() {
		ApecPageChecks check = new ApecPageChecks();
		// assertEquals();
		System.out.println("if wrong we don't see it");
	}

}
