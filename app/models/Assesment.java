package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
@SuppressWarnings("serial")
public class Assesment extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;

	public Date startdate;

	public Date stopdate;

	public int  totalQestions;

	public int attempted;

	public int correct;

	public String Status;

	@ManyToMany(cascade=CascadeType.ALL)
	public List<Question> questionList = new ArrayList<Question>();

	public static Model.Finder<Long, Assesment> find = new Finder<Long, Assesment>(Long.class, Assesment.class);

}
