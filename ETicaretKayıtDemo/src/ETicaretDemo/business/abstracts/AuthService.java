package ETicaretDemo.business.abstracts;

import ETicaretDemo.entities.concretes.User;

public interface AuthService {
	User register(User user);
	void login(String email,String password);
	boolean userExists(String email);
}
