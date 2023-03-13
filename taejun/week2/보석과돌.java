package taejun.week2;

import java.util.*;

class Solution {
    public int numJewelsInStones1(String jewels, String stones) {
        // ArrayList 및 for문 활용
        ArrayList<Character> list = new ArrayList<>();
        char[] jewels_arr = jewels.toCharArray();
        char[] stones_arr = stones.toCharArray();
        int cnt = 0;
        for(char c : jewels_arr) {
            list.add(c);
        }
        for(char c : stones_arr) {
            if(list.contains(c)) cnt++;
        }
        return cnt;
    }
    public int numJewelsInStones2(String jewels, String stones) {
        // ArrayList 및 foreach문 활용
        ArrayList<Character> list = new ArrayList<>();
        char[] jewels_arr = jewels.toCharArray();
        char[] stones_arr = stones.toCharArray();
        int cnt = 0;
        for(char c : jewels_arr) {
            list.add(c);
        }
        for(char c : stones_arr) {
            if(list.contains(c)) cnt++;
        }
        return cnt;
    }
    public int numJewelsInStones3(String jewels, String stones) {
        // HashMap 및 foreach문 활용
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] jewels_arr = jewels.toCharArray();
        char[] stones_arr = stones.toCharArray();
        int cnt = 0;
        for(char c : jewels_arr) {
            hm.put(c, 0);
        }
        for(char c : stones_arr) {
            if(hm.containsKey(c)) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String jewels = "aA";
        String stones = "aAAbbbb";
        long start = System.nanoTime();
        sol.numJewelsInStones3(jewels, stones);
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
