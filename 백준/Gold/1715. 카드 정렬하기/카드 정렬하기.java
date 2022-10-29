

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }


        int ans = 0;

        while (pq.size() > 1){
            int temp = pq.poll();
            int temp2 = pq.poll();

            ans += temp + temp2;
            pq.add(temp + temp2);
        }

        System.out.println(ans);
    }
}