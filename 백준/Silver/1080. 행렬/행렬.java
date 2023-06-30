import java.util.*;
import java.io.*;

public class Main {

    /*
    0과 1로만 이루어진 행렬 A와 행렬 B가 존재
    이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값
    3 X 3 크기의 부분 행렬에 있는 모든 원소를 뒤집는다.
     */



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] matrix = new int[N][M];
        int [][] changedMatrix = new int[N][M];

        // 바꾸기 전 행렬 A
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        // 바꾸어야 할 행렬렬 B
       for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                changedMatrix[i][j] = str.charAt(j) - '0';
            }
        }

       int ans = 0;
       boolean flag = true;
       loop:
       for(int i = 0; i < N; i++){
           for(int j = 0; j < M; j++){
               // 같지 않은 부분을 찾았을 경우
               // 행렬을 3 x 3 만큼 바꾼다.
               if(matrix[i][j] != changedMatrix[i][j]){
                   // 바꾸려고 하는데 그 값이 행렬 크기 넘어가는 경우 A에서 B로 못 바꿈
                   for(int k = i; k < i + 3; k++){
                       if(k == N){
                           flag = false;
                           break loop;
                       }
                       for(int l = j; l < j + 3; l++){
                           if(l == M){
                               flag = false;
                               break loop;
                           }
                           // 값 바꾸기
                           if(matrix[k][l] == 0){
                               matrix[k][l] = 1;
                           }
                           else{
                               matrix[k][l] = 0;
                           }
                       }
                   }
                   ans++;
               }
           }
       }
       // 정답 혹은 -1
       if(flag) System.out.println(ans);
       else{
           System.out.println(-1);
       }
    }
}
