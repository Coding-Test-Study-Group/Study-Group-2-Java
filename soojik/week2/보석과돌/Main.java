package soojik.week2.보석과돌;

/*
2개의 문자열을 입력받아서 첫번째 문자열의 각 문자가 두번째 문자열에 몇 개 포함되어 있는지 계산 – 대소문자 구분
jewels는 중복된 문자는 존재하지 않음

입출력 예1
입력: jewels = "aA", stones = "aAAbbbb"
출력: 3

입출력 예2
입력: jewels = "z", stones = "ZZ"
출력: 0
 */

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.solution("aA", "aAAbbbb"));
    System.out.println(solution.solution("z", "ZZ"));
  }
}

class Solution {
  public int solution(String jewels, String stones) {

    // stones 배열에서 jewels 에서 알파벳이 몇번 나오는지 저장해놓을 hashmap
    // key: Character 알파벳
    // value: Integer key가 나온 횟수
    HashMap<Character, Integer> cnt_stones = new HashMap<>();

    // stones 문자열 순회
    for (char stone : stones.toCharArray()) {
      // 한번 나왔던 알파벳이라면
      if (cnt_stones.containsKey(stone)) {
        // 이전에 나왔던 횟수에 +1
        cnt_stones.put(stone, cnt_stones.get(stone) + 1);
      }
      else {
        // 처음 나왔다면 1을 넣어준다.
        cnt_stones.put(stone, 1);
      }
    }

    int answer = 0;

    // jewels 문자열 순회하면서 각 알파벳을 jewel로 두고
    for (char jewel : jewels.toCharArray()) {
      // 만약 jewel이 stones에서 각 알파벳의 등장 횟수를 세어놨던 cnt_stones에 있다면
      if (cnt_stones.containsKey(jewel)) {
        // 가져와서 answer에 더해준다.
        answer += cnt_stones.get(jewel);
      }
    }

    return answer;
  }
}