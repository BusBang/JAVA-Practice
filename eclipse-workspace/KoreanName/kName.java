import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class kName {
	static List<String> lNameList = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
	"송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "성", "차", "주",
	"우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현","양",
	"여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "방", "위", "표", "명", "기", "반", "왕", "금",
	"인", "맹", "모", "장", "남", "여", "진", "어", "은", "구");
	static List<String> fNameList = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
	"단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
	"백", "범", "별", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순", "재", "제", "호", "나", "영",
	"슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
	"유", "윤", "은", "의", "이", "익", "인", "일", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
	"중", "지", "진", "찬", "창", "채", "춘", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
	"혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "황", "린", "을", "비",
	"솜", "공", "면", "탁", "온", "디", "항", "후", "려", "묵", "송", "욱", "휴", "언", "삼",
	"열", "웅", "양", "타", "흥", "곤", "식", "란", "더", "손", "반", "빈", "실", "직",	"흔", "악", "람", "뜸", "권", "복", "심",
	"헌", "학", "개", "늘", "랑", "향", "울", "희");

	
	public static void main(String[] args) {
		try
		{
			Random rand = new Random();
			File f = new File("C:\\Users\\bang8255\\Desktop\\name.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	
			int lNameLength = lNameList.size();
			int fNameLength = fNameList.size();
		
			for (int i = 0; i < 5000; i++) 
			{
				String name = lNameList.get(rand.nextInt(lNameLength)) + fNameList.get(rand.nextInt(fNameLength)) + fNameList.get(rand.nextInt(fNameLength));
				if (f.canWrite() && f.isFile())
				{
					bw.write(name);
					bw.newLine();
				}
		    }
			bw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    }
}
