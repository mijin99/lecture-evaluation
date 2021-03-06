package util;

import java.security.MessageDigest;

public class SHA256 {
	//샤 256 이메일인증!
	
	public static String getSHA256(String input){
		StringBuffer result = new StringBuffer();
		try{
			//사용자 이메일을 실제 SHA-256을 적용 시키기 위함
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			//해킹 방지를 위한 솔트값
			byte[] salt = "Hello! This is Salt.".getBytes();
			//리셋
			digest.reset();
			//솔트값 적용
			digest.update(salt);
			
			//입력값을 다이제스트로 utf-8형식의 바이트를 얻어 배열에 넣어준다
			byte [] chars = digest.digest(input.getBytes("UTF-8"));
			for(int i=0;i<chars.length;i++){
				//문자열 길이만큼 돌면서 hex를 붙여               유효 자리수 제외 모두 0으로(0000000~~)
				String hex = Integer.toHexString(0xff & chars[i]);
				//헥스가 1글자면 0을 붙여주고 
				if(hex.length()==1) result.append("0");
				//그 값을 넣어준다
				result.append(hex);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//해쉬값 반환
		return result.toString();
	}
}
