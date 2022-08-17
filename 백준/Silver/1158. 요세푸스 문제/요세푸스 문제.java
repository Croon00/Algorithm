import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        st= new StringTokenizer(br.readLine());
        // N 명
        int N = Integer.parseInt(st.nextToken());
        // K 번째
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        // 0부터 새서 K 번째 까지
        int n = 0;
        // queue에 일단 처음 넣기
        for(int i = 1; i < N + 1; i++){
            queue.offer(i);
        }

        // queue 크기가 1이 될때 까지
        while (queue.size() > 1){
            n++;
            // n번째가 K와 같을 때 sb에 추가하고 n은 다시 0으로 초기화
            if(n == K){
                sb.append(queue.poll() + ", ");
                n = 0;
            }
            // n번째가 아닌 경우 앞에서 뽑아서 다시 뒤로 넣기
            else{
                int temp = queue.poll();
                queue.offer(temp);
            }
        }
        sb.append(queue.poll());
        sb.append(">");
        System.out.println(sb);
    }
}