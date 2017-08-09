package site.index;

import site.util.Path;
import site.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;;

public class IndexController {
	public static Route serveIndex = (Request req, Response res) -> {
		// Fill model here if necessary
		return ViewUtil.render(req, Path.Template.INDEX);
	};
}
