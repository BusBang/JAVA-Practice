import java.util.*;

public class kkkk {

	public static void main(String[] args) {
		List<String> �� = Arrays.asList("��", "��", "��");
		List<String> �̸� = Arrays.asList("��","��","��","��");
		Collections.shuffle(��);
		Collections.shuffle(�̸�);
		
		for(int i=0; i<3; i++) {
			System.out.println(��.get(0) + �̸�.get(0) + �̸�.get(1));
			}
	}

}
