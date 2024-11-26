package np.sb.main.service;

import java.util.List;
import java.util.Optional;

import np.sb.main.entity.User;

public interface UserService {

	public User addDetail(User user);
	public List<User> getDetail();
	public Optional<User> GetUser(int id);
	
	public User updateUser(int id,User newUser);
	
	public boolean DeleteUser(int id);
}
