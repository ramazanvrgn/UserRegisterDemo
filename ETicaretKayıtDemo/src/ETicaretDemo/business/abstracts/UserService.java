package ETicaretDemo.business.abstracts;


import java.util.List;

import ETicaretDemo.entities.concretes.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(User user);
	void emailControl(String message);
	User get(int id);
	List<User> getAll();
}
