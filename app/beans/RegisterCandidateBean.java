package beans;

import java.io.Serializable;

import models.AppUser;
import models.Candidate;
import models.Role;

public class RegisterCandidateBean implements Serializable {


	public String name;

	public String email;

	public String password;

	public String mobileNo;

	public Role role;

	public String education;


	public AppUser toAppUser(){
		final AppUser appUser = new AppUser();

		if(this.name != null){
			appUser.name = this.name;
		}

		if(this.email != null){
			appUser.email = this.email;
		}

		if(this.password != null){
			appUser.password = this.password;
		}

		if(this.mobileNo != null){
			appUser.mobileNo = this.mobileNo;
		}

		if(this.role != null){
			appUser.role = this.role;
		}
		return appUser;
	}

	public Candidate toCandidate(){
		final Candidate candidate = new Candidate();

		candidate.appUser=this.toAppUser();
		candidate.appUser.save();
		return candidate;

	}
}
