// Baekjoon_18310_안테나
package sollyj.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 안테나 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			ArrayList<Integer> locations = new ArrayList<>();    // 집 위치 리스트

			for (int i = 0; i < N; i++) {
				int location = Integer.parseInt(st.nextToken());
				locations.add(location);
			}

			Collections.sort(locations);    // 오름차순 정렬

			if (N % 2 == 1) {    // 집이 홀수개이면
				System.out.println(locations.get(N / 2));
			} else {    // 집이 짝수개이면
				System.out.println(locations.get(N / 2 - 1));
			}

			br.close();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
