package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
//����������db�� ����
	
	public static Connection getConnection(){
		try{
			//3306��Ʈ�� ����ϴ� tutorial�̶� �̸��� ������
			String dbURL ="jdbc:mysql://localhost:3306/LectureEvaluation?serverTimezone=UTC";
			String dbID ="root"; //�ٷ� ���Ӱ����ϵ���
			String dbPassword ="671003"; //��� ���� �α���
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			//���� ���¸� ��ȯ���� 
			return DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
