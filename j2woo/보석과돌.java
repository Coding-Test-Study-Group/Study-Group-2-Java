package j2woo;

import java.util.*;
// solution 2개
public class 보석과돌 {
    public static void main(String[] args){
        System.out.println(solution2("aA","aAAbbbb"));
        System.out.println(solution2("z","ZZ"));
    }

    // hash를 사용한 코드
    public static int solution1(String jewels, String stones){
        int result=0;
        char [] jew=jewels.toCharArray();
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c: jew){ // jewels에 포함된 문자 hash에 넣기
            map.put(c,0);
        }
        char [] st=stones.toCharArray();
        for(char c: st){ // stone에 문자가 jewels에 있다면 개수 +1
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
        }

        ArrayList<Integer> count=new ArrayList<>(map.values());
        for(int num: count) result+=num; // jewels의 문자가 stones에 들어있는 개수 넣어주기
        return result;
    }

    // 태준님 코드 참고해한 리스트를 사용한 코드
    public static int solution2(String jewels, String stones){
        int result=0;
        // jewels를 String-> char[] 배열로 변환하고 리스트에 넣기
        char [] jew=jewels.toCharArray();
        ArrayList<Character> li=new ArrayList<>();
        for(char c: jew){
            li.add(c);
        }

        for(int i=0; i<stones.length(); i++){ // stone에 문자가 jewels 리스트 에 포함하면 result ++;
            if(li.contains(stones.charAt(i))){
                result++;
            }
        }
        return result;
    }

}
