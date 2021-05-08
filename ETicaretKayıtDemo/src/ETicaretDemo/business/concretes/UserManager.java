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
		
		System.out.println("Mesaj alýndý. Mesajýnýz : "+message);
		System.out.println();
		System.out.print("Lütfen Onaylamak için Enter tuþuna basýn: ");
		Scanner onay = new Scanner(System.in);
		 onay.nextLine();
		System.out.println("Doðrulama Baþarýlý.");
	}
	

}
