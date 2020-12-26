package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
//실질적으로db와 연동
	
	public static Connection getConnection(){
		try{
			//3306포트를 사용하는 tutorial이란 이름의 정보로
			String dbURL ="jdbc:mysql://localhost:3306/LectureEvaluation?serverTimezone=UTC";
			String dbID ="root"; //바로 접속가능하도록
			String dbPassword ="671003"; //비번 설정 로그인
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			//연결 상태를 반환해줌 
			return DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
