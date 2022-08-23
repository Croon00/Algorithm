import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 우선 순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            // 각각 테케 돌릴때마다 clear
            pq.clear();
            // N번 연산
            int N = Integer.parseInt(br.readLine());
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                int operation = Integer.parseInt(st.nextToken());
                // 1이면 삽입
                if(operation == 1){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
                // 2일 때 삭제
                else if(operation == 2){
                    if(pq.isEmpty()){
                        sb.append(-1);
                    }
                    else{
                        sb.append(pq.poll());
                    }
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
