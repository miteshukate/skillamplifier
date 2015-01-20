package controllers;

import java.util.List;
import java.util.Map;

import models.Question;
import beans.QuestionBean;

import play.Logger;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

import service.FileProcess;

public class QuestionController extends Controller {

	public static Form<QuestionBean> questionform = Form.form(QuestionBean.class);

	/**
	 * @author Mitesh
	 * Action to display a form to be filled to enter a question and the its option and it's answer
	 * GET /question-form
	 */
	public static Result displayFillQuestionForm() {

		return ok(views.html.question.fillQuestion.render(questionform));

	}

	/**
	 * @author Mitesh
	 * Action to process a form that  been filled to enter a question and the its option and it's answer
	 * and save to data base
	 *POST /process-question
	 */
	public static Result processQuestionForm() {
		final Form<QuestionBean> filledQForm = questionform.bindFromRequest();
		final Map<String, List<ValidationError>> map=filledQForm.errors();


		if(filledQForm.hasErrors()){
			return ok(views.html.question.fillQuestion.render(questionform));
		}
		final Question question=filledQForm.get().toQuestionEntity();

		question.save();
		return ok("saved to data base");

	}


	/**
	 * @author Mitesh
	 * Action to display a form where a user can upload a file filled with Question
	 *GET /display-fileupload-form
	 */
	public static Result displayFileUploadForm() {

		return ok(views.html.question.uploadQuestionFile.render());
	}

	/**
	 * @author Mitesh
	 * Action to process a file been uploaded
	 *POST	/process-file
	 */
	public static Result processFile() {
		final MultipartFormData md=request().body().asMultipartFormData();

		List<FilePart>file;

		file=md.getFiles();

		for(final FilePart p: file){
			Logger.info(p.getFilename());
		}

		FileProcess.processXltoDB(file.get(0).getFile());

		return ok(file.get(0).getFilename());

	}

	/**
	 * @author Mitesh
	 * Action to display a random genrated question
	 *GET	/display-question
	 */
	public static Result getQuestion() {
		return ok(views.html.question.questionForm.render());
	}
}
