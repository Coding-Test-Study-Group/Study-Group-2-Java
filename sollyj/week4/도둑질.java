// Programmers_도둑질
package sollyj.week4;

public class 도둑질 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 1}));
	}

	private static int solution(int[] money) {
		int answer = 0;
		int len = money.length;

		// 1. n번째 집을 털었을때 훔친 돈의 최댓값이 들어갈 배열 선언
		int[] dp_first = new int[len];    // 첫번째 집을 터는 경우
		int[] dp_second = new int[len];    // 첫번째 집을 안 터는 경우

		// 2. 배열 초기값
		for (int i = 0; i < len; i++) {
			dp_first[i] = money[i];
			dp_second[i] = money[i];
		}

		dp_first[1] = -1;    // 두번째집 안털기
		dp_second[0] = -1;    // 첫번째집 안털기
		dp_first[2] += dp_first[0];    // 집의 개수는 최소 3개이므로, dp_first[2]의 초기값도 넣어준다.

		// 3. 점화식
		for (int i = 3; i < len; i++) {
			// 인접하지 않은 집(i - 2, i - 3)과 비교해 더 큰 값을 누적해 더해줌
			dp_first[i] += Math.max(dp_first[i - 3], dp_first[i - 2]);
			dp_second[i] += Math.max(dp_second[i - 3], dp_second[i - 2]);
		}

		// 맨 마지막 두집을 비교하여 최댓값 찾기
		int first_max = Math.max(dp_first[len - 2], dp_first[len - 3]);    // 첫번째 집을 털었으니까 맨 마지막 집은 어차피 못 턴다.
		int second_max = Math.max(dp_second[len - 1], dp_second[len - 2]);    // 첫번째 집을 안 털었으니까 맨 마지막 집 털 수 있다.

		answer = Math.max(first_max, second_max);

		return answer;
	}
}
