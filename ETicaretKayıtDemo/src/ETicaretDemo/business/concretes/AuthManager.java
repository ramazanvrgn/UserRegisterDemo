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

		// kurallar�m�z� bu �ekilde belirttim.
		
		boolean result = user.getPassword().length() >= 6 && user.getFirstName().length() >= 2
				&& user.getLastName().length() >= 2 && emailValidator.isEmailValid(user.getEmail());
				
		//kurallar do�ruysa i�eri girip emailin daha �nce kullan�p kullan�lmad���n� denetleyecek.	
				
		if (result) {
			
			//Email kullan�lmam��sa kayd� tamamlay�p s�z konusu user�n kayd�n� ger�ekle�tirecek ve mailine do�rulama linki g�nderecek
			
			if (userExists(user.getEmail())) {
				
				userService.add(user);
				System.out.println("-----------------------------------------------------------");
				System.out.println("Kullan�c� ba�ar�l� bir �ekilde kaydedildi.");
				
				System.out.println("-----------------------------------------------------------");
				int validationCode= (int) (Math.random() * 100002);
				userService.emailControl("Hesab� Onaylay�n�z. Do�rulama Kodunuz : "+validationCode);
							
				System.out.println("-----------------------------------------------------------");
				authorization.authToSystem(user);
				
				System.out.println("-----------------------------------------------------------");				
				return user;				
				} 
			else
				{
				System.out.println("Bu email daha �nce kullan�lm��t�r.");
				}
		}
		
		System.out.println("Kullan�c� kaydedilemedi. L�tfen formu belirtilen kurallara uygun doldurun");
		return null;

	}

	@Override
	public void login(String email, String password) {

		boolean result = email.length() > 0 && password.length() > 0;

		if (result) {
			for (User users : userService.getAll()) {

				boolean emailCheck = users.getEmail().equals(email) && users.getPassword().equals(password);

				if (emailCheck) {
					System.out.println("Giri� Ba�ar�l�.");
					return;
				}

				System.out.println("Giri� ba�ar�s�z.");

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
