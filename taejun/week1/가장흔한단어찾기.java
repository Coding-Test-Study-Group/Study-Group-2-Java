package taejun.week1;

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[!?,;'\\.\\s]+");
        Map<String, Integer> count = new HashMap<>();
        String answer = null;

        for(String w : words) {
            String word = w.replace("\\W", "");
            Boolean possiable = true;
            for(String ban : banned) {
                if(word.equals(ban)) {
                    possiable = false;
                    break;
                }
            }
            if(possiable) count.put(word, count.getOrDefault(word, 0)+1);
        }

        for(String key : count.keySet()) {
            if(answer == null || count.get(key) > count.get(answer)) answer = key;
        }
        
        System.out.println(answer);
        return answer;
    }
}