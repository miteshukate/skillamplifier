package controllers;

import java.util.List;

import models.AppUser;
import models.Role;
import beans.LoginBean;

import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import utils.Constants;

public class LoginController extends Controller{

	public static final Form<LoginBean> loginForm = Form.form(LoginBean.class);

	public static Result login(){
		return ok(views.html.login.render(loginForm));
	}

	public static Result processLogin(){
		Logger.debug("ENTERD");

		final Form<LoginBean> filledForm = loginForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.login.render(filledForm));
		}
		else {
			final LoginBean loginBean = filledForm.get();
			final List<AppUser> appUsers = AppUser.find.where().eq("email", loginBean.email).eq("password", loginBean.password).findList();
			if(appUsers.size() < 1) {
				Logger.error("Invalid username/password");
				return badRequest(views.html.login.render(filledForm));
			}
			if(appUsers.size() == 1) {
				session().clear();
				session(Constants.LOGGED_IN_USER_ID, appUsers.get(0).id + "");
				session(Constants.LOGGED_IN_USER_ROLE, appUsers.get(0).role+ "");
				if(appUsers.get(0).role.equals(Role.CANDIDATE)){
					return ok(views.html.candidate.dashboard.render());
				}else{
					/*if(appUsers.get(0).role.equals(Role.ADMIN) || appUsers.get(0).role.equals(Role.ADMIN_MANAGER)){
					}*/
					return ok("Admin Logged In");
				}

			}
			if(appUsers.size() > 1) {
				session().clear();
				session(Constants.LOGGED_IN_USER_ID, appUsers.get(0).id + "");
				session(Constants.LOGGED_IN_USER_ROLE, appUsers.get(0).role+ "");
				Logger.info("more than one users exists with same email and passowrd");
				return redirect("/");
			}
			return null;
		}

	}

	//@BasicAuth
	public static Result processLogout() {
		session().clear();
		return redirect("/");
	}

	public static AppUser getLoggedInUser() {
		final String idStr = session(Constants.LOGGED_IN_USER_ID);
		return AppUser.find.byId(Long.parseLong(idStr));
	}

	public static Boolean isLoggedIn() {
		return session(Constants.LOGGED_IN_USER_ID) == null ? false : true;
	}

	public static String getLoggedInUserRole() {
		return session(Constants.LOGGED_IN_USER_ROLE);
	}

}
