package np.sb.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import np.sb.main.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
User findByEmail(String email);

}
