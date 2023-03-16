package soojik.week2.펠린드롬페어;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    String[] input1 = {"abcd", "dcba", "lls", "s", "sssll"};
    String[] input2 = {"bat", "tab", "cat"};
    String[] input3 = {"a", ""};
    String[] input4 = {"ab", "abc", "cba", "ba", "abcded"};

    Solution s = new Solution();

    System.out.println("첫번째 예시");
    System.out.println(s.solution(input1));
    System.out.println("두번째 예시");
    System.out.println(s.solution(input2));
    System.out.println("세번째 예시");
    System.out.println(s.solution(input3));
    System.out.println("네번째 예시");
    System.out.println(s.solution(input4));
  }
}

class Solution {
  public List<List<Integer>> solution(String[] words) {
    // wordMap
    // key: String 단어
    // value: Integer 단어의 인덱스
    HashMap<String,Integer> wordMap = new HashMap<>();

    // 단어 길이의 집합
    // 존재하는 단어 길이에 한해서만 비교
    Set<Integer> set = new TreeSet<>();
    int n = words.length;

    // 주어진 words 배열을 wordMap과 set에 넣어준다.
    for(int i=0;i<n;i++){
      wordMap.put(words[i],i);
      set.add(words[i].length());
    }

    // 정답 넣을 2차원 배열
    List<List<Integer>> ans = new ArrayList<>();

    // words 배열 순회
    for(int i=0;i<n;i++){

      // 현재 단어의 길이
      int length = words[i].length();

      // 단어를 뒤집어서 다른 단어들과 비교할 것
      String reverse = new StringBuilder(words[i]).reverse().toString();

      /*
      1. "abcd" , "dcba" - 그대로 뒤집어진 단어
      2. "abcdc", "ba" - palindrome 규칙을 만족하는 단어를 두개로 쪼갤 수 있을 때, substring[1] + substring[2]의 일부 , substring[2]의 일부
      3. "ab", "cdcba" - palindrome 규칙을 만족하는 단어를 두개로 쪼갤 수 있을 때, substring[1], substring[1]의 일부 + substring[2]
      3. "" , "a" - 빈 문자열과 이미 펠린드롬 규칙을 만족하는 단어의 경우
       */

      // 1번 경우를 찾는다.
      if(wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
        ans.add(Arrays.asList(i,wordMap.get(reverse)));

      // 단어 길이의 집합을 순회하고 각 길이를 k라고 한다.
      for(Integer k:set){
        // 같은 길이의 경우는 앞에서 검사한 1번과 같으므로 break;로 반복문을 끝낸다.
        if(k==length)
          break;


        // 현재 단어에서 k 길이 단어를 찾아 뒤에 붙일 것인지 앞에 붙일 것인지에 따라 팰린드롬 규칙을 만족하는지 검사하는 부분이 달라진다.
        // 밑에 과정에서 reverse는 현재 단어의 뒤집어진 형태라는 것을 기억해야한다.

        // 뒤에 붙인다는 가정 하에 팰린드롬 규칙을 만족하는지 검사해야하는 부분은 원래 단어에서는 __[ ] 처럼 앞 k 만큼 뺀 범위다.
        // 하지만 뒤집어진 단어로 검사하기 때문에 [ ]__ 처럼 뒤에서 k만큼 빼고난 후의 범위를 검사하게 된다.
        // 결과적으로 reverse 의 [0] 부터 [length-1-k] 인덱스만큼 isPalindrome 에서 팰린드롬 규칙을 만족하는지 검사한다.
        if(isPalindrome(reverse,0,length-1-k)){

          // [0] 부터 [length-1-k] 만큼 펠린드롬 규칙을 만족한다면
          // [length-k] 부터 [length-1] 만큼 잘라 findStr 가 참조하도록해서
          String findStr = reverse.substring(length-k);

          // findStr 도 입력받은 배열에 있었다면
          if(wordMap.containsKey(findStr))
            // 현재 인덱스, findStr 인덱스 순으로 답 배열에 추가한다.
            ans.add(Arrays.asList(i,wordMap.get(findStr)));
        }

        // 앞에 붙인다는 가정 하에 팰린드롬 규칙을 만족하는지 검사해야하는 부분은 원래 단어에서는 [ ]__ 처럼 뒤 k 만큼 뺀 범위다.
        // 하지만 뒤집어진 단어로 검사하기 때문에 __[ ] 처럼 앞에서 k만큼 빼고난 후의 범위를 검사하게 된다.
        // 결과적으로 reverse 의 [k] 부터 [length-1] 인덱스만큼 isPalindrome 에서 팰린드롬 규칙을 만족하는지 검사한다.
        if(isPalindrome(reverse,k,length-1)) {

          // [k] 부터 [length-1] 만큼 펠린드롬 규칙을 만족한다면
          // [0] 부터 [k-1] 만큼 잘라 findStr 가 참조하도록해서
          String findStr = reverse.substring(0,k);

          // findStr 도 입력받은 배열에 있었다면
          if(wordMap.containsKey(findStr))
            // findStr 인덱스, 현재 인덱스 순으로 답 배열에 추가한다.
            ans.add(Arrays.asList(wordMap.get(findStr),i));
        }
      }
    }
    return ans;
  }

  // isPalindrome은 left와 right를 포함해서 양쪽에서 가운데로 거리를 좁혀오며 문자를 검사해서 palindrome 규칙을 만족하는지 확인하는 메서드
  private boolean isPalindrome(String s, int left, int right){
    while (left < right)
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    return true;
  }
}
