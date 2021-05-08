package ETicaretDemo.dataAccess.abstracts;


import java.util.List;

import ETicaretDemo.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	User get(int id);
	List<User> getAll();
}
