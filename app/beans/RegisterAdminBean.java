package beans;

import java.io.Serializable;

import models.RegisterAdmin;
import models.Role;
import models.AppUser;

@SuppressWarnings("serial")
public class RegisterAdminBean implements Serializable{
	
	public String name;
	
	public String email;
	
	public String password;
	
	public String mobileNo;
	
	public Role role;
	
	public String education;
	
	
	public AppUser toAppUser(){
		AppUser appUser = new AppUser();
		
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
	
	public RegisterAdmin toRegisterAdmin(){
		RegisterAdmin registerAdmin = new RegisterAdmin();
		
		if(this.education != null){
			registerAdmin.education = this.education;
		}
		
		return registerAdmin;
		
	}

}
