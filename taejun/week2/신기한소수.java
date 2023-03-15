package taejun.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        recursion("");
        br.close();
    }

    // 재귀를 통해 N만큼 자리수를 붙여가기
    public static void recursion(String str) {
		if(str.length() == N) {
            System.out.println(str);
			return;
		}
		for(int i = 1; i <= 9; i++) {
			if(isPrime(Integer.parseInt(str + i))) {
				recursion(str + i);
			}
		}
	}

    // 에라토스테네스의 체로 소수 판별하기
    public static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        if (num == 1) return false;
        for (int i=2; i<=sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}