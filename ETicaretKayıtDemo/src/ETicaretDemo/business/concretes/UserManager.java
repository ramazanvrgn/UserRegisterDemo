package ETicaretDemo.business.concretes;


import java.util.List;
import java.util.Scanner;

import ETicaretDemo.business.abstracts.UserService;
import ETicaretDemo.dataAccess.abstracts.UserDao;
import ETicaretDemo.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User get(int id) {
		userDao.get(id);
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

	@Override
	public void emailControl(String message) {
		
		System.out.println("Mesaj al�nd�. Mesaj�n�z : "+message);
		System.out.println();
		System.out.print("L�tfen Onaylamak i�in Enter tu�una bas�n: ");
		Scanner onay = new Scanner(System.in);
		 onay.nextLine();
		System.out.println("Do�rulama Ba�ar�l�.");
	}
	

}
