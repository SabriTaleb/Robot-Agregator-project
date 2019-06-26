package robot.agregator.jobs.app;

import java.util.ArrayList;
import java.util.List;

import robot.agregator.jobs.loaders.MyDriver;
import robot.agregator.jobs.mailing.ContenuMail;
import robot.agregator.jobs.mailing.Mailing;
import robot.agregator.jobs.pageObjects.Apec.ApecPage;
import robot.agregator.jobs.pageObjects.Indeed.IndeedPage;
import robot.agregator.jobs.pageObjects.JobOpportunit.JobOpportunitPage;
import robot.agregator.jobs.sites.recherche.Offre;

// classe permettant de lancer le robot
public class App {

	public static void main(String[] args) {

		List<Offre> toutesLesOffres = new ArrayList<>();
		// INDEED //
		toutesLesOffres.addAll(IndeedPage.donneMoiLesOffresIndeed());

		// APEC //
		try {
		toutesLesOffres.addAll(ApecPage.donneMoiLesOffresApec());
		}
		catch (Exception e) {
			System.out.println("Pas possible de récupérer offres APEC");
			MyDriver.quitDriver();
		}
		// JobOpportun IT
		toutesLesOffres.addAll(JobOpportunitPage.donneMoiLesOffresJobOpp());

		// action pour l'envoi de mail groupé avec les offres
		Mailing.sendMessage(ContenuMail.SUBJECT, ContenuMail.getBody(toutesLesOffres), ContenuMail.DESTINATAIRES,
			ContenuMail.COPYDEST);
		System.out.println(toutesLesOffres);
		MyDriver.quitDriver();

	}

//	public static void pause(int seconds) {
//		try {
//			Thread.sleep(seconds * 1000);
//		} catch (InterruptedException ex) {
//			Thread.currentThread().interrupt();
//		}
//	}
}
