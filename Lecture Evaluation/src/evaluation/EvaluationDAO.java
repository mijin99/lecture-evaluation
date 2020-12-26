package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class EvaluationDAO {
	
	//강의평가
	//접근 성공한 데이터 베이스 객체를 이용, 로그인 글쓰기 함수
		public int write(EvaluationDTO evalautionDTO ){
													//오토 인크리먼트
			String SQL ="INSERT INTO EVALUATION VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,0)";
			Connection conn =null; //연결 값 받기
			PreparedStatement pstmt = null; //연결 후 sql넣기
			//sql실행 후 결과 처리
			ResultSet rs = null;
			try{
				conn = DatabaseUtil.getConnection(); //db접근(util에 사전정의 한 것) 모듈화
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1,evalautionDTO.getUserID());
				pstmt.setString(2,evalautionDTO.getLectureName());
				pstmt.setString(3,evalautionDTO.getProfessorName());
				pstmt.setInt(4,evalautionDTO.getLectureYear()); //강의 연도
				pstmt.setString(5,evalautionDTO.getSemesterDivide());
				pstmt.setString(6,evalautionDTO.getLectureDivide());
				pstmt.setString(7,evalautionDTO.getEvaluationTitle());
				pstmt.setString(8,evalautionDTO.getEvaluationContent());
				pstmt.setString(9,evalautionDTO.getTotalScore());
				pstmt.setString(10,evalautionDTO.getCreditScore());
				pstmt.setString(11,evalautionDTO.getComfortableScore());
				pstmt.setString(12,evalautionDTO.getLectureScore());	
				return pstmt.executeUpdate();  //1개가 변환되어 1이 반환
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				//반드시 실행! 자원 해제해주기
				try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
				try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
				try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
			}
			return -1; //데이터 베이스 오류
		}
	
}
