package Hibernatecustomizespringboot.Hibernatecustomize.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Hibernatecustomizespringboot.Hibernatecustomize.domain.User;
import Hibernatecustomizespringboot.Hibernatecustomize.reposatory.UserReposatory;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserReposatory userReposatory;
	
	public void setUserReposatory(UserReposatory userReposatory) {
		this.userReposatory = userReposatory;
	}

	public User save(User user){
		 return userReposatory.save(user);
	}
	
	public List<User> getAllUsers() {
		return userReposatory.getAllUsers();
	}
	
	public User getUser(long id) {
		return userReposatory.getUser(id);
	}
	
	public void updateUser(User updateUser,long id) {
		userReposatory.updateUser(updateUser, id);
	}
	
	public void deleteUser(long id) {
		userReposatory.deleteUser(id);
	}
	
	public List<User> getAllUsersByCriteria() {
		return userReposatory.getAllUsersByCriteria();
	}
	
	public List<User> getAllUsersByName(String name) {
		return userReposatory.getAllUsersByName(name);
	}
	
}
