package kr.or.iei.common;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component("SHA256Util")
public class SHA256Util {
	public String encData(String data) throws Exception {
		//MessageDigest 클래스를 이용한 암호화
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		//PW값 바이트배열로 변경하여 mDigest에 입력
		mDigest.update(data.getBytes());
		//SHA-256로 업데이트 된 데이터를 byte 배열로 가지고 있음.
		byte[] msgStr = mDigest.digest();
		//byte : -128 ~ 127까지 표현 가능 -> 00 ~ FF값으로 변경하는 작업
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<msgStr.length; i++) {
			byte tmp = msgStr[i];
			String tmpEncTxt = Integer.toString((tmp&0xff)+0x100,16).substring(1);
			sb.append(tmpEncTxt);
		}
		return sb.toString();
	}
}
