package controllers;

import models.Candidate;
import beans.RegisterCandidateBean;

import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

	public static final Form<RegisterCandidateBean>	registerForm = Form.form(RegisterCandidateBean.class);

	/**
	 * @author Mitesh
	 * Action to display Candidate registration Form
	 * GET /register/candidate
	 */
	public static Result registerCandidate(){
		return ok(views.html.candidate.candidateRegistration.render(registerForm));
	}

	public static Result processCandidateRegister() {
		final Form<RegisterCandidateBean> filledForm = registerForm.bindFromRequest();

		if(filledForm.hasErrors()){
			Logger.error("redirect");
			return ok(views.html.candidate.candidateRegistration.render(registerForm));
		}else{
			final Candidate	candidate = filledForm.get().toCandidate();
			candidate.save();
			return ok(views.html.candidate.dashboard.render());
		}
	}

}
