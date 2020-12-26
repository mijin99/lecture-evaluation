package util;

import java.security.MessageDigest;

public class SHA256 {
	//�� 256 �̸�������!
	
	public static String getSHA256(String input){
		StringBuffer result = new StringBuffer();
		try{
			//����� �̸����� ���� SHA-256�� ���� ��Ű�� ����
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			//��ŷ ������ ���� ��Ʈ��
			byte[] salt = "Hello! This is Salt.".getBytes();
			//����
			digest.reset();
			//��Ʈ�� ����
			digest.update(salt);
			
			//�Է°��� ��������Ʈ�� utf-8������ ����Ʈ�� ��� �迭�� �־��ش�
			byte [] chars = digest.digest(input.getBytes("UTF-8"));
			for(int i=0;i<chars.length;i++){
				//���ڿ� ���̸�ŭ ���鼭 hex�� �ٿ�               ��ȿ �ڸ��� ���� ��� 0����(0000000~~)
				String hex = Integer.toHexString(0xff & chars[i]);
				//������ 1���ڸ� 0�� �ٿ��ְ� 
				if(hex.length()==1) result.append("0");
				//�� ���� �־��ش�
				result.append(hex);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//�ؽ��� ��ȯ
		return result.toString();
	}
}