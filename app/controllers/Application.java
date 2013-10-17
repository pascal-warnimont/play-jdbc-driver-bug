package controllers;

import play.Logger;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
  
    public static Result index() {
    	try {
    		DB.getDataSource().getConnection();
			//DB.getConnection();
		} catch (Exception e) {
			Logger.error("", e);
		}
        return ok(index.render("Your new application is ready."));
    }
  
}
