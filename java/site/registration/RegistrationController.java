package site.registration;

import org.apache.commons.lang3.StringUtils;

import site.Site;
import site.util.Security;
import spark.Request;
import spark.Response;
import spark.Route;
import site.util.Logging;

public class RegistrationController {
	
	public static Route register = (Request request, Response response) -> {
		
		String names = request.queryParams("names");
		String email = request.queryParams("email");
		String password = request.queryParams("password");
		int vegetarians = Integer.valueOf(request.queryParams("vegetarians"));
		int vegans = Integer.valueOf(request.queryParams("vegans"));
		int lactos = Integer.valueOf(request.queryParams("lactos"));
		String allergies = request.queryParams("allergies");
		String message = request.queryParams("message");
		
		String data = String.format("{Names: %s | Email: %s | Password: %s | Vegetarians: %d | Vegans: %d | Lacto: %d | Allergies: %s | Message: %s}",
									 names, email, password, vegetarians, vegans, lactos, allergies, message);
		Logging.log("Received form submission: " + data);
		
		// Data OK?
		if (validSubmission(names, email, vegetarians, vegans, lactos, allergies, message)) {
			// Password correct?
			if (Security.validatePassword(password)) {
				Registration newRegistration = new Registration(names, email, vegetarians, vegans, lactos, allergies, message);
				try {
					int id = Site.registrationDao.create(newRegistration);
					response.status(200);
					Logging.log("RESULT - OK!");
					return Integer.toString(id);
				}
				catch(Exception ex) {
					ex.printStackTrace();
					Logging.log("RESULT - database error!");
					response.status(500);
					return "Tapahtui virhe yhdistettessä tietokantaan.";
				}
			}
			else {
				Logging.log("RESULT - invalid passcode: " + password);
				response.status(403);
				return "Väärä koodisana.";
			}
		}
		else {
			response.status(400);
			Logging.log("RESULT - blank name or invalid range on numeric input!");
			return "Lomakkeen täytössä on virhe. Tarkista, että ilmoittautuneiden nimet on täytetty ja lukumääräkenttien arvot ovat oikeellisia.";
		}
	};
	
	private static boolean validSubmission(String name, String email, int veg, int vegan, int lacto, String allergies, String message) {
		boolean valid = !StringUtils.isBlank(name) && validRange(veg, vegan, lacto);
		return valid;
	}
	
	private static boolean validRange(int... input) {
		for (int i : input) {
			if (i < 0 || i > 10)
				return false;
		}
		return true;
		
	}
}
