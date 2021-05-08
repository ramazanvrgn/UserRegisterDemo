package ETicaretDemo.business.concretes;


import java.util.List;

import ETicaretDemo.business.abstracts.AuthService;
import ETicaretDemo.business.abstracts.UserService;
import ETicaretDemo.core.adapters.AuthorizationService;
import ETicaretDemo.core.utilities.EmailValidator;
import ETicaretDemo.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;
	private EmailValidator emailValidator;
	private AuthorizationService authorization;

	public AuthManager(UserService userService, EmailValidator emailValidator, AuthorizationService authorization) {
		super();
		this.userService = userService;
		this.emailValidator = emailValidator;
		this.authorization =authorization;
	}

	@Override
	public User register(User user) {

		// kurallarýmýzý bu þekilde belirttim.
		
		boolean result = user.getPassword().length() >= 6 && user.getFirstName().length() >= 2
				&& user.getLastName().length() >= 2 && emailValidator.isEmailValid(user.getEmail());
				
		//kurallar doðruysa içeri girip emailin daha önce kullanýp kullanýlmadýðýný denetleyecek.	
				
		if (result) {
			
			//Email kullanýlmamýþsa kaydý tamamlayýp söz konusu userýn kaydýný gerçekleþtirecek ve mailine doðrulama linki gönderecek
			
			if (userExists(user.getEmail())) {
				
				userService.add(user);
				System.out.println("-----------------------------------------------------------");
				System.out.println("Kullanýcý baþarýlý bir þekilde kaydedildi.");
				
				System.out.println("-----------------------------------------------------------");
				int validationCode= (int) (Math.random() * 100002);
				userService.emailControl("Hesabý Onaylayýnýz. Doðrulama Kodunuz : "+validationCode);
							
				System.out.println("-----------------------------------------------------------");
				authorization.authToSystem(user);
				
				System.out.println("-----------------------------------------------------------");				
				return user;				
				} 
			else
				{
				System.out.println("Bu email daha önce kullanýlmýþtýr.");
				}
		}
		
		System.out.println("Kullanýcý kaydedilemedi. Lütfen formu belirtilen kurallara uygun doldurun");
		return null;

	}

	@Override
	public void login(String email, String password) {

		boolean result = email.length() > 0 && password.length() > 0;

		if (result) {
			for (User users : userService.getAll()) {

				boolean emailCheck = users.getEmail().equals(email) && users.getPassword().equals(password);

				if (emailCheck) {
					System.out.println("Giriþ Baþarýlý.");
					return;
				}

				System.out.println("Giriþ baþarýsýz.");

			}
		}
		
		System.out.println("Email veya password eksik.");
	}

	@Override
	public boolean userExists(String email) {
		List<User> users = userService.getAll();
		if (users!=null) {
			
			for (User us : users) {
				
				if (us.getEmail() == email) {
					return false;
				}
			}
		}		
		return true;
	}

}
