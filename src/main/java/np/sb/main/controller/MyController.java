package np.sb.main.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import np.sb.main.entity.User;
import np.sb.main.service.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user){
		
		
		 return userservice.addDetail(user);
	}
	
	
	@GetMapping("/user")
	public List<User> getUser(){
		
		List<User> user=userservice.getDetail();
		return user;
		
		
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable int id){
		
		User user= userservice.GetUser(id).orElse(null);
		if(user!=null) {
			
			return ResponseEntity.ok().body(user);
		}
		
		else {
			
			return ResponseEntity.notFound().build();
		}
	
	}
	
	
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
		
		
		User newUpdate=userservice.updateUser(id, user);
		
		if(newUpdate!=null) {
			
			return ResponseEntity.ok(newUpdate);
			
		}
		
		else {
			
			return ResponseEntity.notFound().build();
			
		}
	}
	
	
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id) {
		
		boolean status=userservice.DeleteUser(id);
		if(status==true) {
			return "Data Deleted Successfully:::";
		}
		else {
			
			return "Data doesn't found!!!";
		}

		
	}
	
}
