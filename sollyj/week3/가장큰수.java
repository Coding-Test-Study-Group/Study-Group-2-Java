package sollyj.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 가장큰수 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {6, 10, 2}));
		System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
	}

	private static String solution(int[] numbers) {
		StringBuilder answer = new StringBuilder();

		// 문자열로 바꿔서 리스트에 저장
		ArrayList<String> strList = new ArrayList<>();

		for (int number : numbers) {
			strList.add(String.valueOf(number));
		}

		// 정렬기준을 Comparator로 직접 구현
		Collections.sort(strList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int num1 = Integer.parseInt(o1 + o2);
				int num2 = Integer.parseInt(o2 + o1);

				return num2 - num1;
			}
		});

		if (strList.get(0).equals("0"))    // 0 예외처리
			answer.append("0");
		else
			strList.stream().forEach(s -> answer.append(s));

		return answer.toString();
	}
}
