package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import models.Answer;
import models.Option;
import models.Question;

import play.Logger;

@SuppressWarnings("serial")
public class QuestionBean implements Serializable {

	public Long id;

	public String questionName;

	public List<String> optionList=new ArrayList<String>();

	public List<String>	answerList=new ArrayList<String>();

	public Question toQuestionEntity(){
		final Question question=new Question();
		if(this.id != null){
			question.Id=this.id;
		}
		if(this.questionName != null){
			question.questionName=this.questionName;
		}

		Logger.debug("option"+this.optionList.size());
		Logger.debug("answer"+this.answerList.size());

		if(this.optionList.size() != 0){
			for (final String option : this.optionList) {
				if(option.compareTo("") != 0){
					final Option option2=new Option();
					option2.optionNumber=this.optionList.indexOf(option);
					option2.optionName=option;
					question.optionList.add(option2);
				}
			}
		}
		if(this.answerList.size() != 0){
			for (final String answer : this.answerList) {
				if(answer.compareTo("") != 0){
					final Answer answer2 = new Answer();
					answer2.answerName=answer;
					question.answerList.add(answer2);
				}
			}
		}


		if(this.questionName != null){
			question.questionName=this.questionName;
		}

		if(this.questionName != null){
			question.questionName=this.questionName;
		}

		return question;
	}
}
