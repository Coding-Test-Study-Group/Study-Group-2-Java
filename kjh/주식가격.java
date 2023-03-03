package org.example.homework;


import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        solve(new int[]{1, 2, 3, 2, 3});
    }

    static void solve(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int ms = 0;
            for (int j = i + 1; j < prices.length; j++) { // i =0 이여서 i+1을해줬다 비교해줄필요가없음. 같은값이기때문에
                ms++; // 시간 초 (가격이 떨어지지 않을 초 )

                if (prices[i] > prices[j]) {//기준점이 더 클경우 break;
                    break;
                }
            }
            /**
             *  5초는 j<prices.length 범위를 넘었기때문에 0
             *
             */
            answer[i] = ms;
        }

        System.out.println(Arrays.toString(answer));
    }
}
