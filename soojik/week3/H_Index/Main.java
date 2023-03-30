package soojik.week3.H_Index;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    System.out.println(solution(new int[]{1, 0, 5, 3, 8}));
    System.out.println(solution(new int[]{1, 0, 5, 4, 8}));
    System.out.println(solution(new int[]{30, 18, 19, 20, 21}));
  }

  public static int solution(int[] citations) {
    // citations 길이를 len이 참조하도록 한다.
    int len = citations.length;

    // 각 논문의 인용 수를 담은 citations 배열을 오름차순으로 정렬한다.
    Arrays.sort(citations);

    // h가 최대로 나올 수 있는 len 부터 하나씩 감소해 나가겠습니다.
    // 0부터 len-1 인덱스까지 순회를 할 때 현재 인덱스가 i라고 한다면 (i ~ len - 1) 범위의 인용수가 citation[i] 보다 크다는 뜻이며, len - 1 - i + 1 == (len - i == h)
    // 근데 어차피 i가 0부터 len-1 까지 하나씩 커지므로 매번 idx가 참조하는 값을 가져오기보다는 h를 하나씩 감소했습니다.
    int h = len;

    // 이 문제의 목적은 최대 h를 찾기입니다.
    // citations 배열 순회하면서
    for (int citation : citations) {
      // 현재 인용수(citation)가 h보다 크다면 순회 중단
      // 항상 현재 h가 최대가 되는데 현재 인용수가 h보다 크거나 같다면 h의 값이 정답이 된다.
      if (h <= citation) {
        break;
      }
      // h를 하나씩 감소
      --h;
    }

    // h와 len이 같다는 뜻은 가장 작은 인용수(citations[len-1])가 모든 논문 수(len) 크다는 뜻
    // 그 상황이면 h를 찾을 수 없으므로 0을 반환
    if (h == len && citations[h - 1] > h) {
      return len;
    }

    // 아까 구한 h 반환
    return h;
  }
}
