package org.example.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 백준신기한소수 {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        solution(0, 0);

        System.out.println(sb.toString());
    }

    static void solution(int length, int n) {

        if (length == N) { //재귀를 통한 반복문 종료문
            //example length +1 ... ... 예제 인풋값 4가 length랑 같다면 . 종료
            sb.append(n).append("\n");
            return;
        }

        for (int i = 0; i <= 9; i++) {
            int temp = n * 10 + i;// n이 만약에 233 이다 3으로 나누어떨어짐
            /**
             *  트리로 생각했을때
             *  2 -> 1 x
             *  2-> 2  x
             *  2 -> 3 o
             *  21 -> x
             *  22 -> x
             *  23 -> o
             *  2 -> 3 -> 1 x
             *  2 -> 3 -> 2 x
             *  2 -> 3 -> 3 o
             *
             *  2 -> 3 -> 3-> 1 x
             *  2 -> 3 -> 3 -> 2 x
             *  2 -> 3 -> 3-> 2 o
             *
             * 총 o가 4자리가 되었으므로 빌더에 append해준다
             *
             *
             */
            if (!isPrimeNumber(temp)) continue;
            solution(length + 1, temp);
        }

    }

    static boolean isPrimeNumber(int n) {
        //0 과 1은 소수가아니기때문에
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            /**
             * 18의 예시를 들면
             * 18의 약수는 1 2 3 6 9 18 인데
             * 제곱근 값보다 같거나 작은 숫자로 나누어떨이지면 대칭이기에 계산을 할 필요가 없다는 원리이여서 제곱근 값 이하의 수만큼만 체크하면된다.
             *
             */
            if (n % i == 0) return false;
        }
        return true;
    }

}
