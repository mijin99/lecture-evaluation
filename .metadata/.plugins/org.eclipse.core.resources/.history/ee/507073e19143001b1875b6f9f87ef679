package user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DatabaseUtil;

public class userDAO {
//database access object 직접 접근
	public int join(String userID, String userPassword){
		//유저의 정보를 넣어준다. 새로운 유저 로그인
		String SQL = "insert into user values (?,?)";
		try{
			Connection conn = DatabaseUtil.getConnection();
			//statement를 상속받아 sql구문을 실행시켜줌  //conn은 connection객체
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			
			return pstmt.executeUpdate();
			//오류는 0 제대로 1 
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	
	}
}
