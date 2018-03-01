package com.pbc.goyou.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.pbc.goyou.entity.User;
import com.pbc.goyou.model.FormResetPasswordModel;
import com.pbc.goyou.model.FormUserAddModel;
import com.pbc.goyou.model.FormUserAdminModel;
import com.pbc.goyou.model.LoginResetPasswordModel;



public interface UserService extends UserDetailsService {

	public HashMap<String, Object> getUsersByUsernameOrName(Pageable pageable, String username);
	

	public HashMap<String, Object> getAllUsers(Pageable pageable); 

	public FormUserAdminModel saveUser(FormUserAdminModel saveUser);
	
	public FormUserAddModel addUser(FormUserAddModel newUser);
	
	public void removeUser(String username);
	
	public FormResetPasswordModel resetPassword(FormResetPasswordModel resetPasswordModel);
	
	public User getUser (String username);
	
	public abstract User addUser(User user);
	
	public LoginResetPasswordModel saveNewPassword(LoginResetPasswordModel resetPasswordModel);

}
