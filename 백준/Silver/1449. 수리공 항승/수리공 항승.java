import java.util.*;
import java.io.*;

public class Main {

    /*
    가장 왼쪽에서 정수만큼 떨어진 거리에 물이 샘
    L 길이가 테이프를 무한개 가짐
    위치의 좌우 0.5만큼 간격을 줘야 물이 안샘
    물이 새는 곳과 L 길이의 테이프 가졌을 대 최소 개수 테이프
     */

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // N 개의 갯수만큼 물이 새는 곳 위치
        // 좌우 0.5만큼 간격이니 1만큼 있으면 그곳을 막을 수 있다.

        boolean [] pipe = new boolean[1001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            pipe[Integer.parseInt(st.nextToken())] = true;
        }
        int cnt = 0;
        // 물이 새는 곳을 발견했을 때 L 개의 길이만큼 막으면된다.
        for(int i = 1; i <= 1000; i++){
            if(pipe[i]){
                cnt++;
                for(int j = i; j < i + L; j++){
                    if(j > 1000) break;
                    pipe[j] = false;
                }
            }
        }

        System.out.println(cnt);
    }

}
