package org.example.homework;

import java.util.*;

public class 가장흔한단어찾기 {
    public static void main(String[] args) {
        solve("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
    }

    static void solve(String paragraph, String[] banned) {
        String[] str = paragraph.toLowerCase().split(" ");
        String answer = "";
        List<String> liststr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String ban = "";
        for (String temp : banned) {
            ban = temp;
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i].endsWith(".") || str[i].endsWith(",")) {
                str[i] = str[i].substring(0, str[i].length() - 1);
            }
            if (str[i].equals(ban)) continue; // banned가 있으면 그냥 건너뛰고 list에 넣어준다
            liststr.add(str[i]);
        }
        for (int i = 0; i < liststr.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < liststr.size(); j++) {
                if (liststr.get(i).equals(liststr.get(j))) {
                    cnt++;
                }
            }
            map.put(liststr.get(i), cnt);
        }
        int max = Collections.max(map.values());

        for(String key : map.keySet()) {
            if(map.get(key).equals(max)) {
                answer = key;
                break;
            }
        }
        System.out.println(answer);
    }


}
