package org.example.homework;

import java.util.*;

public class 소수찾기 {
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        solve("17");
    }

    // 한가지 숫자가 적힌 종이 조각이 여러 개로 들어올때 흩어진 종이 조각을 붙여서 소수를 몇개나 만들 수 있는지 알아내고 개수를 알아내는문제이고
    // 흩어져있는종이(numbers 숫자를 조합해보면 1, 7 17 ,71 인데 1은 소수가아니기때문에 제거  하고 이문제에서 만약에 177 이라는 숫자가나왔을경우 조합해보면
    // 1, 7 ,17 77 77 두번이나오게됩니다 그래서 77이 두번세지는걸 방지)하기위해 Set을이용하였다.
    // 그 이후 만들어진 숫자가 소수인지 판단한다 .
    static void solve(String numbers) {
        int answer = 0;

        // 모든 조합의 숫자만들기
        recursive("", numbers);// 첫번째 매개변수는 여태까지 조합한 숫자를 만들려고

        for (Integer it : set)
            if (isPrime(it))
                answer++;
        System.out.println(answer);
    }

    private static boolean isPrime(int n) {//에라토스테네스의 체
        if (n == 0 || n == 1)
            return false;

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;

    }

    private static void recursive(String s, String n) {
        if (!s.equals("")) //2 .
            set.add(Integer.valueOf(s));//현재까지만들어진 조합을 set에 넣어주기

        for (int i = 0; i < n.length(); i++) {
            // 리컬시브라는메서드에서 하고자하는것은  여태까지만들어진 첫번째매개변수에 더해서 그다음 리컬시브로 넘어가게
            recursive(s + n.charAt(i), n.substring(0, i) + n.substring(i + 1)); // 1. 조합을만들기위ㅣ해 포문을돌린다
            // 1, 7
            //17  ""

        }

    }
}

