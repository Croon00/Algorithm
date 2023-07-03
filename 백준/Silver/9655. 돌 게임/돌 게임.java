import java.util.*;
import java.io.*;

public class Main {

    /*
    돌 게임은 2명이서 게임
    N 개의 돌
    상근 창영이 턴을 번갈아가면서 돌을 가져감, 1개 또는 3개 가져간다.
    마지막 돌을 가져가는 사람이 이기게된다.
    완벽하게 게임 했을 때 이기는 사람 구하기
    상근이가 먼저 시작
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 1개일 경우 상근이가 무조건 진다.
        // 2개일 경우 상근이가 1개 가져가면 이긴다.
        // 3개일 경우 상근 창영 상근으로 상근이 진다.
        // 4개일 경우 상근이가 3개 가져감으로 이긴다.
        // 5개일 경우 상근이가 1개 가져간 경우 1, 3, 1로 진다, 3개 가져간 경우 3,1,1로 진다.
        // 6개일 경우 상근이가 1개 가져간 경우 상근이가 1로 시작 하든 3으로 시작하든 이긴다.
        String [] dp = new String[1001];
        for(int i = 1; i <= 1000; i++){
            if(i % 2 == 0){
                dp[i] = "CY";
            }
            else{
                dp[i] = "SK";
            }
        }
        System.out.println(dp[N]);
    }
}
