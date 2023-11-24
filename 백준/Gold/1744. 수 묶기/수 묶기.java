import java.util.*;
import java.io.*;

public class Main {

    // 수 묶기
    // 길이가 N인 수열이 주어졌을 때 그 수열의 합 구하기
    // 수열의 두 수를 묶기
    // 위치에 상관 없이 묶을 수 있으나, 자기 자신을 묶는 것은 불가능
    // 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후 더한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 50 보다 작은 자연수

        // 양수용 pq랑 음수용 pq 넣기
        // 얌수는 큰 수끼리 곱해서 더하기 음수는 낮은 수끼리 곱해서 더하기
        // 양수는 1인 경우 곱해버리는거 보다 더하는게 더 큼
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        Queue<Integer> oneQ = new LinkedList<>();
        boolean flag = false;
        int [] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine()); // 수열의 값은 -1000 보다 크거나 같고 1000보단 작거나 같은 정수
            // 0 있으면 flag = true
            if(arr[i] == 0){
                flag = true;
            }
            if(arr[i] > 1) plusPq.offer(arr[i]);
            if(arr[i] == 1) oneQ.offer(arr[i]);
            if(arr[i] < 0) minusPq.offer(arr[i]);

        }
        // 음수는 음수끼리 곱해서 더해야 되고
        // 양수는 양수끼리 곱해서 더해야 최대
        // 음수는 0과 곱해서 0으로 만들 수 있다.
        // 양수는 0과 곱하면 안댐

        int ans = 0;
        // 2개 이상이면
        while (plusPq.size() > 1){
            int num1 = plusPq.poll();
            int num2 = plusPq.poll();

            ans += num1 * num2;

        }
        // 나머지 하나 있는 경우 더하기
        if(!plusPq.isEmpty()) {
            ans += plusPq.poll();
        }

        // 1 숫자인 경우 더하기
        while (!oneQ.isEmpty()){
            ans += oneQ.poll();
        }
        
        while (minusPq.size() > 1){
            int num1 = minusPq.poll();
            int num2 = minusPq.poll();
            ans += num1 * num2;
        }
//        나머지 하나 음수 있는 경우
        if(!minusPq.isEmpty()){
            // 0이 없는 경우에는 그 값을 더해야 한다.
            if(!flag){
                ans += minusPq.poll();
            }
        }
        System.out.println(ans);

    }
}



