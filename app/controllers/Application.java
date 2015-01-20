package controllers;

import models.AppUser;
import models.RegisterAdmin;
import beans.RegisterAdminBean;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	public static final Form<RegisterAdminBean>	registerForm = Form.form(RegisterAdminBean.class);
	public static Result index() {
		return ok(views.html.index.render("Your new application is ready. Now ok!"));

	}
	public static Result landingPage() {
		return ok(views.html.landingPage.render());
	}

	public static Result registerAdmin(){
		return ok(views.html.registerAdmin.render(registerForm));
	}
	public static Result registerAdminProccess(){
		final Form<RegisterAdminBean> filledForm = registerForm.bindFromRequest();

		if(filledForm.hasErrors()){
			return badRequest(views.html.registerAdmin.render(filledForm));
		}else{
			/*	final RegisterAdmin registerAdmin = filledForm.toRegisterAdmin();
			Logger.info("emailc: "+registerAdmin.email);
			registerAdmin.save();*/
			return TODO;
		}


	}

}
