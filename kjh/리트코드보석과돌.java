package org.example.homework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 리트코드보석과돌 {

    public static void main(String[] args) {
        solve("aA", "aAAbbbb");
    }

    static void solve(String jewels, String stones) {
        int answer = 0;
        String[] str2 = jewels.split("");

        String[] str = stones.split("");
        Set<String> jewelsStr = new HashSet<>(List.of(str2));


        for (int i = 0; i < str.length; i++) {
            if (jewelsStr.contains(str[i])) answer++;
            else continue;
        }
        System.out.println(answer);




    }
}
