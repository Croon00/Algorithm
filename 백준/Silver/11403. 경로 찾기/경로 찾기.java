import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 간선의 수
        for(int i = 0; i < N; i++){
            // 출발 노드
            for(int j = 0; j < N; j++){
                // 도착 노드
                for(int k = 0; k < N; k++){
                    // i로 가는 간선을 j와 k 모두 가지고 있으면 두 개의 노드는 연결 되어 있는 것
                    if(arr[j][i] == 1 && arr[i][k] == 1){
                        arr[j][k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
