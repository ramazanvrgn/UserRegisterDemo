package ETicaretDemo;


import ETicaretDemo.business.abstracts.UserService;
import ETicaretDemo.business.concretes.AuthManager;
import ETicaretDemo.business.concretes.UserManager;
import ETicaretDemo.core.adapters.JGoogleManagerAdapter;
import ETicaretDemo.core.utilities.EmailValidator;
import ETicaretDemo.dataAccess.concretes.AbcUserDao;
import ETicaretDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1,"Aslan","Kahraman","127567","aslan2@gmail.com");
		
		UserService userManager= new UserManager(new AbcUserDao());
		AuthManager auth = new AuthManager(userManager,new EmailValidator(),new JGoogleManagerAdapter());
		auth.register(user);
		auth.login("aslan2@gmail.com", "127567");

	}

}
