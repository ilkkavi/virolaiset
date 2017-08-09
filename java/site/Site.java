package site;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.sql.SQLException;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import site.index.IndexController;
import site.registration.Registration;
import site.registration.RegistrationController;
import site.registration.RegistrationDao;
import site.util.DB;
import site.util.Filters;
import site.util.Path;
import site.util.ViewUtil;


public class Site {
	
	public static RegistrationDao registrationDao;
	
	public static void main(String[] args) throws SQLException {
		// Instantiate Jetty on port 80
		port(80);
				
		// Instantiate dependencies
		ConnectionSource connectionSource = DB.getConnectionSource();
		registrationDao = DaoManager.createDao(connectionSource, Registration.class);
		
		// Static resource (js, css, images)
		staticFileLocation("public");
		
		// Routes
		get(Path.Web.INDEX,		IndexController.serveIndex);
		post(Path.Web.SUBMIT,	RegistrationController.register);

		
		get("*", ViewUtil.notFound);
		after("*", Filters.addGzipHeader);
	}
}
