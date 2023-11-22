import java.util.*;
import java.io.*;

public class Main {

    // 보석 도둑
    // N개의 보석, 무게 M, 가격 V
    // 가방 K 개 갖고 각 가방에 담을 수 있는 최대 무게 C
    // 가방에는 최대 한 개의 보석만 넣을 수 있음
    // 가져갈 수 있는 최대 가격

    // 무게가 낮은 가방에 최대한 높은 가격의 보석을 넣기

    // 보석
    static class jewel implements Comparable<jewel>{
        int weight;
        int price;

        public jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        // 무게 오름차순으로 정렬하면서 무게가 같은 경우 가치가 내림차순으로 정렬
        @Override
        public int compareTo(jewel j){
            if(j.weight == this.weight){
                return j.price - this.price;
            }
            return this.weight - j.weight;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        int N, K;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 보석 수
        K = Integer.parseInt(st.nextToken()); // 가방 수

        Integer [] back = new Integer[K]; // 가방 수 무게
        jewel [] jewels = new jewel[N]; // 보석들


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            // 보석 무게와 가치 담기
            jewels[i] = new jewel(w, p);
        }

        Arrays.sort(jewels);


                // 가방 무게
        for(int i = 0; i < K; i++){
            back[i] = Integer.parseInt(br.readLine());
        }

        // 가방 무게 오름차순으로 정렬
        Arrays.sort(back);

        long ans = 0;

        // 가격이 내림차순으로 가장 큰 가치가 위에 오게
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // 보석의 index
        int jewelIndex = 0;
        // 가방 무게가 작은거 부터
        for(int i = 0; i < K; i++){

            // 현재 가방 무게보다 작거나 같은 보석을 우선순위 큐에 넣기
            while (jewelIndex < N && jewels[jewelIndex].weight <= back[i]){
                // 다음 보석 index로 증가 하면서 가치 더하기
                pq.offer(jewels[jewelIndex++].price);
            }

            // 무게가 작거나 같은 것 중에 가장 가치가 높은 보석 더하기
            if(!pq.isEmpty()){
                ans += pq.poll();
            }

        }
        System.out.println(ans);
    }
}



