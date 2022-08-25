import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // static으로 재료 갯수, 제한칼로리, 가장 맛있은 조합 맛 받기
    static int N, L, maxTaste;
    // 각 재료에 대한 맛이랑 칼로리
    static int []  taste, calorie;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            maxTaste = 0;
            // N 크기만큼 선언
            taste = new int[N];
            calorie = new int[N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            rec(0, 0, 0);
            System.out.println("#" + tc + " " + maxTaste);
        }
    }
    static void rec(int idx, int sumTaste, int sumCalorie){
        // L 이상일땐 칼로리 제한을 넘음으로 return해서 해당 재귀함수 끝내기
        if(sumCalorie > L){
            return;
        }
        // N번째 재료까지 봤을 때 maxTaste 값을 가장 맛있을 때로 변경 후 재귀함수 끝내기
        if(idx == N){
            if(maxTaste < sumTaste){
                maxTaste = sumTaste;
            }
            return;
        }
        // idx를 증가시키면서 해당 재료의 맛과 칼로리를 더하거나 안 더하는 방법으로 재귀함수
        rec(idx + 1, sumTaste+taste[idx], sumCalorie+calorie[idx]);
        rec(idx + 1, sumTaste, sumCalorie);
    }
}
