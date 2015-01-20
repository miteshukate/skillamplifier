package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class Candidate extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;

	@OneToOne
	public AppUser appUser;

	@ManyToMany
	public List<Assesment> assesmetntList = new ArrayList<Assesment>();

	public static Model.Finder<Long, Candidate> find = new Finder<Long, Candidate>(Long.class, Candidate.class);

}
