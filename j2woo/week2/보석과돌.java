package j2woo.week2;
import java.util.*;
public class 보석과돌 {
    public static void main(String[] args){
        System.out.println(solution("aA","aAAbbbb"));
        System.out.println(solution("z","ZZ"));
    }
    public static int solution(String jewels, String stones){
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
}
