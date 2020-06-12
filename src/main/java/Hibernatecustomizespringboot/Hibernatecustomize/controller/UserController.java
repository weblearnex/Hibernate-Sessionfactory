package Hibernatecustomizespringboot.Hibernatecustomize.controller;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Hibernatecustomizespringboot.Hibernatecustomize.domain.User;
import Hibernatecustomizespringboot.Hibernatecustomize.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}


	@PostMapping("/save")
	public User save(@RequestBody User user){
		System.out.println(user.getName());
		return userService.save(user);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable(value="id")long id) {
		return userService.getUser(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateUser(@RequestBody User updateUser,@PathVariable(value="id")long id) {
		userService.updateUser(updateUser, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(value="id")long id) {
		 userService.deleteUser(id);
	}
	
	@GetMapping("/allUsersByCriteria")
	public List<User> getAllUsersByCriteria() {
		return userService.getAllUsersByCriteria();
	}
	
	@GetMapping("/name/{name}")
	public List<User> getAllUsersByName(@PathVariable(value="name")String name) {
		return userService.getAllUsersByName(name);
	}

}
