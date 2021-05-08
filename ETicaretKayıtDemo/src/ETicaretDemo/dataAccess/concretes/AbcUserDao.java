package ETicaretDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ETicaretDemo.dataAccess.abstracts.UserDao;
import ETicaretDemo.entities.concretes.User;

public class AbcUserDao implements UserDao {

	 List<User> users = new ArrayList<User>();
	@Override
	public void add(User user) {
		this.users.add(user); 
		System.out.println(user.getFirstName() +" kullan�c�s� eklendi");
		
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() +" kullan�c�s� g�ncellendi.");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName() +" kullan�c�s� silindi.");
		
	}

	@Override
	public User get(int id) {
		
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> newUser= users;
		return newUser;
	}
	
	
}
