
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){

            // 사람 수, M초, K값
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            // 가능한지 불가능 한지
            boolean possible = true;
            // 각 사람들의 도착 시간
            ArrayList<Integer> arriveSec = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            // 도착 시간 받기
            for(int i = 0; i < N; i++){
                arriveSec.add(Integer.parseInt(st.nextToken()));
           }
            // 도착시간에 따라서 오름차순 정렬
            Collections.sort(arriveSec);

            for(int i = 0; i < arriveSec.size(); i++){
                int temp = arriveSec.get(i);
                int sum = K * (temp/M);
                if(sum  < (i + 1)){
                    possible = false;
                }
            }
            if(possible == true){
                System.out.println("#" + tc + " " + "Possible");
            }
            else{
                System.out.println("#" + tc + " " + "Impossible");
            }
        }
    }
}