package taejun.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(seq[j] > seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);;
                }
            }
            max = Math.max(max, dp[i]);
        }

        bw.write(N - max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
