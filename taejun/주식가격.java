package taejun;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
            int term = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] <= prices[j]) term++;
                else if(prices[i] > prices[j]) {
                    term++;
                    break;
                }
                else break;
            }
            answer[i] = term;
        }
        return answer;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] prices = new int[]{1,2,3,2,3};
        // int[] prices = new int[]{5,4,3,2,5};
        sol.solution(prices);
    }
}