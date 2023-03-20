// Programmers 소수찾기
package sollyj.week3;

import java.util.ArrayList;
import java.util.HashSet;

public class 소수찾기 {
	static int answer;
	static HashSet<Integer> set = new HashSet<>();    // 중복 방지위해 set 선언
	static int len;    // numbers 길이
	static boolean[] visited;   // 종이 조각 선택 여부
	static ArrayList<String> particles = new ArrayList<>();    // 종이 조각 리스트

	public static void main(String[] args) {
		System.out.println(solution("17"));
		//System.out.println(solution("011"));
	}

	private static int solution(String numbers) {
		answer = 0;
		len = numbers.length();
		visited = new boolean[len];    // visited 배열 초기화

		// numbers를 리스트에 넣어준다.
		for (int i = 0; i < numbers.length(); i++) {
			particles.add(numbers.substring(i, i + 1));
		}

		permutation("", 1);	// 1~len개까지 순열로 뽑아 소수 판별해서 answer구하기

		return answer;
	}

	// 백트래킹 사용한 순열 구현
	// 매개변수 (문자열, 몇 개 뽑는지)
	private static void permutation(String str, int cnt) {
		if (!str.equals("")) {
			int temp = Integer.parseInt(str);

			if (isPrime(temp) && !set.contains(temp)) {    // 소수 판별 && set에 없는지
				System.out.println(temp);
				answer++;
				set.add(temp);	// set에 추가함으로써 중복 방지
			}
		}

		if (cnt > len)    // 끝까지 다했을때
			return;

		for (int i = 0; i < len; i++) {
			if (visited[i])    // 이미 뽑았으면
				continue;    // 넘어가기

			visited[i] = true;
			permutation(str + particles.get(i), cnt + 1);    // 재귀하면서 len개까지 뽑는다.
			visited[i] = false;
		}
	}

	// 소수 판별 함수
	// 에라토스테네스의 체
	private static boolean isPrime(int number) {
		if (number <= 1)
			return false;

		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;

		return true;
	}
}
