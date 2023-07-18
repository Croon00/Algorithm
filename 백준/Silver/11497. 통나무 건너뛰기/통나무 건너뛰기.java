import java.util.*;
import java.io.*;

public class Main {
    /*
        통나무를 세워놓고 건너뛰기
        N개의 통나무를 원형으로 세워 놓고 뛰어 놀기
        인접한 통나무 높이 차가 최소가 되게 한다.
        맨 앞에 온 배열에 통나무와 맨 끝 배열 통나무도 비교
        통나무 건너뛰기 난이도 --> 두 통나무 간의 높이의 차의 최대값으로 결정

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테케
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine()); // 5 ~ 10,000 개의 통나무 개수
            int [] treeHight = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                treeHight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(treeHight);
            // 가장 큰 것이 가운데 가게 왼쪽 오른쪽 나눠서 넣기

            int [] sortTree = new int[N];

            int left = 0;
            int right = N - 1;

            for(int i = 0; i < N; i++){
                if(i % 2 == 0){
                    sortTree[left] = treeHight[i];
                    left++;
                }
                else{
                    sortTree[right] = treeHight[i];
                    right--;
                }
            }

            int MaxDifferent = 0;

            // 자기 자신과 그 다음 통나무의 차이를 구하면서 더 큰 경우 넣기
            for(int i = 0; i < N - 1; i++){
                MaxDifferent = Math.max(MaxDifferent, Math.abs(sortTree[i] - sortTree[i + 1]));
            }

            // 0 배열과 끝 배열 차도 넣기
            MaxDifferent = Math.max(MaxDifferent, Math.abs(sortTree[0] - sortTree[N - 1]));
            sb.append(MaxDifferent).append("\n");
        }
        System.out.println(sb);

    }
}



