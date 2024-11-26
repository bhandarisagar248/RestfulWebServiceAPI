package np.sb.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.sb.main.entity.User;
import np.sb.main.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService {
	
	@Autowired
	private UserRepository userrepo;

	@Override
	public User addDetail(User user){
		
		
	try {
		 return userrepo.save(user);
		
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	
		
	}

	@Override
	public List<User> getDetail() {
		
		List<User> user =userrepo.findAll();
		return user;
	}

	@Override
	public Optional<User> GetUser(int id) {
		
		try {
			Optional<User> user=userrepo.findById(id);
					return user;
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public User updateUser(int id,User newUser){
		
		User user=userrepo.findById(id).orElse(null);
		
		if(user!=null) {
			return userrepo.save(newUser);
              		
		
		}
		else {
			
			throw new RuntimeException("Data doesn't found");
		}
	}

	@Override
	public boolean DeleteUser(int id){
		
		
		User user=userrepo.findById(id).orElse(null);
		if(user!=null) {
			
		userrepo.deleteById(id);
			return true;
		}
		
		else {
			
			
			return false;
		}
		
	}

}
