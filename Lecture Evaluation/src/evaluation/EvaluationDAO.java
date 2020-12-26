package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class EvaluationDAO {
	
	//������
	//���� ������ ������ ���̽� ��ü�� �̿�, �α��� �۾��� �Լ�
		public int write(EvaluationDTO evalautionDTO ){
													//���� ��ũ����Ʈ
			String SQL ="INSERT INTO EVALUATION VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,0)";
			Connection conn =null; //���� �� �ޱ�
			PreparedStatement pstmt = null; //���� �� sql�ֱ�
			//sql���� �� ��� ó��
			ResultSet rs = null;
			try{
				conn = DatabaseUtil.getConnection(); //db����(util�� �������� �� ��) ���ȭ
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1,evalautionDTO.getUserID());
				pstmt.setString(2,evalautionDTO.getLectureName());
				pstmt.setString(3,evalautionDTO.getProfessorName());
				pstmt.setInt(4,evalautionDTO.getLectureYear()); //���� ����
				pstmt.setString(5,evalautionDTO.getSemesterDivide());
				pstmt.setString(6,evalautionDTO.getLectureDivide());
				pstmt.setString(7,evalautionDTO.getEvaluationTitle());
				pstmt.setString(8,evalautionDTO.getEvaluationContent());
				pstmt.setString(9,evalautionDTO.getTotalScore());
				pstmt.setString(10,evalautionDTO.getCreditScore());
				pstmt.setString(11,evalautionDTO.getComfortableScore());
				pstmt.setString(12,evalautionDTO.getLectureScore());	
				return pstmt.executeUpdate();  //1���� ��ȯ�Ǿ� 1�� ��ȯ
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				//�ݵ�� ����! �ڿ� �������ֱ�
				try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
				try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
				try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
			}
			return -1; //������ ���̽� ����
		}
	
}