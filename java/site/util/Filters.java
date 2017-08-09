package site.util;

import spark.Filter;
import spark.Request;
import spark.Response;

public class Filters {
    public static Filter addGzipHeader = (Request request, Response response) -> {
        response.header("Content-Encoding", "gzip");
    };
}
