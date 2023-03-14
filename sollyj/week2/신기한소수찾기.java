package sollyj.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 신기한소수찾기 {
	static int N;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			N = Integer.parseInt(br.readLine());

			dfs(2, 1);    // 2로 시작하는 신기한 소수 구하기
			dfs(3, 1);    // 3로 시작하는 신기한 소수 구하기
			dfs(5, 1);    // 5로 시작하는 신기한 소수 구하기
			dfs(7, 1);    // 7로 시작하는 신기한 소수 구하기

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	// 소수 판별 함수
	private static boolean isPrime(int num) {
		if (num <= 1)
			return false;

		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// 현재 숫자가 소수인지 판별하면서
	// 길이 N까지 깊이우선탐색을 하며 신기한 소수를 구하는 함수
	private static void dfs(int num, int len) {
		if (len == N) {    // N자리수면 출력
			if (isPrime(num))
				System.out.println(num);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			int newNum = (num * 10) + i;

			if (isPrime(newNum)) {    // 소수면
				dfs(newNum, len + 1);    // 자릿수를 늘려주고 깊이우선탐색
			}
		}
	}
}
