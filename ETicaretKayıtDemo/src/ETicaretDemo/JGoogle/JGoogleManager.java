package ETicaretDemo.JGoogle;



import ETicaretDemo.entities.concretes.User;

public class JGoogleManager {

	public void registerWithGoogle(User user) {
		//Burada google ile kayýt ile bir takým kodlar olabilirdi ama onlarý yazmadým çünkü buranýn kodlarý normalde hazýr olacaktý.
		//Ben sadece burda servis entegrasyonunu simüle ettim.
		System.out.println(user.getEmail()+ " google ile kayýt yapýldý ");
		
	}
}
