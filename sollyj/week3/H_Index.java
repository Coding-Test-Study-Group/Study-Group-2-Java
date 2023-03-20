// Programmers_H-Index
package sollyj.week3;

import java.util.Arrays;

public class H_Index {
	static int quoted;    // h번 이상 인용된 논문 수

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
		System.out.println(solution(new int[] {10, 50, 100}));
	}

	private static int solution(int[] citations) {
		Arrays.sort(citations);    // 오름차순 정렬

		int len = citations.length;    // 논문 개수
		int h_max = Integer.MIN_VALUE;	// H-Index

		int start = 0;
		int end = citations.length - 1;

		// 이분 탐색
		while (start <= end) {
			int mid = (start + end) / 2;

			quoted = 0;
			hindex(citations, mid);

			if (quoted >= mid) {
				if (h_max < mid)
					h_max = mid;
				start++;
			} else {
				end--;
			}
		}

		// !예외!
		// 모든 논문의 인용횟수가 논문 개수보다 많다면 논문 개수가 H-Index이다.
		for (int i = 0; i < len; i++) {
			if (citations[i] <= len) {
				break;
			} else {
				if (i == len - 1)
					h_max = len;
			}
		}

		return h_max;
	}

	// h가 H-Index인지 판별하기 위해 인용된 논문수(quoted)를 카운트하는 함수
	private static void hindex(int[] citations, int h) {
		for (int c : citations) {
			if (c >= h)
				quoted++;
		}
	}
}
