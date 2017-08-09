package site.util;

public class Path {
	
	public static class Web {
		public static final String INDEX  = "/";
		public static final String SUBMIT = "/Register/";
		
		public String getINDEX() {return INDEX;}
		public String getSUBMIT() {return SUBMIT;}
	}
	
	public static class Template {
		public static final String INDEX = "index.ftl";
		public static final String NOT_FOUND = "not_found.ftl";
	}
}
