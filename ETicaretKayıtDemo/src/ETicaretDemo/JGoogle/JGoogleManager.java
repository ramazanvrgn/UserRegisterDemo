package ETicaretDemo.JGoogle;



import ETicaretDemo.entities.concretes.User;

public class JGoogleManager {

	public void registerWithGoogle(User user) {
		//Burada google ile kay�t ile bir tak�m kodlar olabilirdi ama onlar� yazmad�m ��nk� buran�n kodlar� normalde haz�r olacakt�.
		//Ben sadece burda servis entegrasyonunu sim�le ettim.
		System.out.println(user.getEmail()+ " google ile kay�t yap�ld� ");
		
	}
}
