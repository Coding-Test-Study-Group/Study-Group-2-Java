package j2woo.week3;
import java.util.*;
public class 가장큰수 {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String numString[] =new String[numbers.length];
            for(int i=0;i<numbers.length;i++){ // numbers int -> String 배열로 변환, 이유는 String으로 정렬하여 큰 수 비교하기 위해
                numString[i]=Integer.toString(numbers[i]);
            }
            Arrays.sort(numString,new Comparator<>(){
                // 내림차순 정렬
                @Override
                public int compare(String o1, String o2){ // string형 배열이면 sort(A)는 UTF-16 문자 인코딩 체계의 코드 순서에 따라 요소를 정렬한다.
                    return (o2+o1).compareTo(o1+o2); // {6, 10, 2}-> {6, 2, 10}
                }
            });
            answer=String.join(answer,numString); // 문자열 배열 이어붙이기
            // 숫자가 다 0일 때
            if(numString[0].equals("0")){
                answer="0";
            }
            return answer;
        }
    }
}
