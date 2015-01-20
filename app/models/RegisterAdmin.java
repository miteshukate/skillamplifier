package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class RegisterAdmin extends BaseEntity{
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	public Long id;
	
	@OneToOne
	public AppUser appUser;
	
	public String education;
	
	public static Finder<Long,RegisterAdmin> find = new Finder<Long,RegisterAdmin> (Long.class,RegisterAdmin.class);

}

