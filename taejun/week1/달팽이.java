package taejun.week1;

import java.util.*;
class Solution {
    public int[][] solution(int row, int col) {
        
        int[][] answer = new int[col][row];
        int i = 0; // row start index
        int j = -1; // col start index
        int tmp = 0; // snail number
        int direction = 1; // i with j switch direction(1 or -1)
        int repeat = row; // repeat count

        while(repeat > 0) {
            for(int l=0; l<repeat; l++) {
                tmp++;
                j = j + direction;
                answer[i][j] = tmp;
            }
            repeat--;
            for(int m=0; m<repeat; m++) {
                tmp++;
                i = i + direction;
                answer[i][j] = tmp;
                
            }
            direction *= -1;
        }

        for(int[] arr : answer) {
            System.out.println(Arrays.toString(arr));
        }
        return answer;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int row = 5;
        int col = 5;
        sol.solution(row, col);
    }
}
