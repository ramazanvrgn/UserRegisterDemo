package ETicaretDemo.core.adapters;

import ETicaretDemo.JGoogle.JGoogleManager;
import ETicaretDemo.entities.concretes.User;

public class JGoogleManagerAdapter implements AuthorizationService {

	@Override
	public void authToSystem(User user) {
		JGoogleManager googleManager = new JGoogleManager();
		googleManager.registerWithGoogle(user);
	}

}
