package sollyj.week2;

import java.util.HashMap;

public class 보석과돌 {
	public static void main(String[] args) {
		//String jewels = "aA";
		//String jewels = "z";
		String jewels = "Zja";
		//String stones = "aAAbbbb";
		//String stones = "ZZ";
		String stones = "ZjJjaaa";

		System.out.println(solution(jewels, stones));
	}

	private static int solution(String jewels, String stones) {
		int answer = 0;

		// key는 문자
		// value는 사실상 의미 없다.
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < jewels.length(); i++) {
			map.put(jewels.charAt(i), 0);
		}

		for (int i = 0; i < stones.length(); i++) {
			Character c = stones.charAt(i);

			// map에 문자가 존재하는지
			if (map.containsKey(c)) {
				answer++;
			}
		}

		return answer;
	}
}
