import java.util.*;

public class kkkk {

	public static void main(String[] args) {
		List<String> 성 = Arrays.asList("김", "이", "박");
		List<String> 이름 = Arrays.asList("가","강","건","경");
		Collections.shuffle(성);
		Collections.shuffle(이름);
		
		for(int i=0; i<3; i++) {
			System.out.println(성.get(0) + 이름.get(0) + 이름.get(1));
			}
	}

}
