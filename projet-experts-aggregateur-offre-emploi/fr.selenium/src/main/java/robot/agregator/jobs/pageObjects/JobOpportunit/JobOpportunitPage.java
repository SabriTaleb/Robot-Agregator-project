package robot.agregator.jobs.pageObjects.JobOpportunit;

import java.util.List;

import robot.agregator.jobs.constants.JobsWebSites;
import robot.agregator.jobs.loaders.MyDriver;
import robot.agregator.jobs.pageObjects.Apec.ApecPageChecks;
import robot.agregator.jobs.sites.recherche.JobOpportunit_JobList;
import robot.agregator.jobs.sites.recherche.Offre;

public class JobOpportunitPage {

	public static List<Offre> donneMoiLesOffresJobOpp() {
		OpenWebSite();
		performanceActions();
		List<Offre> offres = JobOpportunit_JobList.recupererOffres();
		// performanceChecks();
		MyDriver.quitDriver();
		return offres;

	}

	private static void performanceActions() {
		JobOpportunitPageActions actions = new JobOpportunitPageActions();
		actions.SearchChoice();
		actions.clickSearchButton();
		// actions.clickSearch();
	}

	public static void performanceChecks() {
		ApecPageChecks check = new ApecPageChecks();
		// assertEquals();
		System.out.println("if wrong we don't see it");
	}

	public static void OpenWebSite() {
		new MyDriver();
		MyDriver.driver.get(JobsWebSites.JOBOPPORTUNIT_HOME_PAGE);
	}

}
