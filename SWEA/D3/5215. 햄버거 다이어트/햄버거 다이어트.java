import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, L, maxTaste;
    static int [][] hamburger;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            hamburger = new int[N][2];
            maxTaste = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                // 맛 과 칼로리
                hamburger[i][0] = Integer.parseInt(st.nextToken());
                hamburger[i][1] = Integer.parseInt(st.nextToken());

            }
            int taste, calorie;
            // 부분 집합의 총 갯수
            for(int i = 0; i < (1 << N); i++){
                // 각 부분 집합 마다 고르기 위해 초기화
                taste = 0;
                calorie = 0;
                // 원소가 N개라서 (원소를 검사하는)
                for(int j = 0; j < N; j++){
                    if((i & (1 << j)) > 0){
                        // 해당 원소가 있음
                        taste += hamburger[j][0];
                        calorie += hamburger[j][1];
                        if(calorie > L){
                            break;
                        }
                    }
                    if(calorie < L && maxTaste < taste){
                        maxTaste = taste;
                    }
                }
            }
            System.out.println("#" + tc + " " +maxTaste);
        }
    }
}