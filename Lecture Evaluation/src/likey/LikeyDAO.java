package likey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class LikeyDAO {
	
	//���ƿ� ������ db�� ����
	public int like(String userID,String evaluationID,String userIP){
		String SQL ="INSERT INTO LIKEY VALUES (?, ?, ?)";
		Connection conn =null; //���� �� �ޱ�
		PreparedStatement pstmt = null; //���� �� sql�ֱ�
		//sql���� �� ��� ó��
		ResultSet rs = null;
		
		try{
			conn = DatabaseUtil.getConnection(); //db����(util�� �������� �� ��) ���ȭ
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			pstmt.setInt(2,Integer.parseInt(evaluationID));
			pstmt.setString(3,userIP);
			
			//executeQuery �� resultset���� ��� �޾Ƽ� '��ȸ'!
			return pstmt.executeUpdate(); 
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//�ݵ�� ����! �ڿ� �������ֱ�
			try {if(conn!=null) conn.close();}catch(Exception e){e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e){e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e){e.printStackTrace();}
		}
		return -1; //��õ �ߺ� ����
	}
}