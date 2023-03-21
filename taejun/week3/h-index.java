package taejun.week3;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] citations	= {3, 0, 6, 1, 5};
        // int[] citations = {10,8,5,4,3};
        // int[] citations = {25,8,5,3,3};
        // int[] citations = {4,4,4};
        // int[] citations = {10,10,10,10,10};
        // int[] citations = {0,0,0,0,0};

        long start = System.currentTimeMillis();
        solution(citations);
        long end = System.currentTimeMillis();
        System.out.println("\n수행시간 = " + (end-start));
    }
    public static int solution(int[] citations) {
        Integer[] cit = Arrays.stream(citations).boxed().toArray(Integer[]::new); 
        Arrays.sort(cit, Collections.reverseOrder());

        int i=0;
        int answer = 0;
        boolean none = false;

        for(; i<cit.length-1; i++) {
            if((i+1)<=cit[i] && (i+2)>cit[i+1]) {
                answer = i+1;
                break;
            }
            else if((i+1)>cit[i]) none = true;
        }

        if(none==false) answer=i+1;
        return answer;
    }
}
