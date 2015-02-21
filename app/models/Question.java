package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;
@SuppressWarnings("serial")
@Entity
public class Question extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long Id;

	@Column(columnDefinition="TEXT")
	public String questionName;

	@OneToMany(cascade=CascadeType.ALL)
	public List<Option> optionList = new ArrayList<Option>();

	@OneToMany(cascade=CascadeType.ALL)
	public List<Answer> answerList = new ArrayList<Answer>();
	
	
	public Date createdDate;
	
	
	public AppUser CreatedBy;
		
	public QuestionType questionType;

	public static Model.Finder<Long, Question> find = new Finder<Long, Question>(Long.class, Question.class);

}
