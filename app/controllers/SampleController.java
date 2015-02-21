package controllers;

import models.AppUser;
import play.mvc.Controller;
import play.mvc.Result;

public class SampleController extends Controller {

	
	public static Result createSampleAdmin() {
		
		
		AppUser appuser = new AppUser();
		appuser.email = "admin";
		appuser.password = "123";
		appuser.save();
		return ok("Ok");
		
	}
	
}
