package soojik.week4.평균거리;

public class Main {
  public static void main(String[] args) {
    System.out.println(solution("sunday", "saturday"));
    System.out.println(solution("cut", "cat"));
  }

  public static int solution(String str1, String str2) {
    int len1 = str1.length();
    int len2 = str2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];

    /*
     기본적으로 각 문자열의 알파벳이 1 ~ len 까지의 인덱스에 참조되기 때문에 가장자리 배열에 대해서는 기본값을 넣어준다.
     이 기본값은 예를 들어
     str1 = "sunday"
     str2 = "saturday"
     를 참조할 때

     dp[1][0]은 "s" -> "" 의 편집 거리
     dp[2][0]은 "su" -> "" 의 편집 거리
     ... 중략

     dp[0][1]은 "" -> "s" 의 편집 거리
     dp[0][2]은 "" -> "sa" 의 편집 거리

     를 나타내기 때문에 가장자리에는 각 문자열 길이, 즉 인덱스와 같은 값이 들어간다.
     */

    for (int i = 1; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= len2; i++) {
      dp[0][i] = i;
    }

    /*
     dp[i][j] 에 들어가는 값은
     str1 문자열을 앞에서부터 i만큼 자른 문자열에서
     str2 문자열을 앞에서부터 j만큼 자른 문자열로 편집하는데 걸리는 최소 연산 수
     가 된다.
     */
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        // 현 위치의 알파벳이 같다면 이전에 비해 연산이 필요 없으므로
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          // 바로 가져온다.
          dp[i][j] = dp[i - 1][j - 1];
        }
        /* 그 외의 경우에는 */
        else {
          /*
           세 위치를 비교해서 가장 작은 연산 수를 가져와 +1 을 해준다.
           예를 들ㅇㅓ i = 2, j = 3 이라면
           "su" -> "sat" 이 되는데
           "s" -> "sat" 연산 수 [i-1][j]
           "su" -> "sa" 연산 수 [i][j-1]
           "s" -> "sa" 연산 수 [i-1][j-1]
           를 비교해서 지금 단어 또한 다르니까 연산 수에 +1 을 더해준다.

           세군데를 비교하는 이유?
           "su" -> "sat" 연산을 예로 들면
           직전에 나올 수 있는 모든 연산을 비교해 최소값을 찾아 1을 더해줘야하는데
           여기서 직전에 나올 수 있는 모든 연산이 위 예시들과 같다.
           */
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }

    return dp[len1][len2];
  }
}
