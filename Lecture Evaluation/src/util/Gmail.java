package util;
					
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
					//���� ������ �����ִ� Ŭ����
public class Gmail extends Authenticator{
	//gmail smtp �̿�(?) jaf , javamail ���̺귯�� �ٿ�޾ƿ�! lib�� �־��
                                                     	
	@Override
	protected PasswordAuthentication getPasswordAuthentication(){
		//���������� �߼��� ������ (���� ���� ����)
		return new PasswordAuthentication("mijinkim92326@gmail.com","ki671003");
	}
	
}