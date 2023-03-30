package com.example.codingtest.week3;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;

        //citations 오름차순 정렬
        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 해당 논문보다 인용횟수가 크거나 같은 논문 개수

            //citations[i]는 해당 논문 인용 횟수
            //해당 논문 인용 횟수 >= h횟수 이상 인용된 논문 개수가 되면 정답
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
