package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;



public class UserDAO {
	
	//접근 성공한 데이터 베이스 객체를 이용, 로그인
	public int login(String userID,String userPassword){
		String SQL ="SELECT userPassword FROM USER WHERE userID= ?";
		Connection conn =null; //연결 값 받기
		PreparedStatement pstmt = null; //연결 후 sql넣기
		//sql실행 후 결과 처리
		ResultSet rs = null;
		try{
			conn = DatabaseUtil.getConnection(); //db접근(util에 사전정의 한 것) 모듈화
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			
				//executeQuery 는 resultset으로 결과 받아서 '조회'!
			rs = pstmt.executeQuery(); 
			if(rs.next()){  	//실행결과 존재시
				if(rs.getString(1).equals(userPassword)){ //비밀번호가 같으면
					return 1;//로그인 성공
				}
				else{
					return 0; //로그인 실패 (비밀번호 틀림)
				}
			}
			return -1; //아이디 없음
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//반드시 실행! 자원 해제해주기
			try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
		}
		return -2; //데이터 베이스 오류
	}
	
	
	//회원가입
	public int join(UserDTO user){
		String SQL ="INSERT INTO USER VALUES(?,?,?,?,false)";
		Connection conn =null; //연결 값 받기
		PreparedStatement pstmt = null; //연결 후 sql넣기
		//sql실행 후 결과 처리
		ResultSet rs = null;
		try{
			conn = DatabaseUtil.getConnection(); //db접근(util에 사전정의 한 것) 모듈화
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,user.getUserID());
			pstmt.setString(2,user.getUserPassword());
			pstmt.setString(3,user.getUserEmail());
			pstmt.setString(4,user.getUserEmailHash());
			//executeUpdate는  sql 실행으로 수정,삭제,삽입! ,데이터 개수 반환
			return pstmt.executeUpdate(); //성공시 1 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//반드시 실행! 자원 해제해주기
			try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
		}
		return -1; //데이터 베이스 오류,회원가입 실패
	}
	
	
	
	//이메일 인증
	public boolean getUserEmailChecked(String userID){
		String SQL ="SELECT userEmailChecked FROM USER WHERE userID =?";
		Connection conn =null; //연결 값 받기
		PreparedStatement pstmt = null; //연결 후 sql넣기
		//sql실행 후 결과 처리
		ResultSet rs = null;
		try{
			conn = DatabaseUtil.getConnection(); 
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			rs= pstmt.executeQuery() ;
			
			if(rs.next()){
				return rs.getBoolean(1); //true
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//반드시 실행! 자원 해제해주기
			try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
		}
		return false; //데이터 베이스 오류
	}
	
	//이메일 인증완료 처리
	public boolean setUserEmailChecked(String userID){
		String SQL ="UPDATE USER SET userEmailChecked = true WHERE userID= ?";
		Connection conn =null; //연결 값 받기
		PreparedStatement pstmt = null; //연결 후 sql넣기
		//sql실행 후 결과 처리
		ResultSet rs = null;
		try{
			conn = DatabaseUtil.getConnection(); 
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			pstmt.executeUpdate();
			return true; //인증이 됐더라도 그냥 트루! 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//반드시 실행! 자원 해제해주기
			try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
		}
		return false; //데이터 베이스 오류
	}
	
	
	//유저의 이메일 알아오기
	public String getUserEmail(String userID){
		String SQL ="SELECT userEmail FROM USER WHERE userID =?";
		Connection conn =null; //연결 값 받기
		PreparedStatement pstmt = null; //연결 후 sql넣기
		//sql실행 후 결과 처리
		ResultSet rs = null;
		try{
			conn = DatabaseUtil.getConnection(); 
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			rs= pstmt.executeQuery() ;
			
			if(rs.next()){
				return rs.getString(1); //true
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//반드시 실행! 자원 해제해주기
			try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
		}
		return null; //데이터 베이스 오류시 null값
	}
}
