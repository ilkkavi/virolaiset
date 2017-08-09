package site.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.http.HttpStatus;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

public class ViewUtil {
	
	public static String render(Request request, String templatePath) {
		Map<String,Object> model = new HashMap<String,Object>();
		return render(request, model, templatePath);
	}
	
    public static String render(Request request, Map<String, Object> model, String templatePath) {
        model.put("WebPath", Path.Web.class); // Access application URLs from templates
        String kek = "";
        try {
        	kek = getEngine().render(new ModelAndView(model, templatePath));
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return kek; 
    }
    
    public static Route notFound = (Request request, Response response) -> {
        response.status(HttpStatus.NOT_FOUND_404);
        return render(request, new HashMap<>(), Path.Template.NOT_FOUND);
    };
    
    private static FreeMarkerEngine getEngine() {
    	FreeMarkerEngine configuredEngine = new FreeMarkerEngine();
    	return configuredEngine;
    }
}
