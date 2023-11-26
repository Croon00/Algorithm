import java.util.*;
import java.io.*;

public class Main {

    // 강의실 배정
    // Si에서 시작해서 Ti에 끝나는 N개의 수업
    // 최소의 강의실을 상요해서 모든 수업을 가능하게 하기
    // 수업이 끝난 직후 다음 수업 시작할 수 있음

    static class Time implements Comparable<Time>{
        int S, T;

        public Time(int S, int T){
            this.S = S;
            this.T = T;
        }

        @Override
        public int compareTo(Time o) {
            // 시작 시간 오름차순 정렬
            // 같은 경우 끝나는 시간 오름차순 정렬
            if(this.S == o.S){
                return this.T - o.T;
            }
            return this.S - o.S;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Time [] times = new Time[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            times[i] = new Time(s, t);
        }

        // 정렬
        Arrays.sort(times);
        
        // 우선순위 큐로 끝나는 시간을 오름차순으로 정렬해서 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 시작시간이 가장 작으면서 끝나는 시간이 작은 시간을 pq에 넣기
        pq.offer(times[0].T);

        for(int i = 1; i < N; i++){

            // 현재 가장 빨리 시작하면서 빨리 끝나는 강의실의 끝나는 시간이
            // 다음 강의실 시작 시간보다 빨리 끝나서 가능하다면 빼기
            if(pq.peek() <= times[i].S) pq.poll();

            // 다음 강의시간 끝나는 시간 넣기
            pq.offer(times[i].T);
        }

        int ans = pq.size();


        System.out.println(ans);
    }
}



