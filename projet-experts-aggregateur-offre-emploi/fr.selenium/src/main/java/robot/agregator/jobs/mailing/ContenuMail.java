package robot.agregator.jobs.mailing;

import java.util.List;

import robot.agregator.jobs.sites.recherche.Offre;

public class ContenuMail {

	public static final String SUBJECT = "Dernières offres d'emploi";
//	public static final String TEXT = "Bonjour,\n Voici les dernières offres d'emploi : \n\n INDEED \n"
//			+ Indeed_JobList.listeIndeed + "\n*******\n\n APEC \n\n" + Apec_JobList.listeApec
//			+ "\n*******\n\n Job Opportun IT\n\n" + JobOpportunit_JobList.listeJobOppIt
//			+ "\n\nCordialement,\n\n l'équipe des experts";
	public static final String DESTINATAIRES = "sabri.taleb@outlook.com";
	public static final String COPYDEST = "expertprojet2019@gmail.com";

	public static String getBody(List<Offre> toutesLesOffres) {
		String body = "Bonjour,\n Voici les dernières offres d'emploi :";
		for (Offre offre : toutesLesOffres) {
			body = body + offre;
		}

		return body;
	}
	//"dalia@logilune.com,sabri.taleb@outlook.com,nawrassmn@gmail.com,allogo9@yahoo.fr";
}
